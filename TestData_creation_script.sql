START TRANSACTION;

INSERT INTO cinema.row (row_number, cost) VALUES (1, 100.00);
INSERT INTO cinema.row (row_number, cost) VALUES (2, 100.00);
INSERT INTO cinema.row (row_number, cost) VALUES (3, 150.00);
INSERT INTO cinema.row (row_number, cost) VALUES (4, 150.00);
INSERT INTO cinema.row (row_number, cost) VALUES (5, 150.00);
INSERT INTO cinema.row (row_number, cost) VALUES (6, 200.00);
INSERT INTO cinema.row (row_number, cost) VALUES (7, 200.00);
INSERT INTO cinema.row (row_number, cost) VALUES (8, 200.00);
INSERT INTO cinema.row (row_number, cost) VALUES (9, 150.00);
INSERT INTO cinema.row (row_number, cost) VALUES (10, 150.00);
INSERT INTO cinema.row (row_number, cost) VALUES (11, 150.00);
INSERT INTO cinema.row (row_number, cost) VALUES (12, 100.00);
INSERT INTO cinema.row (row_number, cost) VALUES (13, 100.00);
INSERT INTO cinema.row (row_number, cost) VALUES (14, 100.00);
INSERT INTO cinema.row (row_number, cost) VALUES (15, 80.00);
INSERT INTO cinema.row (row_number, cost) VALUES (16, 80.00);

INSERT INTO cinema.seat (seat_number) VALUES (1);
INSERT INTO cinema.seat (seat_number) VALUES (2);
INSERT INTO cinema.seat (seat_number) VALUES (3);
INSERT INTO cinema.seat (seat_number) VALUES (4);
INSERT INTO cinema.seat (seat_number) VALUES (5);
INSERT INTO cinema.seat (seat_number) VALUES (6);
INSERT INTO cinema.seat (seat_number) VALUES (7);
INSERT INTO cinema.seat (seat_number) VALUES (8);
INSERT INTO cinema.seat (seat_number) VALUES (9);
INSERT INTO cinema.seat (seat_number) VALUES (10);
INSERT INTO cinema.seat (seat_number) VALUES (11);
INSERT INTO cinema.seat (seat_number) VALUES (12);
INSERT INTO cinema.seat (seat_number) VALUES (13);
INSERT INTO cinema.seat (seat_number) VALUES (14);
INSERT INTO cinema.seat (seat_number) VALUES (15);
INSERT INTO cinema.seat (seat_number) VALUES (16);
INSERT INTO cinema.seat (seat_number) VALUES (17);
INSERT INTO cinema.seat (seat_number) VALUES (18);
INSERT INTO cinema.seat (seat_number) VALUES (19);
INSERT INTO cinema.seat (seat_number) VALUES (20);
INSERT INTO cinema.seat (seat_number) VALUES (21);
INSERT INTO cinema.seat (seat_number) VALUES (22);
INSERT INTO cinema.seat (seat_number) VALUES (23);
INSERT INTO cinema.seat (seat_number) VALUES (24);
INSERT INTO cinema.seat (seat_number) VALUES (25);

INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('10:00 15.07.2018', 'Монстры на каникулаз 3: Море зовёт');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('11:55 15.07.2018', 'Монстры на каникулаз 3: Море зовёт');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('13:50 15.07.2018', 'Монстры на каникулаз 3: Море зовёт');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('15:45 15.07.2018', 'Монстры на каникулаз 3: Море зовёт');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('17:40 15.07.2018', 'Монстры на каникулаз 3: Море зовёт');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('12:30 15.07.2018', 'Небоскрёб');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('17:00 15.07.2018', 'Небоскрёб');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('19:40 15.07.2018', 'Небоскрёб');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('21:30 15.07.2018', 'Небоскрёб');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('10:20 15.07.2018', 'Человек-муравей и Оса');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('14:40 15.07.2018', 'Человек-муравей и Оса');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('19:10 15.07.2018', 'Человек-муравей и Оса');
INSERT INTO cinema.seance (seance_date, seance_filmname) VALUES ('21:40 15.07.2018', 'Человек-муравей и Оса');

COMMIT;