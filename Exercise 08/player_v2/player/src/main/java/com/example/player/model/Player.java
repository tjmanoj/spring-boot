package com.example.player.model;

public class Player {
    private Integer playerId;
    private String playerName;
    private Integer jerseyNumber;
    private String role;

    public Player(Integer playerId, String playerName, Integer jerseyNumber, String role) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.jerseyNumber = jerseyNumber;
        this.role = role;
    }

    //Getters
    public Integer getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Integer getJerseyNumber() {
        return jerseyNumber;
    }

    public String getRole() {
        return role;
    }

    //Setters
    public void setPlayerId(Integer playerId){
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setJerseyNumber(Integer jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public void setRole(String role) {
        this.role = role;
    }

}