package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.model.PlayerRowMapper;
import com.example.player.repository.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class PlayerH2Service implements PlayerRepository{
    @Autowired
    private JdbcTemplate db;
    @Override
    public ArrayList<Player> getAllPlayers() {
        List<Player> players = db.query("SELECT * FROM team", new PlayerRowMapper());
        return new ArrayList<Player>(players);
    }

    @Override
    public Player getPlayerById(Integer playerId) {
        try{
            Player player = db.queryForObject("SELECT * FROM team WHERE playerId = ?", new PlayerRowMapper(),playerId);
            return player;
        }
        catch (Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    }

    @Override
    public Player addPlayer(Player player) {
            db.update("INSERT INTO team (playerName, jerseyNumber, role) VALUES (?,?,?)",player.getPlayerName(), player.getJerseyNumber(), player.getRole());
            Player savedPlayer = db.queryForObject("SELECT * FROM team WHERE playerName= ?", new PlayerRowMapper(),player.getPlayerName());
            return savedPlayer;
    }

    @Override
    public Player updatePlayer(Integer playerId, Player player) {
        try{
            if(player.getPlayerName() != null ){
                db.update("UPDATE team SET playerName =? WHERE playerId =?", player.getPlayerName(),playerId);
            }

            if(player.getJerseyNumber() != null){
                db.update("UPDATE team SET jerseyNumber =? WHERE playerId =?",player.getJerseyNumber(), playerId);
            }

            if(player.getRole() != null){
                db.update("UPDATE team SET role =? WHERE playerId =?", player.getRole(), playerId);
            }
            return getPlayerById(playerId);
        }

        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePlayer(Integer playerId) {
        try{
            Player player = db.queryForObject("SELECT * FROM team WHERE playerId =?", new PlayerRowMapper(), playerId);
            db.update("DELETE FROM team WHERE playerId =?", playerId);
            throw new ResponseStatusException(HttpStatus.OK);
        }

        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.OK);
        }
    }
}