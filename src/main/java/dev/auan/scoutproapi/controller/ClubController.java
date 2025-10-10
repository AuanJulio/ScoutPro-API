package dev.auan.scoutproapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @GetMapping
    public String getClubs() {
        return "Clubs";
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
