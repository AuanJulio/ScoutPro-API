package dev.auan.scoutproapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.auan.scoutproapi.model.ClubModel;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PlayerResponseDTO {

    private int id;
    private String fullName;
    private String knowAs;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String position;
    private String nationality;
    private int heightCm;
    private Double weightKg;

}
