package dev.auan.scoutproapi.dto;

import dev.auan.scoutproapi.model.PlayerModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScoutReportRequestDTO {

    private String scoutName;
    private Integer potentialScore;
    private String stregths;
    private String weaknesses;

}
