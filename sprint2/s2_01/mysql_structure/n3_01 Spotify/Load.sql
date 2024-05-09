-- Table Users
INSERT INTO Users (email, password, username, date_of_birth, sex, country, postal_code, user_type)
VALUES 
('user1@example.com', 'password1', 'user1', '1990-01-01', 'M', 'USA', '12345', 'premium'),
('user2@example.com', 'password2', 'user2', '1995-05-15', 'F', 'UK', '54321', 'free'),
('user3@example.com', 'password3', 'user3', '1988-11-20', 'M', 'Canada', '67890', 'free');

-- Table Subscriptions
INSERT INTO Subscriptions (user_id, subscription_start_date, service_renewal_date, payment_method)
VALUES 
(1, '2023-01-01', '2024-01-01', 'credit_card'),
(2, '2023-02-15', '2023-08-15', 'PayPal'),
(3, '2023-03-20', '2023-09-20', 'credit_card');

-- Table PaymentMethods
INSERT INTO PaymentMethods (user_id, method_type, card_number, expiry_month, expiry_year, security_code, PayPal_username)
VALUES 
(1, 'credit_card', '1234567890123456', 12, 2025, '123', NULL),
(2, 'PayPal', NULL, NULL, NULL, NULL, 'user2_paypal'),
(3, 'credit_card', '9876543210987654', 10, 2024, '456', NULL);

-- Table Payments
INSERT INTO Payments (subscription_id, payment_date, order_number, total_amount)
VALUES 
(1, '2023-01-01', 'ORD123456', 99.99),
(2, '2023-02-15', 'ORD987654', 49.99),
(3, '2023-03-20', 'ORD246810', 79.99);

-- Table Playlists
INSERT INTO Playlists (user_id, title, number_of_songs, creation_date, is_deleted, deletion_date)
VALUES 
(1, 'My Playlist', 10, '2023-01-01', FALSE, NULL),
(2, 'Workout Mix', 15, '2023-02-15', FALSE, NULL),
(3, 'Chill Vibes', 20, '2023-03-20', FALSE, NULL);

-- Table Songs
INSERT INTO Songs (title, duration, play_count)
VALUES 
('Song 1', '03:45', 100000),
('Song 2', '04:20', 95000),
('Song 3', '03:30', 90000);

-- Table Albums
INSERT INTO Albums (title, year_of_publication, cover_image, artist_id)
VALUES 
('Album 1', 2020, 'album1_cover.jpg', 1),
('Album 2', 2018, 'album2_cover.jpg', 2),
('Album 3', 2019, 'album3_cover.jpg', 3);

-- Table Artists
INSERT INTO Artists (first_name, image)
VALUES 
('Artist 1', 'artist1_image.jpg'),
('Artist 2', 'artist2_image.jpg'),
('Artist 3', 'artist3_image.jpg');

-- Table UserArtistRelationships
INSERT INTO UserArtistRelationships (user_id, artist_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

-- Table UserFavorites
INSERT INTO UserFavorites (user_id, album_id, song_id)
VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);
