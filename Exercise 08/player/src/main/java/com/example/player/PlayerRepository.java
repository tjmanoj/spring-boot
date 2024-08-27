package com.example.player;

import java.util.ArrayList;

public interface PlayerRepository {
    ArrayList<Player> getAllPlayers();
    Player getPlayerById(int playerId);
    Player addPlayer(Player player);
    Player updatePlayer(int playerId, Player player);
    void deletePlayer(int playerId);
}
