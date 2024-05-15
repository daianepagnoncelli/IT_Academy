INSERT INTO Users (email, password, username, date_of_birth, sex, country, postal_code) VALUES
('user1@example.com', 'password1', 'user1', '1990-01-01', 'M', 'USA', '12345'),
('user2@example.com', 'password2', 'user2', '1992-02-02', 'F', 'Canada', '54321'),
('user3@example.com', 'password3', 'user3', '1994-03-03', 'Other', 'Brazil', '98765');

INSERT INTO Videos (title, description, size, file_name, length, thumbnail, user_id, publish_datetime) VALUES
('Sample Video 1', 'This is a short video for demonstration purposes.', '10MB', 'sample_video_1.mp4', '00:02:00', 'thumbnail_1.jpg', 1, NOW()),
('Sample Video 2', 'Another example video with a longer description.', '20MB', 'sample_video_2.mp4', '00:05:00', 'thumbnail_2.jpg', 2, NOW()),
('Travel Vlog', 'A short travel vlog showcasing beautiful landscapes.', '50MB', 'travel_vlog.mp4', '00:10:00', 'thumbnail_3.jpg', 3, NOW());

INSERT INTO Tags (tag_name) VALUES
('Comedy'),
('Music'),
('Travel'),
('Gaming');

INSERT INTO VideoTags (video_id, tag_id) VALUES
(1, 1),  -- Sample Video 1 with Comedy tag
(2, 2),  -- Sample Video 2 with Music tag
(3, 3);  -- Travel Vlog with Travel tag

INSERT INTO Channels (name, description, creation_date, user_id) VALUES
('user1\'s Channel', 'A channel with interesting content.', '2023-12-31', 1),
('user2\'s Channel', 'Sharing my passion for music.', '2024-01-15', 2),
('Travel Enthusiast', 'Exploring the world one vlog at a time.', '2024-02-29', 3);

INSERT INTO Subscriptions (user_id, channel_id, subscribe_date) VALUES
(2, 1, '2024-04-01'),  -- user2 subscribes to user1's channel
(1, 3, '2024-04-10');  -- user1 subscribes to Travel Enthusiast channel

INSERT INTO Playlists (name, creation_date, user_id, status) VALUES
('Favorite Videos', '2024-04-15', 1, 'public'),
('Travel Playlist', '2024-04-20', 3, 'private');

INSERT INTO Comments (text, comment_datetime, user_id, video_id) VALUES
('This video is hilarious!', NOW(), 1, 1),
('Great music selection!', NOW(), 2, 2),
('Beautiful scenery!', NOW(), 3, 3);

INSERT INTO CommentReactions (user_id, comment_id, reaction, reaction_datetime) VALUES
(2, 1, 'like', NOW());
