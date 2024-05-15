CREATE DATABASE  `youtubedb`;
USE `youtubedb`;

-- -----------------------------------------------------
-- Table `youtubedb`.`Users`
-- -----------------------------------------------------
CREATE TABLE Users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255),
    password VARCHAR(255),
    username VARCHAR(100),
    date_of_birth DATE,
    sex ENUM('M', 'F'),
    country VARCHAR(100),
    postal_code VARCHAR(20)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`Videos`
-- -----------------------------------------------------
CREATE TABLE Videos (
    video_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    size VARCHAR(20),
    file_name VARCHAR(255),
    length TIME,
    thumbnail VARCHAR(255),
    views INT DEFAULT 0,
    likes INT DEFAULT 0,
    dislikes INT DEFAULT 0,
    state ENUM('public', 'hidden', 'private'),
    user_id INT,
    publish_datetime DATETIME,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`Tags`
-- -----------------------------------------------------
CREATE TABLE Tags (
    tag_id INT AUTO_INCREMENT PRIMARY KEY,
    tag_name VARCHAR(100)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`VideoTags`
-- -----------------------------------------------------
CREATE TABLE VideoTags (
    video_id INT,
    tag_id INT,
    PRIMARY KEY (video_id, tag_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id),
    FOREIGN KEY (tag_id) REFERENCES Tags(tag_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`Channels`
-- -----------------------------------------------------
CREATE TABLE Channels (
    channel_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    creation_date DATE,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`Subscriptions`
-- -----------------------------------------------------
CREATE TABLE Subscriptions (
    subscription_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    channel_id INT,
    subscribe_date DATE,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (channel_id) REFERENCES Channels(channel_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`Comments`
-- -----------------------------------------------------
CREATE TABLE Comments (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    text TEXT,
    comment_datetime DATETIME,
    user_id INT,
    video_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`CommentReactions`
-- -----------------------------------------------------
CREATE TABLE CommentReactions (
    reaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    comment_id INT,
    reaction ENUM('like', 'dislike'),
    reaction_datetime DATETIME,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (comment_id) REFERENCES Comments(comment_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`Playlists`
-- -----------------------------------------------------
CREATE TABLE Playlists (
    playlist_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    creation_date DATE,
    status ENUM('public', 'private'),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`PlaylistVideos`
-- -----------------------------------------------------
CREATE TABLE PlaylistVideos (
    playlist_id INT,
    video_id INT,
    added_by_user_id INT,
    added_date DATETIME,
    PRIMARY KEY (playlist_id, video_id),
    FOREIGN KEY (playlist_id) REFERENCES Playlists(playlist_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id),
    FOREIGN KEY (added_by_user_id) REFERENCES Users(user_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`VideoReactions`
-- -----------------------------------------------------
CREATE TABLE VideoReactions (
    reaction_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    video_id INT,
    reaction ENUM('like', 'dislike'),
    reaction_datetime DATETIME,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

-- -----------------------------------------------------
-- Table `youtubedb`.`UserFavorites`
-- -----------------------------------------------------
CREATE TABLE UserFavorites (
    favorite_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    video_id INT,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (video_id) REFERENCES Videos(video_id)
);

