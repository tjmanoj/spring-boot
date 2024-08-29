package com.example.player.repository;

import com.example.player.model.Player;

import java.util.ArrayList;

public interface PlayerRepository {
    ArrayList<Player> getAllPlayers();
    Player getPlayerById(Integer playerId);
    Player addPlayer(Player player);
    Player updatePlayer(Integer playerId, Player player);
    void deletePlayer(Integer playerId);
}