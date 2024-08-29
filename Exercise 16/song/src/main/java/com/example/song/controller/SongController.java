package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.SongH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SongController {
    @Autowired
    private SongH2Service songService;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return songService.getSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable Integer songId) {
        return songService.getSongById(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSongById(@PathVariable Integer songId, @RequestBody Song newSong) {
        return songService.updateSongById(songId, newSong);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteSongById(@PathVariable Integer songId) {
        songService.deleteSongById(songId);
    }
}