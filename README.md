# Educational Management System

## Overview
This project is an object-oriented educational management system designed to handle the educational journey of students. It manages departments, study programs, teachers, modules, students, and grades, ensuring a structured and comprehensive tracking of academic progress.

## Objectives
- Develop a system to manage students' educational paths.
- Handle departments, study programs, teachers, modules, students, and grades.
- Facilitate profile management for teachers and students.
- Allow teachers to manage multiple modules and associate with a single department.
- Enable students to enroll in study programs and track their grades per module.

## Phases of Development
The project is divided into four main phases:
1. Creation of a console application fulfilling all specified requirements.
2. Management of data persistence through file handling.
3. Transition from file-based data management to a SQL database.
4. Development of a user interface using JavaFX for enhanced user interaction.

## Key Features
- Extensible and flexible program development.
- Solid code structure with clean coding practices.
- Streamlined processes for development, testing, and deployment.
- Implementation of various object relationships (One To One, One To Many, Many To One, Many To Many).

## Class Descriptions
- **Department**: Manages department details and responsible teacher.
- **Study Program (Filiere)**: Manages program details and associated department.
- **Teacher (Enseignant)**: Manages teacher profiles and their associated modules and department.
- **Module**: Manages module details, responsible teacher, and associated study program.
- **Student (Etudiant)**: Manages student profiles, enrolled study program, and grades.
- **Note (Note)**: Manages notes 

## Installation and Setup

Follow these steps to get the Educational Management System up and running on your local machine.

### Prerequisites

- Ensure you have Java JDK 11 or above installed on your system.
- Install MySQL for the database, or have access to an existing MySQL server.
- Git should be installed to clone the repository.

### Clone the Repository

To clone the project repository, open a terminal and run:

```bash

git clone https://github.com/yourusername/educational-management-system.git
cd educational-management-system
```
## Database Setup

The application utilizes MySQL, managed through XAMPP and MySQL Workbench, for database interactions.

1. Start XAMPP and ensure the MySQL service is active.
2. Open MySQL Workbench and establish a connection to your local MySQL server.
3. Create a new schema named `gestionsysedu` by executing the SQL statement:

   ```sql
   CREATE SCHEMA `gestionsysedu`;
    ```

1. Use MySQL Workbench to design your database schema or import it from a pre-existing SQL file.
2. Apply the changes to set up the database on your MySQL server.

## JDBC Connector Setup

To connect to the MySQL database, the application requires the MySQL JDBC driver.

1. Download the MySQL JDBC driver, which is available as a .jar file from the MySQL website.
2. Place the downloaded .jar file into the lib directory of your project.
3. Ensure that your project's classpath includes the JDBC driver. If using an IDE like IntelliJ IDEA, you can add the .jar file to your project's libraries.

## Configuration
Before running the application, configure it to connect to your MySQL database:

1. In the src directory of your project, locate the configuration file, typically named config.properties or database.properties.

2. Edit the file to include your MySQL database details:

```
db.url=jdbc:mysql://localhost:3306/gestionsysedu
db.user=yourUsername  # Default is 'root' if you haven't set a custom username
db.password=yourPassword  # The password you've set for MySQL in XAMPP, leave blank if none
```
3. Save the file with the new configuration settings.

## Compile and Run the Application

1. Open a terminal or command prompt.

2. Navigate to the root directory of your project.

3. Compile the Java application using the following command, replacing <path-to-jdbc-driver> with the actual path to the JDBC .jar file:

```
javac -cp ".:<path-to-jdbc-driver>" lst/tpjava/models/*.java lst/tpjava/controllers/*.java
```
4. Run the compiled application:

```
java -cp ".:<path-to-jdbc-driver>" lst.tpjava.main.Main
```
Replace <path-to-jdbc-driver> with the actual path to the JDBC .jar file, and adjust the classpath as necessary.

### Usage
After installation and setup, you can use the application through the console interface by executing the Main class. Follow the on-screen prompts to interact with the system.

```
Replace placeholders like `yourUsername` and `yourPassword` with the actual MySQL username and password you've set up in XAMPP.
```


## Contributions
Contributions to this project are welcome. Please follow these guidelines:
- Fork the repository and create a new branch for your feature.
- Write clear commit messages and include comments in your code.
- Open a pull request with a detailed description of your changes.



## Contact
- **Developer**: Hanane mazyan
- **Email**: hananemzn16@gmail.com
- **LinkedIn/GitHub**: [hanane mazyan /hananemazyan]

## Acknowledgments

This project has been influenced and supported by several external resources and guidance:

- The insights provided by Mohamed Ennaji on creating the first console application have been particularly valuable. [Jumpstarting Java: Creating Your First Console Application](https://medium.com/@mohamed.enn/jumpstarting-java-creating-your-first-console-application-27f3fc5a6459).
- JavaTpoint's resources on the Java Console class were instrumental in understanding and implementing console I/O in Java. [Java Console Class Tutorial](https://www.javatpoint.com/java-console-class).
- OpenAI's ChatGPT was instrumental in resolving issues related to the path and installation process. Its conversational assistance helped troubleshoot and streamline the setup.
- IBM's Informix documentation provided foundational knowledge on database operations and connectivity. [Getting Started with IBM Informix](https://www.ibm.com/docs/en/informix-servers/12.10?topic=ijdg-getting-started).

A special thanks to these resources for their support and valuable information that have contributed to the development of this application.
