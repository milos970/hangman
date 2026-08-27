# 🎮 Hangman

> A desktop Hangman game built with Java Swing, featuring a countdown timer, multiple difficulty levels and persistent score storage using SQLite.





---



## ✨ Features

* ⏱️ Countdown timer
* 🎯 Multiple difficulty levels
* 💾 Persistent score storage using SQLite
* 🏆 High score tracking
* ❌ Input validation
* 🧩 MVC architecture

---

## 🛠️ Tech Stack

* **Java 20+**
* **Java Swing** — graphical user interface
* **SQLite** — local database
* **JDBC** — database connectivity
* **Apache NetBeans** — development environment
* **Git / GitHub** — version control

---

## 🏗️ Architecture

The application follows the **MVC (Model-View-Controller)** architecture.

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

The database stores information such as:

* Player name
* Score
* Difficulty
* Game result
* Date/time

Example database structure:

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

* Implemented **MVC architecture** to separate the graphical interface, game logic and data access.
* Integrated **SQLite with JDBC** for persistent score storage.
* Implemented **game state management** for active, won, lost and timed-out games.
* Added **input validation** to prevent invalid and repeated letter guesses.
* Implemented a **countdown timer** integrated with the Swing application.
* Implemented a **difficulty system** affecting the gameplay experience.

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

Open the project in **Apache NetBeans**.

```text
File → Open Project
```

### 3. Run

Run the project from NetBeans:

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

### Gameplay

### Scores

---

## 🔮 Future Improvements

* [ ] Add word categories
* [ ] Improve scoring system
* [ ] Add unit tests
