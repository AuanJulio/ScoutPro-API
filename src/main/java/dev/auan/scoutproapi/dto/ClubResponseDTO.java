package dev.auan.scoutproapi.dto;

import dev.auan.scoutproapi.model.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClubResponseDTO {

    private int id;
    private String name;
    private String country;
    private String league;
    private List<PlayerModel> players;

}
