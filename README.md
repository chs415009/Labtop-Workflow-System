# Labtop Workflow System

![Java](https://img.shields.io/badge/Java-Swing-orange)
![Project](https://img.shields.io/badge/Project-Academic-blue)

**Labtop Workflow System** is a Java Swing application developed as an academic project to simulate and manage the workflow of a laptop production process. The system demonstrates the implementation of user interfaces and business logic in a desktop application environment.

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

### Network Structure:

#### Technology Product Enterprise
- Product Management Organization
- Research And Development Organization
- Purchasing Organization
- Marketing Organization

#### Manufacturing Enterprise
- Manufacturing Manager 
- Production Line Organization

#### Delivery Enterprise
- Delivery Manager 
- Deliver Organization

#### Retail Enterprise
- Retail Sales Organization

#### Advertising Enterprise
- Plannar Organization
- Digital Strategy Organization

## 👥 Roles & Organizations Matrix

The Labtop Workflow System implements a complex organizational structure with specific roles assigned to each department. Below is a comprehensive mapping of all roles and their corresponding organizations, along with their primary responsibilities in the workflow:

### Role-Department Relationships

| Enterprise | Organization | Role | Primary Responsibilities |
|------------|--------------|------|--------------------------|
| **Technology Product** | Product Management | Product Manager | • Creates initial WorkRequests<br>• Verifies completed development work<br>• Verifies marketing campaign results |
| **Technology Product** | Research & Development | RD Role | • Updates development status<br>• Provides technical feedback<br>• Marks development as completed |
| **Technology Product** | Purchasing | Purchase Manager | • Creates PurchaseWorkRequests<br>• Approves manufacturing price quotes<br>• Verifies completed production |
| **Technology Product** | Marketing | Marketing Manager | • Creates MarketingWorkRequests<br>• Sets marketing budgets<br>• Evaluates advertising performance |
| **Manufacturing** | Manufacturing Manager | Manufacturing Manager | • Provides production price quotes<br>• Signs shipping agreements<br>• Creates DeliveryWorkRequests |
| **Manufacturing** | Production Line | Manufacturing Worker | • Updates production status<br>• Tracks manufactured quantities<br>• Reports manufacturing completion |
| **Delivery** | Delivery Manager | Delivery Manager | • Sets shipping prices<br>• Allocates delivery resources<br>• Manages delivery logistics |
| **Delivery** | Deliver | Delivery Role | • Updates shipping status<br>• Handles physical deliveries<br>• Reports completed deliveries |
| **Retail** | Retail Sales | Retail Manager | • Confirms receipt of products<br>• Initiates marketing workflows<br>• Manages retail inventory |
| **Advertising** | Planner | Advertising Manager | • Reviews marketing requests<br>• Signs or rejects campaigns<br>• Allocates advertising resources |
| **Advertising** | Digital Strategy | Digital Ads Strategist | • Executes marketing campaigns<br>• Tracks budget utilization<br>• Reports on campaign performance |

### WorkRequest Flow & Role Interactions

The system orchestrates complex interactions between these roles through specialized WorkRequest objects:

1. **DevelopmentWorkRequest Flow**:
   - Created by: Product Manager
   - Processed by: RD Role
   - Verified by: Product Manager

2. **PurchaseWorkRequest Flow**:
   - Created by: Purchase Manager
   - Price quoted by: Manufacturing Manager
   - Signed by: Purchase Manager
   - Executed by: Manufacturing Worker
   - Verified by: Purchase Manager

3. **DeliveryWorkRequest Flow**:
   - Created by: Manufacturing Manager
   - Price quoted by: Delivery Manager
   - Signed by: Manufacturing Manager
   - Executed by: Delivery Role
   - Confirmed by: Retail Manager

4. **MarketingWorkRequest Flow**:
   - Created by: Marketing Manager
   - Signed by: Advertising Manager
   - Executed by: Digital Ads Strategist
   - Verified by: Marketing Manager

This interdependent role structure ensures proper handoffs between departments and maintains accountability throughout the laptop production lifecycle.


## 💻 Implementation Details

- **Technology**: 
  - Java Swing for desktop application UI
  - Object-oriented design pattern

- **Frontend Development**:
  - Custom UI components for intuitive user interaction
  - Event-driven interface design
  - Responsive layout management

- **Backend Framework**:
  - Business logic layer implemented using Java classes
  - Inheritance and polymorphism for flexible workflow systems
  - Observer pattern for inter-departmental communication

- **Project Scope**: 
  - Academic demonstration of software design principles
  - Simulation of real-world enterprise workflow systems


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
