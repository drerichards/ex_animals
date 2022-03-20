package com.andrerichards.playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    private static void printMenu() {
        System.out.println("Menu Options: \nPress ");
        System.out.println("0 - Quit\n" +
                "1 - Next Song\n" +
                "2 - Previous Song\n" +
                "3 - Replay Current Song\n" +
                "4 - Show Playlist\n" +
                "5 - Show Menu\n" +
                "6 - Remove Current Song"
        );
    }

    private static void printPlaylist(LinkedList<Song> playlist) {
        int count = 1;
        for (Song song : playlist) {
            System.out.println(count++ + ". " + song.toString());
        }
    }

    private static void removeSong(ListIterator<Song> listIterator, LinkedList<Song> playlist) {
        if (playlist.size() > 0) {
            listIterator.remove();
            if (listIterator.hasNext()) {
                System.out.println("Now Playing ==> " + listIterator.next().toString());
            } else if (listIterator.hasPrevious()) {
                System.out.println("Now Playing ==> " + listIterator.previous().toString());
            }
        } else System.out.println("Playlist is empty");
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        printMenu();
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("Playlist is empty");
            return;
        } else {
            System.out.println("Now Playing ==> " + listIterator.next().toString());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist completed");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) listIterator.next();
                        forward = true;
                    }
                    if (listIterator.hasNext()) System.out.println("Now Playing ==> " + listIterator.next().toString());
                    else {
                        System.out.println("End of Playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) listIterator.previous();
                        forward = false;

                    }
                    if (listIterator.hasPrevious())
                        System.out.println("Now Playing ==> " + listIterator.previous().toString());
                    else {
                        System.out.println("Beginning of Playlist");
                        System.out.println("Now Playing ==> " + playlist.get(0).toString());
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now Replaying ==> " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("Beginning of Playlist");
                            System.out.println("Now Playing ==> " + playlist.get(0).toString());
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now Replaying ==> " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("End of Playlist");
                            forward = false;
                        }
                    }
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    removeSong(listIterator, playlist);
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Album album = new Album("Cool Congo EP", "Otto P");
        album.addSong("Song 1", 34000);
        album.addSong("Song 2", 34000);
        album.addSong("Song 3", 34000);
        album.addSong("Song 4", 34000);
        album.addSong("Song 5", 34000);
        album.addSong("Song 6", 34000);
        album.addSong("Song 7", 34000);
        albums.add(album);

        // valid because new object created
        album = new Album("Mild Bachata EP", "Senor Tio");
        album.addSong("Track 1", 34000);
        album.addSong("Track 2", 34000);
        album.addSong("Track 3", 34000);
        album.addSong("Track 4", 34000);
        album.addSong("Track 5", 34000);
        album.addSong("Track 6", 34000);
        album.addSong("Track 7", 34000);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<>();
        albums.get(0).addToPlaylist("Song 4", playlist);
        albums.get(1).addToPlaylist("Track 6", playlist);
//        albums.get(1).addToPlaylist("Song 4", playlist);
        albums.get(0).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(2, playlist);
//        albums.get(0).addToPlaylist(46, playlist);

        play(playlist);
    }
}
