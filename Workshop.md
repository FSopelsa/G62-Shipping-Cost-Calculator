![Lexicon Logo](https://lexicongruppen.se/media/wi5hphtd/lexicon-logo.svg)

# Workshop: Shipping Cost Calculator

The **Shipping Cost Calculator** is a small console-based Java application that calculates the cost of shipping an order
based on a few simple inputs.

The goal of the application is to determine **how much shipping should cost** depending on **how and where** a package
is being shipped.

---

## 🔗 Repository

Fork the repository to get started:

> **Note:** Make sure to fork the repository to your own GitHub account before cloning it locally.

---

## 🚚 What Does the Application Do?

The application receives a **shipping request** that contains:

- **Destination**
    - `DOMESTIC`
    - `INTERNATIONAL`

- **Shipping Speed**
    - `STANDARD`
    - `EXPRESS`

- **Package Weight**
    - Weight in kilograms

Based on this information, the application selects the **correct shipping strategy** and calculates the final shipping
cost.

---

## How the Logic Is Structured

The application is designed using **interfaces and multiple implementations**:

- A common interface:
    - `ShippingCostCalculator`

- Multiple implementations of that interface, each responsible for a specific case:
    - Standard Domestic Shipping
    - Express International Shipping

Each implementation knows:

- **Which type of request it supports**
- **How to calculate the cost for that request**

This design allows the application to:

- Support multiple shipping rules
- Be extended easily without rewriting existing logic

---

## Supporting Components

To coordinate the calculation process, the application uses:

- **A factory**
    - Selects the correct `ShippingCostCalculator` based on the request

- **A service**
    - Uses the factory to calculate and return the shipping cost

- **A main entry point**
    - Creates objects
    - Wires dependencies together
    - Runs the application

At this stage, **all objects are created manually using `new`**.

---

## Your Task

Your task is to **refactor this application using the Spring Framework**.

Currently, the application is written using **pure Java**, where:

- Objects are created manually using `new`
- Dependencies are wired together in the `main` method

You will replace this manual wiring by using **Spring Core features**.

Refactor the application so that:

- Object creation is handled by the **Spring IoC Container**
- Dependencies are injected using **Spring Dependency Injection (DI)**
- The application logic remains the same, but **Spring manages the object graph**

1. Configure the Spring Container
2. Register Application Classes as Spring Beans
3. Use Constructor-Based Dependency Injection
4. Transfer Object Creation to the IoC Container

---

## Optional Tasks

1. **Add More Shipping Strategies**
    - Domestic Express
    - International Standard

2. **Log Bean Creation**
    - Add `@PostConstruct` to each shipping calculator
    - Print a message when the bean is created

3. **Use `application.properties` or `application.yaml`**
    - Move pricing values (base cost, cost per kg) to properties
    - Inject them into calculators

4. **Use Spring Profiles**
    - Create `dev` and `prod` profiles
    - Use different prices per profile

---
