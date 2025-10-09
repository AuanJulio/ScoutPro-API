package dev.auan.scoutproapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_scout_report")
public class ScoutReportModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "report_date")
    private LocalDateTime reportDate;

    @Column(name = "scout_name")
    private String scoutName;

    @Column(name = "potential_score")
    private Integer potentialScore;

    @Column(name = "stregths")
    private String stregths;

    @Column(name = "weaknesses")
    private String weaknesses;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerModel player;

}
