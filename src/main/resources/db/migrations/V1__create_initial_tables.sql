CREATE TABLE tb_club (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    country VARCHAR(255),
    league VARCHAR(255)
);

CREATE TABLE tb_player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(255),
    know_as VARCHAR(255),
    birth_date DATE,
    nationality VARCHAR(255),
    position VARCHAR(255),
    height_cm INT,
    weight_kg DOUBLE,
    club_id INT,
    FOREIGN KEY (club_id) REFERENCES tb_club(id)
);

CREATE TABLE tb_scout_report (
     id INT AUTO_INCREMENT PRIMARY KEY,
     report_date TIMESTAMP,
     scout_name VARCHAR(255),
     potential_score INT,
     stregths VARCHAR(255),
     weaknesses VARCHAR(255),
     player_id INT,
     FOREIGN KEY (player_id) REFERENCES tb_player(id)
);