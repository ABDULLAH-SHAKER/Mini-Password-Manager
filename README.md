# 🛡️ Mini-Password-Manager

<p align="center">
  <img src="/src/assets/header.png" width="600" alt="Mini-Password-Manager" />
</p>
**Mini-Password-Manager** is a simple and lightweight Java application designed to securely manage your passwords via a clean **Command Line Interface (CLI)**.  
It is beginner-friendly but structured with **OOP principles**, making it easy to maintain and extend in the future.

---

## ⭐ Features
- Add new password entries (Site, Username, Encrypted Password)
- List all saved passwords
- Search for a password by site name
- Update existing entries
- Delete unwanted entries
- Basic encryption & decryption using Base64 with a custom prefix
- Auto-save and load data from a local file (`passwords.db`)
- Clean and scalable project structure

---

## 🧩 Project Structure
```
Mini-Password-Manager/
│
├── src/
│   ├── Main.java
│   ├── models/
│   │   └── PasswordEntry.java
│   ├── services/
│   │   └── PasswordManager.java
│   └── utils/
│       └── Encryptor.java
├── README.md
└── LICENSE (optional)
```

---

## 🎯 Project Goals
- Practice real-world Java programming
- Implement Object-Oriented Programming (OOP)
- Handle files in Java (File I/O)
- Understand basic encryption techniques
- Build a fully functional console application from scratch
- Prepare the codebase for future GUI or web versions

---

## 🛠️ Technologies Used
- **Java 17+**
- **CLI Interface**
- **Object-Oriented Programming**
- **File Handling (Local Storage)**
- **Base64 Encryption**

---

## 🚀 How to Run

1. **Clone the repository**
```bash
git clone https://github.com/ABDULLAH-SHAKER/Mini-Password-Manager.git
cd Mini-Password-Manager
```

2. **Create `bin` directory and compile all Java files**
```bash
mkdir -p bin
javac -d bin src/**/*.java
```

3. **Run the application**
```bash
java -cp bin Main
```

---

## 💻 Example CLI Usage

```
=== Mini Password Manager ===
1. Add Password
2. List Passwords
3. Search Password
4. Update Password
5. Delete Password
6. Exit
Choose an option: 1
Site: example.com
Username: user123
Password: mySecret!
Password added successfully!
```

---

## 🔒 Encryption
- All passwords are encrypted using **Base64 + custom prefix** before saving to file.
- Example: `MPM_bXlTZWNyZXQh`  
- Can be easily extended to use stronger encryption (AES) in the future.

---

## 📝 Roadmap / TODO
- Add GUI version (JavaFX or Swing)
- Integrate stronger encryption (AES)
- Multi-user support
- Export / Import functionality (CSV, JSON)
- Cloud backup option

---

## 👤 Author
**Abdullah Shaker**  
- GitHub: [ABDULLAH-SHAKER](https://github.com/ABDULLAH-SHAKER)  
- Contact: `Abdullah.bamalhas@gmail.com`

---

