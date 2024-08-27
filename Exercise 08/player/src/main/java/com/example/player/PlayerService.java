package com.example.player;

// Don't modify the below code

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PlayerService implements PlayerRepository {
    private int playerCount = 12;
    private static HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    @Override
    public ArrayList<Player> getAllPlayers() {
        Collection<Player> players = team.values();
        return new ArrayList<>(players);
    }

    @Override
    public Player getPlayerById(int playerId) {
        if(team.get(playerId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            return team.get(playerId);
        }
    }

    @Override
    public Player addPlayer(Player player) {
        player.setPlayerId(playerCount++);
        team.put(player.getPlayerId(), player);
        return player;
    }

    @Override
    public Player updatePlayer(int playerId, Player player) {
        Player oldPlayer = team.get(playerId);

        if(oldPlayer == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


        if(player.getPlayerName() != null){
            oldPlayer.setPlayerName(player.getPlayerName());
        }
        if(player.getRole() != null){
            oldPlayer.setRole(player.getRole());
        }
        if(player.getJerseyNumber() != 0){
            oldPlayer.setJerseyNumber(player.getJerseyNumber());
        }
        return oldPlayer;

    }

    @Override
    public void deletePlayer(int playerId) {
        if(team.get(playerId) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        else{
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}
