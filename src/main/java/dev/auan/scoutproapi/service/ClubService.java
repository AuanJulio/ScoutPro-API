package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.dto.ClubRequestDTO;
import dev.auan.scoutproapi.dto.ClubResponseDTO;
import dev.auan.scoutproapi.mapper.ClubMapper;
import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    public ClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public List<ClubResponseDTO> getAllClubs() {
        List<ClubModel> clubs = clubRepository.findAll();
        return clubs.stream().map(clubMapper::mapResponse).toList();
    }

    public ClubResponseDTO getClubById(int id) {
        Optional<ClubModel> club = clubRepository.findById(id);
        return club.map(clubMapper::mapResponse).orElse(null);
    }

    public ClubResponseDTO createClub(ClubRequestDTO club) {
        ClubModel clubModel = clubMapper.mapRequest(club);
        ClubModel savedClub = clubRepository.save(clubModel);
        return clubMapper.mapResponse(savedClub);
    }

    public ClubResponseDTO updateClubById(int id, ClubRequestDTO club) {
        return clubRepository.findById(id).map(existing -> {
            if (club.getName() != null) existing.setName(club.getName());
            if (club.getCountry() != null) existing.setCountry(club.getCountry());
            if (club.getLeague() != null) existing.setLeague(club.getLeague());
            ClubModel updatedClub = clubRepository.save(existing);
            return clubMapper.mapResponse(updatedClub);
        }).orElse(null);
    }

}
