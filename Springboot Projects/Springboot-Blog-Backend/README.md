# Blog Application — Spring Boot Backend

A feature-rich blog application backend built with **Spring Boot 2.6.6**, **Spring Security (JWT)**, **Spring Data JPA**, and **MySQL**. It exposes a REST API for user registration & authentication, category management, blog posts (with pagination, sorting, search & image upload), and comments.

---

## Tech Stack

| Layer       | Technology                                    |
| ----------- | --------------------------------------------- |
| Language    | Java 11                                       |
| Framework   | Spring Boot 2.6.6                             |
| Security    | Spring Security + JWT (jjwt 0.9.1)            |
| Persistence | Spring Data JPA / Hibernate                   |
| Database    | MySQL 8 (mysql-connector-java 8.0.22)         |
| Mapping     | ModelMapper 2.3.5                             |
| Validation  | spring-boot-starter-validation                |
| Build Tool  | Maven (wrapper included: `mvnw` / `mvnw.cmd`) |
| Boilerplate | Lombok                                        |

---

## Project Structure

```
src/main/java/com/arbaz/blog
├── BlogApplication.java              # Spring Boot entry point
├── Configurations/                   # Global & Security configuration
│   ├── GlobalConfiguration.java
│   └── SecurityConfiguration.java
├── Controller/                       # REST controllers
│   ├── LoginController.java
│   ├── UserController.java
│   ├── CategoryController.java
│   ├── PostController.java
│   ├── CommentController.java
│   └── FileController.java
├── DTO/                              # Request/response objects
├── Entity/                           # JPA entities
├── Exceptions/                       # Global exception handling
├── Repository/                       # Spring Data JPA repositories
├── Services/                         # Service interfaces
├── ServiceImplementation/            # Service implementations
└── Utils/                            # JWT helpers & filter
```

---

## Prerequisites

- **Java 11+**
- **Maven 3.6+** (or use the included `mvnw` wrapper)
- **MySQL 8.x** running locally

---

## Setup

### 1. Clone the repository
```bash
git clone <repo-url>
cd "Java Springboot Projects"
```

### 2. Create the MySQL database
```sql
CREATE DATABASE blogapplication;
```

### 3. Configure `src/main/resources/application.properties`
Default values (update credentials if needed):
```properties
server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/blogapplication
spring.datasource.username=root
spring.datasource.password=roottoor

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

project.image=images/
```

### 4. Run the application
```bash
# Windows
mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

The server starts on **http://localhost:8080**.

---

## Authentication

This API uses **JWT Bearer tokens**.

1. Register a user via `POST /user`.
2. Login via `POST /auth/login` with `{ "name": "<username>", "password": "<password>" }`.
3. The response returns a JWT in the `message` field.
4. Send the token in subsequent requests as a header:
   ```
   Authorization: Bearer <token>
   ```

> Public endpoints: `POST /user`, `POST /auth/login`. All others require authentication. Admin-only routes require `ROLE_ADMIN`.

---

## API Endpoints

### Auth
| Method | Endpoint         | Description                |
| ------ | ---------------- | -------------------------- |
| POST   | `/auth/login`    | Login & get a JWT          |

### User
| Method | Endpoint                       | Description                       |
| ------ | ------------------------------ | --------------------------------- |
| POST   | `/user`                        | Register a new user (public)      |
| PUT    | `/user/{id}`                   | Update user                       |
| GET    | `/getUsers`                    | List all users (Admin only)       |
| GET    | `/getUser/{id}`                | Get user by id                    |
| DELETE | `/delete/{id}`                 | Delete user by id (Admin only)    |
| DELETE | `/del`                         | Delete all users                  |
| GET    | `/access/{userId}/{role}`      | Assign role to user (Admin only)  |

### Category
| Method | Endpoint                            | Description           |
| ------ | ----------------------------------- | --------------------- |
| POST   | `/category/create`                  | Create category       |
| PUT    | `/category/category/{id}`           | Update category       |
| GET    | `/category/getCategory/{id}`        | Get category by id    |
| GET    | `/category/getAllCategories`        | List all categories   |
| DELETE | `/category/delete/{id}`             | Delete category by id |
| DELETE | `/category/delete`                  | Delete all categories |

### Post
| Method | Endpoint                                              | Description                       |
| ------ | ----------------------------------------------------- | --------------------------------- |
| POST   | `/post/user/{userId}/category/{categoryId}/posts`     | Create post                       |
| PUT    | `/post/update/{postId}`                               | Update post                       |
| GET    | `/post/user/{userId}/posts`                           | Posts by user                     |
| GET    | `/post/category/{categoryId}/posts`                   | Posts by category                 |
| GET    | `/post/getAllPost`                                    | List all posts (paginated/sorted) |
| GET    | `/post/getPost/{postId}`                              | Get post by id                    |
| DELETE | `/post/delete/{postId}`                               | Delete post                       |
| DELETE | `/post/deleteAll`                                     | Delete all posts                  |
| GET    | `/post/posts/{keyword}`                               | Search posts by keyword           |
| POST   | `/post/image/upload/{postId}`                         | Upload post image (`multipart`)   |
| GET    | `/post/profile/{ImageName}`                           | Stream post image                 |

**Pagination query params for `/post/getAllPost`:**
`pageNumber` (default `0`), `pageSize` (default `5`), `sortBy` (default `postId`), `sortDirection` (`ascending` / `descending`).

### Comment
| Method | Endpoint                          | Description     |
| ------ | --------------------------------- | --------------- |
| POST   | `/post/{postId}/comments`         | Add comment     |
| DELETE | `/delete/comment/{commentId}`     | Delete comment  |

### File
| Method | Endpoint                       | Description                 |
| ------ | ------------------------------ | --------------------------- |
| POST   | `/file/upload`                 | Upload image (`multipart`)  |
| GET    | `/file/profile/{ImageName}`    | Stream image                |

---

## Postman Collection

A ready-to-use Postman collection lives at:

```
postman/BlogApplication.postman_collection.json
```

**Import:**
1. Open Postman → **Import** → select the file above.
2. The collection ships with two variables:
   - `baseUrl` — defaults to `http://localhost:8080`
   - `token` — auto-populated by the **Auth → Login (get JWT)** request via a test script.
3. Run **Create User (Register)** first, then **Login**. After login, all other requests will automatically use the saved token via the collection-level Bearer auth.

---

## Sample Payloads

**Register user — `POST /user`**
```json
{
  "name": "arbaz",
  "password": "password123",
  "email": "arbaz@example.com",
  "about": "I love writing blogs about tech"
}
```

**Login — `POST /auth/login`**
```json
{
  "name": "arbaz",
  "password": "password123"
}
```

**Create category — `POST /category/create`**
```json
{
  "categoryTitle": "Technology",
  "categoryDescription": "All posts related to technology"
}
```

**Create post — `POST /post/user/{userId}/category/{categoryId}/posts`**
```json
{
  "title": "My First Blog Post",
  "content": "This is the content of my first blog post."
}
```

**Add comment — `POST /post/{postId}/comments`**
```json
{
  "content": "Nice post!"
}
```

---

## Build

```bash
mvnw.cmd clean package      # Windows
./mvnw clean package        # Linux / macOS
java -jar target/blog-0.0.1-SNAPSHOT.jar
```

---

## Notes

- Uploaded images are stored under the `images/` folder (configurable via `project.image`).
- Database tables are auto-created/updated via `spring.jpa.hibernate.ddl-auto=update`.
- Default user role on registration is `ROLE_USER`. Promote a user to admin via `/access/{userId}/{role}` (requires an existing admin).

---

## Author

Created by **Arbaz** — Blog Application backend on the `badr` branch.
