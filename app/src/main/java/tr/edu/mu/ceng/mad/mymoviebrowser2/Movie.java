package tr.edu.mu.ceng.mad.mymoviebrowser2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Parcelable {
    private String name, director,description;
    private int year;
    private List<String> stars = new ArrayList<>();

    public Movie(String name, String director, int year, List<String> stars,String description) {
        this.name = name;
        this.director = director;
        this.description = description;
        this.year = year;
        this.stars = stars;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.director);
        dest.writeString(this.description);
        dest.writeInt(this.year);
        dest.writeStringList(this.stars);
    }

    protected Movie(Parcel in) {
        this.name = in.readString();
        this.director = in.readString();
        this.description = in.readString();
        this.year = in.readInt();
        this.stars = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
