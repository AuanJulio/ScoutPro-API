package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.dto.PlayerRequestDTO;
import dev.auan.scoutproapi.dto.PlayerResponseDTO;
import dev.auan.scoutproapi.mapper.PlayerMapper;
import dev.auan.scoutproapi.model.PlayerModel;
import dev.auan.scoutproapi.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
    }

    public List<PlayerResponseDTO> getPlayers() {
        List<PlayerModel> players = playerRepository.findAll();
        return players.stream().map(playerMapper::mapResponse).toList();
    }

    public PlayerResponseDTO getPlayerById(int id) {
        Optional<PlayerModel> player = playerRepository.findById(id);
        return player.map(playerMapper::mapResponse).orElse(null);
    }

    public PlayerResponseDTO createPlayer(PlayerRequestDTO player) {
        PlayerModel newPlayer = playerMapper.mapRequest(player);
        newPlayer = playerRepository.save(newPlayer);
        return playerMapper.mapResponse(newPlayer);
    }

    public PlayerResponseDTO updatePlayerById(int id, PlayerRequestDTO player) {
        return playerRepository.findById(id).map(existing -> {
            if (player.getFullName() != null) existing.setFullName(player.getFullName());
            if (player.getKnowAs() != null) existing.setKnowAs(player.getKnowAs());
            if (player.getBirthDate() != null) existing.setBirthDate(player.getBirthDate());
            if (player.getNationality() != null) existing.setNationality(player.getNationality());
            if (player.getPosition() != null) existing.setPosition(player.getPosition());
            if (player.getHeightCm() != 0) existing.setHeightCm(player.getHeightCm());
            if (player.getWeightKg() != null) existing.setWeightKg(player.getWeightKg());
            if (player.getClub() != null) existing.setClub(player.getClub());

            PlayerModel updatedPlayer = playerRepository.save(existing);
            return playerMapper.mapResponse(updatedPlayer);
        }).orElse(null);
    }

    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }

}
