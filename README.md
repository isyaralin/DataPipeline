# Data Pipeline Monitoring & Anomaly Detection Platform

This is a project I'm building to learn more about **data engineering, backend development, databases, and anomaly detection**.

The idea is to start with a simple transaction dataset and gradually turn it into a complete data pipeline that can process, store, analyze, and detect unusual transactions.

The project is being built step by step, so some of the parts below are planned but haven't been implemented yet.

## Current Pipeline

```text
CSV File
   ↓
Read Data
   ↓
Validate Transactions
   ↓
Filter Invalid Data
   ↓
Transform Data
   ↓
PostgreSQL
   ↓
Analysis
   ↓
Anomaly Detection
```

Right now, the project is at the **validation and transformation stage**.

---

## What I've Done So Far

### CSV Reading

The program reads transactions from a CSV file and converts each row into a `Transaction` object.

Each transaction contains:

* ID
* User ID
* Amount
* Country
* Timestamp

Example:

```csv
id,userId,amount,country,timestamp
1,101,25.50,CZ,2026-09-29T09:15:00
2,102,120.00,DE,2026-09-29T09:20:00
3,103,-50.00,CZ,2026-09-29T09:25:00
4,104,75.30,AT,2026-09-29T09:30:00
5,105,300.00,XX,2026-09-29T09:35:00
```

I'm using Java's `BufferedReader` to read the file and `LocalDateTime` for the timestamps.

---

### Transaction Validation

After reading the transactions, the program checks whether they are valid.

Currently it checks:

* ID is positive
* User ID is positive
* Amount is positive
* Country is a valid two-letter country code
* Timestamp exists

Invalid transactions are not included in the valid transaction list.

---

### Validation Errors

I use an enum to keep track of why a transaction is invalid:

```text
INVALID_ID
INVALID_USER_ID
INVALID_AMOUNT
INVALID_COUNTRY
INVALID_TIMESTAMP
```

This lets the program report how many transactions failed for each reason.

For example:

```text
Total transactions read: 5
Total transactions valid: 3
Total transactions invalid: 2

Total transactions with invalid amount: 1
Total transactions with invalid country: 1
```

---

### Basic Data Transformation

For the valid transactions, the program currently calculates:

* Total transaction amount
* Average transaction amount
* Number of transactions per country

For the current test data:

```text
Total amount: 220.8
Average amount: 73.6

CZ: 1
DE: 1
AT: 1
```

---

## Project Structure

```text
DataPipeline/
├── data/
│   └── transactions.csv
│
├── src/
│   └── com/
│       └── alin/
│           └── datapipeline/
│               ├── Main.java
│               ├── Transaction.java
│               ├── CsvReader.java
│               ├── TransactionValidator.java
│               ├── TransactionTransformer.java
│               └── ValidationError.java
│
└── README.md
```

### Classes

| Class                    | What it does                                  |
| ------------------------ | --------------------------------------------- |
| `Main`                   | Runs the pipeline                             |
| `Transaction`            | Represents a transaction                      |
| `CsvReader`              | Reads transactions from the CSV               |
| `TransactionValidator`   | Checks whether transactions are valid         |
| `ValidationError`        | Defines the possible validation errors        |
| `TransactionTransformer` | Calculates statistics from valid transactions |

---

## How to Run

The CSV file path is passed as a command-line argument.

For example:

```bash
java com.alin.datapipeline.Main data/transactions.csv
```

In IntelliJ IDEA, I use:

```text
Program arguments:
data/transactions.csv
```

---

# What I Want to Build Next

The project is still in development. My plan is to add the following parts gradually.

### 1. PostgreSQL

Next, I want to store the valid transactions in a PostgreSQL database.

I'll work on:

* Creating the database
* Designing the transactions table
* Connecting Java to PostgreSQL using JDBC
* Inserting valid transactions
* Reading the data back from the database
* Using SQL for some of the analysis

The pipeline will then look more like:

```text
CSV
 ↓
Java
 ↓
Validation
 ↓
PostgreSQL
 ↓
SQL Analysis
```

### 2. Pipeline Monitoring

After the database part, I want to add some basic monitoring.

For example:

* Number of transactions processed
* Number of valid/invalid transactions
* Validation error counts
* Processing time
* Database insertion results

### 3. Statistical Analysis

I'll then add more statistics that can be useful for finding unusual transactions.

Some things I want to experiment with:

* Mean
* Standard deviation
* Z-scores
* Transaction frequency
* User-level statistics

### 4. Anomaly Detection

After understanding the statistical approach, I want to add a machine learning component.

The idea is to use Python and scikit-learn for models such as **Isolation Forest**.

Something like:

```text
Java Pipeline
     ↓
PostgreSQL
     ↓
Feature Creation
     ↓
Python ML
     ↓
Anomaly Detection
```

### 5. REST API

Later, I want to add a Spring Boot API so that the processed data and anomaly results can be accessed through endpoints.

### 6. Docker

The final step will be to containerize the different parts of the project using Docker.

---

## Technologies

### Currently

* Java
* Java Collections
* File I/O
* CSV
* Object-Oriented Programming
* `LocalDateTime`

### Planned

* PostgreSQL
* SQL
* JDBC
* Spring Boot
* Python
* scikit-learn
* Docker

---

## Why I'm Building This

I'm using this project to get more comfortable with building something closer to a real data pipeline rather than just working on small programming exercises.

I also want to understand how the different parts fit together:

**data ingestion → validation → storage → analysis → machine learning → API**

