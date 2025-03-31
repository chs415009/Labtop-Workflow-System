# Labtop Workflow System

![Java](https://img.shields.io/badge/Java-Swing-orange)
![Project](https://img.shields.io/badge/Project-Academic-blue)

**Labtop Workflow System** is a Java Swing application developed as an academic project to simulate and manage the workflow of a laptop production process. The system demonstrates the implementation of user interfaces, database connectivity, and business logic in a desktop application environment.

## 📋 Project Overview

This workflow management simulation enables users to:

- Track laptop production steps from design to delivery
- Manage different departments' roles in the production process
- Monitor quality control checkpoints
- Visualize production timelines
- Generate reports on production status

## 🚀 Key Features

### 01. Process Management
- **Centralized Dashboard**: Interface for monitoring all production stages
- **Status Tracking**: Updates on production progress
- **Task Assignment**: Assign responsibilities to departments

<p align="center">
  <img src="./bin/slide2.png" width="700" alt="Process Management Interface">
</p>

### 02. System Architecture

- **UML Class Diagram**: Illustrates the object-oriented design and class relationships of the entire system
- **Workflow Design**: Shows work request relationships between different departments and organizations
- **Data Model**: Demonstrates how data is structured and related throughout the system

The diagram displays:
- Relationships between different enterprise entities (Advertising, Retail, Delivery, Manufacturing, etc.)
- WorkQueue connections between various departments
- How different types of WorkRequests flow through the system

This architecture enables the system to track the complete lifecycle of laptop production and coordinate workflows across departments.

<p align="center">
  <img src="./bin/slide4.png" width="700" alt="Model Configuration Panel">
</p>

### 03. Additional Features
- **Basic Reporting**: Generate status reports
- **Quality Control Checkpoints**: Track testing results
- **Process Visualization**: View production flow

<p align="center">
  <img src="./bin/slide6.png" width="700" alt="Advanced Features">
</p>

## 🔍 System Design

The project implements a modular design with simulated department interactions:

<p align="center">
  <img src="./bin/slide5.png" width="700" alt="System Architecture Diagram">
</p>

### Simulated Departments:

#### Design Department
- Creates laptop designs
- Sets specifications
- Initiates production workflow

#### Material Manufacturing
- Tracks component selection
- Simulates material quality control

#### Production Line
- Manages assembly process simulation
- Tracks build progress

#### Quality Assurance
- Simulates testing procedures
- Approves or rejects completed units

#### Delivery
- Simulates shipment preparation
- Tracks delivery information

## 💻 Implementation Details

- **Technology**: Java Swing for desktop application UI
- **Database**: Local database for data persistence
- **Project Scope**: Academic demonstration of software design principles

## 📥 Installation & Setup

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE

### Installation Steps
1. Clone the repository:
   ```
   git clone https://github.com/chs415009/Labtop-Workflow-System.git
   ```
2. Open the project in NetBeans IDE
3. Build and run the application

## 👨‍💻 Learning Outcomes

This academic project demonstrates proficiency in:

- Java Swing UI development
- Object-oriented programming principles
- Database interaction from a desktop application
- Workflow management concepts
- Software design patterns

## 🎓 Academic Context

This project was developed as part of a Application Engineer & Development course at Northeastern University. The assignment focused on applying software engineering principles to create a workflow management system with a graphical user interface.

---

**Labtop Workflow System** - A Java Swing academic project demonstrating workflow management concepts.
