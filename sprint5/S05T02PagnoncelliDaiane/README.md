# 🎲 DICE GAME

## 📜 Description
This project is a dice game developed with Spring Boot, using JWT for user authentication and authorization. The game allows users to register, log in, and play dice. Additionally, there are user and admin roles that control access to certain endpoints.

## 🕹️ About
This game is played with two dice. If the sum of the two dice equals 7, the game is won; otherwise, it is lost. To play the game and make a roll, a user must register with a unique email and player name. If the user chooses not to add a name, they will be called "ANONYMOUS". Upon registration, each user is assigned a unique ID and a registration date. Each player can see a list of all the rolls they have made, including the value of each roll. Players cannot delete specific games but can delete their entire list of rolls. The app allows listing all players in the system and provides the average success percentage of all players, the best percentage player, and the worst.

## ✨ Features
- 🔒 Authentication and authorization with JWT
- 👤 User and admin roles
- ⚙️ CRUD operations for players and games
- 🗄️ Integration with MySQL and MongoDB databases

## 📋 Prerequisites
- ☕ Java 17 or higher
- 📦 Maven
- 🗄️ MySQL
- 🗄️ MongoDB

## 🚀 Usage

### 🌐 Public Endpoints
- **POST /api/auth/register**: Register a new user
- **POST /api/auth/login**: Log in and obtain a JWT token

### 🔑 Admin Endpoints
These endpoints require a valid JWT token with the admin role.
- **GET /players/admin/all**: Get a list of all players
- **POST /players/admin/getAverageRate**: Get the average win rate of all players

### 🛡️ User Endpoints
These endpoints require a valid JWT token. Non-admin players can only use their ID as a path parameter.
- **GET /players/{id}**: Get a player by ID
- **POST /players**: Create a new player
- **PUT /players/{id}**: Update a player by ID
- **DELETE /players/{id}**: Delete a player by ID
- **DELETE /players/{id}/games**: Delete all games for a player by ID
- **GET /players/ranking**: Get the average success rate of all players
- **GET /players/ranking/loser**: Get the player with the lowest success rate
- **GET /players/ranking/winner**: Get the player with the highest success rate

## 📞 Contact
Daiane Pagnoncelli - d_pagnoncellli@hotmail.com
