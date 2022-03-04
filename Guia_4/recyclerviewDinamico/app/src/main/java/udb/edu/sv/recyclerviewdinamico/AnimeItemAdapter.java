package udb.edu.sv.recyclerviewdinamico;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class AnimeItemAdapter extends
        RecyclerView.Adapter<AnimeItemAdapter.TeamViewHolder> {
    ArrayList<Anime> anime = new ArrayList<>();
    Context context;
    public AnimeItemAdapter(ArrayList<Anime> anime, Context context){
        this.anime = anime;
        this.context = context;
    }
    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View row =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new TeamViewHolder(row);
    }
    @Override
    public void onBindViewHolder(TeamViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Anime anime = this.anime.get(position);
        //Picasso.with(context).load(team.getImgLogo()).fit().placeholder(R.drawable.loading).error(R.drawable.alert).into(holder.imageLogo);
        Picasso.get().load(anime.getImgLogo()).into(holder.imageLogo);
        holder.animeDescription.setText("⭐"+ anime.getDescription());
        holder.teamName.setText(anime.getTeamName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("teamdetail", AnimeItemAdapter.this.anime.get(position));
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return anime.size();
    }
    public static class TeamViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageLogo;
        private TextView teamName;
        private TextView animeDescription;
        private TextView animerating;
        private TextView animeEpisode;
        public TeamViewHolder(View itemView) {
            super(itemView);
            imageLogo = (ImageView) itemView.findViewById(R.id.teamImage);
            teamName = (TextView) itemView.findViewById(R.id.teamName);
            animeDescription = (TextView)
                    itemView.findViewById(R.id.teamDescription);
            animerating = (TextView)
                    itemView.findViewById(R.id.animerating);

            animeEpisode = (TextView)
                    itemView.findViewById(R.id.animeEpisode);
        }

        public ImageView getImageLogo() {
            return imageLogo;
        }

        public void setImageLogo(ImageView imageLogo) {
            this.imageLogo = imageLogo;
        }

        public TextView getTeamName() {
            return teamName;
        }

        public void setTeamName(TextView teamName) {
            this.teamName = teamName;
        }

        public TextView getTeamDescription() {
            return animeDescription;
        }

        public TextView getRating() {
            return  animerating;
        }
        public void setRating(TextView teamrating) {
            this.animerating = teamrating;
        }

        public TextView getEpisode() {
            return  animeEpisode;
        }
        public void setEpisode(TextView episode) {
            this.animeEpisode = episode;
        }

        public void setTeamDescription(TextView teamDescription) {
            this.animeDescription = teamDescription;
        }
    }
}