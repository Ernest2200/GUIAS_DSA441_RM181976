package edu.udb.mapsandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlacesClickActivity extends AppCompatActivity {

    ImageView img1,img2,img5,img4;
    TextView tv1,tv2;

    String url,url2,url3,url4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_click);

        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img5 = findViewById(R.id.imageView5);
        img4 = findViewById(R.id.imageView4);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        Bundle bundle = this.getIntent().getExtras();

        if (bundle.getString("NameClick").equals("Parque Santa Lucia El Triangulo")){
            tv1.setText("Nombre del lugar: "+bundle.getString("NameClick"));
            tv2.setText("Tipo de riesgo: "+bundle.getString("TypeRisk"));
             url = "https://lh3.googleusercontent.com/p/AF1QipOKNtw1lTPQF9ayNI_QEEj9Yo1PKAq8TlVzkJ9O=s1600-w400";
             url2 = "https://lh5.googleusercontent.com/p/AF1QipOsiflWlLGa5NpMYTwmu60v6LiLyVkJ8vCbcoWJ=w500-h500-k-no";

             url4 = "https://i0.wp.com/www.diariocolatino.com/wp-content/uploads/2020/08/0-1-7.jpg?fit=645%2C484&ssl=1";
            Glide.with(this).load(url).into(img1);
            Glide.with(this).load(url2).into(img2);

            Glide.with(this).load(url4).into(img4);
        }

        if (bundle.getString("NameClick").equals("Cancha Futbol Las Palmas")){
            tv1.setText("Nombre del lugar: "+bundle.getString("NameClick"));
            tv2.setText("Tipo de riesgo: "+bundle.getString("TypeRisk"));
            url = "https://cdn-pro.elsalvador.com/wp-content/uploads/2019/10/Carcava_17.jpg";
            url2 = "https://sintesistv.com.mx/wp-content/uploads/2019/11/cancha-inundada.jpg";

            url4 = "https://pbs.twimg.com/media/EG8rpDJWwAAC5Uw?format=jpg&name=4096x4096";
            Glide.with(this).load(url).into(img1);
            Glide.with(this).load(url2).into(img2);

            Glide.with(this).load(url4).into(img4);
        }

        if (bundle.getString("NameClick").equals("Parroquia Santa Lucia")){
            tv1.setText("Nombre del lugar: "+bundle.getString("NameClick"));
            tv2.setText("Tipo de riesgo: "+bundle.getString("TypeRisk"));
            url = "https://fastly.4sqi.net/img/general/600x600/527488847_4ptsPtNZILF_e6-P90E5cXRPRy3_jv_IntNm7ygdX5M.jpg";
            url2 = "https://live.staticflickr.com/6220/6307047493_241353d8c4_b.jpg";

            url4 = "";
            Glide.with(this).load(url).into(img1);
            Glide.with(this).load(url2).into(img2);

            Glide.with(this).load(url4).into(img4);
        }

        if (bundle.getString("NameClick").equals("Entrada Santa Lucia")){
            tv1.setText("Nombre del lugar: "+bundle.getString("NameClick"));
            tv2.setText("Tipo de riesgo: "+bundle.getString("TypeRisk"));
            url = "https://pbs.twimg.com/media/Da6qpAnVMAA88N4.jpg";
            url2="https://cdn-pro.elsalvador.com/wp-content/uploads/2018/05/Hoyos-colonia-Santa-Lucia-2.jpg";
            url4="";
            Glide.with(this).load(url).into(img1);
            Glide.with(this).load(url2).into(img2);
        }

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlacesClickActivity.this, MapsActivity.class);

                startActivity(intent);
            }
        });
    }
}