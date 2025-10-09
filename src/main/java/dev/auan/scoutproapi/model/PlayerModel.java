package dev.auan.scoutproapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_player")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "know_as")
    private String knowAs;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "position")
    private String position;

    @Column(name = "height_cm")
    private int heightCm;

    @Column(name = "weight_kg")
    private Double weightKg;

}
