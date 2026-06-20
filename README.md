# Gas Bill Expert System

A Java desktop application that determines the natural gas billing category based on meter consumption using JRuleEngine and JSR94.

## ⚡️ :sparkles: Features
- Determine the customer's billing category based on gas consumption.
- Uses Rule-Based Programming with JRuleEngine.
- XML rules can be modified without changing Java code.
- Simple and extensible design.

## 📜 Technologies Used
- Java 8
- NetBeans
- JRuleEngine
- JSR94
- XML

## 📁 Project Structure

```
src/
│
├── gas.bill
│   ├── Consumption.java
│   ├── The_Bill.java
│   ├── compilation_of_rules.java
│   └── GasBill.java
│
├── gas_bill_rules.xml

lib/
├── jsr94.jar
└── jruleengine.jar
```

## 💡 Example

Input:
```
30
```

Output:
```
انت من ضمن : الشريحة الأولى
```

Input:
```
45
```

Output:
```
انت من ضمن :الشريحة الثانية
```

Input:
```
75
```

Output:
```
انت من ضمن :الشريحة الثالثة
```

## 🚀 How to Run

1. Open the project using NetBeans.
2. Use JDK 8.
3. Build the project.
4. Run `compilation_of_rules.java`.
5. Enter the meter reading in the console.

## ✏️ Author

ALAA KHALED