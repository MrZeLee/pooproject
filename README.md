# POOProject: Delivery Management System

## Overview

This project is a Delivery Management System developed as part of a 3rd-year university course focused on Object-Oriented Programming (OOP). It simulates the core functionalities of a delivery service, connecting users, stores, transporters, and volunteers to facilitate efficient and reliable package delivery.

## Features

- **User Management:**
  - Registration and login for users, stores, transporters, and volunteers.
  - Secure password handling.
- **Location Services:**
  - Utilizes geographical coordinates to determine proximity between entities.
  - Calculates distances for delivery cost estimations.
- **Order Management:**
  - Users can create and manage delivery requests.
  - Stores can manage their order queues.
  - Order information includes product details, weight, and destination.
- **Delivery Assignment:**
  - Automatic or manual assignment of deliveries to available transporters or volunteers.
  - Considers location, availability, and other relevant factors.
- **Real-Time Tracking:** (Planned Feature - Not Implemented)
  - Monitor the status and location of deliveries.
- **Payment Processing:** (Planned Feature - Not Implemented)
  - Securely process payments for delivery services.
- **Rating and Reviews:**
  - Users can rate and review completed deliveries.
- **Statistics and Reporting:**
  - Generation of reports on delivery performance.
  - Top 10 users and transporters.
- **Data Persistence:**
  - The system state is saved using serialization for persistence.
- **GUI with MVC:**
  - The system is presented in a GUI using the MVC model.
- **Log Parsing:**
  - The system parses a log file to create objects at the start.

## Technologies Used

- **Java:** The primary programming language.
- **Swing:** Used for creating the graphical user interface (GUI).
- **Object-Oriented Programming (OOP):** Core design paradigm.
- **Data Structures:** Utilizes `TreeMap`, `TreeSet`, `ArrayList`, and more for efficient data management.
- **Serialization:** Used for object persistence, allowing the system state to be saved and restored.
- **File I/O:** Used for reading initial configurations from log files.

## Project Structure

The project is organized using the Model-View-Controller (MVC) architectural pattern:

- **`src/Base/Basic/`:**  Basic classes such as `Coordenadas` (coordinates) and `Pair` (generic pair class).
- **`src/Base/Encomenda/`:** Classes related to orders, like `Encomenda` (order), `LinhaEncomenda` (order line), and `Aceite` (acceptance).
- **`src/MVC/`:** Contains the MVC components:
    - **`Controller/`:** Handles user input and updates the model.
    - **`Model/`:** Manages the application data and business logic.
    - **`Observer/`:** Implements the Observer pattern for UI updates.
    - **`View/`:**  Presents the data to the user through the GUI.
- **`src/Parser/`:** Classes responsible for parsing data from log files to initialize the system.
- **`src/Users/`:**  Classes representing different types of users: `Loja` (store), `Transportadora` (transporter), `Utilizador` (user), and `Voluntario` (volunteer).
- **`src/Main.java`:**  The entry point of the application.

## Class Diagram
The class diagram of this project can be found on `diagrama.png`

## Usage

1.  **Clone the repository:**

    ```bash
    git clone [repository_url]
    ```

2.  **Compile the Java code:**

    ```bash
    javac src/*.java src/Base/Basic/*.java src/Base/Encomenda/*.java src/MVC/Controller/*.java src/MVC/Controller/Menu/*.java src/MVC/Model/*.java src/MVC/Observer/*.java src/MVC/View/*.java src/Parser/*.java src/Users/*.java
    ```

3.  **Run the application:**

    ```bash
    java Main [optional_log_file]
    ```

    - Replace `[optional_log_file]` with the path to a log file (e.g., `logs.txt`) if you want to initialize the system with data from the log file.  If no log file specified, the system will load `save.dat` or start with an empty state.
