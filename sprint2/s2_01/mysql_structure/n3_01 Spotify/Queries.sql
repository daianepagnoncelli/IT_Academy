CREATE DATABASE  `spotifydb`;
USE `spotifydb`;

-- -----------------------------------------------------
-- Table `spotifydb`.`Users`
-- -----------------------------------------------------
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(100),
    date_of_birth DATE,
    sex VARCHAR(10),
    country VARCHAR(100),
    postal_code VARCHAR(20),
    user_type ENUM('free', 'premium')
);

-- -----------------------------------------------------
-- Table `spotifydb`.`Subscriptions`
-- -----------------------------------------------------

CREATE TABLE Subscriptions (
    subscription_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    subscription_start_date DATE,
    service_renewal_date DATE,
    payment_method VARCHAR(20),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`PaymentMethods`
-- -----------------------------------------------------

CREATE TABLE PaymentMethods (
    payment_method_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    method_type ENUM('credit_card', 'PayPal'),
    card_number VARCHAR(20),
    expiry_month INT,
    expiry_year INT,
    security_code VARCHAR(5),
    PayPal_username VARCHAR(100),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`Payments`
-- -----------------------------------------------------

CREATE TABLE Payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    subscription_id INT,
    payment_date DATE,
    order_number VARCHAR(50),
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (subscription_id) REFERENCES Subscriptions(subscription_id)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`Playlists`
-- -----------------------------------------------------

CREATE TABLE Playlists (
    playlist_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    title VARCHAR(255),
    number_of_songs INT,
    creation_date DATE,
    is_deleted BOOLEAN DEFAULT FALSE,
    deletion_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`Songs`
-- -----------------------------------------------------

CREATE TABLE Songs (
    song_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    duration TIME,
    play_count INT DEFAULT 0
);

-- -----------------------------------------------------
-- Table `spotifydb`.`Artists`
-- -----------------------------------------------------

CREATE TABLE Artists (
    artist_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    image VARCHAR(255)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`Albums`
-- -----------------------------------------------------

CREATE TABLE Albums (
    album_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    year_of_publication INT,
    cover_image VARCHAR(255),
    artist_id INT,
    FOREIGN KEY (artist_id) REFERENCES Artists(artist_id)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`UserArtistRelationships`
-- -----------------------------------------------------

CREATE TABLE UserArtistRelationships (
    relationship_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    artist_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (artist_id) REFERENCES Artists(artist_id)
);

-- -----------------------------------------------------
-- Table `spotifydb`.`UserFavorites`
-- -----------------------------------------------------

CREATE TABLE UserFavorites (
    favorite_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    album_id INT,
    song_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (album_id) REFERENCES Albums(album_id),
    FOREIGN KEY (song_id) REFERENCES Songs(song_id)
);

