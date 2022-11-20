package main;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static LinkedList<Song> myPlaylist = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Album album1 = new Album("The Death of Man", "Nightcrawler");
        album1.addSong("Misanthropy pt.1", "3:33");
        album1.addSong("Into the Void", "2:25");
        album1.addSong("Nothingness", "3:00");
        album1.addSong("Rise of the Insane", "4:22");
        album1.addSong("Genocide and War", "5:21");
        album1.addSong("Misanthropy pt.2", "5:40");
        album1.addSong("Death of Mankind", "6:36");

        Album album2 = new Album("The Way of the Black Mage", "Gaargarius");
        album2.addSong("Blood and Sand", "4:55");
        album2.addSong("Animosity among the party", "5:40");
        album2.addSong("Betrayal", "2:59");
        album2.addSong("Killing of innocence", "4:20");
        album2.addSong("Necromancy", "5:23");
        album2.addSong("Army of Undead", "4:30");
        album2.addSong("Glory in War", "2:50");
        album2.addSong("Dead Inside", "3:40");
        album2.addSong("Lich", "5:56");

        if (album1.addSong("Death of Mankind", "2:22")) {
            System.out.println("Successfully added.");
        } else {
            System.out.println("Error");
        }

        if (album1.removeSong("Victim")) {
            System.out.println("Successfully removed.");
        } else {
            System.out.println("Error");
        }

        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.print("Select an action: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    printInstructions();
                    break;
                case 2:
                    printPlaylistSongs();
                    break;
                case 3:
                    addSongToPlaylist(album1, album2);
                    break;
                case 4:
                    listenToPlaylist();
                    break;
                case 5:
                    removeSongFromPlaylist();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    private static void addSongToPlaylist(Album album1, Album album2) {
        System.out.println("\nAlbum 1: " + album1.getName());
        album1.printSongs();
        System.out.println("\nAlbum 2: " + album2.getName());
        album2.printSongs();
        System.out.print("Which album do you want to pick a song from? Type "
                + "'1' for the first '2' for the second: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Choose the number of the song: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                addSongToPlaylist(number, album1);
                break;
            case 2:
                addSongToPlaylist(number, album2);
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    private static boolean addSongToPlaylist(int number, Album album) {
        if (number > album.albumSize()) {
            System.out.println("This song does not exist.");
            return false;
        }
        Song song = album.browseSong(number - 1);
        Song doesSongExist = browseSongFromPlaylist(song.getTitle());
        if (doesSongExist != null) {
            System.out.println("This song is already in the playlist.");
            return false;
        }
        myPlaylist.add(new Song(song.getTitle(), song.getDuration()));
        System.out.println("Successfully added.");
        return true;
    }

    private static void listenToPlaylist() {
        boolean stuck = false;
        boolean quit = false;
        boolean goingForward = true;
        String msg = "";
        ListIterator<Song> listIterator = myPlaylist.listIterator();
        if (myPlaylist.isEmpty()) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("You are listening to '" +
                    listIterator.next().getTitle() + "'");
            printMenu();
        }

        while (!quit) {
            System.out.print("#");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("You are listening to '" +
                                listIterator.next().getTitle() + "'");
                        stuck = false;
                    } else {
                        System.out.println("There's no next songs. "
                                + "You can only go backwards.");
                        msg = "You can only go backwards.";
                        stuck = true;
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }

                    if (listIterator.hasPrevious()) {
                        System.out.println("You are listening to '" +
                                listIterator.previous().getTitle() + "'");
                        stuck = false;
                    } else {
                        System.out.println("There's no previous songs. "
                                + "You can only go forward.");
                        msg = "You can only go forward.";
                        stuck = true;
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (stuck) {
                        System.out.println(msg);
                    } else if (goingForward) {
                        listIterator.previous();
                        System.out.println("You are listening to '" + 
                                listIterator.next().getTitle() + "'");
                    } else {
                        listIterator.next();
                        System.out.println("You are listening to '" + 
                                listIterator.previous().getTitle() + "'");
                    }
                    break;
                case 4:
                    if (myPlaylist.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("You are listening to '" + 
                                    listIterator.next().getTitle() + "'");
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("You are listening to '" + 
                                    listIterator.previous().getTitle() + "'");
                        }
                    }
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Press" +
                "\n0 - to quit" +
                "\n1 - to next song" +
                "\n2 - to previous song" +
                "\n3 - to replay song" +
                "\n4 - to remove current song" +
                "\n5 - print menu options");
    }

    private static void removeSongFromPlaylist() {
        printPlaylistSongs();
        System.out.print("Which song above do you want to delete? Type the "
                + "number of the song: ");
        int pos = scanner.nextInt();
        scanner.nextLine();
        if (pos > myPlaylist.size()) {
            System.out.println("This song does not exist.");
            return;
        }
        Song song = browseSongFromPlaylist(pos - 1);
        myPlaylist.remove(song);
        System.out.println("Song successfully removed.");
    }

    private static void printPlaylistSongs() {
        if (myPlaylist.isEmpty()) {
            System.out.println("Empty playlist");
            return;
        }
        int pos = 0;
        System.out.println("My Playlist");
        Iterator<Song> iterator = myPlaylist.iterator();
        while (iterator.hasNext()) {
            System.out.println((pos + 1) + ". " + iterator.next());
            pos++;
        }
        System.out.println();
    }

    private static Song browseSongFromPlaylist(int pos) {
        return myPlaylist.get(pos);
    }

    private static Song browseSongFromPlaylist(String title) {
        for (Song song : myPlaylist) {
            if (song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    private static void printInstructions() {
        System.out.println("Press:");
        System.out.println("0 - quit application" +
                "\n1 - print instructions" +
                "\n2 - print playlist songs" +
                "\n3 - add song to playlist" +
                "\n4 - listen to playlist" +
                "\n5 - remove song from playlist");
    }
}
