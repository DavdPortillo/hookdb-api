INSERT INTO `translation` (`id`, `language`)
VALUES (NULL, 'Español'),
       (NULL, 'Inglés');

INSERT INTO `role` (`id`, `name`)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_USER');

INSERT INTO `crossplay` (`id`, `has_crossplay`)
VALUES (1, true),
       (2, false);

INSERT INTO system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES ('11', 'NVIDIA GeForce GTX 760 o AMD Radeon R7 260x con 2GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i5-4460 o AMD FX-6300', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 1060 o AMD Radeon RX 480 con 3GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i7-3770 o AMD FX-9590', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 760 o AMD Radeon R7 260x con 2GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i5-4460 o AMD FX-6300', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 1060 o AMD Radeon RX 480 con 3GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i7-3770 o AMD FX-9590', '8 GB', '26 GB'),
       ('11', 'Nvidia GeForce GTX 570, 1 GB | AMD Radeon HD 7850, 2 GB', 'Windows 10, 64-bit',
        'Intel Core i5-2300 | AMD FX-4350', '4 GB RAM', '10 GB'),
       ('11', 'Nvidia GeForce GTX 760, 2 GB | AMD Radeon HD 7870, 2 GB', 'Windows 10, 64-bit',
        'Intel Core i7-3770 | AMD FX-9590', '8 GB RAM', '10 GB'),
       ('11', 'Nvidia GTX 660 o AMD Radeon HD 7850', 'Windows 10', 'Intel Core i3-3250/AMD FX-4350', '8 GB RAM',
        '30 GB'),
       ('11', 'Nvidia GTX 1060 o AMD Radeon RX 5500 XT', 'Windows 10', 'Intel Core i5-9600k/AMD Ryzen 5 2600',
        '16 GB RAM', '30 GB'),
       ('12', 'GeForce GTX 780 / Radeon RX 480 (3GB VRAM)', 'Windows 10 64 bit',
        'Intel Core i5-3330 / AMD FX-8350', '8 GB', '100 GB'),
       ('12', 'GeForce GTX 1080 / Radeon RX 5700 (8GB VRAM)', 'Windows 10 64 bit',
        'Intel Core i7-3770 / AMD Ryzen 3 3100', '12 GB', '100 GB'),
       ('12', 'GeForce RTX 2060 / Radeon RX 6600', 'Windows 10/11 64-bit', 'Intel i5-7600K', '16 GB',
        '90 GB SSD'),
       ('12', 'GeForce RTX 3060 / Radeon RX 6600 XT', 'Windows 10/11 64-bit', 'Ryzen 7 3700X',
        '16 GB', '90 GB SSD'),
       ('11', 'NVIDIA GeForce GTX 760 o AMD Radeon R7 260x con 2GB VRAM', 'WINDOWS 7, 8.1, 10',
        'Intel Core i5-4460 o AMD FX-6300', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 1060 o AMD Radeon RX 480 con 3GB VRAM', 'WINDOWS 7, 8.1, 10',
        'Intel Core i7-3770 o AMD FX-9590', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 760 o AMD Radeon R7 260x con 2GB VRAM', 'WINDOWS 7, 8.1, 10',
        'Intel Core i5-4460 o AMD FX-6300', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 1060 o AMD Radeon RX 480 con 3GB VRAM', 'WINDOWS 7, 8.1, 10',
        'Intel Core i7-3770 o AMD FX-9590', '8 GB', '26 GB'),
       ('11', 'Nvidia GeForce GTX 570, 1 GB | AMD Radeon HD 7850, 2 GB', 'Windows 10, 64-bit',
        'Intel Core i5-2300 | AMD FX-4350', '4 GB RAM', '10 GB'),
       ('11', 'Nvidia GeForce GTX 760, 2 GB | AMD Radeon HD 7870, 2 GB', 'Windows 10, 64-bit',
        'Intel Core i7-3770 | AMD FX-9590', '8 GB RAM', '10 GB'),
       ('11', 'Nvidia GTX 660 o AMD Radeon HD 7850', 'Windows 10', 'Intel Core i3-3250/AMD FX-4350', '8 GB RAM',
        '30 GB'),
       ('11', 'Nvidia GTX 1060 o AMD Radeon RX 5500 XT', 'Windows 10', 'Intel Core i5-9600k/AMD Ryzen 5 2600',
        '16 GB RAM', '30 GB'),
       ('12', 'GeForce GTX 780 / Radeon RX 480 (3GB VRAM)', 'Windows 10 64 bit ',
        'Intel Core i5-3330 / AMD FX-8350', '8 GB', '100 GB'),
       ('12', 'GeForce GTX 1080 / Radeon RX 5700 (8GB VRAM)', 'Windows 10 64 bit ',
        'Intel Core i7-3770 / AMD Ryzen 3 3100', '12 GB', '100 GB'),
       ('12', 'GeForce RTX 2060 / Radeon RX 6600', 'Windows 10/11 64-bit', 'Intel i5-7600K', '16 GB',
        '90 GB SSD'),
       ('12', 'GeForce RTX 3060 / Radeon RX 6600 XT', 'Windows 10/11 64-bit', 'Ryzen 7 3700X',
        '16 GB', '90 GB SSD');


-- a123456. -> Contraseña encriptada con Bcrypt
INSERT INTO `user` (`year`, `id`, `role_id`, `language`, `country`, `username`, `password`, `email`, `gender`,
                    `image`, `alt`, `register_date`)
VALUES (1950, 1, 1, 'Idioma del usuario', 'España', 'Admin',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'admin@admin.com', NULL, '2',
        'alt',
        '2024/11/02'),
       (1950, 2, 2, 'Idioma del usuario', 'España', 'David',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'david@david.com', NULL, '2',
        'alt',
        '2024/11/02'),
       (1950, 3, 2, 'Idioma del usuario', 'España', 'Sergio',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'sergio@sergio.com', NULL, '2',
        'alt',
        '2024/11/02'),
       (1950, 4, 2, 'Idioma del usuario', 'España', 'Alejandro',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'alejandro@alejandro.com', NULL,
        'URL de la imagen', 'alt', '2024/11/02'),
       (1950, 5, 2, 'Idioma del usuario', 'España', 'Eustaquio',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'eustaquio@eustaquio.com', NULL,
        'URL de la imagen', 'alt', '2024/11/02'),
       (1950, 6, 2, 'Idioma del usuario', 'España', 'Dominic',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'dominic@dominic.com', NULL, 'URL de la imagen',
        'alt', '2024/11/02'),
       (1950, 7, 2, 'Idioma del usuario', 'España', 'Paco',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'paco@paco.com', NULL,
        'URL de la imagen', 'alt', '2024/11/02'),
       (1950, 8, 2, 'Idioma del usuario', 'España', 'Roma',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'roma@roma.com', NULL,
        'URL de la imagen', 'alt', '2024/11/02'),
       (1950, 9, 2, 'Idioma del usuario', 'España', 'Eugenio',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'eugenio@eugenio.com', NULL, 'URL de la imagen',
        'alt', '2024/11/02');



INSERT INTO `saga` (`id`, `name`)
VALUES ('1', 'Resident Evil'),
       ('2', 'Resident Evil'),
       ('3', 'Little Nightmares'),
       ('4', 'Little Nightmares'),
       ('5', 'Diablo'),
       ('6', 'Diablo'),
       ('7', 'Final Fantasy'),
       ('8', 'Final Fantasy'),
       ('9', 'Alan Wake'),
       ('10', 'Alan Wake');



INSERT INTO `game` (`complete_time`, `story_time`, `crossplay_id`, `id`, `minimum_system_requirement_id`,
                    `recommended_system_requirement_id`, `saga_id`, `alt`, `cover`, `date`, `sinopsis`, `title`,
                    `popularity`,
                    `trailer`, `translation_id`)
VALUES (2100, 540, 2, 1, '1', '2', '1', 'Imagen del Resident Evil 2 Remake',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/883710/header.jpg?t=1701395502',
        '2019/01/25',
        'Resident Evil 2 Remake” es una versión completamente reimaginada del clásico juego de 1998. Ambientado en la ciudad de Raccoon City, sumida en un apocalipsis zombi, los jugadores controlan a Leon S. Kennedy, un policía novato, y a Claire Redfield, una estudiante universitaria. Ambos buscan sobrevivir y descubrir la verdad detrás del brote que ha transformado a los ciudadanos en muertos vivientes.
El juego alterna entre ambos personajes, cada uno con su propia perspectiva y áreas de exploración. Leon se encuentra con Ada Wong, una agente federal enigmática, mientras que Claire intenta proteger a Sherry Birkin, la hija de un ejecutivo de Umbrella. Con una jugabilidad mejorada y gráficos actualizados, el remake ofrece tanto a los nuevos jugadores como a los fans del original una experiencia de terror intensa y envolvente.',
        'Resident Evil 2 Remake', 0, 'https://www.youtube.com/watch?v=xtxJtQa6VSw', 1),
       (2100, 540, 1, 2, '3', '4', '2', 'Imagen del Resident Evil 2 Remake',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/883710/header.jpg?t=1701395502',
        '2019/01/25',
        'Resident Evil 2 Remake” brings players back to the terrifying Raccoon City, reimagined from the 1998 horror classic. In this survival horror adventure, players choose between Leon S. Kennedy, a rookie cop, and Claire Redfield, a college student, as they navigate a city overrun by zombies. Their quest for survival reveals the dark side of a bioweapon disaster while they encounter other survivors and face the monstrous results of the outbreak. With revamped gameplay and stunning graphics, the game offers a modern twist on the original’s chilling narrative.',
        'Resident Evil 2 Remake', 0, 'https://www.youtube.com/watch?v=xtxJtQa6VSw', 2),
       (300, 240, 2, 3, '5', '6', '3', 'Imagen de Little Nightmares II',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/860510/header.jpg?t=1629372719',
        '2021/02/11',
        'Little Nightmares II es un juego de plataformas y rompecabezas con elementos de horror. Los jugadores controlan a Mono, un niño atrapado en un mundo distorsionado y oscuro. Junto a Six, la protagonista del primer juego, deben enfrentarse a enemigos aterradores y resolver acertijos para avanzar. La atmósfera inquietante y el estilo artístico único son las señas de identidad del juego.',
        'Little Nightmares II', 0, 'https://www.youtube.com/watch?v=Td9nPbsDV-0', 1),
       (300, 240, 1, 4, '7', '8', '4', 'Imagen de Little Nightmares II',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/860510/header.jpg?t=1629372719',
        '2021/02/11',
        'Little Nightmares II is a platformer and puzzle game with horror elements. Players control Mono as he navigates a dark and distorted world, teaming up with Six from the first game to face terrifying enemies and solve puzzles. The game’s eerie atmosphere and unique art style set it apart from other titles in the genre.',
        'Little Nightmares II', 0, 'https://www.youtube.com/watch?v=Td9nPbsDV-0', 2),
       (1500, 1200, 2, 5, '9', '10', '5', 'Imagen de Diablo II: Resurrected',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/1406030/header.jpg?t=1632431742',
        '2021/09/23',
        'Diablo II: Resurrected es una remasterización del clásico juego de rol de acción Diablo II y su expansión, Lord of Destruction. Los jugadores asumen el papel de un héroe que debe enfrentarse a las hordas demoníacas del Señor del Terror, Diablo, y sus hermanos. Con gráficos mejorados, sonido actualizado y jugabilidad clásica, esta versión trae de vuelta la intensa experiencia del original con mejoras modernas.',
        'Diablo II: Resurrected', 0, 'https://www.youtube.com/watch?v=DRP62MGOrU4', 1),
       (1500, 1200, 1, 6, '11', '12', '6', 'Imagen de Diablo II: Resurrected',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/1406030/header.jpg?t=1632431742',
        '2021/09/23',
        'Diablo II: Resurrected is a remastered version of the classic action RPG Diablo II and its expansion, Lord of Destruction. Players take on the role of a hero who must battle the demonic hordes of the Lord of Terror, Diablo, and his brothers. With enhanced graphics, updated sound, and classic gameplay, this version brings back the intense experience of the original with modern improvements.',
        'Diablo II: Resurrected', 0, 'https://www.youtube.com/watch?v=DRP62MGOrU4', 2),
       (2500, 2100, 1, 7, '13', '14', '7', 'Imagen de Final Fantasy VII',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/39140/header.jpg?t=1603128794',
        '2020/10/04',
        'Final Fantasy VII es un clásico juego de rol que sigue la historia de Cloud Strife, un ex-soldado que se une a un grupo de resistencia llamado AVALANCHE para luchar contra la megacorporación Shinra. La historia profundiza en temas de ecoterrorismo, identidad y redención mientras los personajes viajan por un mundo detallado y fascinante. Con su revolucionario sistema de combate y su narrativa épica, Final Fantasy VII ha dejado una marca duradera en la historia de los videojuegos.',
        'Final Fantasy VII', 0, 'https://www.youtube.com/watch?v=I77s1p2r6rY', 1),
       (2500, 2100, 1, 8, '15', '16', '8', 'Imagen de Final Fantasy VII',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/39140/header.jpg?t=1603128794',
        '2020/10/04',
        'Final Fantasy VII is a classic role-playing game that follows the story of Cloud Strife, a former soldier who joins a resistance group called AVALANCHE to fight against the megacorporation Shinra. The story delves into themes of eco-terrorism, identity, and redemption as the characters travel through a detailed and fascinating world. With its revolutionary combat system and epic narrative, Final Fantasy VII has left a lasting mark on video game history.',
        'Final Fantasy VII', 0, 'https://www.youtube.com/watch?v=I77s1p2r6rY', 2),
       (2500, 900, 2, 9, '17', '18', '9', 'Imagen de Alan Wake 2',
        'https://cdn.alanwake2.com/header.jpg',
        '2023/10/17',
        'Alan Wake 2 es la secuela del aclamado juego de acción y horror psicológico Alan Wake. La historia sigue a Alan Wake, un escritor de novelas de terror, mientras lucha por escapar de una realidad distorsionada y descubrir la verdad detrás de los eventos sobrenaturales que lo rodean. Con gráficos impresionantes, una narrativa envolvente y una jugabilidad que combina acción y misterio, Alan Wake 2 ofrece una experiencia única y aterradora.',
        'Alan Wake 2', 0, 'https://www.youtube.com/watch?v=8yDO9dDfrLg', 1),
       (2500, 900, 2, 10, '19', '20', '10', 'Imagen de Alan Wake 2',
        'https://cdn.alanwake2.com/header.jpg',
        '2023/10/17',
        'Alan Wake 2 is the sequel to the acclaimed action and psychological horror game Alan Wake. The story follows Alan Wake, a horror novelist, as he struggles to escape a distorted reality and uncover the truth behind the supernatural events surrounding him. With stunning graphics, an immersive narrative, and gameplay that blends action and mystery, Alan Wake 2 offers a unique and terrifying experience.',
        'Alan Wake 2', 0, 'https://www.youtube.com/watch?v=8yDO9dDfrLg', 2),
       (2500, 900, 2, 11, '21', '22', '1', 'Imagen de Resident Evil 4',
        'https://cdn.alanwake2.com/header.jpg',
        '2024/07/17',
        'Resident Evil 4 es un juego de acción y terror que sigue a Leon S. Kennedy en una misión para rescatar a la hija del presidente de los Estados Unidos. En un pueblo remoto de Europa, Leon se enfrenta a una horda de infectados por un parásito y descubre una conspiración que amenaza con desatar una nueva amenaza biológica. Con su innovador sistema de combate y su atmósfera inquietante, Resident Evil 4 es un clásico moderno del género de los survival horror.',
        'Resident Evil 4 Remake', 0, 'https://www.youtube.com/watch?v=8yDO9dDfrLg', 1),
       (2500, 900, 2, 12, '23', '24', '2', 'Imagen de Resident Evil 4',
        'https://image.api.playstation.com/vulcan/ap/rnd/202210/0712/BiS5QP6h4506JHyJlZlVzK9D.jpg',
        '2024/07/17',
        'Resident Evil 4 is an action-packed horror game that follows Leon S. Kennedy on a mission to rescue the President of the United States’ daughter. In a remote village in Europe, Leon faces off against a horde of parasite-infected enemies and uncovers a conspiracy that threatens to unleash a new biological threat. With its innovative combat system and eerie atmosphere, Resident Evil 4 is a modern classic in the survival horror genre',
        'Resident Evil 4 Remake', 0, 'https://www.youtube.com/watch?v=8yDO9dDfrLg', 2);


INSERT INTO `platform` (`name`)
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


-- Resident Evil 2 Remake
INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (1, 1), -- Resident Evil 2 Remake en PC
       (1, 3), -- Resident Evil 2 Remake en PS4
       (1, 4), -- Resident Evil 2 Remake en Xbox One
       (1, 2), -- Resident Evil 2 Remake en PS5
       (1, 5), -- Resident Evil 2 Remake en Xbox Series X
       (2, 1), -- Resident Evil 2 Remake en PC
       (2, 3), -- Resident Evil 2 Remake en PS4
       (2, 4), -- Resident Evil 2 Remake en Xbox One
       (2, 2), -- Resident Evil 2 Remake en PS5
       (2, 5);
-- Xbox Series X

--  Little Nightmares II
INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (3, 1), -- Resident Evil 2 Remake en PC
       (3, 2), -- Resident Evil 2 Remake en PS5
       (3, 5), -- Resident Evil 2 Remake en Xbox Series X
       (4, 1), -- Resident Evil 2 Remake en PC
       (4, 2), -- Resident Evil 2 Remake en PS5
       (4, 5);
-- Resident Evil 2 Remake en Xbox Series X

-- Diablo II: ResurrectedQ
INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (5, 1), -- Diablo II: Resurrected en PC
       (5, 2), -- Diablo II: Resurrected en PS5
       (5, 5), -- Diablo II: Resurrected en Xbox Series X
       (6, 1), -- Diablo II: Resurrected en PC
       (6, 2), -- Diablo II: Resurrected en PS5
       (6, 5);
-- Diablo II: Resurrected en Xbox Series X


-- Final Fantasy VII
INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (7, 1), -- Final Fantasy VII en PC
       (7, 2), -- Final Fantasy VII en PS5
       (7, 5), -- Final Fantasy VII en Xbox Series X
       (8, 1), -- Final Fantasy VII en PC
       (8, 2), -- Final Fantasy VII en PS5
       (8, 5);
-- Final Fantasy VII en Xbox Series X

-- Alan Wake 2
INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (9, 1),  -- Alan Wake 2 en PC
       (9, 2),  -- Alan Wake 2 en PS5
       (9, 5),  -- Alan Wake 2 en Xbox Series X
       (10, 1), -- Alan Wake 2 en PC
       (10, 2), -- Alan Wake 2 en PS5
       (10, 5);
-- Alan Wake 2 en Xbox Series X


-- Resident Evil 4 Remake
INSERT INTO `game_platform` (`game_id`, `platform_id`)
VALUES (11, 1), -- Resident Evil 4 Remake en PC
       (11, 2), -- Resident Evil 4 Remake en PS5
       (11, 5), -- Resident Evil 4 Remake en Xbox Series X
       (11, 6),
       (12, 1), -- Resident Evil 4 Remake en PC
       (12, 2), -- Resident Evil 4 Remake en PS5
       (12, 5),-- Resident Evil 4 Remake en Xbox Series X
       (12, 6);


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
       (2, 8),
       (2, 11),
       (2, 7);


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

-- Resident Evil 2 Remake
INSERT INTO game_developer (game_id, developer_id)
VALUES (1, 1),
       (2, 1);

-- Resident Evil 4 Remake
INSERT INTO game_developer (game_id, developer_id)
VALUES (11, 1),
       (12, 1);

-- Little Nightmares II
INSERT INTO game_developer (game_id, developer_id)
VALUES (3, 3),
       (4, 3);

-- Diablo II: Resurrected
INSERT INTO game_developer (game_id, developer_id)
VALUES (5, 11),
       (6, 11);

-- Final Fantasy VII
INSERT INTO game_developer (game_id, developer_id)
VALUES (7, 4),
       (8, 4);

-- Alan Wake 2
INSERT INTO game_developer (game_id, developer_id)
VALUES (9, 2),
       (10, 2);

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


-- Resident Evil 2 Remake
INSERT INTO game_distributor (game_id, distributor_id)
VALUES (1, 1),
       (2, 1);

-- Resident Evil 4 Remake
INSERT INTO game_distributor (game_id, distributor_id)
VALUES (11, 1),
       (12, 1);

-- Little Nightmares II
INSERT INTO game_distributor (game_id, distributor_id)
VALUES (3, 3),
       (4, 3);

-- Diablo II: Resurrected
INSERT INTO game_distributor (game_id, distributor_id)
VALUES (5, 17),
       (6, 17);

-- Final Fantasy VII
INSERT INTO game_distributor (game_id, distributor_id)
VALUES (7, 4),
       (8, 4);

-- Alan Wake 2
INSERT INTO game_distributor (game_id, distributor_id)
VALUES (9, 2),
       (10, 2);

-- Resident Evil 2 Remake
INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (1, 'Extra DLC Pack', '2019/02/15',
        'Un paquete de contenido descargable que incluye los siguientes elementos: The 4th Survivor, The Tofu Survivor, Traje de Claire: Elza Walker, Traje de Claire: Military, Traje de Claire: Noir, Traje de Leon: Arklay Sheriff, Traje de Leon: Noir, Modelo de pistola: Samurai Edge',
        'Imagen de DLC', 'https://cdn.cloudflare.steamstatic.com/steam/apps/883710/header.jpg?t=1701395502'),
       (2, 'Extra DLC Pack', '2019/02/15',
        'A downloadable content pack that includes the following items: The 4th Survivor, The Tofu Survivor, Claire Costume: Elza Walker, Claire Costume: Military, Claire Costume: Noir, Leon Costume: Arklay Sheriff, Leon Costume: Noir, Weapon Model: Samurai Edge',
        'DLC Image', 'https://cdn.cloudflare.steamstatic.com/steam/apps/883710/header.jpg?t=1701395502');


-- Little Nightmares II
INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (3, 'Secrets of the Maw Expansion Pass', '2021/02/11',
        'Un pase de expansión que incluye los siguientes capítulos: The Depths, The Hideaway, The Residence',
        'Imagen de DLC', 'https://cdn.cloudflare.steamstatic.com/steam/apps/860510/header.jpg?t=1629372719'),
       (4, 'Secrets of the Maw Expansion Pass', '2021/02/11',
        'An expansion pass that includes the following chapters: The Depths, The Hideaway, The Residence',
        'DLC Image', 'https://cdn.cloudflare.steamstatic.com/steam/apps/860510/header.jpg?t=1629372719');

-- Diablo II: Resurrected
INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (5, 'Lord of Destruction Expansion', '2021/09/23',
        'Un paquete de expansión que agrega nuevo contenido al juego base, incluyendo nuevas clases de personajes, objetos y áreas por explorar.',
        'DLC Image', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1406030/header.jpg?t=1632431742'),
       (6, 'Lord of Destruction Expansion', '2021/09/23',
        'An expansion pack that adds new content to the base game, including new character classes, items, and areas to explore.',
        'DLC Image', 'https://cdn.cloudflare.steamstatic.com/steam/apps/1406030/header.jpg?t=1632431742');

-- Final Fantasy VII
INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (7, 'Remake Intergrade', '2020/10/04',
        'Un paquete de contenido descargable que incluye los siguientes elementos: Episodio de Yuffie, Mini-juego de Fort Condor, Nueva Materia de Invocación, Nuevas Armas',
        'DLC Image', 'https://cdn.cloudflare.steamstatic.com/steam/apps/39140/header.jpg?t=1603128794'),
       (8, 'Remake Intergrade', '2020/10/04',
        'A downloadable content pack that includes the following items: Yuffie Episode, Fort Condor Mini-Game, New Summon Materia, New Weapons',
        'DLC Image', 'https://cdn.cloudflare.steamstatic.com/steam/apps/39140/header.jpg?t=1603128794');

-- Alan Wake 2
INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (9, 'AWE Expansion', '2023/10/17',
        'Un paquete de expansión que continúa la historia de Alan Wake, introduciendo nuevos personajes, ubicaciones y misterios por resolver.',
        'DLC Image', 'https://cdn.alanwake2.com/header.jpg'),
       (10, 'AWE Expansion', '2023/10/17',
        'An expansion pack that continues the story of Alan Wake, introducing new characters, locations, and mysteries to solve.',
        'DLC Image', 'https://cdn.alanwake2.com/header.jpg');

-- Resident Evil 4 Remake
INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (11, 'Separate Ways', '2024/08/17',
        'Un paquete de expansión que añade una nueva campaña jugable centrada en Ada Wong, un personaje secundario de la historia principal. Los jugadores controlan a Ada mientras se adentra en la misteriosa organización detrás de los eventos de Resident Evil 4.',
        'Imagen de DLC', 'https://cdn.alanwake2.com/header.jpg'),
       (12, 'Separate Ways', '2024/08/17',
        'An expansion pack that adds a new playable campaign centered on Ada Wong, a secondary character from the main story. Players control Ada as she delves into the mysterious organization behind the events of Resident Evil 4.',
        'DLC Image', 'https://cdn.alanwake2.com/header.jpg');


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
       ('Spanish'),
       ('English'),
       ('French'),
       ('German'),
       ('Italian'),
       ('Portuguese'),
       ('Russian'),
       ('Chinese'),
       ('Japanese');


-- Resident Evil 2 Remake
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (1, 1, true, true, true),   -- Español
       (1, 2, true, true, true),   -- Inglés
       (1, 3, true, true, true),   -- Francés
       (1, 4, true, true, true),   -- Alemán
       (1, 5, true, true, true),   -- Italiano
       (1, 6, true, true, false),  -- Portugués
       (1, 7, true, true, false),  -- Ruso
       (1, 8, true, true, false),  -- Chino
       (1, 9, true, true, false),  -- Japonés
       (2, 10, true, true, true),  -- Español
       (2, 11, true, true, true),  -- Inglés
       (2, 12, true, true, true),  -- Francés
       (2, 13, true, true, true),  -- Alemán
       (2, 14, true, true, true),  -- Italiano
       (2, 15, true, true, false), -- Portugués
       (2, 16, true, true, false), -- Ruso
       (2, 17, true, true, false), -- Chino
       (2, 18, true, true, false);
-- Japonés

-- Resident Evil 4 Remake
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (11, 1, true, true, true),   -- Español
       (11, 2, true, true, true),   -- Inglés
       (11, 3, true, true, true),   -- Francés
       (11, 4, true, true, true),   -- Alemán
       (11, 5, true, true, true),   -- Italiano
       (11, 6, true, true, false),  -- Portugués
       (11, 7, true, true, false),  -- Ruso
       (11, 8, true, true, false),  -- Chino
       (11, 9, true, true, false),  -- Japonés
       (12, 10, true, true, true),  -- Español
       (12, 11, true, true, true),  -- Inglés
       (12, 12, true, true, true),  -- Francés
       (12, 13, true, true, true),  -- Alemán
       (12, 14, true, true, true),  -- Italiano
       (12, 15, true, true, false), -- Portugués
       (12, 16, true, true, false), -- Ruso
       (12, 17, true, true, false), -- Chino
       (12, 18, true, true, false);

-- Little Nightmares II
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (3, 1, true, true, false),  -- Español
       (3, 2, true, true, false),  -- Inglés
       (3, 3, true, true, false),  -- Francés
       (3, 4, true, true, false),  -- Alemán
       (3, 5, true, true, false),  -- Italiano
       (3, 6, true, true, false),  -- Portugués
       (4, 10, true, true, false), -- Español
       (4, 11, true, true, false), -- Inglés
       (4, 12, true, true, false), -- Francés
       (4, 13, true, true, false), -- Alemán
       (4, 14, true, true, false), -- Italiano
       (4, 15, true, true, false);
-- Portugués


-- Diablo II: Resurrected
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (5, 1, true, true, true),  -- Español
       (5, 2, true, true, true),  -- Inglés
       (5, 3, true, true, true),  -- Francés
       (5, 4, true, true, true),  -- Alemán
       (5, 5, true, true, true),  -- Italiano
       (5, 6, true, true, false), -- Portugués
       (6, 10, true, true, true), -- Español
       (6, 11, true, true, true), -- Inglés
       (6, 12, true, true, true), -- Francés
       (6, 13, true, true, true), -- Alemán
       (6, 14, true, true, true), -- Italiano
       (6, 15, true, true, false);
-- Portugués


-- Final Fantasy VII
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (7, 1, true, true, false),  -- Español
       (7, 2, true, true, true),   -- Inglés
       (7, 4, true, true, false),  -- Alemán
       (7, 5, true, true, false),  -- Italiano
       (8, 10, true, true, false), -- Español
       (8, 11, true, true, true),  -- Inglés
       (8, 13, true, true, false), -- Alemán
       (8, 14, true, true, false);
-- Italiano

-- Alan Wake 2
INSERT INTO availability (game_id, language_id, interface_language, subtitle_language, audio_language)
VALUES (9, 1, true, true, true),   -- Español
       (9, 2, true, true, true),   -- Inglés
       (9, 3, true, true, true),   -- Francés
       (9, 4, true, true, true),   -- Alemán
       (9, 5, true, true, true),   -- Italiano
       (9, 6, true, true, false),  -- Portugués
       (10, 10, true, true, true), -- Español
       (10, 11, true, true, true), -- Inglés
       (10, 12, true, true, true), -- Francés
       (10, 13, true, true, true), -- Alemán
       (10, 14, true, true, true), -- Italiano
       (10, 15, true, true, false);


INSERT INTO `news_author` (`id`, `name`, `surname`, `image`, `alt`)
VALUES (NULL, 'Alejandro', 'Romero', 'https://miro.medium.com/v2/resize:fit:1024/0*wATbQ49jziZTyhZH.jpg', 'alt'),
       (NULL, 'Eustaquio', 'García', 'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'alt'),
       (NULL, 'Dominic', 'Toretto', 'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'alt');


-- Resident Evil 2 Remake
INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (1, 1, 1,
        'Capcom ha anunciado recientemente que “Resident Evil 2 Remake” ha superado los 11,2 millones de copias vendidas, consolidando su posición como uno de los títulos más exitosos y queridos de la franquicia1. Este hito es un testimonio del trabajo duro y la dedicación del equipo de desarrollo, que logró reimaginar el clásico de 1998 para las audiencias modernas.

El juego, que se lanzó originalmente en enero de 2019, ha recibido elogios tanto de críticos como de jugadores por su fiel recreación del ambiente de terror del original, al tiempo que introduce mejoras significativas en los gráficos y la jugabilidad. La capacidad de Capcom para equilibrar la nostalgia con la innovación ha sido clave para el éxito del juego.

Además de las impresionantes cifras de ventas, “Resident Evil 2 Remake” ha recibido actualizaciones constantes desde su lanzamiento. La más reciente incluye la adición del español latinoamericano como opción de idioma, lo que demuestra el compromiso de Capcom con su base de jugadores global2.

El éxito de “Resident Evil 2 Remake” no solo ha revitalizado el interés en los títulos anteriores de la serie, sino que también ha establecido un precedente para futuros remakes. Con el lanzamiento del “Resident Evil 4 Remake” a la vuelta de la esquina, los fans tienen grandes expectativas de que Capcom continuará entregando experiencias de juego de alta calidad que honren el legado de la serie.

Mientras tanto, la comunidad de jugadores sigue explorando los oscuros pasillos de la comisaría de Raccoon City y las profundidades del laboratorio de Umbrella, disfrutando de los sustos y desafíos que “Resident Evil 2 Remake” tiene para ofrecer. Con su combinación de horror clásico y modernidad, el juego sigue siendo un referente en el género de terror y supervivencia.',
        'El Legado de un Clásico Renace: Resident Evil 2 Remake Sigue Cautivando a Jugadores en Todo el Mundo',
        '2024-01-23T18:16:17.633882315',
        'Capcom Celebra el Éxito Continuo de Resident Evil 2 Remake',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg', 'alt', 1),
       (2, 2, 1,
        'Capcom has recently announced that “Resident Evil 2 Remake” has surpassed 11.2 million copies sold, solidifying its position as one of the most successful and beloved titles in the franchise. This milestone is a testament to the hard work and dedication of the development team, who managed to reimagine the 1998 classic for modern audiences.

The game, which was originally released in January 2019, has been praised by critics and players alike for its faithful recreation of the original’s atmosphere of terror, while introducing significant improvements in graphics and gameplay. Capcom’s ability to balance nostalgia with innovation has been key to the game’s success.

In addition to impressive sales figures, “Resident Evil 2 Remake” has received constant updates since its release. The most recent includes the addition of Latin American Spanish as a language option, demonstrating Capcom’s commitment to its global player base.

The success of “Resident Evil 2 Remake” has not only revitalized interest in the series’ previous titles but has also set a precedent for future remakes. With the release of “Resident Evil 4 Remake” just around the corner, fans have high expectations that Capcom will continue to deliver high-quality gaming experiences that honor the legacy of the series.

Meanwhile, the gaming community continues to explore the dark corridors of the Raccoon City police station and the depths of the Umbrella laboratory, enjoying the scares and challenges that “Resident Evil 2 Remake” has to offer. With its combination of classic horror and modernity, the game remains a benchmark in the survival horror genre.',
        'The Legacy of a Classic Reborn: Resident Evil 2 Remake Continues to Captivate Players Around the World',
        '2024-01-23T18:16:17.633882315',
        'Capcom Celebrates the Ongoing Success of Resident Evil 2 Remake',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg', 'alt', 2);


-- Little Nightmares II
INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (3, 3, 1,
        'En el mundo de los videojuegos, pocas secuelas logran capturar la esencia de su predecesor mientras expanden su universo de manera significativa. Little Nightmares II no solo ha logrado este raro equilibrio sino que también ha elevado el listón para los juegos de terror y aventura. Desde su lanzamiento, ha recibido elogios tanto de críticos como de jugadores por su atmósfera envolvente, diseño de rompecabezas ingenioso y una narrativa que se desarrolla con una tensión palpable.

La historia de Mono y Six, dos niños atrapados en un mundo distorsionado por transmisiones siniestras, ha resonado con una audiencia global, llevando a la franquicia a superar las 12 millones de unidades vendidas. Este hito no solo demuestra el éxito comercial del juego sino también su impacto cultural en la industria del entretenimiento interactivo.

Con una dirección artística que combina lo grotesco con lo hermoso, Little Nightmares II ofrece una experiencia visualmente deslumbrante que se queda grabada en la memoria de los jugadores. La capacidad del juego para contar una historia profunda sin una sola línea de diálogo es una hazaña que pocos títulos pueden presumir.

A medida que los jugadores guían a Mono a través de la Ciudad Pálida, se encuentran con escenarios que son tanto cautivadores como inquietantes. Cada escena está meticulosamente diseñada para evocar emociones y provocar reflexiones sobre los temas oscuros que subyacen en la narrativa del juego.

El éxito de Little Nightmares II es un testimonio del talento y la visión de Tarsier Studios, que ha creado no solo un juego, sino una obra de arte interactiva. Mientras los fanáticos esperan ansiosamente noticias sobre una posible tercera entrega, la saga Little Nightmares sigue siendo un referente en el género de terror y aventura.',
        'La secuela del aclamado juego de terror y aventura sigue superando expectativas con su inmersiva narrativa y estilo visual único.',
        '2024-06-04T18:16:17.633882315',
        'Little Nightmares II: Un Viaje Aterrador que Continúa Cautivando a Millones',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg', 'alt', 1),

       (4, 4, 2,
        'In the world of video games, few sequels manage to capture the essence of their predecessor while expanding their universe in a meaningful way. Little Nightmares II has not only achieved this rare balance but has also raised the bar for horror and adventure games. Since its release, it has garnered praise from both critics and players for its enveloping atmosphere, clever puzzle design, and a narrative that unfolds with palpable tension.

The story of Mono and Six, two children trapped in a world distorted by sinister transmissions, has resonated with a global audience, leading the franchise to surpass 12 million units sold. This milestone not only demonstrates the commercial success of the game but also its cultural impact on the interactive entertainment industry.

With an artistic direction that combines the grotesque with the beautiful, Little Nightmares II offers a visually stunning experience that remains etched in the players’ memories. The game’s ability to tell a profound story without a single line of dialogue is a feat few titles can boast.

As players guide Mono through the Pale City, they encounter scenarios that are both captivating and disturbing. Each scene is meticulously crafted to evoke emotions and provoke thoughts on the dark themes underlying the game’s narrative.

The success of Little Nightmares II is a testament to the talent and vision of Tarsier Studios, which has created not just a game, but an interactive work of art. As fans eagerly await news of a possible third installment, the Little Nightmares saga remains a benchmark in the horror and adventure genre.',
        'The sequel to the acclaimed horror and adventure game continues to exceed expectations with its immersive narrative and unique visual style.',
        '2024-06-04T18:16:17.633882315',
        'Little Nightmares II: A Terrifying Journey That Continues to Captivate Millions',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg', 'alt', 2);


-- Diablo II: Resurrected
INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (5, 5, 1,
        'La temporada 7 de la jerarquía de Diablo II: Resurrected ya está en marcha, y los jugadores de todo el mundo están listos para enfrentarse a las hordas del infierno una vez más. Con el lanzamiento del parche 2.7.3 el pasado 21 de mayo, la nueva temporada promete ser una de las más emocionantes hasta la fecha.

    Esta temporada introduce una serie de nuevas palabras rúnicas, modificadores de juego y zonas de terror que pondrán a prueba incluso a los jugadores más experimentados. Además, se han implementado mejoras en la calidad de vida y correcciones de errores que aseguran una experiencia de juego más fluida y satisfactoria.

    Los aventureros que se atrevan a sumergirse en las profundidades de Santuario encontrarán que las recompensas son tan grandes como los riesgos. Desde armaduras únicas hasta armas legendarias, la temporada 7 ofrece una gran variedad de botines que ayudarán a los jugadores en su lucha contra Diablo y sus secuaces.

    Con eventos especiales programados a lo largo de la temporada y la posibilidad de escalar en las clasificaciones de la jerarquía, la comunidad de Diablo II: Resurrected se encuentra más activa y comprometida que nunca. Los desarrolladores han prometido seguir apoyando el juego con contenido fresco y actualizaciones regulares, asegurando que la llama de Diablo II siga ardiendo por muchos años más.',
        'La última temporada trae consigo desafíos renovados y recompensas exclusivas para los jugadores más valientes de Santuario.',
        '2024-05-01T18:16:17.633882315', 'Diablo II: Resurrected Temporada 7: El Infierno se Despierta de Nuevo',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'Imagen de portada', 1),
       (6, 6, 2,
        'Season 7 of the Diablo II: Resurrected ladder is underway, and players around the world are ready to face the hordes of hell once again. With the release of patch 2.7.3 on May 21st, the new season promises to be one of the most thrilling to date.

This season introduces a series of new rune words, game modifiers, and terror zones that will test even the most seasoned players. In addition, quality of life improvements and bug fixes have been implemented to ensure a smoother and more satisfying gaming experience.

Adventurers daring to delve into the depths of Sanctuary will find that the rewards are as great as the risks. From unique armors to legendary weapons, season 7 offers a wide variety of loot that will aid players in their fight against Diablo and his minions.

With special events scheduled throughout the season and the chance to climb the ladder rankings, the Diablo II: Resurrected community is more active and engaged than ever. The developers have promised to continue supporting the game with fresh content and regular updates, ensuring that the flame of Diablo II continues to burn for many more years.',
        'The latest season brings renewed challenges and exclusive rewards for the bravest players of Sanctuary.',
        '2024-05-01T18:16:17.633882315', 'Diablo II: Resurrected Launches Season 7 with New Surprises',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'Imagen de portada', 2);

-- Final Fantasy VII
INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (7, 7, 1,
        'Mientras el mundo aún celebra el lanzamiento de Final Fantasy VII Rebirth, Square Enix ya está preparando el terreno para la tercera y última parte de la trilogía del remake. Con el compromiso de ofrecer “aún más libertad” en el combate y una jugabilidad renovada, la próxima entrega se perfila como la más ambiciosa de la serie.

La historia de Cloud y sus compañeros llegará a su clímax en una aventura que promete no solo cerrar la trama con broche de oro, sino también introducir elementos de juego que sorprenderán incluso a los fans más acérrimos del título original. La expectativa es alta, y el equipo de desarrollo está decidido a superarla.

Con una fecha de lanzamiento tentativa para 2027, la tercera parte de Final Fantasy VII Remake se está desarrollando con la promesa de mantener la calidad y la integridad que han caracterizado a la serie hasta ahora. Los jugadores pueden esperar un mundo más expansivo, con localizaciones detalladas y sin tiempos de carga, gracias a la exclusividad en la plataforma PlayStation.

El legado de Final Fantasy VII es indiscutible, y su influencia en la cultura de los videojuegos es incuestionable. Con esta nueva entrega, Square Enix no solo busca honrar ese legado, sino también llevarlo a nuevas alturas, asegurando que la saga continúe siendo relevante para las nuevas generaciones de jugadores.',
        'La tercera entrega del remake promete una libertad sin precedentes en el combate y una narrativa que concluirá la épica saga.',
        '2024-05-01T18:16:17.633882315', 'Final Fantasy VII: El Legado Continúa con Innovaciones Revolucionarias',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'Imagen de portada', 1),
       (8, 8, 2,
        'As the world still celebrates the release of Final Fantasy VII Rebirth, Square Enix is already laying the groundwork for the third and final part of the remake trilogy. Committed to offering “even more freedom” in combat and revamped gameplay, the upcoming installment is shaping up to be the most ambitious in the series.

The story of Cloud and his companions will reach its climax in an adventure that promises not only to close the plot with a golden clasp but also to introduce gameplay elements that will surprise even the most die-hard fans of the original title. Expectations are high, and the development team is determined to exceed them.

With a tentative release date set for 2027, the third part of Final Fantasy VII Remake is being developed with the promise of maintaining the quality and integrity that have characterized the series so far. Players can expect a more expansive world, with detailed locations and no loading times, thanks to its exclusivity on the PlayStation platform.

The legacy of Final Fantasy VII is undeniable, and its influence on video game culture is unquestionable. With this new installment, Square Enix seeks not only to honor that legacy but also to elevate it to new heights, ensuring that the saga continues to be relevant for new generations of players.',
        'The third installment of the remake promises unprecedented freedom in combat and a narrative that will conclude the epic saga.',
        '2024-05-01T18:16:17.633882315', 'Final Fantasy VII: The Legacy Continues with Groundbreaking Innovations',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'Imagen de portada', 2);


-- Alan Wake 2
INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (9, 9, 1,
        'Los fanáticos de Alan Wake 2 están de enhorabuena, ya que Remedy Entertainment ha anunciado el lanzamiento del primer DLC para el juego, titulado “Night Springs”. Este nuevo contenido, que se espera sea presentado en detalle durante el Summer Game Fest 20241, promete llevar a los jugadores a una nueva aventura llena de misterio y suspense.

Desde su lanzamiento, Alan Wake 2 ha cautivado a los jugadores con su combinación única de narrativa de terror psicológico y acción trepidante. El juego ha sido un éxito comercial, alcanzando 1,3 millones de ventas y convirtiéndose en el título más rápidamente vendido de Remedy2. Con “Night Springs”, la compañía busca no solo continuar el éxito del juego sino también ofrecer a los jugadores una experiencia aún más rica y profunda.

El DLC llevará a Alan Wake a explorar los confines de la realidad y la ficción, enfrentándose a nuevos enemigos y descubriendo secretos que cambiarán su percepción del mundo que lo rodea. Además, se espera que “Night Springs” introduzca nuevos elementos de juego y mecánicas que enriquecerán la jugabilidad ya de por sí sólida del título principal.

La comunidad de Alan Wake 2 está llena de especulaciones y teorías sobre lo que este nuevo contenido traerá. Lo que es seguro es que la oscuridad nunca ha sido tan atractiva, y los jugadores están ansiosos por sumergirse una vez más en el universo de Alan Wake.',
        'El esperado contenido descargable “Night Springs” promete expandir el universo de Alan Wake con nuevas historias y desafíos.',
        '2024-01-06T18:16:17.633882315', 'Alan Wake 2: La Oscuridad se Ilumina con el Anuncio del Nuevo DLC',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'Imagen de portada', 1),
       (10, 10, 2,
        'Fans of Alan Wake 2 are in for a treat, as Remedy Entertainment has announced the release of the first DLC for the game, titled “Night Springs”. This new content, expected to be detailed during the Summer Game Fest 2024, promises to take players on a new adventure filled with mystery and suspense.

Since its release, Alan Wake 2 has captivated players with its unique blend of psychological horror narrative and thrilling action. The game has been a commercial success, reaching 1.3 million sales and becoming Remedy’s fastest-selling title. With “Night Springs”, the company aims not only to continue the game’s success but also to offer players an even richer and deeper experience.

The DLC will take Alan Wake to explore the boundaries of reality and fiction, facing new enemies and uncovering secrets that will change his perception of the world around him. Additionally, “Night Springs” is expected to introduce new gameplay elements and mechanics that will enrich the already solid gameplay of the main title.

The Alan Wake 2 community is filled with speculation and theories about what this new content will bring. What is certain is that darkness has never been so appealing, and players are eager to dive once again into the universe of Alan Wake.',
        'The anticipated downloadable content “Night Springs” promises to expand the Alan Wake universe with new stories and challenges.',
        '2024-01-06T18:16:17.633882315', 'Alan Wake 2: The Darkness Shines with the Announcement of New DLC',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'Imagen de portada', 2);

-- Resident Evil 4 Remake
INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (11, 11, 3, 'Resident Evil 4 Remake es un juego de acción y terror que sigue a Leon S. Kennedy en una misión para rescatar a la hija del presidente de los Estados Unidos. En un pueblo remoto de Europa, Leon se enfrenta a una horda de infectados por un parásito y descubre una conspiración que amenaza con desatar una nueva amenaza biológica. Con su innovador sistema de combate y su atmósfera inquietante, Resident Evil 4 es un clásico moderno del género de los survival horror.
                   El juego ha sido aclamado por su narrativa envolvente, su diseño de niveles ingenioso y su capacidad para mantener a los jugadores en vilo desde el principio hasta el final. Con su lanzamiento previsto para el 17 de julio de 2024, Resident Evil 4 Remake promete ofrecer una experiencia de juego inolvidable que cautivará a los fanáticos de la serie y a los nuevos jugadores por igual. ',
        'Resident Evil 4 Remake', '2024-06-07T18:16:17.633882315',
        'Resident Evil 4 Remake: Un Clásico Moderno del Terror y la Acción',
        'https://cdn.alanwake2.com/header.jpg', 'alt', 1),
       (12, 12, 3, 'Resident Evil 4 is an action-packed horror game that follows Leon S. Kennedy on a mission to rescue the President of the United States’ daughter. In a remote village in Europe, Leon faces off against a horde of parasite-infected enemies and uncovers a conspiracy that threatens to unleash a new biological threat. With its innovative combat system and eerie atmosphere, Resident Evil 4 is a modern classic in the survival horror genre.
                   The game has been praised for its enveloping narrative, clever level design, and ability to keep players on the edge of their seats from start to finish. With its release scheduled for July 17, 2024, Resident Evil 4 Remake promises to deliver an unforgettable gaming experience that will captivate fans of the series and newcomers alike. ',
        'Resident Evil 4 Remake', '2024-06-07T18:16:17.633882315',
        'Resident Evil 4 Remake: A Modern Classic of Horror and Action',
        'https://cdn.alanwake2.com/header.jpg', 'alt', 2);

-- Little Nightmares II
INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '3', '2',
        '¡La atmósfera de ‘Little Nightmares II’ es simplemente increíble! Cada rincón del juego está lleno de detalles y misterios. ¡Espero que Tarsier Studios siga creando experiencias tan inmersivas en el futuro!',
        '2024-05-10T15:16:17.633882315'),
       (NULL, '3', '3',
        'Me encanta cómo ‘Little Nightmares II’ logra contar una historia tan profunda sin usar palabras. La dirección artística y el diseño de niveles son excepcionales. ¡Espero que la franquicia siga creciendo y explorando nuevos horizontes!',
        '2024-05-20T18:16:17.633882315'),
       (NULL, '3', '4',
        'Como fan del primer juego, estaba emocionado por la secuela, y debo decir que no me ha decepcionado. La jugabilidad, los personajes y la atmósfera son simplemente increíbles. ¡Espero que Tarsier Studios siga creando mundos tan fascinantes!',
        '2024-06-02T20:16:17.633882315'),
       (NULL, '4', '5',
        'The atmosphere of ‘Little Nightmares II’ is simply amazing! Every corner of the game is filled with details and mysteries. I hope Tarsier Studios continues to create such immersive experiences in the future!',
        '2024-06-03T15:16:17.633882315'),
       (NULL, '4', '6',
        'I love how ‘Little Nightmares II’ manages to tell such a deep story without using words. The art direction and level design are exceptional. I hope the franchise continues to grow and explore new horizons!',
        '2024-04-20T18:16:17.633882315'),
       (NULL, '4', '7',
        'As a fan of the first game, I was excited for the sequel, and I must say it has not disappointed. The gameplay, characters, and atmosphere are simply amazing. I hope Tarsier Studios continues to create such fascinating worlds!',
        '2024-04-10T20:16:17.633');


-- Diablo II: Resurrected
INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '5', '2',
        '¡La temporada 7 de Diablo II: Resurrected es increíble! Los nuevos desafíos y recompensas mantienen la experiencia fresca y emocionante. ¡No puedo esperar a ver qué más tiene preparado Blizzard para los jugadores!',
        '2024-05-05T15:16:17.633882315'),
       (NULL, '5', '3',
        'Diablo II: Resurrected sigue siendo uno de mis juegos favoritos de todos los tiempos. La temporada 7 ha sido una experiencia increíble, y estoy ansioso por ver qué más tiene en la tienda Blizzard. ¡Santuario nunca ha sido tan emocionante!',
        '2024-05-15T18:16:17.633882315'),
       (NULL, '5', '4',
        'Como fanático de Diablo desde el primer juego, debo decir que la temporada 7 de Diablo II: Resurrected ha superado mis expectativas. Los nuevos desafíos y recompensas mantienen la experiencia fresca y emocionante. ¡Espero que Blizzard siga apoyando el juego con más contenido!',
        '2024-06-01T20:16:17.633882315'),
       (NULL, '6', '5',
        'The Diablo II: Resurrected season 7 is amazing! The new challenges and rewards keep the experience fresh and exciting. I can’t wait to see what else Blizzard has in store for players!',
        '2024-05-05T15:16:17.633882315'),
       (NULL, '6', '6',
        'Diablo II: Resurrected remains one of my all-time favorite games. Season 7 has been an incredible experience, and I’m eager to see what else Blizzard has in store. Sanctuary has never been more thrilling!',
        '2024-05-15T18:16:17.633882315'),
       (NULL, '6', '7',
        'As a Diablo fan since the first game, I must say that the Diablo II: Resurrected season 7 has exceeded my expectations. The new challenges and rewards keep the experience fresh and exciting. I hope Blizzard continues to support the game with more content!',
        '2024-05-15T18:16:17.633882315');


-- Final Fantasy VII
INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '7', '2',
        '¡Estoy emocionado de Final Fantasy VII Remake! La historia y los personajes son tan cautivadores que no puedo esperar a ver cómo se desarrolla la trama. ¡Square Enix nunca deja de sorprenderme!',
        '2024-05-05T15:16:17.633882315'),
       (NULL, '7', '3',
        'Final Fantasy VII fue un juego increíble, y estoy seguro de que la tercera parte será aún mejor. La narrativa y el mundo de juego son tan ricos y detallados que es fácil perderse en ellos. ¡Estoy ansioso por ver qué más tiene Square Enix en la tienda!',
        '2024-05-15T18:16:17.633882315'),
       (NULL, '7', '4',
        'Como fan de Final Fantasy desde hace años, no puedo esperar a ver cómo se desarrolla la trama del remake. La calidad y la atención al detalle de Square Enix son incomparables. ¡Estoy seguro de que la tercera parte será un éxito rotundo!',
        '2024-06-01T20:16:17.633882315'),
       (NULL, '8', '5',
        'I’m excited for Final Fantasy VII Remake! The story and characters are so captivating that I can’t wait to see how the plot unfolds. Square Enix never ceases to amaze me!',
        '2024-05-05T15:16:17.633882315'),
       (NULL, '8', '6',
        'Final Fantasy VII was an amazing game, and I’m sure the third part will be even better. The narrative and game world are so rich and detailed that it’s easy to get lost in them. I’m eager to see what else Square Enix has in store!',
        '2024-05-15T18:16:17.633882315'),
       (NULL, '8', '7',
        'As a longtime Final Fantasy fan, I can’t wait to see how the plot unfolds in the second part of the remake. Square Enix’s quality and attention to detail are unmatched. I’m sure the third part will   be a resounding success!',
        '2024-06-01T20:16:17.633882315');

-- Alan Wake 2
INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '9', '2',
        '¡El DLC de Alan Wake 2 suena increíble! Estoy emocionado de ver a dónde llevará la historia y qué nuevos desafíos enfrentará Alan. ¡Remedy Entertainment nunca deja de sorprenderme con sus juegos!',
        '2024-02-06T18:16:17.633882315'),
       (NULL, '9', '3',
        'Alan Wake 2 ha sido una experiencia increíble desde el principio, y el anuncio del DLC solo aumenta mi emoción. La narrativa y el mundo del juego son tan envolventes que es difícil dejar de jugar. ¡Espero que el DLC sea tan bueno como el juego principal!',
        '2024-03-06T18:16:17.633882315'),
       (NULL, '9', '4',
        'Como fan de Alan Wake desde el primer juego, no puedo esperar a sumergirme en el DLC. La atmósfera y el misterio que rodean a Alan son simplemente fascinantes. ¡Espero que el DLC ofrezca más de lo que hace que la serie sea tan especial!',
        '2024-04-06T18:16:17.633882315'),
       (NULL, '10', '5',
        'The Alan Wake 2 DLC sounds amazing! I’m excited to see where the story will go and what new challenges Alan will face. Remedy Entertainment never ceases to amaze me with their games!',
        '2024-02-06T18:16:17.633882315'),
       (NULL, '10', '6',
        'Alan Wake 2 has been an incredible experience from the start, and the DLC announcement only increases my excitement. The narrative and game world are so immersive that it’s hard to stop playing. I hope the DLC is as good as the main game!',
        '2024-03-06T18:16:17.633882315'),
       (NULL, '10', '7',
        'As a fan of Alan Wake since the first game, I can’t wait to dive into the DLC. The atmosphere and mystery surrounding Alan are simply fascinating. I hope the DLC offers more of what makes the series so special!',
        '2024-04-06T18:16:17.633882315');


-- Resident Evil 4 Remake
INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '11', '2',
        '¡Resident Evil 4 Remake es uno de los juegos más esperados del año! La combinación de acción y terror es simplemente perfecta. ¡No puedo esperar a ver cómo se compara con el original!',
        '2024-06-07T15:16:17.633882315'),
       (NULL, '11', '3',
        'Resident Evil 4 es uno de mis juegos favoritos de todos los tiempos, y estoy emocionado de ver cómo se reinventa en el remake. La historia y los personajes son tan icónicos que es difícil no emocionarse. ¡Estoy ansioso por jugarlo!',
        '2024-06-07T18:16:17.633882315'),
       (NULL, '11', '4',
        'Como fan de Resident Evil desde hace años, no puedo esperar a ver cómo se actualiza el clásico en el remake. La jugabilidad y la atmósfera del original son inolvidables, y espero que el remake capture esa magia. ¡Estoy seguro de que será un éxito!',
        '2024-06-08T20:16:17.633882315'),
       (NULL, '12', '5',
        'Resident Evil 4 Remake is one of the most anticipated games of the year! The combination of action and horror is simply perfect. I can’t wait to see how it compares to the original!',
        '2024-06-08T15:16:17.633882315'),
       (NULL, '12', '6',
        'Resident Evil 4 is one of my all-time favorite games, and I’m excited to see how it’s reinvented in the remake. The story and characters are so iconic that it’s hard not to get excited. I’m eager to play it!',
        '2024-06-09T18:16:17.633882315'),
       (NULL, '12', '7',
        'As a longtime Resident Evil fan, I can’t wait to see how the classic is updated in the remake. The gameplay and atmosphere of the original are unforgettable, and I hope the remake captures that magic. I’m sure it will be a hit!',
        '2024-06-10T18:16:17.633882315');


INSERT INTO `feature` (`name`, `image`, `alt`)
VALUES ('Un Jugador', 'dassa', 'asdsad2as'),
       ('Multijugador', 'dassa', 'asdsadas'),
       ('Jugadores vs Entorno', 'dassa', 'asdsadas'),
       ('Jugador vs Jugador', 'dassa', 'asdsadas'),
       ('Coop.Online', 'dassa', 'asdsadas'),
       ('Coop.LAN', 'dassa', 'asdsadas'),
       ('One Player', 'dassa', 'asdsadas'),
       ('Multiplayer', 'dassa', 'asdsadas'),
       ('Player vs Environment', 'dassa', 'asdsadas'),
       ('Player vs Player', 'dassa', 'asdsadas'),
       ('Online Coop.', 'dassa', 'asdsadas'),
       ('LAN Coop.', 'dassa', 'asdsadas');

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

-- Resident Evil 2 Remake
INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (1, 1, NULL), -- Asociar el juego con ID 1 con la característica con ID 1 y sin NumberPlayer
       (1, 3, NULL), -- Asociar el juego con ID 1 con la característica con ID 2 y NumberPlayer con ID 1
       (2, 7, NULL), -- Asociar el juego con ID 1 con la característica con ID 1 y sin NumberPlayer
       (2, 9, NULL);

-- Little Nightmares II
INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (3, 1, NULL), -- Asociar el juego con ID 3 con la característica con ID 1 y sin NumberPlayer
       (3, 3, NULL), -- Asociar el juego con ID 3 con la característica con ID 2 y NumberPlayer con ID 1
       (4, 7, NULL), -- Asociar el juego con ID 3 con la característica con ID 1 y sin NumberPlayer
       (4, 9, NULL);

-- Diablo II: Resurrected
INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (5, 1, NULL), -- Asociar el juego con ID 5 con la característica con ID 1 y sin NumberPlayer
       (5, 3, NULL), -- Asociar el juego con ID 5 con la característica con ID 2 y NumberPlayer con ID 1
       (5, 4, NULL),
       (5, 5, 8),
       (6, 7, NULL), -- Asociar el juego con ID 5 con la característica con ID 1 y sin NumberPlayer
       (6, 9, NULL),
       (6, 11, 8);

-- Final Fantasy VII
INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (7, 1, NULL), -- Asociar el juego con ID 7 con la característica con ID 1 y sin NumberPlayer
       (7, 3, NULL), -- Asociar el juego con ID 7 con la característica con ID 2 y NumberPlayer con ID 1
       (8, 7, NULL), -- Asociar el juego con ID 7 con la característica con ID 1 y sin NumberPlayer
       (8, 9, NULL);

-- Alan Wake 2
INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (9, 1, NULL),  -- Asociar el juego con ID 9 con la característica con ID 1 y sin NumberPlayer
       (9, 3, NULL),  -- Asociar el juego con ID 9 con la característica con ID 2 y NumberPlayer con ID 1
       (10, 7, NULL), -- Asociar el juego con ID 9 con la característica con ID 1 y sin NumberPlayer
       (10, 9, NULL);

-- Resident Evil 4 Remake
INSERT INTO `game_feature` (`game_id`, `feature_id`, `number_player_id`)
VALUES (11, 1, NULL), -- Asociar el juego con ID 11 con la característica con ID 1 y sin NumberPlayer
       (11, 3, NULL), -- Asociar el juego con ID 11 con la característica con ID 2 y NumberPlayer con ID 1
       (11, 5, 4),
       (12, 7, NULL), -- Asociar el juego con ID 11 con la característica con ID 1 y sin NumberPlayer
       (12, 9, NULL),
       (12, 11, 4);

-- Residet Evil 2 Remake
INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2023-01-30T18:16:17.633882315', 0, 1, 10, 2, 'Un Clásico Reinventado',
        'Capcom ha hecho un trabajo magistral al traer ‘Resident Evil 2’ al siglo XXI. La jugabilidad es fluida, los gráficos son impresionantes y la historia se siente tan fresca como en 1998. Es un remake que respeta el original pero no tiene miedo de innovar. ¡Un imprescindible para cualquier fan de la serie!'),
       ('2023-10-30T18:16:17.633882315', 2, 1, 8, 3, 'Terror en Alta Definición',
        'Resident Evil 2 Remake’ me mantuvo al borde de mi asiento de principio a fin. La tensión es constante y los sustos están bien ejecutados. Aunque algunos puzles se sienten un poco anticuados, la experiencia general es excepcional.'),
       ('2023-11-30T18:16:17.633882315', 1, 1, 9, 4, 'Una Obra Maestra del Horror',
        'Este juego redefine lo que debería ser un remake. Con una narrativa envolvente y un diseño de sonido que te sumerge completamente, ‘Resident Evil 2 Remake’ es una experiencia que ningún fan del género debería perderse.'),
       ('2023-12-30T18:16:17.633882315', 3, 1, 7, 5, 'Más que Nostalgia',
        'Al principio, compré ‘Resident Evil 2 Remake’ por la nostalgia, pero lo que encontré fue una obra de arte moderna. Los personajes son profundos, el mundo es inmersivo y cada rincón de Raccoon City está lleno de detalles. Sin embargo, la IA de los enemigos a veces deja que desear.'),
       ('2023-01-30T18:16:17.633882315', 0, 2, 10, 6, 'A Classic Reimagined',
        'Capcom has done a masterful job bringing ‘Resident Evil 2’ into the 21st century. The gameplay is smooth, the graphics are stunning, and the story feels as fresh as it did in 1998. It’s a remake that respects the original but isn’t afraid to innovate. A must-play for any series fan!'),
       ('2023-10-30T18:16:17.633882315', 2, 2, 8, 7, 'High-Definition Horror',
        'Resident Evil 2 Remake’ kept me on the edge of my seat from start to finish. The tension is constant, and the scares are well-executed. While some puzzles feel a bit dated, the overall experience is exceptional.'),
       ('2023-11-30T18:16:17.633882315', 1, 2, 9, 8, 'A Horror Masterpiece',
        'This game redefines what a remake should be. With an immersive narrative and sound design that fully immerses you, ‘Resident Evil 2 Remake’ is an experience no genre fan should miss.'),
       ('2023-12-30T18:16:17.633882315', 3, 2, 7, 9, 'More Than Nostalgia',
        'At first, I bought ‘Resident Evil 2 Remake’ for the nostalgia, but what I found was a modern masterpiece. The characters are deep, the world is immersive, and every corner of Raccoon City is filled with detail. However, enemy AI can sometimes leave something to be desired.');

-- Little Nightmares II
INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2024-06-05T08:40:57.000000', 1, 3, 15, 2, 'Pesadillas que Encantan',
        'Little Nightmares II es una joya del terror psicológico. La atmósfera opresiva y el diseño artístico son de otro nivel. Aunque el juego puede ser corto, cada minuto está repleto de tensión y belleza oscura.'),
       ('2024-06-05T08:40:57.000000', 0, 3, 12, 3, 'Un Viaje Visualmente Deslumbrante',
        'Este título lleva el arte en los videojuegos a nuevas alturas. La narrativa visual de Little Nightmares II es cautivadora, y aunque carece de diálogos, cuenta una historia profunda y emocionante.'),
       ('2024-06-05T08:40:57.000000', 2, 3, 13, 4, 'Una Aventura Inolvidable',
        'Con puzzles ingeniosos y una dirección de sonido impecable, Little Nightmares II ofrece una experiencia que se queda grabada en la memoria. Es un juego que desafía tanto como entretiene.'),
       ('2024-06-05T08:40:57.000000', 1, 4, 15, 6, 'Nightmares that Enchant',
        'Little Nightmares II is a gem of psychological horror. The oppressive atmosphere and artistic design are on another level. Although the game may be short, every minute is packed with tension and dark beauty.'),
       ('2024-06-05T08:40:57.000000', 0, 4, 12, 7, 'A Visually Stunning Journey',
        'This title takes art in video games to new heights. The visual narrative of Little Nightmares II is captivating, and even without dialogue, it tells a deep and thrilling story.'),
       ('2024-06-05T08:40:57.000000', 2, 4, 13, 8, 'An Unforgettable Adventure',
        'With clever puzzles and impeccable sound direction, Little Nightmares II offers an experience that stays etched in memory. It’s a game that challenges as much as it entertains.');


-- Diablo II: Resurrected
INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2024-05-01T18:16:17.633882315', 1, 5, 15, 2, 'Un Clásico Reimaginado',
        'Diablo II: Resurrected es una carta de amor a los fans del original. La jugabilidad es tan adictiva como siempre, y los gráficos remasterizados son impresionantes. Aunque algunos problemas técnicos pueden entorpecer la experiencia, el juego sigue siendo una joya del género.'),
       ('2024-05-01T18:16:17.633882315', 0, 5, 12, 3, 'Un Regreso Triunfal al Infierno',
        'La temporada 7 de Diablo II: Resurrected ha sido una montaña rusa de emociones. Los nuevos desafíos y recompensas mantienen la experiencia fresca y emocionante. ¡No puedo esperar a ver qué más tiene preparado Blizzard para los jugadores!'),
       ('2024-05-01T18:16:17.633882315', 2, 5, 13, 4, 'Un Clásico que se Mantiene Vigente',
        'Diablo II: Resurrected sigue siendo uno de los mejores ARPG de todos los tiempos. La temporada 7 ha sido un éxito rotundo, y Blizzard ha demostrado una vez más por qué es uno de los líderes del género.'),
       ('2024-05-01T18:16:17.633882315', 1, 6, 15, 6, 'A Classic Reimagined',
        'Diablo II: Resurrected is a love letter to fans of the original. The gameplay is as addictive as ever, and the remastered graphics are stunning. While some technical issues may hinder the experience, the game remains a genre gem.'),
       ('2024-05-01T18:16:17.633882315', 0, 6, 12, 7, 'A Triumphant Return to Hell',
        'Diablo II: Resurrected season 7 has been a rollercoaster of emotions. The new challenges and rewards keep the experience fresh and exciting. I can’t wait to see what else Blizzard has in store for players!'),
       ('2024-05-01T18:16:17.633882315', 2, 6, 13, 8, 'A Classic That Stands the Test of Time',
        'Diablo II: Resurrected remains one of the greatest ARPGs of all time. Season 7 has been a resounding success, and Blizzard has once again shown why it is one of the genre leaders.');


-- Final Fantasy VII
INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2024-05-01T18:16:17.633882315', 1, 7, 15, 2, 'Un Regreso Épico',
        'Final Fantasy VII es un triunfo de la narrativa y el diseño de juego. La tercera parte promete cerrar la trilogía con broche de oro, y los fans están ansiosos por ver cómo se desarrolla la historia. ¡Square Enix ha superado todas las expectativas con este remake!'),
       ('2024-05-01T18:16:17.633882315', 0, 7, 12, 3, 'Una Aventura Inolvidable',
        'Final Fantasy VII Remake promete ser un hito en la historia de los videojuegos. Con una jugabilidad renovada y una narrativa épica, este título se perfila como uno de los mejores de la serie. ¡Los fans no pueden esperar a sumergirse en el mundo de Midgar una vez más!'),
       ('2024-05-01T18:16:17.633882315', 2, 7, 13, 4, 'Un Clásico que se Reinventa',
        'Final Fantasy VII es un remake que supera al original en todos los aspectos. La segunda parte promete ser un viaje emocionante y lleno de sorpresas. ¡Square Enix ha demostrado una vez más por qué es uno de los mejores estudios de desarrollo de videojuegos!'),
       ('2024-05-01T18:16:17.633882315', 1, 8, 15, 6, 'An Epic Return',
        'Final Fantasy VII is a triumph of narrative and game design. The third part promises to close the trilogy with a golden clasp, and fans are eager to see how the story unfolds. Square Enix has exceeded all expectations with this remake!'),
       ('2024-05-01T18:16:17.633882315', 0, 8, 12, 7, 'An Unforgettable Adventure',
        'Final Fantasy VII Remake promises to be a milestone in video game history. With revamped gameplay and an epic narrative, this title is shaping up to be one of the best in the series. Fans can’t wait to dive back into the world of Midgar once more!'),
       ('2024-05-01T18:16:17.633882315', 2, 8, 13, 8, 'A Classic Reinvented',
        'Final Fantasy VII is a remake that surpasses the original in every aspect. The third part promises to be an exciting journey full of surprises. Square Enix has once again shown why it is one of the best game development studios!');

-- Alan Wake 2
INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2024-01-06T18:16:17.633882315', 1, 9, 15, 2, 'Un Regreso Triunfal',
        'Alan Wake 2 ha superado todas las expectativas. La narrativa es tan envolvente como siempre, y el nuevo contenido promete expandir el universo de Alan de formas inimaginables. ¡Remedy Entertainment ha creado una obra maestra del terror psicológico!'),
       ('2024-01-06T18:16:17.633882315', 0, 9, 12, 3, 'Una Aventura Inolvidable',
        'El DLC de Alan Wake 2 es una adición bienvenida a un juego ya excepcional. La historia es intrigante, los personajes son profundos y la atmósfera es inquietante. ¡Espero que este sea solo el comienzo de una nueva era para la franquicia!'),
       ('2024-01-06T18:16:17.633882315', 2, 9, 13, 4, 'Un Clásico que se Reinventa',
        'Alan Wake 2 es un regreso triunfal para Remedy Entertainment. La narrativa es tan cautivadora como siempre, y el nuevo contenido promete llevar a los jugadores a lugares nunca antes vistos. ¡Este es un juego que ningún fan del terror psicológico debería perderse!'),
       ('2024-01-06T18:16:17.633882315', 1, 10, 15, 6, 'A Triumphant Return',
        'Alan Wake 2 has exceeded all expectations. The narrative is as immersive as ever, and the new content promises to expand Alan’s universe in unimaginable ways. Remedy Entertainment has created a masterpiece of psychological horror!'),
       ('2024-01-06T18:16:17.633882315', 0, 10, 12, 7, 'An Unforgettable Adventure',
        'Alan Wake 2’s DLC is a welcome addition to an already exceptional game. The story is intriguing, the characters are deep, and the atmosphere is haunting. I hope this is just the beginning of a new era for the franchise!'),
       ('2024-01-06T18:16:17.633882315', 2, 10, 13, 8, 'A Classic Reinvented',
        'Alan Wake 2 is a triumphant return for Remedy Entertainment. The narrative is as captivating as ever, and the new content promises to take players to places never before seen. This is a game no psychological horror fan should miss!');


-- Resident Evil 4 Remake
INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2024-06-07T15:16:17.633882315', 1, 11, 15, 2, 'Un Clásico Reimaginado',
        'Resident Evil 4 Remake es una carta de amor a los fans del original. La jugabilidad es tan adictiva como siempre, y los gráficos remasterizados son impresionantes. Aunque algunos problemas técnicos pueden entorpecer la experiencia, el juego sigue siendo una joya del género.'),
       ('2024-06-07T18:16:17.633882315', 0, 11, 12, 3, 'Un Regreso Triunfal al Infierno',
        'La temporada 7 de Resident Evil 4 Remake ha sido una montaña rusa de emociones. Los nuevos desafíos y recompensas mantienen la experiencia fresca y emocionante. ¡No puedo esperar a ver qué más tiene preparado Capcom para los jugadores!'),
       ('2024-06-08T20:16:17.633882315', 2, 11, 13, 4, 'Un Clásico que se Mantiene Vigente',
        'Resident Evil 4 Remake sigue siendo uno de los mejores juegos de terror de todos los tiempos. La temporada 7 ha sido un éxito rotundo, y Capcom ha demostrado una vez más por qué es uno de los líderes del género.'),
       ('2024-06-08T15:16:17.633882315', 1, 12, 15, 6, 'A Classic Reimagined',
        'Resident Evil 4 Remake is a love letter to fans of the original. The gameplay is as addictive as ever, and the remastered graphics are stunning. While some technical issues may hinder the experience, the game remains a genre gem.'),
       ('2024-06-09T18:16:17.633882315', 0, 12, 12, 7, 'A Triumphant Return to Hell',
        'Resident Evil 4 Remake season 7 has been a rollercoaster of emotions. The new challenges and rewards keep the experience fresh and exciting. I can’t wait to see what else Capcom has in store for players!'),
       ('2024-06-10T18:16:17.633882315', 2, 12, 13, 8, 'A Classic That Stands the Test of Time',
        'Resident Evil 4 Remake remains one of the greatest horror games of all time. Season 7 has been a resounding success, and Capcom has once again shown why it is one of the genre leaders.');


-- Resident Evil 2 Remake
INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('7', '2023-01-30T18:16:17.633882315', '1', NULL, '2'),
       ('8', '2023-01-30T18:16:17.633882315', '1', NULL, '3'),
       ('8', '2023-01-30T18:16:17.633882315', '1', NULL, '4'),
       ('9', '2023-01-30T18:16:17.633882315', '1', NULL, '5'),
       ('7', '2023-01-30T18:16:17.633882315', '2', NULL, '6'),
       ('8', '2023-01-30T18:16:17.633882315', '2', NULL, '7'),
       ('8', '2023-01-30T18:16:17.633882315', '2', NULL, '8'),
       ('9', '2023-01-30T18:16:17.633882315', '2', NULL, '9');

-- Little Nightmares II
INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('9', '2024-06-05T08:40:57.000000', '3', NULL, '2'),
       ('8', '2024-06-05T08:40:57.000000', '3', NULL, '3'),
       ('8', '2024-06-05T08:40:57.000000', '3', NULL, '4'),
       ('9', '2024-06-05T08:40:57.000000', '4', NULL, '6'),
       ('8', '2024-06-05T08:40:57.000000', '4', NULL, '7'),
       ('8', '2024-06-05T08:40:57.000000', '4', NULL, '8');


-- Diablo II: Resurrected
INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('9', '2024-05-01T18:16:17.633882315', '5', NULL, '2'),
       ('8', '2024-05-01T18:16:17.633882315', '5', NULL, '3'),
       ('9', '2024-05-01T18:16:17.633882315', '6', NULL, '6'),
       ('8', '2024-05-01T18:16:17.633882315', '6', NULL, '7');


-- Final Fantasy VII
INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('9', '2024-05-01T18:16:17.633882315', '7', NULL, '2'),
       ('8', '2024-05-01T18:16:17.633882315', '7', NULL, '3'),
       ('9', '2024-05-01T18:16:17.633882315', '8', NULL, '6'),
       ('8', '2024-05-01T18:16:17.633882315', '8', NULL, '7'),
       ('2', '2024-05-01T18:16:17.633882315', '8', NULL, '8'),
       ('4', '2024-05-01T18:16:17.633882315', '8', NULL, '9');

-- Alan Wake 2
INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('9', '2024-01-06T18:16:17.633882315', '9', NULL, '2'),
       ('10', '2024-01-06T18:16:17.633882315', '9', NULL, '3'),
       ('10', '2024-01-06T18:16:17.633882315', '10', NULL, '6'),
       ('10', '2024-01-06T18:16:17.633882315', '10', NULL, '7');

-- Resident Evil 4 Remake
INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('9', '2024-06-07T15:16:17.633882315', '11', NULL, '2'),
       ('8', '2024-06-07T18:16:17.633882315', '11', NULL, '3'),
       ('8', '2024-06-08T20:16:17.633882315', '11', NULL, '4'),
       ('9', '2024-06-08T15:16:17.633882315', '12', NULL, '6'),
       ('8', '2024-06-09T18:16:17.633882315', '12', NULL, '7'),
       ('8', '2024-06-10T18:16:17.633882315', '12', NULL, '8');


-- Inserta una edición
INSERT INTO edition_product (name)
VALUES ('Edición estándar'),
       ('Edición coleccionista'),
       ('Edición limitada'),
       ('Edición especial'),
       ('Standard Edition'),
       ('Collector’s Edition'),
       ('Limited Edition'),
       ('Special Edition');

-- Inserta una plataforma
INSERT INTO platform_product (name, image, alt)
VALUES ('PlayStation 4', 'URL de la imagen de la plataforma', 'alt de la imagen de la plataforma'),
       ('PlayStation 5', 'URL de la imagen de la plataforma', 'alt de la imagen de la plataforma'),
       ('Xbox One', 'URL de la imagen de la plataforma', 'alt de la imagen de la plataforma'),
       ('Xbox Series X', 'URL de la imagen de la plataforma', 'alt de la imagen de la plataforma'),
       ('PC', 'URL de la imagen de la plataforma', 'alt de la imagen de la plataforma'),
       ('Nintendo Switch', 'URL de la imagen de la plataforma', 'alt de la imagen de la plataforma');

-- Inserta un vendedor
INSERT INTO vendor_product (name, logo, alt)
VALUES ('Steam', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('Epic Games', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('Origin', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('Uplay', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('Battle.net', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('GOG', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('Xbox Live', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('PlayStation Network', 'URL del logo del vendedor', 'alt del logo del vendedor'),
       ('Nintendo eShop', 'URL del logo del vendedor', 'alt del logo del vendedor');

-- Inserta una región
INSERT INTO region_product (name)
VALUES ('EUR'),
       ('USA'),
       ('JPN');

-- Inserta una clave de producto
INSERT INTO keys_product (name)
VALUES ('Clave'),
       ('Regalo'),
       ('Cuenta'),
       ('Key'),
       ('Gift'),
       ('Account');


-- Resident Evil 2 Remake
INSERT INTO `product` (`price`, `edition_product_id`, `game_id`, `id`, `keys_product_id`,
                       `platform_product_id`, `region_product_id`, `vendor_product_id`, `link`)
VALUES ('10.99', '1', '1', NULL, '1', '1', '1', '1',
        '#'),
       ('12.99', '2', '1', NULL, '2', '2', '2', '2',
        '#'),
       ('7.99', '3', '1', NULL, '3', '3', '3', '3',
        '#'),
       ('20.99', '4', '1', NULL, '1', '4', '1', '4',
        '#'),
       ('9.99', '1', '1', NULL, '2', '1', '2', '5',
        '#'),
       ('19.99', '2', '1', NULL, '2', '2', '1', '1',
        '#'),
       ('15.99', '3', '1', NULL, '1', '3', '2', '2',
        '#'),
       ('10.99', '5', '2', NULL, '4', '1', '1', '1',
        '#'),
       ('12.99', '6', '2', NULL, '5', '2', '2', '2',
        '#'),
       ('7.99', '7', '2', NULL, '6', '3', '3', '3',
        '#'),
       ('20.99', '8', '2', NULL, '4', '4', '1', '4',
        '#'),
       ('9.99', '5', '2', NULL, '5', '1', '2', '5',
        '#'),
       ('19.99', '6', '2', NULL, '5', '2', '1', '1',
        '#'),
       ('15.99', '7', '2', NULL, '4', '3', '2', '2',
        '#');

-- Little Nightmares II
INSERT INTO `product` (`price`, `edition_product_id`, `game_id`, `id`, `keys_product_id`,
                       `platform_product_id`, `region_product_id`, `vendor_product_id`, `link`)
VALUES ('5.99', '1', '3', NULL, '1', '1', '1', '1',
        '#'),
       ('12.99', '2', '3', NULL, '2', '2', '2', '2',
        '#'),
       ('7.99', '3', '3', NULL, '3', '3', '3', '3',
        '#'),
       ('20.99', '4', '3', NULL, '1', '4', '1', '4',
        '#'),
       ('9.99', '1', '3', NULL, '2', '1', '2', '5',
        '#'),
       ('19.99', '2', '3', NULL, '2', '2', '1', '1',
        '#'),
       ('15.99', '3', '3', NULL, '1', '3', '2', '2',
        '#'),
       ('10.99', '5', '4', NULL, '4', '1', '1', '1',
        '#'),
       ('12.99', '6', '4', NULL, '5', '2', '2', '2',
        '#'),
       ('7.99', '7', '4', NULL, '6', '3', '3', '3',
        '#'),
       ('20.99', '8', '4', NULL, '4', '4', '1', '4',
        '#'),
       ('9.99', '5', '4', NULL, '5', '1', '2', '5',
        '#'),
       ('19.99', '6', '4', NULL, '5', '2', '1', '1',
        '#'),
       ('15.99', '7', '4', NULL, '4', '3', '2', '2',
        '#');


-- Diablo II: Resurrected
INSERT INTO `product` (`price`, `edition_product_id`, `game_id`, `id`, `keys_product_id`,
                       `platform_product_id`, `region_product_id`, `vendor_product_id`, `link`)
VALUES ('13.99', '1', '5', NULL, '1', '1', '1', '1',
        '#'),
       ('14.99', '2', '5', NULL, '2', '2', '2', '2',
        '#'),
       ('15.99', '3', '5', NULL, '3', '3', '3', '3',
        '#'),
       ('20.99', '4', '5', NULL, '1', '4', '1', '4',
        '#'),
       ('30.99', '1', '5', NULL, '2', '1', '2', '5',
        '#'),
       ('19.99', '2', '5', NULL, '2', '2', '1', '1',
        '#'),
       ('15.99', '3', '5', NULL, '1', '3', '2', '2',
        '#'),
       ('32.99', '5', '6', NULL, '4', '1', '1', '1',
        '#'),
       ('22.99', '6', '6', NULL, '5', '2', '2', '2',
        '#'),
       ('7.99', '7', '6', NULL, '6', '3', '3', '3',
        '#'),
       ('20.99', '8', '6', NULL, '4', '4', '1', '4',
        '#'),
       ('29.99', '5', '6', NULL, '5', '1', '2', '5',
        '#');


-- Final Fantasy VII
INSERT INTO `product` (`price`, `edition_product_id`, `game_id`, `id`, `keys_product_id`,
                       `platform_product_id`, `region_product_id`, `vendor_product_id`, `link`)
VALUES ('20.99', '1', '7', NULL, '1', '1', '1', '1',
        '#'),
       ('30.99', '2', '7', NULL, '2', '2', '2', '2',
        '#'),
       ('45.99', '3', '7', NULL, '3', '3', '3', '3',
        '#'),
       ('20.99', '4', '7', NULL, '1', '4', '1', '4',
        '#'),
       ('30.99', '1', '7', NULL, '2', '1', '2', '5',
        '#'),
       ('39.99', '2', '7', NULL, '2', '2', '1', '1',
        '#'),
       ('65.99', '3', '7', NULL, '1', '3', '2', '2',
        '#'),
       ('52.99', '5', '8', NULL, '4', '1', '1', '1',
        '#'),
       ('72.99', '6', '8', NULL, '5', '2', '2', '2',
        '#'),
       ('45.99', '7', '8', NULL, '6', '3', '3', '3',
        '#'),
       ('34.99', '8', '8', NULL, '4', '4', '1', '4',
        '#'),
       ('29.99', '5', '8', NULL, '5', '1', '2', '5',
        '#');


-- Alan Wake 2
INSERT INTO `product` (`price`, `edition_product_id`, `game_id`, `id`, `keys_product_id`,
                       `platform_product_id`, `region_product_id`, `vendor_product_id`, `link`)
VALUES ('30.99', '1', '9', NULL, '1', '1', '1', '1',
        '#'),
       ('30.99', '2', '9', NULL, '2', '2', '2', '2',
        '#'),
       ('45.99', '3', '9', NULL, '3', '3', '3', '3',
        '#'),
       ('27.99', '4', '9', NULL, '1', '4', '1', '4',
        '#'),
       ('30.99', '1', '9', NULL, '2', '1', '2', '5',
        '#'),
       ('39.99', '2', '9', NULL, '2', '2', '1', '1',
        '#'),
       ('65.99', '3', '9', NULL, '1', '3', '2', '2',
        '#'),
       ('52.99', '5', '10', NULL, '4', '1', '1', '1',
        '#'),
       ('72.99', '6', '10', NULL, '5', '2', '2', '2',
        '#'),
       ('45.99', '7', '10', NULL, '6', '3', '3', '3',
        '#'),
       ('34.99', '8', '10', NULL, '4', '4', '1', '4',
        '#'),
       ('29.99', '5', '10', NULL, '5', '1', '2', '5',
        '#');


-- Resident Evil 4 Remake
INSERT INTO `product` (`price`, `edition_product_id`, `game_id`, `id`, `keys_product_id`,
                       `platform_product_id`, `region_product_id`, `vendor_product_id`, `link`)
VALUES ('35.99', '1', '11', NULL, '1', '1', '1', '1',
        '#'),
       ('30.99', '2', '11', NULL, '2', '2', '2', '2',
        '#'),
       ('45.99', '3', '11', NULL, '3', '3', '3', '3',
        '#'),
       ('37.99', '4', '11', NULL, '1', '4', '1', '4',
        '#'),
       ('30.99', '1', '11', NULL, '2', '1', '2', '5',
        '#'),
       ('39.99', '2', '11', NULL, '2', '2', '1', '1',
        '#'),
       ('65.99', '3', '11', NULL, '1', '3', '2', '2',
        '#'),
       ('52.99', '5', '12', NULL, '4', '1', '1', '1',
        '#'),
       ('72.99', '6', '12', NULL, '5', '2', '2', '2',
        '#'),
       ('45.99', '7', '12', NULL, '6', '3', '3', '3',
        '#'),
       ('34.99', '8', '12', NULL, '4', '4', '1', '4',
        '#'),
       ('49.99', '5', '12', NULL, '5', '1', '2', '5',
        '#');


