# AI Resume Analyzer

An AI-powered Resume Analysis Platform built using Java Spring Boot, React.js, MySQL, and Gemini API. The application helps users analyze resumes, calculate ATS scores, identify missing skills, generate professional summaries, and compare resumes with job descriptions.

## Features

- User Registration & Login with JWT Authentication
- Resume Upload and Management
- ATS Score Analysis
- Skill Gap Identification
- Job Description Matching
- AI-Generated Resume Summary
- Resume Improvement Suggestions
- Secure REST APIs
- Responsive User Interface

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT Authentication
- Maven

### Frontend
- React.js
- HTML
- CSS
- JavaScript

### Database
- MySQL

### AI Integration
- Google Gemini API

### Tools
- Git
- GitHub
- Postman
- IntelliJ IDEA
- VS Code

## System Architecture

User → React Frontend → Spring Boot REST APIs → MySQL Database

                                     ↓

                               Gemini API

## Key Functionalities

### Authentication
- User Registration
- User Login
- JWT Token Generation
- Secure API Access

### Resume Analysis
- Upload Resume
- Extract Resume Information
- Generate ATS Score
- Identify Missing Skills
- Compare Resume with Job Description
- Generate AI-Based Recommendations

### Dashboard
- View Analysis Results
- Track ATS Scores
- Review Improvement Suggestions

## Project Structure

```
AI-Resume-Analyzer
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── security
│   └── config
│
├── frontend
│   ├── components
│   ├── pages
│   ├── services
│   └── assets
│
└── database
```

## API Endpoints

### Authentication

| Method | Endpoint |
|----------|----------|
| POST | /api/auth/register |
| POST | /api/auth/login |

### Resume

| Method | Endpoint |
|----------|----------|
| POST | /api/resume/upload |
| GET | /api/resume/analyze/{id} |
| GET | /api/resume/result/{id} |

## Installation

### Clone Repository

```bash
git clone https://github.com/yourusername/ai-resume-analyzer.git
```

### Backend Setup

```bash
cd backend

mvn clean install

mvn spring-boot:run
```

### Frontend Setup

```bash
cd frontend

npm install

npm start
```

### Database Configuration

Update the application.properties file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/resume_analyzer
spring.datasource.username=root
spring.datasource.password=your_password
```

### Gemini API Configuration

Add your Gemini API Key:

```properties
gemini.api.key=YOUR_API_KEY
```

## Future Enhancements

- Resume PDF Generation
- Multiple Resume Versions
- Interview Question Generation
- Job Recommendation System
- Resume Ranking System
- Email Reports

## Learning Outcomes

Through this project, I gained practical experience in:

- Spring Boot Development
- REST API Design
- JWT Authentication
- Spring Security
- React.js Frontend Development
- MySQL Database Design
- AI Integration using Gemini API
- Git & GitHub Version Control

## Author

**Farman Gour**
