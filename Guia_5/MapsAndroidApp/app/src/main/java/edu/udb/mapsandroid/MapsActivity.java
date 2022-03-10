package edu.udb.mapsandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ArrayList<Place> places;
    private Spinner spinnerMapType;
    private SeekBar seekBarZoom;
    private LatLng defaultLatLng = new LatLng(13.692637339579358, -89.12817917628752);
    private FollowPosition followPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when
        //the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        seekBarZoom = (SeekBar) findViewById(R.id.seekBarZoom);

        //HAGA USO DEL ASISTENTE PARA CREAR setOnSeekBarChangeListener. El único método que modificará es onProgressChanged
        seekBarZoom.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                chooseMoveCamera(mMap, defaultLatLng, progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        spinnerMapType = (Spinner) findViewById(R.id.spinnerMapType);

        //HAGA USO DEL ASISTENTE PARA CREAR setOnItemSelectedListener
        spinnerMapType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String mapType = spinnerMapType.getSelectedItem().toString();
                if (mMap == null) return;
                if (mapType.equals("MAP_TYPE_NORMAL")) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                } else if (mapType.equals("MAP_TYPE_SATELLITE")) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                } else if (mapType.equals("MAP_TYPE_HYBRID")) {
                    mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //Broadcast Receiver. Permanecerá escuchando por actualizaciones de FetchPlacesService
    // (Servicio que intentará descargar los datos) HAGA USO DEL ASISTENTE PARA CREAR BroadcastReceiver

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                places = (ArrayList<Place>) bundle.getSerializable(FetchPlacesService.RESULT);
                if (places != null && places.size() > 0) {
                    if (mMap != null) {
                        for (Place tmp : places) {
                            LatLng tmpLatLng = new LatLng(tmp.getLat(), tmp.getLon());
                            mMap.addMarker(new MarkerOptions(). position(tmpLatLng).title(tmp.getPlaceName())
                            );
                        }
                    }
                }
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(FetchPlacesService.NOTIFICATION));
        /**/
        Intent intent = new Intent(this, FetchPlacesService.class);
        startService(intent);
        if (followPosition != null) {
            followPosition.register(MapsActivity.this);
        }
    }

    @Override
    protected void onPause() {
        unregisterReceiver(broadcastReceiver);
        if (followPosition != null)
            followPosition.unRegister(MapsActivity.this);
        super.onPause();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        followPosition = new FollowPosition(this.mMap, MapsActivity.this);
        followPosition.register(MapsActivity.this);

        Marker markerPerth;
        Marker markerPerth2;
        Marker markerPerth3;
        Marker markerPerth4;
        final LatLng PERTH = new LatLng(13.69237533627996, -89.12802820875609);
        final LatLng PERTH2 = new LatLng(13.692487244424623, -89.12484491845883);
        final LatLng PERTH3 = new LatLng(13.690116916693187, -89.12990349164231);
        final LatLng PERTH4 = new LatLng(13.69413030670068, -89.12511483377098);

        //Moveremos la cámara a la Universidad Don Bosco
        mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultLatLng));
        chooseMoveCamera(mMap, defaultLatLng, 30);

        markerPerth = mMap.addMarker(new MarkerOptions().position(PERTH).title("Parque Santa Lucia El Triangulo").snippet("Zona de Riesgo"));
        markerPerth2 = mMap.addMarker(new MarkerOptions().position(PERTH2).title("Cancha Futbol Las Palmas").snippet("Zona de Riesgo"));
        markerPerth3 = mMap.addMarker(new MarkerOptions().position(PERTH3).title("Parroquia Santa Lucia").snippet("No Hay Riesgo"));
        markerPerth4 = mMap.addMarker(new MarkerOptions().position(PERTH4).title("Entrada Santa Lucia").snippet("No Hay Riesgo"));

        drawShapes();
        markerPerth.showInfoWindow();
        mMap.setOnMarkerClickListener(marker -> {
            if (markerPerth.getTitle().equals(marker.getTitle())) { // if marker source is clicked
                Toast.makeText(MapsActivity.this, markerPerth.getTitle(), Toast.LENGTH_SHORT).show();// display toast
            }
            if (markerPerth2.getTitle().equals(marker.getTitle())) { // if marker source is clicked
                Toast.makeText(MapsActivity.this, markerPerth2.getTitle(), Toast.LENGTH_SHORT).show();// display toast
            }
            if (markerPerth3.getTitle().equals(marker.getTitle())) { // if marker source is clicked
                Toast.makeText(MapsActivity.this, markerPerth3.getTitle(), Toast.LENGTH_SHORT).show();// display toast
            }
            if (markerPerth4.getTitle().equals(marker.getTitle())) { // if marker source is clicked
                Toast.makeText(MapsActivity.this, markerPerth4.getTitle(), Toast.LENGTH_SHORT).show();// display toast
            }

            Intent intent = new Intent(MapsActivity.this, PlacesClickActivity.class);
            Bundle b = new Bundle();
            b.putString("NameClick", marker.getTitle());
            b.putString("TypeRisk", marker.getSnippet());
            intent.putExtras(b);
            startActivity(intent);
            return true;
        });





    }


    //El siguiente método permitirá movernos de manera animada a una posición del mapa
    private void chooseMoveCamera(GoogleMap googleMap, LatLng tmpLatLng, int zoom){
        CameraPosition cameraPosition =  new CameraPosition.Builder().zoom(zoom).target(tmpLatLng).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    //El siguiente método custom permite agregar diferentes figuras
    private void drawShapes(){
        ShapesMap shapesMap = new ShapesMap(this.mMap);
        //PolyLines
        ArrayList<LatLng> lines = new ArrayList<>();
        lines.add(new LatLng (13.692133916872747, -89.12823715052944));
        lines.add(new LatLng (13.692210085243012, -89.12791085388679) );
        lines.add(new LatLng (13.69279516274749, -89.12793913734887) );
        lines.add(new LatLng (13.692133916872747, -89.12823715052944) );


        //Llamado al método custom drawLine de shapesMap
        shapesMap.drawLine(lines,5, Color.RED);
        ArrayList<LatLng> linesD = new ArrayList<>();
        ArrayList<LatLng> poligon = new ArrayList<>();
        poligon.add(new LatLng(13.692617969133577, -89.12508769090991));
        poligon.add(new LatLng(13.692333784890977, -89.12509646581778));
        poligon.add(new LatLng(13.69232810120261, -89.12457582128414));
        poligon.add(new LatLng(13.692552606788183, -89.12458167122273));


        //Transparencia
        //Valor Hexadecimal, transparencia + color
        //0x: Valor hexadecimal
        //2F: Trasparencia
        //00FF00: Color Hexadecimal
        shapesMap.drawPoligon(poligon,5, Color.RED,Color.parseColor("#EC7264"));

        //Agregando Circulo
        LatLng circlePoint = new LatLng(13.714966, -89.155755);
        shapesMap.drawCircle(circlePoint,50,Color.BLUE,2,Color.TRANSPARENT);
    }
}
