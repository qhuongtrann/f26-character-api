# Ghibli Character API

A Spring Boot REST API for managing and querying characters from various Ghibli universes, connected to a PostgreSQL database.

## Entity Attributes
* **characterId** (Long): Primary key, auto-generated.
* **name** (String): Name of the character (NotBlank validation).
* **universe** (String): Movie or universe source (NotBlank validation).
* **role** (String): Character role (e.g., Protagonist, Supporting).
* **imageUrl** (String): Link to character image artwork.
* **description** (String): Character description or biography (NotBlank validation).
* **activeDate** (LocalDate): Date the character was introduced.

## API Endpoints Reference

| HTTP Method | Endpoint | Description |
| :--- | :--- | :--- |
| **GET** | `/api/characters` | Retrieve all characters (supports optional query parameters `name` and `universe`) |
| **GET** | `/api/characters/{id}` | Retrieve a specific character by ID |
| **POST** | `/api/characters` | Create a new character |
| **PUT** | `/api/characters/{id}` | Update an existing character |
| **DELETE** | `/api/characters/{id}` | Delete a character by ID |
| **GET** | `/api/characters/pulse` | Health check endpoint |

## Deployed Application
* **Render API URL:** `https://your-render-app-url.onrender.com`