# Machine Translation API Service

Welcome to the **Machine Translation API Service**! This Spring Boot project is designed to serve as an adapter service that exposes a robust API for machine translation. Our primary goal is to reduce translation costs by validating and sanitizing requests before they are sent to a third-party machine translation service. 

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## Introduction

Our Machine Translation API Service acts as an intermediary layer that ensures only valid and sanitized requests reach the third-party translation service, thereby optimizing costs and improving translation quality and data privacy.

## Features

- **Request Validation**: Ensure all translation requests meet predefined criteria before processing.
- **Request Sanitization**: Clean and format requests to prevent errors and improve translation accuracy.
- **Cost Efficiency**: Reduce the number of unnecessary or invalid translation requests, saving on third-party service costs.
- **Scalability**: Built with Spring Boot to handle high volumes of translation requests efficiently.
- **Extensibility**: Easily integrate with various third-party translation services.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/machine-translation-api-service.git
   cd machine-translation-api-service

2. **Build the project**

```bash
mvn clean install

```
3. **Run the application**

```bash
mvn spring-boot:run
```

## Usage
Once the application is up and running, you can access the API at http://localhost:8080. Use any API client (like Postman) to interact with the endpoints.

## API Endpoints
- POST /translate
    - Description: Translate text from one language to another.
    - Request Body:
```json
{
  "sourceLanguage": "en",
  "targetLanguage": "es",
  "text": "Hello, world!"
}
```
    - Response:
```json
{
  "translatedText": "¡Hola, mundo!"
}
```
- GET /languages
    - Description: Get a list of supported languages.
    - Response:
```json
[
  "en",
  "es",
  "fr",
  "de",
  "zh"
]
```

## Contributing ##
We welcome contributions to enhance the Machine Translation API Service. To contribute, please follow these steps:

Fork the repository.
- Create a new branch (git checkout -b feature-branch).
- Commit your changes (git commit -m 'Add new feature').
- Push to the branch (git push origin feature-branch).
- Open a Pull Request.

## Authors

- [Tomislav Krstić](https://github.com/Tomaks23)
- [Miloš Ilić](https://github.com/misa998)

## Documentation

[Documentation](https://github.com/Tomaks23/Machine-Translaton-Service/blob/master/Documentation/Machine%20Translation%20Service.docx)
