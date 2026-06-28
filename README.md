# Blog Platform

A full-stack Blog Platform built using Spring Boot and React that allows users to create, manage, edit, and publish blog posts.

---

## Features

### Authentication
- JWT Authentication
- User Registration
- User Login
- Protected APIs
- Role-based authorization

### Blog Management
- Create Posts
- Update Posts
- Delete Posts
- Draft Posts
- Publish Posts

### Categories
- Create Categories
- Update Categories
- Delete Categories
- Category Filtering

### Tags
- Create Tags
- Delete Tags
- Tag Filtering

### Additional Features
- Reading Time Calculation
- Search and Filtering
- Responsive UI
- REST APIs

---

# Tech Stack

## Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT Authentication
- PostgreSQL
- Hibernate
- Maven

## Frontend

- React
- TypeScript
- Vite
- Tailwind CSS
- Axios

---

# Project Structure

```
Blog_Platform
│
├── Blog_Backend
│   ├── src
│   ├── pom.xml
│   └── application.properties
│
└── Blog_Frontend
    ├── src
    ├── package.json
    └── vite.config.ts
```

---

# Backend Setup

```bash
cd Blog_Backend
```

Install dependencies:

```bash
mvn clean install
```

Run the application:

```bash
mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

# Frontend Setup

```bash
cd Blog_Frontend
```

Install dependencies:

```bash
npm install
```

Run the development server:

```bash
npm run dev
```

Frontend runs on:

```text
http://localhost:5173
```

---

# API Endpoints

### Authentication

- POST /api/v1/auth/register
- POST /api/v1/auth/login

### Posts

- GET /api/v1/posts
- POST /api/v1/posts
- PUT /api/v1/posts/{id}
- DELETE /api/v1/posts/{id}

### Categories

- GET /api/v1/categories
- POST /api/v1/categories
- PUT /api/v1/categories/{id}
- DELETE /api/v1/categories/{id}

### Tags

- GET /api/v1/tags
- POST /api/v1/tags
- DELETE /api/v1/tags/{id}

---

# Author

Pawan Bhandari

GitHub:
https://github.com/PawanBhandari03

---

# License

This project is developed for educational and portfolio purposes.
