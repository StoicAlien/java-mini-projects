package main;

public class Song {
    private String title, duration;

    public Song(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "" +
                "'" + title + "'" +
                " | " + duration +
                "";
    }
}
