# Project X Clone - 1/42% of the former Twitter

## Description

This is a partial clone project of the social network **X** (formerly known as Twitter), developed using **Spring Boot**. The goal is to implement basic features of the platform, representing 1/42% of the full social network experience. This project is for educational purposes and serves as a study of system architecture, API design, and module integration.

---

## Planned Features

### Implemented Features (1/42%):
- **Tweet Posting:**
    - Allow users to post short messages ("tweets") up to 280 characters.
- **Timeline Viewing:**
    - Display the most recent tweets from followed users.
- **User Profile Creation:**
    - User registration with name, username, email, and password.

### Future Features:
- Retweets and Likes.
- Follower and Following System.
- Simple Notifications.
- Hashtags and Mentions.

---

## Technologies Used

- **Backend:** Spring Boot (latest version)
- **Database:** PostgreSQL
- **Security:** Spring Security with JWT
- **APIs:** RESTful APIs
- **Testing:** JUnit and Mockito
- **Documentation:** Swagger/OpenAPI

---

## System Requirements

- **Java:** Version 17 or higher
- **Maven:** Version 3.8+
- **PostgreSQL:** Version 13+

---

## Installation and Setup

### 1. Clone the repository:
```bash
$ git clone https://github.com/danisluz/xuitter-api.git
```

### 2. Configure the database:
Create a PostgreSQL database named `x_clone`.
Update the `application.properties` file with your credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/xuitter?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

### 3. Build and run the project:
```bash
$ mvn clean install
$ mvn spring-boot:run
```

### 4. Access the application:
Open your browser and go to: [http://localhost:8080](http://localhost:8080)

---

## Project Structure

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── br.com.xuitter.xuitter_api/
│   │       ├── controllers/
│   │       ├── dtos/
│   │       ├── entities/
│   │       └── repositories/
│   └── resources/
│       ├── db.migration/
│       ├── static/
│       ├── templates/
│       └── application.properties
└── test/
```

---

## Contributions

Contributions are welcome! To collaborate:
1. Fork the repository.
2. Create a branch for your feature (`git checkout -b my-feature`).
3. Submit your PR with a detailed description.

---

## License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## Contact

For questions or suggestions, contact:
- **Name:** Daniel Luz
- **Email:** danisluz@gmail.com
- **LinkedIn:** [https://linkedin.com/in/your-profile](https://www.linkedin.com/in/danisluz/)
