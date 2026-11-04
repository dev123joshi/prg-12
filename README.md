
## 1. Aim

To develop an Android application that accesses web services using HTTP requests and retrieves data from an online API.

## 2. Introduction

Web services allow Android applications to communicate with remote servers and exchange data through the internet.

HTTP (Hypertext Transfer Protocol) is used for communication between clients and servers.

In this experiment, a Weather Information application is developed using Kotlin. The application sends an HTTP GET request to the Open-Meteo Weather API and retrieves weather information in JSON format.

## 3. Objectives

- To understand HTTP requests in Android.
- To access online web services.
- To send HTTP GET requests.
- To receive JSON responses from an API.
- To parse JSON data using JSONObject.
- To display retrieved information in an Android application.

## 4. Software Requirements

| Requirement | Description |
|---|---|
| IDE | Android Studio |
| Language | Kotlin |
| UI Design | XML |
| API | Open-Meteo Weather API |
| Protocol | HTTP / HTTPS |
| Device | Android Emulator / Android Phone |
| Internet | Required |

## 5. Project Folder Structure

```text
HTTPWebService/
│
├── app/
│   └── src/main/
│       ├── java/com/example/httpwebservice/
│       │   └── MainActivity.kt
│       │
│       ├── res/layout/
│       │   └── activity_main.xml
│       │
│       └── AndroidManifest.xml
│
├── screenshots/
│   ├── home.png
│   ├── weather_data.png
│   └── error.png
│
└── README.md
```

## 6. Concept Used

### HTTP Request

HTTP requests allow applications to communicate with web servers and retrieve information.

### HTTP GET Method

The GET method is used to request data from a web server.

### JSON

JSON (JavaScript Object Notation) is a lightweight format used to exchange data between applications and servers.

### HttpURLConnection

HttpURLConnection is used to establish an HTTP connection and send requests to the API.

### JSONObject

JSONObject is used to parse and extract information from the JSON response.

## 7. API Used

**API Name:** Open-Meteo Weather API

**API URL:**

https://api.open-meteo.com/v1/forecast?latitude=12.9716&longitude=77.5946&current=temperature_2m,relative_humidity_2m,apparent_temperature,wind_speed_10m

The API provides:
- Temperature
- Relative Humidity
- Apparent Temperature
- Wind Speed

## 8. Implementation

1. Create an Android Studio project using Kotlin.
2. Add INTERNET permission in AndroidManifest.xml.
3. Design the user interface using XML.
4. Create an HTTP connection using HttpURLConnection.
5. Send an HTTP GET request.
6. Receive the JSON response from the API.
7. Parse the JSON response using JSONObject.
8. Display the weather information in the application.

## 9. Output Screenshots

###
<img width="1866" height="952" alt="image" src="https://github.com/user-attachments/assets/042e2d35-bcca-4ea4-add9-66c200fa3363" />


## 10. Test Cases

| Test Case | Input / Action | Expected Output |
|---|---|---|
| 1 | Click Fetch Weather Data | Weather information displayed |
| 2 | Receive successful API response | HTTP 200 response |
| 3 | Disable internet connection | Error message displayed |

## 11. Advantages

- Provides real-time access to web services.
- Retrieves information from remote servers.
- Supports JSON data exchange.
- Reduces the need to store all information locally.
- Useful for developing internet-based Android applications.

## 12. Result

The Android application was successfully developed using Kotlin to access web services through HTTP GET requests. Weather information was retrieved from the Open-Meteo API, parsed using JSONObject and displayed in the application.

## 13. Conclusion

This experiment helped us understand how Android applications communicate with web services using HTTP requests. We learned how to establish a connection, send GET requests, receive JSON responses and display the retrieved data.

## 14. GitHub Repository

**Repository Name:** HTTPWebService

**GitHub Link:** https://github.com/YOUR-USERNAME/HTTPWebService

---

**End of Experiment**
