INSERT INTO `role` (`id`, `name`)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO `crossplay` (`id`, `has_crossplay`)
VALUES (1, 'true'),
       (2, 'false');

INSERT INTO minimum_system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES ('DirectX 12a', 'NVIDIA GTX 1650', 'Windows 10', 'Intel Core i5-9400F', '8 GB', '500 GB'),
       ('DirectX 11', 'AMD Radeon RX 57', 'Windows 10', 'AMD Ryzen 5 260', '8 GB', '1 TB'),
       ('DirectX 12', 'NVIDIA RTX 306', 'Windows 10', 'Intel Core i7-9700K', '16 GB', '1 TB SSD');


INSERT INTO recommended_system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES ('DirectX 12', 'NVIDIA RTX 2060', 'Windows 10', 'Intel Core i7-9700K', '16 GB', '1 TB SSD'),
       ('DirectX 12', 'AMD Radeon RX 5700 XT', 'Windows 10', 'AMD Ryzen 7 3700X', '16 GB', '1 TB SSD'),
       ('DirectX 12', 'NVIDIA RTX 3080', 'Windows 10', 'Intel Core i9-9900K', '32 GB', '2 TB SSD');



INSERT INTO `user` (`year`, `id`, `role_id`, `language`, `country`, `username`, `password`, `email`, `gender`,
                    `image`, `alt`, `register_date`)
VALUES (1950, 1, 1, 'Idioma del usuario', 'País del usuario', 'maricon_quien_lo_lea',
        '$2a$10$GQ8EjxA1xo18wJC4Ea8ZQOD1wlg2kf9U4hdobBSipD4Nn3uWZ1HzW', 'admin@admin.com', NULL, 'URL de la imagen',
        'alt',
        '11/02/2024'),
       (1950, 2, 2, 'Idioma del usuario', 'País del usuario', 'panza',
        '$2a$10$GQ8EjxA1xo18wJC4Ea8ZQOD1wlg2kf9U4hdobBSipD4Nn3uWZ1HzW', 'user@user.com', NULL, 'URL de la imagen',
        'alt',
        '11/02/2024');



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


INSERT INTO `game` (`complete_time`, `story_time`, `crossplay_id`, `id`,
                    `minimum_system_requirement_id`, `product_id`, `recommended_system_requirement_id`, `cover`, `alt`,
                    `release_year`, `sinopsis`, `title`, `trailer`)
VALUES (20, 10, 2, 1, NULL, NULL, NULL, 'URL de la imagen del Resident Evil 2 Remake', 'alt', '2019',
        'Es la puesta al día del clásico original del género survival horror para Xbox One, PlayStation 4 y PC.',
        'Resident Evil 2 Remake', 'URL del trailer del Resident Evil 2 Remake'),
       (20, 10, 2, 2, NULL, NULL, NULL, 'URL de la imagen del Alan Wake 2', 'alt', '2023',
        'La historia sigue a Alan Wake, que ha estado atrapado en una dimensión alternativa durante 13 años, mientras intenta escapar escribiendo una historia de terror que involucra a una agente especial del FBI llamada Saga Anderson.',
        'Alan Wake 2', 'URL del trailer del Alan Wake 2'),
       (20, 10, 2, 3, NULL, NULL, NULL, 'URL de la imagen del Little Nightmares 2', 'alt', '2021',
        'La historia sigue a Mono, que debe trabajar junto con Six, la protagonista del juego anterior, para sobrevivir a los horrores de la Ciudad Pálida y descubrir sus oscuros secretos.',
        'Little Nightmares 2', 'URL del trailer del Little Nightmares 2'),
       (20, 10, 2, 4, NULL, NULL, NULL, 'URL de la imagen del Final Fantasy VII', 'alt', '1997',
        'La historia sigue a Cloud Strife, un mercenario que se une a la organización ecoterrorista AVALANCHA para detener el control mundial de la corporación Shinra que está drenando la vida del planeta para usarla como fuente de energía.',
        'Final Fantasy VII', 'URL del trailer del Final Fantasy VII');



INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (1, 1), -- Resident Evil 2 Remake en PC
       (1, 3), -- Resident Evil 2 Remake en PS4
       (1, 4), -- Resident Evil 2 Remake en Xbox One
       (1, 2), -- Resident Evil 2 Remake en PS5
       (1, 5), -- Resident Evil 2 Remake en Xbox Series X
       (2, 2), -- Alan Wake 2 en PS5
       (2, 5), -- Alan Wake 2 en Xbox Series X
       (2, 1), -- Alan Wake 2 en PC
       (3, 6), -- Little Nightmares 2 en Nintendo Switch
       (3, 3), -- Little Nightmares 2 en PS4
       (3, 4), -- Little Nightmares 2 en Xbox One
       (3, 1), -- Little Nightmares 2 en PC
       (4, 13); -- Final Fantasy VII en PS1


INSERT INTO genre (name)
VALUES ('Acción'),
       ('Aventura'),
       ('Rol'),
       ('Simulación'),
       ('Estrategia'),
       ('Deportes'),
       ('Puzzle'),
       ('Plataformas'),
       ('Disparos'),
       ('Lucha'),
       ('Supervivencia'),
       ('Horror'),
       ('Carreras');


INSERT INTO game_genre (game_id, genre_id)
VALUES (1, 8),
       (1, 11),
       (1, 7),
       (2, 11),
       (3, 3),
       (4, 11),
       (4, 9);


INSERT INTO developer (name)
VALUES ('Capcom'),
       ('Remedy Entertainment'),
       ('Tarsier Studios'),
       ('Square Enix'),
       ('Naughty Dog'),
       ('Rockstar Games'),
       ('CD Projekt Red'),
       ('FromSoftware'),
       ('Ubisoft'),
       ('Bethesda Softworks'),
       ('Blizzard Entertainment'),
       ('Nintendo'),
       ('Sega'),
       ('Konami'),
       ('Bandai Namco'),
       ('Kojima Productions'),
       ('Epic Games'),
       ('Valve'),
       ('Electronic Arts'),
       ('Activision'),
       ('Sony Interactive Entertainment'),
       ('Microsoft Studios'),
       ('2K Games'),
       ('Warner Bros. Interactive Entertainment');


INSERT INTO game_developer (game_id, developer_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);

INSERT INTO distributor (name)
VALUES ('Capcom'),
       ('Epic Games'),
       ('Bandai Namco'),
       ('Square Enix'),
       ('Ubisoft'),
       ('Bethesda Softworks'),
       ('Rockstar Games'),
       ('Nintendo'),
       ('Sega'),
       ('Konami'),
       ('Sony Interactive Entertainment'),
       ('Microsoft Studios'),
       ('2K Games'),
       ('Warner Bros. Interactive Entertainment'),
       ('Electronic Arts'),
       ('Activision'),
       ('Blizzard Entertainment'),
       ('Valve'),
       ('Kojima Productions');


INSERT INTO game_distributor (game_id, distributor_id)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (4, 4);


INSERT INTO dlc (game_id, name)
VALUES (1, 'Extra DLC Pack'),
       (1, 'Claire Costume: Elza Walker'),
       (1, 'Claire Costume: Military'),
       (1, 'Claire Costume: Noir'),
       (1, 'Leon Costume: Arklay Sheriff'),
       (1, 'Leon Costume: Noir'),
       (1, 'Samurai Edge - Albert Model'),
       (1, 'The Ghost Survivors'),
       (1, 'Original Ver. Soundtrack Swap'),
       (3, 'The Nomes Attic'),
       (2, 'Night Springs Expansion'),
       (2, 'Lake House Expansion');


INSERT INTO language (name)
VALUES ('Español'),
       ('Inglés'),
       ('Francés'),
       ('Alemán'),
       ('Italiano'),
       ('Portugués'),
       ('Ruso'),
       ('Chino'),
       ('Japonés'),
       ('Coreano');

-- Resident Evil 2 Remake
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (1, 1, true, true, true),  -- Español
       (1, 2, true, true, true),  -- Inglés
       (1, 3, true, true, true),  -- Francés
       (1, 4, true, true, true),  -- Alemán
       (1, 5, true, true, true),  -- Italiano
       (1, 6, true, true, false), -- Portugués
       (1, 7, true, true, false), -- Ruso
       (1, 8, true, true, false), -- Chino
       (1, 9, true, true, false), -- Japonés
       (1, 10, true, true, false);
-- Coreano

-- Alan Wake 2
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (2, 1, true, true, false), -- Español
       (2, 2, true, true, true),  -- Inglés
       (2, 3, true, true, true),  -- Francés
       (2, 4, true, true, true),  -- Alemán
       (2, 5, true, true, false), -- Italiano
       (2, 6, true, true, false), -- Portugués
       (2, 7, true, true, false), -- Ruso
       (2, 8, true, true, false), -- Chino
       (2, 9, true, true, true),  -- Japonés
       (2, 10, false, true, false);
-- Coreano

-- Little Nightmares 2
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (3, 1, true, true, false), -- Español
       (3, 2, true, true, true),  -- Inglés
       (3, 3, true, true, false), -- Francés
       (3, 4, true, true, false), -- Alemán
       (3, 5, true, true, false), -- Italiano
       (3, 6, true, true, false), -- Portugués
       (3, 7, true, true, false), -- Ruso
       (3, 8, true, true, false), -- Chino
       (3, 9, true, true, false), -- Japonés
       (3, 10, true, true, false);
-- Coreano

-- Final Fantasy 7 PSX
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (4, 1, true, true, false), -- Español
       (4, 2, true, true, false), -- Inglés
       (4, 3, true, true, false), -- Francés
       (4, 4, true, true, false), -- Alemán
       (4, 5, true, true, false), -- Italiano
       (4, 6, true, true, false), -- Portugués
       (4, 7, true, true, false), -- Ruso
       (4, 8, true, true, false), -- Chino
       (4, 9, true, true, false), -- Japonés
       (4, 10, true, true, false); -- Coreano


INSERT INTO `news_author` (`id`, `name`, `surname`, `image`, `alt`)
VALUES (NULL, 'David', 'Portillo', 'imagen', 'alt'),
       (NULL, 'Sergey', 'Rolando', 'imagen', 'alt'),
       (NULL, 'Paco', 'Porras', 'imagen', 'alt'),
       (NULL, 'Jesús', 'García', 'imagen', 'alt');

INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `date`, `headline`, `image`, `alt`)
VALUES (NULL, 1, 1,
        'Se dice a menudo que los jugadores buscan innumerables maneras de superarse a sí mismos, y esta es una de las más complicadas. No nos referimos a completar Elden Ring con la mente o cosas similares, sino a derrotar a los jefes del juego de FromSoftware, a pesar de que estos son invisibles. Sí, has leído bien, derrotar a jefes que pueden enviarte al más allá con un solo soplido, sin siquiera poder verlos. Esta es la proeza de la streamer BioticNova. Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino. Luego está BioticNova, quien se desafió a sí misma a completar Elden Ring con los ojos abiertos, las manos en el mando, pero con todos los jefes del juego siendo invisibles.',
        '2024-02-20T18:16:17.633882315',
        'Hay una jugadora que se ha pasado Elden Ring con todos los enemigos invisibles. Ya solo nos queda terminar el soulslike con el PC apagado',
        'URL de la image', 'alt'),
       (NULL, 2, 1,
        'Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino. Luego está BioticNova, quien se desafió a sí misma a completar Elden Ring con los ojos abiertos, las manos en el mando, pero con todos los jefes del juego siendo invisibles. Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino. Luego está BioticNova, quien se desafió a sí misma a completar Elden Ring con los ojos abiertos, las manos en el mando, pero con todos los jefes del juego siendo invisibles.',
        '2024-01-23T18:16:17.633882315',
        'Muchos aún no han terminado Elden Ring. Otros lo han logrado, pero no sin sufrir considerablemente en el camino.',
        'URL de la imagen', 'alt'),
       (1, 3, 1,
        'Capcom ha lanzado un nuevo parche que corrige errores y añade un nuevo idioma cuatro años después de su estreno[4].',
        '2023-12-30T18:16:17.633882315',
        'Resident Evil 2 se actualiza con correcciones y un nuevo idioma 4 años después de su estreno', -- headline
        'image_url', 'alt');


INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '1', '1', 'comentario1', '2024-01-10T15:16:17.633882315'),
       (NULL, '1', '2', 'comentario2', '2024-01-20T18:16:17.633882315'),
       (NULL, '1', '1', 'comentario3', '2024-02-10T20:16:17.633882315');

INSERT INTO `feature` (`name`)
VALUES ('Un Jugador'),
       ('Multijugador'),
       ('Jugadores vs Entorno'),
       ('Jugador vs Jugador'),
       ('Coop.Online'),
       ('Coop.LAN');

INSERT INTO `number_player` (`number_players`)
VALUES (1),
       (2),
       (3),
       (4),
       (5),
       (6),
       (7),
       (8),
       (9),
       (10);

INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (1, 1, NULL), -- Asociar el juego con ID 1 con la característica con ID 1 y sin NumberPlayer
       (1, 2, 1),    -- Asociar el juego con ID 1 con la característica con ID 2 y NumberPlayer con ID 1
       (2, 1, NULL), -- Asociar el juego con ID 2 con la característica con ID 1 y sin NumberPlayer
       (2, 3, 2),    -- Asociar el juego con ID 2 con la característica con ID 3 y NumberPlayer con ID 2
       (3, 4, 3),    -- Asociar el juego con ID 3 con la característica con ID 4 y NumberPlayer con ID 3
       (4, 5, 4); -- Asociar el juego con ID 4 con la característica con ID 5 y NumberPlayer con ID 4

INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2023-01-30T18:16:17.633882315', 0, 1, 10, 1, 'Impresionante experiencia de juego',
        'Resident Evil 2 Remake me ha proporcionado una experiencia de juego inolvidable. La atmósfera, los gráficos y la jugabilidad son excepcionales. Lo recomiendo encarecidamente a todos los amantes de los videojuegos.'),
       ('2023-10-30T18:16:17.633882315', 2, 2, 8, 1, 'Buen juego con algunos defectos',
        'Aunque disfruté jugando a The Witcher 3, sentí que la historia era un poco predecible y los controles a veces eran torpes. Sin embargo, el mundo del juego es hermoso y la música es fantástica.'),
       ('2023-11-30T18:16:17.633882315', 1, 3, 9, 2, 'Un clásico atemporal',
        'Super Mario Bros. es un clásico atemporal que sigue siendo tan divertido hoy como cuando se lanzó por primera vez. Aunque los gráficos son simples comparados con los juegos modernos, la jugabilidad es impecable.'),
       ('2023-12-30T18:16:17.633882315', 3, 4, 7, 2, 'Prometedor pero decepcionante',
        'Cyberpunk 2077 prometía mucho, pero al final resultó ser una decepción. A pesar de sus impresionantes gráficos y su interesante historia, los numerosos bugs y problemas técnicos arruinaron la experiencia de juego para mí.');


INSERT INTO gameslist (`date`, `name`, `user_id`)
VALUES ('2023-01-30T18:16:17.633882315', 'Fantasia Puterita', 1),
       ('2023-10-30T18:16:17.633882315', 'De Locura', 2);

INSERT INTO `gameslist_game` (`game_id`, `gameslist_id`)
VALUES (1, 1),
       (3, 1);



INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('7', '2024-02-14 19:02:04.000000', '1', NULL, '1'),
       ('8', '2024-02-14 19:02:04.000000', '1', NULL, '2'),
       ('8', '2024-02-14 19:02:04.000000', '2', NULL, '1'),
       ('9', '2024-02-14 19:02:04.000000', '3', NULL, '2'),
       ('10', '2024-02-14 19:02:04.000000', '4', NULL, '2');