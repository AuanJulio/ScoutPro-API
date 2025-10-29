package dev.auan.scoutproapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.auan.scoutproapi.model.ClubModel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PlayerRequestDTO {

    private String fullName;
    private String knowAs;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String nationality;
    private String position;
    private int heightCm;
    private Double weightKg;
    private ClubModel club;

}
