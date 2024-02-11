INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

INSERT INTO `crossplay` (`id`, `has_crossplay`) VALUES
(1, 'true'),
(2, 'false');

INSERT INTO minimum_system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES 
('DirectX 12', 'NVIDIA GTX 1650', 'Windows 10', 'Intel Core i5-9400F', '8 GB', '500 GB'),
('DirectX 11', 'AMD Radeon RX 57', 'Windows 10', 'AMD Ryzen 5 260', '8 GB', '1 TB'),
('DirectX 12', 'NVIDIA RTX 306','Windows 10', 'Intel Core i7-9700K', '16 GB', '1 TB SSD');


INSERT INTO recommended_system_requirement (directx, graphics_card, operating_system, processor, ram, storage)
VALUES 
('DirectX 12', 'NVIDIA RTX 2060', 'Windows 10', 'Intel Core i7-9700K', '16 GB', '1 TB SSD'),
('DirectX 12', 'AMD Radeon RX 5700 XT', 'Windows 10', 'AMD Ryzen 7 3700X', '16 GB', '1 TB SSD'),
('DirectX 12', 'NVIDIA RTX 3080', 'Windows 10', 'Intel Core i9-9900K', '32 GB', '2 TB SSD');



INSERT INTO `user` (`year`, `id`, `role_id`, `phone`, `language`, `country`, `username`, `password`, `email`, `gender`, `image`, `register_date`) VALUES
(1950, 1, 1, 'Teléfono del usuario', 'Idioma del usuario', 'País del usuario', 'Nombre del usuario', '$2a$10$GQ8EjxA1xo18wJC4Ea8ZQOD1wlg2kf9U4hdobBSipD4Nn3uWZ1HzW', 'admin@admin.com', NULL, 'URL de la imagen', '11/02/2024'),
(1950, 2, 2, 'Teléfono del usuario', 'Idioma del usuario', 'País del usuario', 'Nombre del usuario', '$2a$10$GQ8EjxA1xo18wJC4Ea8ZQOD1wlg2kf9U4hdobBSipD4Nn3uWZ1HzW', 'user@user.com', NULL, 'URL de la imagen', '11/02/2024');

