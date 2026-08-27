# 🎮 Hangman

> A desktop Hangman game built with Java Swing, featuring a countdown timer, multiple difficulty levels and persistent score storage using SQLite.

![Java](https://img.shields.io/badge/Java-20+-ED8B00?style=flat-square\&logo=openjdk\&logoColor=white)
![Swing](https://img.shields.io/badge/Java%20Swing-GUI-007396?style=flat-square)
![SQLite](https://img.shields.io/badge/SQLite-003B57?style=flat-square\&logo=sqlite\&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Database%20Access-ED8B00?style=flat-square)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=flat-square\&logo=apache-netbeans-ide\&logoColor=white)

---

## ✨ Features

* ⏱️ **Countdown Timer** — Adds a time-based challenge to each game.
* 🎯 **Multiple Difficulty Levels** — Choose between different gameplay difficulties.
* 🏆 **Score & High Score Tracking** — Calculate and save game results.
* 💾 **Persistent Score Storage** — Store scores locally using SQLite.
* ❌ **Input Validation** — Prevent invalid and repeated letter guesses.
* 🔄 **Game Restart** — Start a new game without restarting the application.
* 🎮 **Game State Management** — Handles active, won, lost and timed-out states.

---

## 🏗️ Architecture

The application follows the **MVC (Model-View-Controller)** architecture, separating the graphical interface, game logic and data access.

```text
┌─────────────────────┐
│        View         │
│     Java Swing      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Controller      │
│   Game Flow / Input │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│        Model        │
│  Game State / Score │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│   Data Access Layer │
│     JDBC / SQLite   │
└─────────────────────┘
```

---

## 💾 Database

The application uses **SQLite** for persistent local score storage.

Database operations are handled through **JDBC**.

The database stores:

* Player name
* Score
* Difficulty
* Game result
* Date/time

### Database Structure

```text
scores
├── id
├── player_name
├── score
├── difficulty
├── result
└── created_at
```

---

## 🧠 Technical Highlights

* Designed the application using the **MVC architecture**.
* Integrated **SQLite with JDBC** for persistent data storage.
* Implemented **game state management** for different game outcomes.
* Implemented a **countdown timer** using Swing.
* Added **input validation** for user guesses.
* Implemented a **difficulty system** affecting gameplay and scoring.

---

## ⚙️ Installation

### Requirements

* Java JDK 20+
* Apache NetBeans
* SQLite JDBC driver

### 1. Clone the repository

```bash
git clone https://github.com/milos970/hangman.git
cd hangman
```

### 2. Open the project

Open the project in **Apache NetBeans**:

```text
File → Open Project
```

### 3. Run the application

```text
Run → Run Project
```

or press:

```text
F6
```

---

## 📸 Screenshots

### Main Menu

![Main Menu](docs/screenshots/main-menu.png)

### Gameplay

![Gameplay](docs/screenshots/gameplay.png)

### Scores

![Scores](docs/screenshots/scores.png)

---

## 🔮 Future Improvements

* [ ] Add word categories
* [ ] Add sound effects
* [ ] Improve scoring system
* [ ] Add unit tests
* [ ] Create a standalone application installer

---

## 👨‍💻 Author

**Milos**

Junior Software Developer

[GitHub](https://github.com/milos970)

---

## ⭐ Project Status

✅ **Completed**

No major features are currently planned.
