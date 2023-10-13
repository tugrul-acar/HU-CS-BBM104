import java.util.ArrayList;

public class Movie {
    public String name;
    public String path;
    public int duration;
    public static ArrayList<String> movienames = new ArrayList<>();
    public  ArrayList<String> hallArrayList = new ArrayList<>();
    public static ArrayList<Movie> movies = new ArrayList<>();
    public Movie(String name, String path,int duration){
        this.name = name;
        this.duration = duration;
        this.path = path;
        movienames.add(name);
        movies.add(this);
    }
}
