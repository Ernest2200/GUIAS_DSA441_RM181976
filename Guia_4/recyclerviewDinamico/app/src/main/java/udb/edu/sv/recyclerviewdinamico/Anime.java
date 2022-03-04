package udb.edu.sv.recyclerviewdinamico;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
public class Anime implements Serializable {
    private int id;
    @SerializedName("name")
    private String teamName;
    @SerializedName("Rating")
    private String rating;
    @SerializedName("img")
    private String imgLogo;
    @SerializedName("episode")
    private String episode;
    @SerializedName("description")
    private String description;
    public Anime(int id, String teamName,
                 String rating, String imgLogo, String episode, String description) {
        this.setId(id);
        this.setTeamName(teamName);
        this.setRating(rating);
        this.setImgLogo(imgLogo);
        this.setEpisode(episode);
        this.setDescription(description);
    }
    public Anime(){}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getImgLogo() {
        return imgLogo;
    }
    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }
    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }
}