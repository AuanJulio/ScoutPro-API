package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.dto.ClubRequestDTO;
import dev.auan.scoutproapi.dto.ClubResponseDTO;
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
    public List<ClubResponseDTO> getClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ClubResponseDTO getClubById(@PathVariable int id) {
        return clubService.getClubById(id);
    }

    @PostMapping
    public ClubResponseDTO createClub(@RequestBody ClubRequestDTO club) {
        return clubService.createClub(club);
    }

    @PutMapping("/{id}")
    public ClubResponseDTO updateClubById(@PathVariable int id, @RequestBody ClubRequestDTO club) {
        return clubService.updateClubById(id, club);
    }

    @GetMapping("/{id}/players")
    public String getPlayersByClubId() {
        return "Players by Club ID";
    }

}
