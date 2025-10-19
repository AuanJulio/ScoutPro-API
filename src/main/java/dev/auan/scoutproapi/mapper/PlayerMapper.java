package dev.auan.scoutproapi.mapper;

import dev.auan.scoutproapi.dto.PlayerRequestDTO;
import dev.auan.scoutproapi.dto.PlayerResponseDTO;
import dev.auan.scoutproapi.model.PlayerModel;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {

    public PlayerModel mapRequest(PlayerRequestDTO dto) {
        PlayerModel player = new PlayerModel();
        player.setFullName(dto.getFullName());
        player.setKnowAs(dto.getKnowAs());
        player.setBirthDate(dto.getBirthDate());
        player.setNationality(dto.getNationality());
        player.setHeightCm(dto.getHeightCm());
        player.setWeightKg(dto.getWeightKg());
        player.setClub(dto.getClub());
        return player;
    }

    public PlayerRequestDTO mapRequest(PlayerModel player) {
        PlayerRequestDTO dto = new PlayerRequestDTO();
        dto.setFullName(player.getFullName());
        dto.setKnowAs(player.getKnowAs());
        dto.setBirthDate(player.getBirthDate());
        dto.setNationality(player.getNationality());
        dto.setHeightCm(player.getHeightCm());
        dto.setWeightKg(player.getWeightKg());
        dto.setClub(player.getClub());
        return dto;
    }

    public PlayerModel mapResponse(PlayerResponseDTO dto) {
        PlayerModel player = new PlayerModel();
        player.setId(dto.getId());
        player.setFullName(dto.getFullName());
        player.setKnowAs(dto.getKnowAs());
        player.setBirthDate(dto.getBirthDate());
        player.setNationality(dto.getNationality());
        player.setHeightCm(dto.getHeightCm());
        player.setWeightKg(dto.getWeightKg());
        return player;
    }

    public PlayerResponseDTO mapResponse(PlayerModel player) {
        PlayerResponseDTO dto = new PlayerResponseDTO();
        dto.setId(player.getId());
        dto.setFullName(player.getFullName());
        dto.setKnowAs(player.getKnowAs());
        dto.setBirthDate(player.getBirthDate());
        dto.setNationality(player.getNationality());
        dto.setHeightCm(player.getHeightCm());
        dto.setWeightKg(player.getWeightKg());
        return dto;
    }

}
