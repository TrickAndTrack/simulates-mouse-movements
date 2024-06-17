# Step 1: Set Up the Spring Boot Project
Configure your project with the following options:
Project: Maven Project
Language: Java
Spring Boot: 3.2.6 (compatible with Java 1.8)
Dependencies: Spring Web (to enable scheduling)
Generate the project and unzip it.
# Step 2: Build and Run the Application
Build the project using Maven:
`mvn clean install`
Run the application:
`mvn spring-boot:run`

Ensure that your system allows java.awt.Robot to control the mouse, as some systems might require additional permissions.

This setup will run a Spring Boot application that moves the mouse, clicks on the current cursor position (which should be on an open Notepad window), and types 100 random words every 2 minutes. 
