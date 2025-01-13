# WellCare

> Hospitals today face increasing challenges in managing their operations efficiently due to growing
patient demands, fragmented workflows, and reliance on manual processes. Issues such as inefficient
appointment scheduling, lack of centralized medical records, and inadequate staff and resource
management contribute to delays, errors, and diminished patient experiences. One critical improvement
is displaying billing information directly on the Patients Tab, enabling patients to stay informed about
their expenses, reducing confusion, and fostering transparency. This not only enhances communication
but also builds trust between patients and healthcare providers. Moreover, hospitals often struggle to
engage patients with timely notifications for appointments, test results, and follow-ups, further
impacting care quality. The WellCare - Hospital Management System addresses these challenges by
offering a comprehensive platform to streamline scheduling, centralize patient data, and improve patient
engagement. By integrating modern technologies, it aims to enhance operational efficiency, optimize
resource utilization, and ultimately elevate the quality of patient care.

---

## Tech Stack:
**Frontend**:
  * Thymeleaf, HTML, CSS, JavaScript, Bootstrap
**Backend**:
  * Java, Spring Boot, Spring MVC, Spring Data JPA
  * APIs
**Database**:
  * MySQL
  * WampServer (for data schema visualization and management)
**DevOps & Tools**:
  * Git (version control), GitHub (repository hosting)
  * Maven (build automation)
  * Bruno (API testing)
**Security**:
  * Spring Security, JWT (for authentication and session handling)
**IDE**:
  * IntelliJ IDEA (for Java development and project management)

---

## How to Build and Run the Project

### Prerequisites
1. Java JDK 17 or later installed.
2. Maven installed or use the provided Maven wrapper (`mvnw`).
3. MySQL Server installed and running.

---

## Steps to Set Up MySQL

1. **Install MySQL**:
   Download and install MySQL Server from [https://dev.mysql.com/downloads/](https://dev.mysql.com/downloads/).

2. **Create a Database**:
   Log into your MySQL server and create a database for the application: (import database from document directory.)
   ```sql
   CREATE DATABASE <database_name>;

3. **Set Up Application Properties**:
   Update the `application.properties` file in the `src/main/resources` directory with your MySQL database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
   spring.datasource.username=<your_username>
   spring.datasource.password=<your_password>
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.hibernate.ddl-auto=update

4. **Build the project**:
    ```bash
   ./mvnw clean install


5. **Run the project:**
    ```bash
    ./mvnw spring-boot:run

6. **Package the project**
    ```bash
   ./mvnw package
7. **Run the packaged JAR**
    ```bash
   java -jar target/<artifact-name>.jar
