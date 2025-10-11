package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.model.PlayerModel;
import dev.auan.scoutproapi.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<PlayerModel> getPlayers() {
        return playerService.getPlayers();
    }

    @GetMapping("/{id}")
    public PlayerModel getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public PlayerModel createPlayer(@RequestBody PlayerModel player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    public PlayerModel updatePlayerById(@PathVariable int id, @RequestBody PlayerModel player) {
        return playerService.updatePlayerById(id, player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayerById(@PathVariable int id) {
        playerService.deletePlayerById(id);
    }

}
