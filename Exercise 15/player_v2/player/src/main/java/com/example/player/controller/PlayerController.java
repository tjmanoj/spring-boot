package com.example.player.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.player.service.PlayerH2Service;
import com.example.player.model.Player;
import java.util.ArrayList;

@RestController
public class PlayerController {
    @Autowired
    private PlayerH2Service service;

    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable Integer id) {
        return service.getPlayerById(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return service.addPlayer(player);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable Integer id, @RequestBody Player player){
        return service.updatePlayer(id, player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Integer id){
        service.deletePlayer(id);
    }
}