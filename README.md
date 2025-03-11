# Digital Banking System

## Overview
The Digital Banking System is a Java-based application that simulates a banking environment, allowing users to manage their accounts, perform transactions, and view their financial activities. The system supports two types of accounts: Current Account and Savings Account, each with its own unique features.

## Features
- **Account Types**:
  - **Current Account**: Allows deposits, withdrawals, transfers, and includes an overdraft limit.
  - **Savings Account**: Allows deposits, withdrawals, transfers, and accumulates monthly interest.

- **Functionalities**:
  - Deposit funds into accounts.
  - Withdraw funds while respecting account balance and limits.
  - Transfer funds between accounts within the same bank.
  - Check current account balance.
  - View transaction history (statement).

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Apache Maven

### Installation
1. Clone the repository:
   ```
   git clone https://github.com/yourusername/digital-banking-system.git
   ```
2. Navigate to the project directory:
   ```
   cd digital-banking-system
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```

### Running the Application
To run the application, execute the following command:
```
mvn exec:java -Dexec.mainClass="com.bank.App"
```

## Usage
Once the application is running, you will be presented with an interactive menu. Follow the prompts to perform various banking operations such as creating accounts, making deposits, withdrawals, and transfers.

## Contributing
Contributions are welcome! Please feel free to submit a pull request or open an issue for any suggestions or improvements.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.