# 🚀 Employee Management System

This Employee Management System is a full-stack web application built using **Spring Boot**, **Thymeleaf**, and **MySQL**.  
It offers a clean, intuitive interface for managing employee records and job roles efficiently.  
Designed as a modular component for larger systems, it’s ideal for organizations looking to simplify staff administration.

---

## ✨ Features

- ➕ Create, 🕵️ View, 📝 Edit, and ❌ Delete employee profiles  
- 👤 Assign roles to employees with full CRUD operations on roles  
- 🔍 Search and filter employees by **name** or **role**  
- 📞 Display and manage employee contact info, 💰 salary, and 📅 joining date  
- 🖥️ User-friendly layout with organized tables and forms  
- ⏰ Dynamic date/time header on the main page  
- 🧠 Auto-generated schema using **Spring JPA** and **Lombok**

---

## 🛠 Tech Stack
--------------------------------------------------------
| Layer     | Technology                               |
|-----------|------------------------------------------|
| Backend   | Spring Boot, Spring MVC, Spring Data JPA |
| Frontend  | Thymeleaf, HTML5, CSS                    |
| Database  | MySQL                                    |
| Build Tool| Maven                                    |
| Utility   | Lombok, Validation API                   |
| Optional  | Spring Boot DevTools                     |
--------------------------------------------------------

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/employee-management-system.git
cd employee-management-system
```

2️⃣ **Set Up the Database**
-> Ensure MySQL is running and create a new database:
CREATE DATABASE employee_db;

-> Update your database credentials in src/main/resources/application.properties:
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

3️⃣ **Build and Run the Project**
-> Use the Maven wrapper to run the project:
./mvnw spring-boot:run
-> Or run EmployeeManagementApplication.java directly from your IDE.

4️⃣ **Access the Application**
-> Once the app is running, open your browser and go to:
```
👉 http://localhost:8080/employees
```
From there, you can create, view, and manage employees and roles through an intuitive interface.

📁 **Project Structure Overview**
- `src/main/java/com/yourdomain/employeemanagement/`
  - `controller/`
  - `entity/`
  - `repository/`
  - `service/`
  - `EmployeeManagementApplication.java`

- `src/main/resources/`
  - `templates/`
    - `index.html`
    - `employee_form.html`
    - `role_form.html`
  - `static/css/`
  - `application.properties`
  
🙏 **Acknowledgements**
Thanks to Spring Boot, Thymeleaf, and the open-source community for their powerful, elegant tools.
And thank you for checking out this project — hope it proves useful! 🎉
