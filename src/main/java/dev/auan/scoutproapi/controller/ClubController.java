package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.service.ClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<ClubModel> getClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public String getClubById() {
        return "Club by ID";
    }

    @PostMapping
    public String createClub() {
        return "Create Club";
    }

    @PutMapping("/{id}")
    public String updateClubById() {
        return "Update Club by ID";
    }

    @GetMapping("/{id}/players")
    public String getPlayersByClubId() {
        return "Players by Club ID";
    }

}
