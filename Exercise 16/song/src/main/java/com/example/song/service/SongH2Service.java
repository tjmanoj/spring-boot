package com.example.song.service;

import com.example.song.model.Song;
import com.example.song.model.SongRowMapper;
import com.example.song.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;

@Service
public class SongH2Service implements SongRepository {
    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Song> getSongs() {
        List<Song> songs = db.query("SELECT * FROM PLAYLIST", new SongRowMapper());
        return new ArrayList<Song>(songs);
    }

    @Override
    public Song getSongById(Integer songId) {
        try {
            return db.queryForObject("SELECT * FROM PLAYLIST WHERE songId=?", new SongRowMapper(), songId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song newSong) {
        db.update("Insert into PLAYLIST(songName,lyricist,singer,musicDirector) values(?,?,?,?)", newSong.getSongName(),
                newSong.getLyricist(), newSong.getSinger(), newSong.getMusicDirector());
        Song song = db.queryForObject("Select * from PLAYLIST where songName=?", new SongRowMapper(),
                newSong.getSongName());
        return song;
    }

    @Override
    public Song updateSongById(Integer songId, Song newSong) {
        try {
            if (newSong.getSongName() != null) {
                db.update("Update PLAYLIST set songName = ? where songId = ?", newSong.getSongName(), songId);
            }
            if (newSong.getSinger() != null) {
                db.update("Update PLAYLIST set singer =? where songId =?", newSong.getSinger(), songId);
            }
            if (newSong.getLyricist() != null) {
                db.update("Update PLAYLIST set lyricist =? where songId =?", newSong.getLyricist(), songId);
            }
            if (newSong.getMusicDirector() != null) {
                db.update("Update PLAYLIST set musicDirector =? where songId =?", newSong.getMusicDirector(), songId);
            }

            return getSongById(songId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteSongById(Integer songId) {
        try {
            db.update("DELETE FROM PLAYLIST WHERE songId =?", songId);
            throw new ResponseStatusException(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }
}