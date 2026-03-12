# Multithreaded Chat Application (Java)

## 📌 Project Description
This project is a client-server chat application developed using Java Socket Programming and Multithreading.  
The server allows multiple clients to connect simultaneously and exchange messages in real time.

Each connected client is handled using a separate thread, enabling concurrent communication between multiple users.

---

## 🚀 Features
- Supports multiple clients simultaneously
- Real-time message broadcasting
- Username-based chat system
- Join and leave notifications
- Multithreaded server architecture
- Synchronized message handling

---

## 🛠 Technologies Used
- Java
- ServerSocket & Socket
- Multithreading (Thread class)
- BufferedReader & PrintWriter
- HashSet Collection

---

## 📂 Project Structure

Task3_ChatApp/
│
├── Server.java
├── Client.java
└── README.md


---

## ▶️ How to Run the Project

### 1️⃣ Compile the files

javac Server.java
javac Client.java


### 2️⃣ Run the Server

java Server


### 3️⃣ Run Clients (Open multiple terminals)

java Client


Enter different usernames in each client and start chatting.

---

## 📷 Sample Output
- Server starts and listens on port 5000
- Clients connect and enter usernames
- Join message is displayed
- Messages are broadcast to all connected clients
- Leave message is displayed when a client exits

---

## 📚 Concepts Used
- Socket Programming
- ServerSocket
- Client-Server Architecture
- Multithreading
- Synchronization
- Collections Framework (HashSet)

---

## 🎯 Learning Outcome
Through this project, I learned how to:
- Build a client-server architecture
- Handle multiple clients using threads
- Implement real-time communication
- Manage shared resources using synchronization