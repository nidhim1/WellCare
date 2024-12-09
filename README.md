[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/6xRviSdT)
# Welcome to the course CSYE6200- Concepts of Object Oriented Design
> Northeastern University, College of Engineering

# Video Link : https://northeastern-my.sharepoint.com/:v:/r/personal/lodh_y_northeastern_edu/Documents/1733768115620258.mov?csf=1&web=1&e=ZFiLMQ&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D

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

## Professor: Daniel Peters

### Requirements
1. Eclipse or VS Code or IntelliJ.

Note: If you are using Eclipse, please have git CLI installed on your system or GitHub Desktop to commit the code in this repository

### SetUp Instructions
1. Please clone the repository on your local system
2. For Eclipse Import the project as Existing Maven Project, For IntelliJ you can directlty open it using 'Get from VCS'.
3. All code should be pushed to the main branch
4. Ensure the GitHub actions are successful post push

Submissions will have deadlines, failed GitHub Actions would result in point deductions.

### References
1. Cloning a Repository: <https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository>
2. Any GitHub Setup: Please refer to the Git & GitHub Fundamentals Repository shared to you by your respective TA and refer the README.md section

Please reach out to your respective TA if you need any help in regards with submission/ GitHub

Author:
- Rohan Vasudev Ginde (ginde.r@northeastern.edu)
- Yesha Joshi (joshi.ye@northeastern.edu)

