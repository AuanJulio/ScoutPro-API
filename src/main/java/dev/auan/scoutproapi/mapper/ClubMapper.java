package dev.auan.scoutproapi.mapper;

import dev.auan.scoutproapi.dto.ClubRequestDTO;
import dev.auan.scoutproapi.dto.ClubResponseDTO;
import dev.auan.scoutproapi.model.ClubModel;
import org.springframework.stereotype.Component;

@Component
public class ClubMapper {

    public ClubModel mapRequest(ClubRequestDTO dto) {
        ClubModel club = new ClubModel();
        club.setName(dto.getName());
        club.setCountry(dto.getCountry());
        club.setLeague(dto.getLeague());
        return club;
    }

    public ClubRequestDTO mapRequest(ClubModel club) {
        ClubRequestDTO dto = new ClubRequestDTO();
        dto.setName(club.getName());
        dto.setCountry(club.getCountry());
        dto.setLeague(club.getLeague());
        return dto;
    }

    public ClubModel mapResponse(ClubResponseDTO dto) {
        ClubModel club = new ClubModel();
        club.setId(dto.getId());
        club.setName(dto.getName());
        club.setCountry(dto.getCountry());
        club.setLeague(dto.getLeague());
        return club;
    }

    public ClubResponseDTO mapResponse(ClubModel club) {
        ClubResponseDTO dto = new ClubResponseDTO();
        dto.setId(club.getId());
        dto.setName(club.getName());
        dto.setCountry(club.getCountry());
        dto.setLeague(club.getLeague());
        return dto;
    }

}
