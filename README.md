
# School Management System (OOP, Java Swing)

A desktop-based School Management System built using Java Swing to simulate real-world academic operations such as student enrollment, course creation, and teacher assignment, using OOP principles.

## Overview

This application provides a graphical interface for managing core school entities including students, teachers, and courses. It demonstrates object-oriented design and event-driven programming through a functional GUI.

## Features

### Core Functionalities

* Add new students with ID and semester
* Add teachers with subject specialization
* Create courses and assign teachers
* Enroll students into courses
* View detailed student information including enrolled courses

### User Interface

* Interactive GUI built with Java Swing
* Button-based navigation for different operations
* Dialog boxes for input and feedback
* Dropdown selections for linking students, teachers, and courses

## System Design

The system is structured around key object-oriented entities:

* **Person (Base Class)**

  * Shared attributes: name

* **Student**

  * Inherits from Person
  * Stores student ID and enrolled courses
  * Supports course enrollment

* **Teacher**

  * Inherits from Person
  * Includes subject specialization

* **Course**

  * Contains course name and assigned teacher

This design models real-world relationships between students, teachers, and courses.

## Technologies Used

* Java
* Java Swing (GUI)
* Object-Oriented Programming (OOP)

## How to Run

1. Compile all Java files:

   ```
   javac School.java
   ```

2. Run the application:

   ```
   java School
   ```

> Make sure all image files (icons/splash screen) are in the correct directory or update their paths accordingly.

## Sample Output

(Add screenshots here)

Suggested screenshots:

* Main menu interface
* Add student window
* Course creation screen
* Student information display

## Key Learning Outcomes

* Applied OOP concepts such as inheritance and encapsulation
* Built a GUI-based application using Java Swing
* Managed relationships between multiple entities
* Implemented event-driven programming using action listeners

## Limitations

* Data is stored in memory (no database integration)
* No persistent storage after application closes
* Basic input validation

## Future Improvements

* Integrate database (MySQL or file storage)
* Add update/delete functionality
* Improve UI design and layout
* Add authentication system
* Enhance validation and error handling

## Purpose

This project was developed to practice designing and implementing real-world systems using object-oriented principles and Java GUI development.
