package dev.auan.scoutproapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @GetMapping
    public String getPlayers() {
        return "Players";
    }

    @GetMapping("/{id}")
    public String getPlayerById() {
        return "Player by ID";
    }

    @PostMapping
    public String createPlayer() {
        return "Create Player";
    }

    @PutMapping("/{id}")
    public String updatePlayerById() {
        return "Update Player by ID";
    }

    @DeleteMapping("/{id}")
    public String deletePlayerById() {
        return "Delete Player by ID";
    }

}
