# Codsoft_taskno.03
## 💱 Currency Converter

The Currency Converter project allows users to convert an amount in INR (Indian Rupees) to multiple global currencies. It includes using a real-time API for accurate, up-to-date conversions.

---


This enhanced version fetches **live exchange rates** from a public REST API using:

- `HttpURLConnection` for HTTP GET requests  
- `org.json` library for parsing JSON responses  

API used:

```https://api.exchangerate-api.com/v4/latest/INR```


**Features:**
- Real-time currency conversion
- Dynamic exchange rate retrieval
- Graceful error handling (network issues, invalid input, etc.)
- Simple and interactive command-line interface

---

### 🧠 Concepts Learned

| Concept | Used For |
|--------|----------|
| HTTP Networking | Making GET requests to fetch live exchange rates |
| JSON Parsing (`org.json`) | Extracting API response values |
| Loops & Control Flow | Repeated currency conversions |
| Input Validation | Handling incorrect or invalid input |
| Modular Code | Separation of logic and user flow |

---

### 📌 Requirements

| Component | Needed |
|----------|--------|
| Java 8+ | ✔ |
| Internet Connection (API Version Only) | ✔ |
| `json-20250517.jar` or latest `org.json` | Required for API version |

---

### ▶ How to Run

1. Download or clone the repository:
   ```sh
   git clone https://github.com/Ashif2601/Codsoft_taskno.03
