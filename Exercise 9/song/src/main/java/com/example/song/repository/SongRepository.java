package com.example.song.repository;

import com.example.song.model.Song;

import java.util.ArrayList;

public interface SongRepository {
    ArrayList<Song> getSongs();
    Song getSongById(int songId);
    Song addSong(Song newSong);
    Song updateSongById(int songId, Song newSong);
    void deleteSongById(int songId);

}
