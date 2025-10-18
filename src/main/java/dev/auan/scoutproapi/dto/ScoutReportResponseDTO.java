package dev.auan.scoutproapi.dto;

import dev.auan.scoutproapi.model.PlayerModel;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScoutReportResponseDTO {

    private int id;
    private LocalDateTime reportDate;
    private String scoutName;
    private Integer potentialScore;
    private String stregths;
    private String weaknesses;
    private PlayerModel player;

}

