CREATE DATABASE cinema;

GRANT ALL PRIVILEGES ON cinema.* TO 'cinemaproject'@'localhost' IDENTIFIED BY 'cinemaproject';
GRANT ALL PRIVILEGES ON cinema.* TO 'cinemaproject'@'%' IDENTIFIED BY 'cinemaproject';

CREATE TABLE cinema.row (
  row_number SMALLINT NOT NULL UNIQUE,
  cost DOUBLE NOT NULL DEFAULT 100
) ENGINE InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cinema.seat (
  seat_number SMALLINT NOT NULL UNIQUE
) ENGINE InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cinema.film (
  film_id SMALLINT NOT NULL AUTO_INCREMENT KEY,
  film_name VARCHAR(128) NOT NULL,
  film_info VARCHAR(255) NOT NULL,
  film_notes VARCHAR(255) NOT NULL
) ENGINE InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cinema.seance (
  seance_id SMALLINT NOT NULL AUTO_INCREMENT KEY,
  film_id SMALLINT NOT NULL,
  seance_schedule VARCHAR(64) NOT NULL,
  FOREIGN KEY (film_id) REFERENCES cinema.film (film_id)
) ENGINE InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE cinema.ticket (
  ticket_id SMALLINT NOT NULL AUTO_INCREMENT KEY,
  seance_id SMALLINT NOT NULL,
  cost DOUBLE NOT NULL DEFAULT 100,
  row_number SMALLINT NOT NULL,
  seat_number SMALLINT NOT NULL,
  FOREIGN KEY (seance_id) REFERENCES cinema.seance (seance_id),
  FOREIGN KEY (row_number) REFERENCES cinema.row (row_number),
  FOREIGN KEY (seat_number) REFERENCES cinema.seat (seat_number)
) ENGINE InnoDB DEFAULT CHARSET=utf8;