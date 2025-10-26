package dev.auan.scoutproapi.controller;

import dev.auan.scoutproapi.dto.ClubRequestDTO;
import dev.auan.scoutproapi.dto.ClubResponseDTO;
import dev.auan.scoutproapi.model.ClubModel;
import dev.auan.scoutproapi.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ClubResponseDTO>> getClubs() {
        List<ClubResponseDTO> clubs = clubService.getAllClubs();
        return ResponseEntity.ok(clubs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClubById(@PathVariable int id) {
        ClubResponseDTO club = clubService.getClubById(id);
        if (club != null) {
            return ResponseEntity.ok(club);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Clube com ID " + id + " não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity<String> createClub(@RequestBody ClubRequestDTO club) {
        ClubResponseDTO newClub = clubService.createClub(club);
        return ResponseEntity.ok("Clube " + newClub.getName() + " criado com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClubById(@PathVariable int id, @RequestBody ClubRequestDTO club) {
        ClubResponseDTO updatedClub = clubService.updateClubById(id, club);
        if (updatedClub != null) {
            return ResponseEntity.ok(updatedClub);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Clube com ID " + id + " não encontrado.");
        }
    }

    @GetMapping("/{id}/players")
    public String getPlayersByClubId() {
        return "Players by Club ID";
    }

}
