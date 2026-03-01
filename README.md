<div align="center">

  <br>
  <img src="https://icongr.am/feather/bell.svg?size=48&color=A1A1A6" alt="Notification Bell Icon" />

  <h1 style="color: #FFFFFF; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Helvetica, Arial, sans-serif;">
    <b>NOTIFICATION SERVICE</b>
  </h1>
  <p style="color: #A1A1A6;"><i>Event-Driven Microservice for System Alerts & Messaging</i></p>

  <a href="https://github.com/pedroforbeck/notificacao">
    <img src="https://readme-typing-svg.demolab.com?font=-apple-system,BlinkMacSystemFont,San+Francisco,Helvetica+Neue&weight=400&size=14&duration=4000&pause=1000&color=A1A1A6&center=true&vCenter=true&width=600&lines=Event-Driven+Architecture;Asynchronous+Task+Alerts;Decoupled+Messaging+System;Reliable+Delivery+Mechanisms" alt="Typing SVG" />
  </a>

  <br><br>

  <img src="https://img.shields.io/badge/Java_17-1C1C1E?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/Spring_Boot-1C1C1E?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/PostgreSQL-1C1C1E?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL" />

  <br><br>

  <img src="https://img.shields.io/badge/Role-Event%20Listener-1C1C1E?style=for-the-badge&logo=apachekafka&logoColor=white" alt="Role" />
  <img src="https://img.shields.io/badge/Pattern-Asynchronous-1C1C1E?style=for-the-badge&logo=rabbitmq&logoColor=white" alt="Pattern" />
  <img src="https://img.shields.io/badge/Network-Port%208083-1C1C1E?style=for-the-badge&logo=ngrok&logoColor=white" alt="Port" />

</div>

<br><br>

> **Abstract**<br>
> This repository contains the **Notification Service**, an asynchronous event listener within the Task Scheduler ecosystem. Its primary responsibility is to decouple the communication layer from the core domain, reacting to system events (such as task completion or failure) and dispatching alerts to the end users without blocking the main execution threads.

<br>

## <img src="https://icongr.am/feather/layers.svg?size=24&color=A1A1A6" align="absmiddle" /> Table of Contents

- [Service Architecture](#-service-architecture)
- [Core Capabilities](#-core-capabilities)
- [Deployment & Setup](#-deployment--setup)

---

## <img src="https://icongr.am/feather/cpu.svg?size=24&color=A1A1A6" align="absmiddle" /> Service Architecture

By isolating the notification logic, the ecosystem achieves high throughput. The core Task Engine can simply publish an event and immediately move on to the next process, while this service handles the heavier lifting of formatting and network transmission for alerts.

<br>

<details>
<summary><b style="color: #A1A1A6; cursor: pointer;">View Component Topology (Glass/Wireframe Diagram)</b></summary>
<br>

```mermaid
graph LR;
    %% Glassmorphism / Apple Aesthetic Styling
    classDef default fill:none,stroke:#A1A1A6,stroke-width:1px,color:#A1A1A6,rx:8,ry:8;
    classDef highlight fill:none,stroke:#FFFFFF,stroke-width:2px,color:#FFFFFF,rx:12,ry:12;
    classDef db fill:none,stroke:#007AFF,stroke-width:1px,color:#007AFF,rx:4,ry:4;

    %% Nodes
    TaskService[Task Engine\nPort 8082]:::default
    NotifyService{Notification Service\nPort 8083}:::highlight
    DB[(PostgreSQL\nLogs Schema)]:::db
    ClientMobile([Client Devices]):::default

    %% Connections
    TaskService -. "Triggers Async Event\n(Task Completed/Failed)" .-> NotifyService
    NotifyService -- "Dispatches Alert" --> ClientMobile
    NotifyService <--> "Persists Notification History" DB
```
</details>

---

## <img src="https://icongr.am/feather/command.svg?size=24&color=A1A1A6" align="absmiddle" /> Core Capabilities

| Feature | Description |
| :--- | :--- |
| <img src="https://icongr.am/feather/radio.svg?size=18&color=A1A1A6" align="absmiddle" /> **Async Processing** | Prevents thread blocking on the main Task Engine by handling alerts asynchronously. |
| <img src="https://icongr.am/feather/mail.svg?size=18&color=A1A1A6" align="absmiddle" /> **Alert Dispatch** | Formats and sends notifications based on system triggers. |
| <img src="https://icongr.am/feather/database.svg?size=18&color=A1A1A6" align="absmiddle" /> **Audit Logging** | Maintains a historical record of all dispatched notifications in an isolated schema. |
| <img src="https://icongr.am/feather/maximize-2.svg?size=18&color=A1A1A6" align="absmiddle" /> **Scalability** | Can be horizontally scaled independently if the notification queue spikes. |

---

## <img src="https://icongr.am/feather/terminal.svg?size=24&color=A1A1A6" align="absmiddle" /> Deployment & Setup

To run this microservice locally, ensure you have **Java 17+**, **Maven 3.8+**, and **PostgreSQL** installed.

### 1. Database Configuration
Create a dedicated database/schema in your PostgreSQL instance for this service (e.g., `db_notificacao`), ensuring that event logs don't mix with user or task data.

### 2. Environment Variables
Configure your `application.properties` or `application.yml` with your local credentials. The required variables are:

```yaml
# Server Configuration
server.port: 8083

# Database Configuration
spring.datasource.url: jdbc:postgresql://localhost:5432/db_notificacao
spring.datasource.username: your_postgres_user
spring.datasource.password: your_postgres_password
spring.jpa.hibernate.ddl-auto: update

# JWT Validation (Must match the ecosystem secret to accept requests)
api.security.token.secret: your_super_secret_key_here
```

### 3. Build & Execute
Navigate to the project root directory and start the Spring Boot application:

```bash
# Clone the repository
git clone [https://github.com/pedroforbeck/notificacao.git](https://github.com/pedroforbeck/notificacao.git)

# Navigate to the directory
cd notificacao

# Run the application
./mvnw spring-boot:run
```

---

<div align="center">
  <br>
  <p style="color: #A1A1A6;">Architected and maintained by <b><a href="https://github.com/pedroforbeck" style="color: #A1A1A6; text-decoration: none;">Pedro Forbeck</a></b>.</p>
  <p>
    <a href="https://github.com/pedroforbeck">
      <img src="https://img.shields.io/badge/GitHub-1C1C1E?style=flat-square&logo=github&logoColor=white" alt="GitHub" />
    </a>
    <a href="https://www.linkedin.com/in/pedro-forbeck-180a98390/">
      <img src="https://img.shields.io/badge/LinkedIn-1C1C1E?style=flat-square&logo=linkedin&logoColor=white" alt="LinkedIn" />
    </a>
  </p>
</div>
