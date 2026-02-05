## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

# Warehouse Management System (WMS)

This project is developed as part of the COM5043 Object Oriented Programming module at Buckinghamshire New University. It addresses real-world warehouse challenges through a modular, object-oriented system focused on inventory tracking, order processing, supplier management, and financial reporting.

## Features

### 1. Inventory Management
- Track products by ID, name, quantity, and price.
- Add, remove, and update stock levels.
- Alert for low-stock products.

### 2. Supplier Management
- Maintain supplier records (ID and name).
- Add, update, and remove suppliers.

### 3. Order Processing
- Process customer orders for in-stock products.
- Automatically updates inventory levels.
- Records all processed orders.

### 4. Financial Reporting
- Calculates:
  - Total sales
  - Total purchase costs
  - Net income (profit/loss)

## Testing

Unit tests are included for all core modules:
- `ProductTest`
- `InventoryManagementTest`
- `OrderTest`
- `OrderProcessingTest`
- `SupplierTest`
- `SupplierManagementTest`
- `FinancialManagementTest`

These are implemented using JUnit and follow standard test naming conventions.

## Technologies

- **Language**: Java (OpenJDK 17+)
- **Build Tool**: None (simple `javac` and `java` commands sufficient)
- **Testing**: JUnit 5

## How to Run

```bash
# Compile
javac *.java

# Run main program
java App
