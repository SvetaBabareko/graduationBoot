INSERT INTO users (name, password)
VALUES ('Admin', '{noop}admin'),
       ('User', '{noop}1111'),
       ('User2', '{noop}user');

INSERT INTO USER_ROLES (ROLE, USER_ID)
VALUES ('ADMIN', 1),
       ('USER', 2),
       ('USER', 3);

INSERT INTO restaurants (name, description)
VALUES ('Grand Café', 'Cafe, Restaurant, Italian, Belarusian'),
       ('Kuhmistr', 'Restaurant, Russian'),
       ('La Scala Trattoria Ignazio', 'Restaurant, Italian'),
       ('BAR:DOT XX1', 'Hotel Restaurant, Asian, Fusion'),
       ('Pena Dney', 'Restaurant, European'),
       ('Animal Farm', 'Restaurant, European, Mediterranean'),
       ('Seafood Bar by John Dory', 'Restaurant, Seafood'),
       ('Svobody.4', 'Restaurant, Wine Bar, Italian, European'),
       ('Om Namo', 'Restaurant, Indian, Vegetarian'),
       ('Try Zhaunery', 'Bar, Pub, Beer, Pub Grub');

INSERT INTO dishes(name, price, restaurant_id)
values('Pizza', 345.34, 12),
      ('Pasta', 145.34, 12),
      ('Hamburger', 345.34, 4),
      ('Soup', 341.34, 4),
      ('Salad', 345.34, 4),
      ('Bread', 145.34, 4),
      ('Rice', 345.34, 5),
      ('Eggs', 345.34, 5),
      ('Salad', 345.34, 6),
      ('Bread', 145.34, 6),
      ('Rice', 345.34, 6),
      ('Eggs', 345.34, 7),
      ('Pizza', 345.34, 7),
      ('Pasta', 145.34, 7),
      ('Hamburger', 345.34, 8),
      ('Soup', 345.34, 8),
      ('Salad', 345.34, 9),
      ('Bread', 145.34, 9),
      ('Rice', 345.34, 9),
      ('Eggs', 345.34, 9),
      ('Pizza', 345.34, 10),
      ('Pasta', 145.34, 10),
      ('Hamburger', 345.34, 10),
      ('Soup', 345.34, 13),
      ('Salad', 345.34, 13);

INSERT INTO votes(user_id, restaurant_id, date_vote)
values (1, 8,'2021-05-24 10:00:00'),
       (1, 5,'2021-05-23 14:00:00'),
       (1, 8,'2021-05-22 10:00:00'),
       (1, 12,'2021-05-21 10:00:00'),
       (2, 8,'2021-05-24 10:00:00'),
       (2, 5,'2021-05-23 14:00:00'),
       (2, 4,'2021-05-22 11:00:00'),
       (2, 13,'2021-05-21 12:00:00');

