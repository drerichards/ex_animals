package com.andrerichards.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> album;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.album = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.album.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title) {
        // forEach
        for(Song albumIndex: this.album) {
            if (albumIndex.getTitle().equals(title)) {
                return albumIndex;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.album.size())) {
            playlist.add(this.album.get(index));
            return true;
        }
        System.out.println("Album Track '" + trackNumber + "' not found");
        return false;
    }

    public boolean addToPlaylist(String trackTitle, LinkedList<Song> playlist) {
        Song checkedSong = findSong(trackTitle);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("Album Track '" + trackTitle + "' not found");
        return false;
    }
}
