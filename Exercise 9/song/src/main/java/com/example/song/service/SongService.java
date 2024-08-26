package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.repository.SongRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SongService implements SongRepository {
    private static HashMap<Integer,Song> playlist = new HashMap<>();
    private int uniqueSongId = 6;
    public SongService(){
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songs = playlist.values();
        return new ArrayList<>(songs);
    }

    @Override
    public Song getSongById(int songId) {
        if(playlist.get(songId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return playlist.get(songId);
        }
    }

    @Override
    public Song addSong(Song newSong) {
        newSong.setSongId(uniqueSongId++);
        playlist.put(newSong.getSongId(), newSong);
        return newSong;
    }

    @Override
    public Song updateSongById(int songId, Song newSong) {
        Song oldSong = playlist.get(songId);
        if(oldSong == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(newSong.getSongName() != null){
            oldSong.setSongName(newSong.getSongName());
        }

        if(newSong.getLyricist() != null){
            oldSong.setLyricist(newSong.getLyricist());
        }

        if(newSong.getSinger() != null){
            oldSong.setSinger(newSong.getSinger());
        }

        if(newSong.getMusicDirector() != null){
            oldSong.setMusicDirector(newSong.getMusicDirector());
        }
        return oldSong;
    }

    @Override
    public void deleteSongById(int songId) {
        if(playlist.get(songId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
