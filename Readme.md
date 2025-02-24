# HomeTaskCFG - CSV Processing Project

A Java-based CSV parsing and processing project that reads payments and exchange rates, converts transactions to EUR, and calculates financial metrics.

---

## 📂 Project Structure
Here’s a brief overview of the main directories and files:
- **src/**
    - **main/java/com/deutschebank/task/**:
       - **Main.java:** Main Class where the program will be executed. 
        - **constant/:** Stores constant values. 
            - **AppConstants.java:** Stores global constants (date format, delimiters, table headers).
            - **TableHeaders.java:** Stores CSV column names as constants.
        - **model/:** Defines data models.
            - **Payment.java:** Represents payment transactions.
            - **ExchangeRate.java** Represents exchange rates.
        - **model/:** Defines data models.
            - **Payment.java:** Represents payment transactions.
            - **ExchangeRate.java:**  Represents exchange rates.
      - **parser/:**  Handles CSV file parsing.
           - **CSVFileParser.java:** Parses payments and exchange rates.
      - **service/:**  Contains business logic.
           - **CurrencyConverterService.java:** Converts payments to EUR.
           - **MetricsCalculator.java:** Computes highest, lowest, and outstanding amounts.
- **resources/:** Stores CSV files.
    - **payments.csv**:  Payment transactions dataset.
    - **rates.csv**:  Exchange rates dataset.

## **🚀 How to Install**
### Prerequisites
Ensure the following tools are installed:

| Tool       | Version | Installation Guide |
|------------|---------|--------------------|
| **Java**   | 22      | [Download Java 22](https://jdk.java.net/22/) |
| **Maven**  | Latest  | [Download Maven](https://maven.apache.org/download.cgi) |
| **IDE**    | IntelliJ IDEA or VS Code | [IntelliJ](https://www.jetbrains.com/idea/download/) / [VS Code](https://code.visualstudio.com/) |

### Clone the Repository
```sh
git clone https://github.com/ShaomiRahman/CurrencyConversion.git
```


###  Set Up the Project in IDE
1. Click "Open Project" and select the HomeTaskCFG folder
2. Wait for Maven to resolve dependencies
3. Ensure Java is set in Project SDK (File -> Project Structure -> SDKs)

## How to Run the Project
1. `mvn clean package`
2. Click the play button on Main.java to run the main function
3. In order to play with the data, go to `src -> main -> resources` and change the csv files
