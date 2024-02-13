INSERT INTO `role` (`id`, `name`)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO `crossplay` (`id`, `has_crossplay`)
VALUES (1, 'true'),
       (2, 'false');

INSERT INTO minimum_system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES ('DirectX 12', 'NVIDIA GTX 1650', 'Windows 10', 'Intel Core i5-9400F', '8 GB', '500 GB'),
       ('DirectX 11', 'AMD Radeon RX 57', 'Windows 10', 'AMD Ryzen 5 260', '8 GB', '1 TB'),
       ('DirectX 12', 'NVIDIA RTX 306', 'Windows 10', 'Intel Core i7-9700K', '16 GB', '1 TB SSD');


INSERT INTO recommended_system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES ('DirectX 12', 'NVIDIA RTX 2060', 'Windows 10', 'Intel Core i7-9700K', '16 GB', '1 TB SSD'),
       ('DirectX 12', 'AMD Radeon RX 5700 XT', 'Windows 10', 'AMD Ryzen 7 3700X', '16 GB', '1 TB SSD'),
       ('DirectX 12', 'NVIDIA RTX 3080', 'Windows 10', 'Intel Core i9-9900K', '32 GB', '2 TB SSD');



INSERT INTO `user` (`year`, `id`, `role_id`, `phone`, `language`, `country`, `username`, `password`, `email`, `gender`,
                    `image`, `register_date`)
VALUES (1950, 1, 1, 'Teléfono del usuario', 'Idioma del usuario', 'País del usuario', 'Nombre del usuario',
        '$2a$10$GQ8EjxA1xo18wJC4Ea8ZQOD1wlg2kf9U4hdobBSipD4Nn3uWZ1HzW', 'admin@admin.com', NULL, 'URL de la imagen',
        '11/02/2024'),
       (1950, 2, 2, 'Teléfono del usuario', 'Idioma del usuario', 'País del usuario', 'Nombre del usuario',
        '$2a$10$GQ8EjxA1xo18wJC4Ea8ZQOD1wlg2kf9U4hdobBSipD4Nn3uWZ1HzW', 'user@user.com', NULL, 'URL de la imagen',
        '11/02/2024');

INSERT INTO `news_author` (`id`, `name`, `surname`, `image`)
VALUES (NULL, 'David', 'Portillo', 'imagen');

INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `date`, `headline`, `image`)
VALUES (NULL, 1, 1,
        'Se dice a menudo que los jugadores buscan innumerables maneras de superarse a sí mismos, y esta es una de las más complicadas. No nos referimos a completar Elden Ring con la mente o cosas similares, sino a derrotar a los jefes del juego de FromSoftware, a pesar de que estos son invisibles. Sí, has leído bien, derrotar a jefes que pueden enviarte al más allá con un solo soplido, sin siquiera poder verlos. Esta es la proeza de la streamer BioticNova. Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino. Luego está BioticNova, quien se desafió a sí misma a completar Elden Ring con los ojos abiertos, las manos en el mando, pero con todos los jefes del juego siendo invisibles.',
        '2024-02-12',
        'Hay una jugadora que se ha pasado Elden Ring con todos los enemigos invisibles. Ya solo nos queda terminar el soulslike con el PC apagado',
        'URL de la imagen'),
       (NULL, 2, 1,
        'Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino. Luego está BioticNova, quien se desafió a sí misma a completar Elden Ring con los ojos abiertos, las manos en el mando, pero con todos los jefes del juego siendo invisibles. Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino. Luego está BioticNova, quien se desafió a sí misma a completar Elden Ring con los ojos abiertos, las manos en el mando, pero con todos los jefes del juego siendo invisibles.',
        '2024-02-12',
        'Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino.',
        'URL de la imagen');

INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '1', '1', 'comentario1', '12-02-2024'),
       (NULL, '1', '2', 'comentario2', '13-02-2024'),
       (NULL, '1', '1', 'comentario3', '12-05-2024');


INSERT INTO platform (name)
VALUES ('PC'),
       ('PS5'),
       ('PS4'),
       ('Xbox One'),
       ('Xbox Series X'),
       ('Nintendo Switch'),
       ('Nintendo 3DS'),
       ('Nintendo Wii U'),
       ('PS3'),
       ('Xbox 360'),
       ('Nintendo Wii'),
       ('PS2'),
       ('PS1'),
       ('Xbox'),
       ('GameCube'),
       ('Nintendo 64'),
       ('SNES'),
       ('NES'),
       ('Sega Genesis'),
       ('Sega Saturn'),
       ('Sega Dreamcast'),
       ('Atari 2600');
