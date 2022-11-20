package main;

import java.util.LinkedList;
import java.util.List;

public class Album {
    private List<Song> myAlbum;
    private String name, artist;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.myAlbum = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    /*private int browseSong(String title) {
        return myAlbum.indexOf(title);
    }*/

    public Song browseSong(int position) {
        return myAlbum.get(position);
    }

    public Song browseSong(String title) {
        for (Song song : myAlbum) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addSong(String title, String duration) {
        Song doesSongExist = browseSong(title);
        if (doesSongExist != null) {
            System.out.println("'" + title + "' already exists in this album.");
            return false;
        }
        myAlbum.add(new Song(title, duration));
        return true;
    }

    public boolean removeSong(String title) {
        Song doesSongExist = browseSong(title);
        if (doesSongExist == null) {
            System.out.println("'" + title + "' does not exist in this album.");
            return false;
        }
        myAlbum.remove(doesSongExist);
        return true;
    }

    public void printSongs() {
        if (myAlbum.isEmpty()) {
            System.out.println("There's no song in this album.");
            return;
        }
        int pos = 0;
        for (Song song : myAlbum) {
            System.out.println((pos + 1) + ". " + myAlbum.get(pos).getTitle() +
                    " | " + myAlbum.get(pos).getDuration());
            pos++;
        }
    }

    public int albumSize() {
        return myAlbum.size();
    }
}
