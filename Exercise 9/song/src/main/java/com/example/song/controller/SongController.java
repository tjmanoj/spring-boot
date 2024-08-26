package com.example.song.controller;

import com.example.song.model.Song;
import com.example.song.service.SongService;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {
    SongService service = new SongService();
    @GetMapping("/songs")
    public ArrayList<Song> getSongs() {
        return service.getSongs();
    }

    @GetMapping("/songs/{id}")
    public Song getSongById(@PathVariable int id) {
        return service.getSongById(id);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song) {
        return service.addSong(song);
    }

    @PutMapping("/songs/{id}")
    public Song updateSong(@PathVariable int id, @RequestBody Song song) {
        return service.updateSongById(id, song);
    }

    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable int id) {
        service.deleteSongById(id);
    }

}
