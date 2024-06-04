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
        'Intel Core i5-4460 o AMD FX-6300 o superior', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 1060 o AMD Radeon RX 480 con 3GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i7-3770 o AMD FX-9590 o superior', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 760 o AMD Radeon R7 260x con 2GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i5-4460 o AMD FX-6300 o superior', '8 GB', '26 GB'),
       ('11', 'NVIDIA GeForce GTX 1060 o AMD Radeon RX 480 con 3GB VRAM', 'WINDOWS 7, 8.1, 10 (64-BIT Required)',
        'Intel Core i7-3770 o AMD FX-9590 o superior', '8 GB', '26 GB');


-- a123456. -> Contraseña encriptada con Bcrypt
INSERT INTO `user` (`year`, `id`, `role_id`, `language`, `country`, `username`, `password`, `email`, `gender`,
                    `image`, `alt`, `register_date`)
VALUES (1950, 1, 1, 'Idioma del usuario', 'España', 'Admin',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'admin@admin.com', NULL, 'URL de la imagen',
        'alt',
        '2024/11/02'),
       (1950, 2, 2, 'Idioma del usuario', 'España', 'David',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'david@david.com', NULL, 'URL de la imagen',
        'alt',
        '2024/11/02'),
       (1950, 3, 2, 'Idioma del usuario', 'España', 'Sergio',
        '$2a$12$e9sF2oX8llofdbMLk.YbOOFenroZx0aL0P1e33M9YtdF2M2dGSWlG', 'sergio@sergio.com', NULL, 'URL de la imagen',
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
        'alt', '2024/11/02');



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

INSERT INTO `saga` (`id`, `name`)
VALUES ('1', 'Resident Evil'),
       ('2', 'Resident Evil');


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
       (2100, 540, 2, 2, '3', '4', '2', 'Imagen del Resident Evil 2 Remake',
        'https://cdn.cloudflare.steamstatic.com/steam/apps/883710/header.jpg?t=1701395502',
        '2019/01/25',
        'Resident Evil 2 Remake” brings players back to the terrifying Raccoon City, reimagined from the 1998 horror classic. In this survival horror adventure, players choose between Leon S. Kennedy, a rookie cop, and Claire Redfield, a college student, as they navigate a city overrun by zombies. Their quest for survival reveals the dark side of a bioweapon disaster while they encounter other survivors and face the monstrous results of the outbreak. With revamped gameplay and stunning graphics, the game offers a modern twist on the original’s chilling narrative.',
        'Resident Evil 2 Remake', 0, 'https://www.youtube.com/watch?v=xtxJtQa6VSw', 2);


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
       (2, 5); -- Resident Evil 2 Remake en Xbox Series X


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


INSERT INTO game_developer (game_id, developer_id)
VALUES (1, 1),
       (2, 1);

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
       (2, 1);


INSERT INTO dlc (game_id, name, date, sinopsis, alt, image)
VALUES (1, 'Extra DLC Pack', '2019/02/15',
        'Un paquete de contenido descargable que incluye los siguientes elementos: The 4th Survivor, The Tofu Survivor, Traje de Claire: Elza Walker, Traje de Claire: Military, Traje de Claire: Noir, Traje de Leon: Arklay Sheriff, Traje de Leon: Noir, Modelo de pistola: Samurai Edge',
        'Imagen de DLC', 'https://cdn.cloudflare.steamstatic.com/steam/apps/883710/header.jpg?t=1701395502');


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
       (1, 10, true, true, false),
       (2, 1, true, true, true),  -- Español
       (2, 2, true, true, true),  -- Inglés
       (2, 3, true, true, true),  -- Francés
       (2, 4, true, true, true),  -- Alemán
       (2, 5, true, true, true),  -- Italiano
       (2, 6, true, true, false), -- Portugués
       (2, 7, true, true, false), -- Ruso
       (2, 8, true, true, false), -- Chino
       (2, 9, true, true, false), -- Japonés
       (2, 10, true, true, false);



INSERT INTO `news_author` (`id`, `name`, `surname`, `image`, `alt`)
VALUES (NULL, 'Alejandro', 'Romero', 'https://miro.medium.com/v2/resize:fit:1024/0*wATbQ49jziZTyhZH.jpg', 'alt'),
       (NULL, 'Eustaquio', 'García', 'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'alt'),
       (NULL, 'Dominic', 'Toretto', 'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg',
        'alt');


INSERT INTO `news` (`game_id`, `id`, `news_author_id`, `content`, `subtitle`, `date`, `headline`, `image`, `alt`,
                    `translation_id`)
VALUES (1, 1, 1,
        'Capcom ha anunciado recientemente que “Resident Evil 2 Remake” ha superado los 11,2 millones de copias vendidas, consolidando su posición como uno de los títulos más exitosos y queridos de la franquicia1. Este hito es un testimonio del trabajo duro y la dedicación del equipo de desarrollo, que logró reimaginar el clásico de 1998 para las audiencias modernas.
\n
El juego, que se lanzó originalmente en enero de 2019, ha recibido elogios tanto de críticos como de jugadores por su fiel recreación del ambiente de terror del original, al tiempo que introduce mejoras significativas en los gráficos y la jugabilidad. La capacidad de Capcom para equilibrar la nostalgia con la innovación ha sido clave para el éxito del juego.

Además de las impresionantes cifras de ventas, “Resident Evil 2 Remake” ha recibido actualizaciones constantes desde su lanzamiento. La más reciente incluye la adición del español latinoamericano como opción de idioma, lo que demuestra el compromiso de Capcom con su base de jugadores global2.

El éxito de “Resident Evil 2 Remake” no solo ha revitalizado el interés en los títulos anteriores de la serie, sino que también ha establecido un precedente para futuros remakes. Con el lanzamiento del “Resident Evil 4 Remake” a la vuelta de la esquina, los fans tienen grandes expectativas de que Capcom continuará entregando experiencias de juego de alta calidad que honren el legado de la serie.

Mientras tanto, la comunidad de jugadores sigue explorando los oscuros pasillos de la comisaría de Raccoon City y las profundidades del laboratorio de Umbrella, disfrutando de los sustos y desafíos que “Resident Evil 2 Remake” tiene para ofrecer. Con su combinación de horror clásico y modernidad, el juego sigue siendo un referente en el género de terror y supervivencia.',
        'asdsadasd',
        '2024-01-23T18:16:17.633882315',
        'Capcom Celebra el Éxito Continuo de Resident Evil 2 Remake',
        'https://miro.medium.com/v2/resize:fit:933/1*w4DxUy0PMoqeq25UXfyL0g@2x.jpeg', 'alt', 1);


INSERT INTO `news_comment` (`id`, `news_id`, `user_id`, `content`, `date`)
VALUES (NULL, '1', '2', '¡Increíble ver cómo Capcom ha logrado mantener vivo un clásico! ‘Resident Evil 2 Remake’ no solo me trajo recuerdos de mi infancia, sino que también me presentó desafíos completamente nuevos. ¡Espero con ansias el próximo remake!', '2024-01-10T15:16:17.633882315'),
       (NULL, '1', '3', 'Cada vez que juego ‘Resident Evil 2 Remake’, descubro algo nuevo. La atención al detalle y la atmósfera son impresionantes. Es un ejemplo perfecto de cómo se debe hacer un remake. ¡Bien hecho, Capcom!', '2024-01-20T18:16:17.633882315'),
       (NULL, '1', '4', 'Como fan de la serie desde el principio, tenía mis dudas sobre este remake, pero Capcom superó todas mis expectativas. La historia, los gráficos y la jugabilidad son de primera calidad. ¡‘Resident Evil 2’ siempre tendrá un lugar especial en mi corazón!', '2024-02-10T20:16:17.633882315');

INSERT INTO `feature` (`name`, `image`, `alt`)
VALUES ('Un Jugador', 'dassa', 'asdsadas'),
       ('Multijugador', 'dassa', 'asdsadas'),
       ('Jugadores vs Entorno', 'dassa', 'asdsadas'),
       ('Jugador vs Jugador', 'dassa', 'asdsadas'),
       ('Coop.Online', 'dassa', 'asdsadas'),
       ('Coop.LAN', 'dassa', 'asdsadas');

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
       (2, 1, NULL), -- Asociar el juego con ID 1 con la característica con ID 1 y sin NumberPlayer
       (2, 2, 1);

INSERT INTO `review` (`date`, `dislike`, `game_id`, `like`, `user_id`, `title`, `content`)
VALUES ('2023-01-30T18:16:17.633882315', 0, 1, 10, 2, 'Un Clásico Reinventado',
        'Capcom ha hecho un trabajo magistral al traer ‘Resident Evil 2’ al siglo XXI. La jugabilidad es fluida, los gráficos son impresionantes y la historia se siente tan fresca como en 1998. Es un remake que respeta el original pero no tiene miedo de innovar. ¡Un imprescindible para cualquier fan de la serie!'),
       ('2023-10-30T18:16:17.633882315', 2, 1, 8, 3, 'Terror en Alta Definición',
        'Resident Evil 2 Remake’ me mantuvo al borde de mi asiento de principio a fin. La tensión es constante y los sustos están bien ejecutados. Aunque algunos puzles se sienten un poco anticuados, la experiencia general es excepcional.'),
       ('2023-11-30T18:16:17.633882315', 1, 1, 9, 4, 'Una Obra Maestra del Horror',
        'Este juego redefine lo que debería ser un remake. Con una narrativa envolvente y un diseño de sonido que te sumerge completamente, ‘Resident Evil 2 Remake’ es una experiencia que ningún fan del género debería perderse.'),
       ('2023-12-30T18:16:17.633882315', 3, 1, 7, 5, 'Más que Nostalgia',
        'Al principio, compré ‘Resident Evil 2 Remake’ por la nostalgia, pero lo que encontré fue una obra de arte moderna. Los personajes son profundos, el mundo es inmersivo y cada rincón de Raccoon City está lleno de detalles. Sin embargo, la IA de los enemigos a veces deja que desear.');



INSERT INTO `game_score` (`score`, `date`, `game_id`, `id`, `user_id`)
VALUES ('7', '2023-01-30T18:16:17.633882315', '1', NULL, '2'),
       ('8', '2023-01-30T18:16:17.633882315', '1', NULL, '3'),
       ('8', '2023-01-30T18:16:17.633882315', '1', NULL, '4'),
       ('9', '2023-01-30T18:16:17.633882315', '1', NULL, '5');

-- Inserta una edición
INSERT INTO edition_product (name)
VALUES ('Edición estándar'),
       ('Edición coleccionista'),
       ('Edición limitada'),
       ('Edición especial');

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
VALUES ('Key'),
       ('Gift'),
       ('Account');


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
        '#');


-- INSERT INTO `review_vote` (`vote`, `id`, `review_id`, `user_id`)
-- VALUES ('1', NULL, '2', '1');

--
-- INSERT INTO `follow_game` (`is_following`, `game_id`, `user_id`)
-- VALUES ('1', '2', '1'),
--        ('-1', '1', '1');


