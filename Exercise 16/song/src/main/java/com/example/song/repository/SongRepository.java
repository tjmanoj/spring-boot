package com.example.song.repository;

import com.example.song.model.Song;

import java.util.ArrayList;

public interface SongRepository {
    ArrayList<Song> getSongs();

    Song getSongById(Integer songId);

    Song addSong(Song newSong);

    Song updateSongById(Integer songId, Song newSong);

    void deleteSongById(Integer songId);

}