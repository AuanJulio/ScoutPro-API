package dev.auan.scoutproapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_player")
public class PlayerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "know_as")
    private String knowAs;

    @Column(name = "birth_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "position")
    private String position;

    @Column(name = "height_cm")
    private int heightCm;

    @Column(name = "weight_kg")
    private Double weightKg;

    @ManyToOne
    @JoinColumn(name = "club_id")
    private ClubModel club;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<ScoutReportModel> scoutReports;

}
