## 📘 API Documentation

This project provides a simple REST API to manage books and authors.

### ✅ Swagger Documentation

The full Swagger (OpenAPI 3.0) documentation is available in `swagger.yaml`.

You can view or test it online using:

- Import `swagger.yaml` (available in root folder) to Postman

---

### 📚 Endpoints Overview

#### 🔹 Books

| Method | Endpoint          | Description                |
|--------|-------------------|----------------------------|
| GET    | `/book`           | Get all books (optional title filter) |
| POST   | `/book`           | Create a new book          |
| GET    | `/book/{bookId}`  | Get book detail            |
| PUT    | `/book/{bookId}`  | Update a book              |
| DELETE | `/book/{bookId}`  | Delete a book              |

#### 🔹 Authors

| Method | Endpoint                | Description              |
|--------|-------------------------|--------------------------|
| POST   | `/v1/author`            | Create a new author      |
| GET    | `/author/{authorId}/book` | Get all books by author  |
