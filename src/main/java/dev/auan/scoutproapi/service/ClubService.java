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

}
