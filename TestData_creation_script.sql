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

INSERT INTO cinema.user_role (role_id, role_description) VALUES (0, 'USER');
INSERT INTO cinema.user_role (role_id, role_description) VALUES (1, 'ADMIN');

INSERT INTO cinema.user (user_name, user_password, user_email, role_id, user_notes)
VALUES ('Guest', '', '', 0, '');
INSERT INTO cinema.user (user_name, user_password, user_phone, user_email, role_id, user_notes)
VALUES ('Yaroslav', 'Yaroslav', '+38 068 369 09 40', 'joshimo.kiev@gmail.com', 0, 'Some user notes');
INSERT INTO cinema.user (user_name, user_password, user_phone, user_email, role_id, user_notes)
VALUES ('Admin', 'Admin', '+38 068 369 09 40','admin@cinema.com', 1, 'Admin`s notes');

INSERT INTO cinema.film (film_name, film_info, film_notes) VALUES ('Монстры на каникулах 3: Море зовёт', 'Любишь ужасы? Проведи отпуск с семьёй!', 'Семейный');
INSERT INTO cinema.film (film_name, film_info, film_notes) VALUES ('Небоскрёб', 'The sky is the limit', '18+');
INSERT INTO cinema.film (film_name, film_info, film_notes) VALUES ('Человек-муравей и Оса', 'Real heroes. Not actual size', '18+');

INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (1, '10:00 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (1, '11:55 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (1, '13:50 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (1, '15:45 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (1, '17:40 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (2, '12:30 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (2, '17:00 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (2, '19:40 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (2, '21:30 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (3, '10:20 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (3, '14:40 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (3, '19:10 15.07.2018');
INSERT INTO cinema.seance (film_id, seance_schedule) VALUES (3, '21:40 15.07.2018');

COMMIT;