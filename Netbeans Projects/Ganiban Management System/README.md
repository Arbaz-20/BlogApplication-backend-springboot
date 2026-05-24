# Ganiban Management System

A desktop **Society / Building Maintenance Management System** built with **Java Swing** (NetBeans GUI Builder) and **MySQL**. It provides a role-based desktop application for managing flat owners/renters, generating maintenance bills, tracking income and expenses, exporting reports to Excel/Word, and administering users.

---

## Tech Stack

| Layer        | Technology                                              |
| ------------ | ------------------------------------------------------- |
| Language     | Java 11 (runtime tested on JDK 17)                      |
| UI Framework | Java Swing (NetBeans `.form` GUI Builder)               |
| Database     | MySQL 8 (`mysql-connector-java` 8.0.22)                 |
| Reporting    | Apache POI 4.1.2 (Excel export), `template.docx` (Word) |
| Date Picker  | `DateChooser` Swing component                           |
| Build Tool   | Maven (NetBeans Maven project)                          |
| Packaging    | Executable JAR + `lib/` dependency folder               |

---

## Project Structure

```
Ganiban-Management-System/
├── Ganiban.bat                       # Windows launcher (runs the built JAR with javaw)
├── database_schema.sql               # MySQL schema (database: maintainance)
├── template.docx                     # Word template used for document export
├── pom.xml                           # Maven build descriptor
├── nbactions.xml                     # NetBeans run/debug actions
├── lib/                              # Local jars (DateChooser, etc.)
├── target/                           # Build output (Ganiban_s-1.0-SNAPSHOT.jar + lib/)
└── src/main/java/com/styleattribute/ganiban_s/
    ├── Main.java                     # Application entry point (landing screen)
    ├── Admin_Login.java              # Admin login screen
    ├── User_login.java               # User login screen
    ├── Security_key.java             # Security key / recovery screen
    ├── Admin_MainFrame.java          # Admin dashboard
    ├── User_MainFrame.java           # User dashboard
    ├── Admin_AddUser.java            # Create application users (Admin)
    ├── Admin_ManageUsers.java        # List / delete users (Admin)
    ├── Admin_NewCustomer.java        # Add flat/shop owner & renter details (Admin)
    ├── Admin_Income.java             # Record income entries (Admin)
    ├── Admin_Expenses.java           # Record expense entries (Admin)
    ├── Admin_Export.java             # Export reports to Excel / Word
    ├── Add_User.java                 # Add customer details (User role)
    ├── Bill.java                     # Generate / print maintenance bill
    ├── Manage_Income_Expenses.java   # View & manage income/expense records
    └── *.form                        # Matching NetBeans GUI Builder layout files
```

---

## Prerequisites

- **Java 11+** (JDK 17 supported — see `Ganiban.bat`)
- **Maven 3.6+**
- **MySQL 8.x** running on `localhost:3306`
- **NetBeans 12+** (recommended, for editing `.form` GUI files)

---

## Setup

### 1. Clone the repository
```bash
git clone <repo-url>
cd "Netbeans Projects/Ganiban-Management-System"
```

### 2. Create the MySQL database
The application connects to a database named **`maintainance`** with user `root` / password `roottoor` (hardcoded in the source — see the *Configuration* note below).

```sql
CREATE DATABASE maintainance;
USE maintainance;
SOURCE database_schema.sql;
```

Or run the SQL in `database_schema.sql` directly in your MySQL client.

### 3. Seed an initial admin
The Admin login screen authenticates against the `admin` table. Insert at least one admin row so you can log in:

```sql
INSERT INTO admin (login_ID, password) VALUES ('admin', 'admin');
```

### 4. Build the project
```bash
mvn clean package
```

This produces:
- `target/Ganiban_s-1.0-SNAPSHOT.jar` — the executable JAR
- `target/lib/` — copied runtime dependencies (MySQL connector, POI, DateChooser, etc.)

### 5. Run the application

**From Maven / NetBeans:**
```bash
mvn exec:java -Dexec.mainClass="com.styleattribute.ganiban_s.Main"
```

**From the built JAR:**
```bash
java -jar target/Ganiban_s-1.0-SNAPSHOT.jar
```

**Windows shortcut (`Ganiban.bat`):**
Edit the JAR path inside `Ganiban.bat` to match your local build output, then double-click. The script launches the JAR with `javaw` and `-Xmx1024M -Xms1024M`.

---

## Configuration

Database credentials are currently **hardcoded** in the Swing classes:

```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost/maintainance", "root", "roottoor");
```

If your MySQL setup differs, update the URL / username / password in every screen that opens a connection (`Admin_Login`, `User_login`, `Admin_AddUser`, `Admin_NewCustomer`, `Admin_Income`, `Admin_Expenses`, `Bill`, `Manage_Income_Expenses`, etc.) and rebuild.

---

## Database Schema

All tables live in the `maintainance` database. See `database_schema.sql` for the full definitions.

| Table               | Purpose                                                          |
| ------------------- | ---------------------------------------------------------------- |
| `admin`             | Admin login credentials (`login_ID`, `password`).                |
| `users`             | Regular user logins created by an admin.                         |
| `customers_details` | Flat/Shop directory — owner, renter, flat status, contact info.  |
| `billing`           | Generated maintenance receipts (receipt no, payer, amount, etc). |
| `income`            | Income ledger (date, sender, mode, cheque/txn ref, amount).      |
| `expenses`          | Expense ledger (date, receiver, mode, cheque/txn ref, amount).   |

---

## Application Flow

1. **`Main`** is the landing window. From here you can choose:
   - **Admin Login** → `Admin_Login` → `Admin_MainFrame`
   - **User Login** → `User_login` → `User_MainFrame`
   - **Security Key** → `Security_key` (recovery / privileged action)

2. **Admin Dashboard (`Admin_MainFrame`)** provides:
   - **Add User** → create application user accounts (`Admin_AddUser`)
   - **Manage Users** → view / delete users (`Admin_ManageUsers`)
   - **New Customer** → register a new flat / shop and its owner+renter (`Admin_NewCustomer`)
   - **Income** → record an income entry (`Admin_Income`)
   - **Expenses** → record an expense entry (`Admin_Expenses`)
   - **Manage Income & Expenses** → tabular view, edit, delete (`Manage_Income_Expenses`)
   - **Export** → export tables to Excel / Word reports (`Admin_Export`)
   - **Bill** → generate & print a maintenance bill (`Bill`)

3. **User Dashboard (`User_MainFrame`)** offers a reduced feature set: adding customer details and viewing/printing bills.

---

## Features

- **Role-based access** — separate Admin and User login flows.
- **Customer management** — track flat number, floor, wing, occupancy (owner/renter), and contact details.
- **Bill generation** — issue maintenance receipts with amount-in-words, month range, and total. Printable directly from the UI.
- **Income & Expense ledger** — record entries with payment mode (cash/cheque/bank transfer), cheque number, and transaction reference.
- **Report export** — generate Excel reports via Apache POI and Word documents from `template.docx`.
- **Date picker** — Swing `DateChooser` component for all date fields.
- **Security key recovery** — admin recovery workflow via `Security_key` screen.

---

## Build Notes

- The Maven build copies all runtime dependencies into `target/lib/` and the produced JAR's manifest references them via `Class-Path: lib/...`. Keep the `lib/` folder next to the JAR when distributing.
- Two local jars (`DateChooser`, `unknown.binary`) are resolved from the project-local Maven repo defined in `pom.xml` (`unknown-jars-temp-repo` → `file:${project.basedir}/lib`).
- `nbactions.xml` and `nbactions-release-profile.xml` provide NetBeans run/debug/profile actions.

---

## Troubleshooting

| Problem                                          | Likely cause / fix                                                                                  |
| ------------------------------------------------ | --------------------------------------------------------------------------------------------------- |
| `Communications link failure` on launch          | MySQL is not running, or `maintainance` database does not exist. Run `database_schema.sql` first.   |
| Admin login always fails                         | The `admin` table is empty. Seed a row: `INSERT INTO admin VALUES ('admin','admin');`.              |
| `ClassNotFoundException: com.mysql.cj.jdbc.Driver` | The `lib/` folder is missing next to the JAR. Re-run `mvn clean package`.                         |
| Excel export fails with POI / XMLBeans error     | Make sure `poi-4.1.2.jar` and `xmlbeans-4.0.0.jar` are present in `target/lib/`.                    |
| Word export fails                                | `template.docx` must be in the working directory when the JAR is run.                               |

---

## Notes

- This is a **desktop application**, not a web service — there are no HTTP endpoints or REST APIs.
- The codebase uses NetBeans `.form` files; edit GUI layouts in NetBeans for best results (hand-editing the generated `initComponents()` blocks is discouraged).
- Database credentials and connection strings should be externalised (e.g. into a properties file) for any production use.

---

## Author

Maintained by **Arbaz** — Ganiban Management System (Java Swing + MySQL desktop app).
