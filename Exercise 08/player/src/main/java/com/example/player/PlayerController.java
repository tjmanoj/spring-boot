package com.example.player;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class PlayerController {
    PlayerService service = new PlayerService();
    @GetMapping("/players")
    public ArrayList<Player> getAllPlayers() {
        return service.getAllPlayers();
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable int id) {
        return service.getPlayerById(id);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){
        return service.addPlayer(player);
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable int id, @RequestBody Player player){
        return service.updatePlayer(id, player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayer(id);
    }
}
