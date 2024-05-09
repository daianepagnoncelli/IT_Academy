-- Table Users
INSERT INTO Users (email, password, username, date_of_birth, sex, country, postal_code)
VALUES 
('user1@example.com', 'password1', 'User1', '1990-01-01', 'M', 'Country1', '12345'),
('user2@example.com', 'password2', 'User2', '1992-05-15', 'F', 'Country2', '23456'),
('user3@example.com', 'password3', 'User3', '1988-09-20', 'M', 'Country3', '34567'),
('user4@example.com', 'password4', 'User4', '1995-03-10', 'F', 'Country4', '45678'),
('user5@example.com', 'password5', 'User5', '1998-07-25', 'M', 'Country5', '56789');

-- Table Videos
INSERT INTO Videos (title, description, size, file_name, length, thumbnail, views, likes, dislikes, state, user_id, publish_datetime)
VALUES 
('Video 1', 'Description of Video 1', '100MB', 'video1.mp4', '00:05:30', 'thumbnail1.jpg', 1000, 50, 5, 'public', 1, '2024-01-01 10:00:00'),
('Video 2', 'Description of Video 2', '150MB', 'video2.mp4', '00:07:45', 'thumbnail2.jpg', 800, 40, 8, 'public', 2, '2024-02-15 12:30:00'),
('Video 3', 'Description of Video 3', '120MB', 'video3.mp4', '00:06:20', 'thumbnail3.jpg', 1200, 60, 6, 'public', 3, '2024-03-20 14:45:00'),
('Video 4', 'Description of Video 4', '90MB', 'video4.mp4', '00:04:15', 'thumbnail4.jpg', 1500, 70, 7, 'public', 4, '2024-04-10 16:00:00'),
('Video 5', 'Description of Video 5', '80MB', 'video5.mp4', '00:03:50', 'thumbnail5.jpg', 2000, 80, 4, 'public', 5, '2024-05-25 18:15:00');

-- Table Tags
INSERT INTO Tags (tag_name)
VALUES 
('Tag1'),
('Tag2'),
('Tag3'),
('Tag4'),
('Tag5');

-- Table VideoTags
INSERT INTO VideoTags (video_id, tag_id)
VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Table Channels
INSERT INTO Channels (name, description, creation_date, user_id)
VALUES 
('Channel 1', 'Description of Channel 1', '2024-01-01', 1),
('Channel 2', 'Description of Channel 2', '2024-02-15', 2),
('Channel 3', 'Description of Channel 3', '2024-03-20', 3),
('Channel 4', 'Description of Channel 4', '2024-04-10', 4),
('Channel 5', 'Description of Channel 5', '2024-05-25', 5);

-- Table Subscriptions
INSERT INTO Subscriptions (user_id, channel_id, subscribe_date)
VALUES 
(1, 2, '2024-01-01'),
(2, 3, '2024-02-15'),
(3, 4, '2024-03-20'),
(4, 5, '2024-04-10'),
(5, 1, '2024-05-25');

-- Table Comments
INSERT INTO Comments (text, comment_datetime, user_id, video_id)
VALUES 
('Comment 1 for Video 1', '2024-01-01 10:15:00', 1, 1),
('Comment 2 for Video 2', '2024-02-15 12:45:00', 2, 2),
('Comment 3 for Video 3', '2024-03-20 15:00:00', 3, 3),
('Comment 4 for Video 4', '2024-04-10 16:30:00', 4, 4),
('Comment 5 for Video 5', '2024-05-25 18:45:00', 5, 5);

-- Table CommentReactions
INSERT INTO CommentReactions (user_id, comment_id, reaction, reaction_datetime)
VALUES 
(1, 1, 'like', '2024-01-01 10:20:00'),
(2, 2, 'dislike', '2024-02-15 12:50:00'),
(3, 3, 'like', '2024-03-20 15:15:00'),
(4, 4, 'dislike', '2024-04-10 16:45:00'),
(5, 5, 'like', '2024-05-25 19:00:00');
