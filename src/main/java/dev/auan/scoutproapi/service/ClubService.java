package dev.auan.scoutproapi.service;

import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<ClubModel> getAllClubs() {
        return clubRepository.findAll();
    }

    public ClubModel getClubById(int id) {
        Optional<ClubModel> club = clubRepository.findById(id);
        return club.orElse(null);
    }

    public ClubModel createClub(ClubModel club) {
        return clubRepository.save(club);
    }

    public ClubModel updateClubById(int id, ClubModel club) {
        return clubRepository.findById(id).map(existing -> {
            if (club.getName() != null) existing.setName(club.getName());
            if (club.getCountry() != null) existing.setCountry(club.getCountry());
            if (club.getLeague() != null) existing.setLeague(club.getLeague());
            return clubRepository.save(existing);
        }).orElse(null);
    }

}
