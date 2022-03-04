package udb.edu.sv.recyclerviewdinamico;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView teamImage;
    TextView animeDescription;
    TextView animerating;
    TextView animEpisode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Anime anime = (Anime) getIntent().getSerializableExtra("teamdetail");

        teamImage = (ImageView) findViewById(R.id.teamImage);
        animeDescription = (TextView) findViewById(R.id.animeDescription);
        animerating = (TextView) findViewById(R.id.animerating);
        animEpisode = (TextView) findViewById(R.id.animeEpisode);

        animerating.setText("Rating: ⭐"+anime.getRating());
        animeDescription.setText("Description:"+"\n"+anime.getDescription());
        animEpisode.setText("Episodes:"+anime.getEpisode());
        Glide.with(this).load(anime.getImgLogo()).into(teamImage);
    }

}