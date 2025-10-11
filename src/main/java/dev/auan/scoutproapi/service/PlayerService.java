package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.model.PlayerModel;
import dev.auan.scoutproapi.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerModel> getPlayers() {
        return playerRepository.findAll();
    }

    public PlayerModel getPlayerById(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    public PlayerModel createPlayer(PlayerModel player) {
        return playerRepository.save(player);
    }

    public PlayerModel updatePlayerById(int id, PlayerModel player) {
        return playerRepository.findById(id).map(existing -> {
            if (player.getFullName() != null) existing.setFullName(player.getFullName());
            if (player.getKnowAs() != null) existing.setKnowAs(player.getKnowAs());
            if (player.getBirthDate() != null) existing.setBirthDate(player.getBirthDate());
            if (player.getNationality() != null) existing.setNationality(player.getNationality());
            if (player.getPosition() != null) existing.setPosition(player.getPosition());
            if (player.getHeightCm() != 0) existing.setHeightCm(player.getHeightCm());
            if (player.getWeightKg() != null) existing.setWeightKg(player.getWeightKg());
            if (player.getClub() != null) existing.setClub(player.getClub());
            return playerRepository.save(existing);
        }).orElse(null);
    }

    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

}
