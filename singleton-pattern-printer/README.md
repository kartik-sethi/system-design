# Thread-Safe Singleton Printer – Java LLD

A thread-safe console printing utility built in **Java** to demonstrate the **Singleton Design Pattern** combined with **concurrency control** using locks.

This project showcases how to design a lazily initialized singleton that guarantees safe access across multiple threads while ensuring consistent console output.

---

## Overview

The system provides a single global printer instance that:

* Ensures only one object is created throughout the application
* Supports thread-safe printing operations
* Prevents interleaving of console outputs in multithreaded environments
* Provides timestamp printing functionality

---

## Key Features

* Lazy initialization of singleton instance
* Double-checked locking for performance
* Thread-safe print and println operations
* Custom console output wrapper
* Timestamp printing support
* Demonstration of concurrent usage with multiple threads

---

## Design Patterns Used

### 1. Singleton Pattern

The `SingletonThreadSafePrinter` class ensures:

* Only one instance exists
* Global access point is provided
* Lazy initialization is used
* Thread safety is guaranteed using locking

The instance is created using **double-checked locking** with a volatile reference.

---

### 2. Concurrency Control Using Locks

A `ReentrantLock` is used to:

* Ensure safe creation of the singleton instance
* Prevent concurrent printing conflicts
* Maintain atomic console output operations

---

## Components

### SingletonThreadSafePrinter

Responsibilities:

* Manage single printer instance
* Provide thread-safe print operations
* Coordinate access using locks

Key Methods:

* `instance()` – returns singleton instance
* `print(Object)` – prints without newline
* `println(Object)` – prints with newline
* `printTimeStamp()` – prints current timestamp

---

### CustomSystem

Responsibilities:

* Acts as a simplified wrapper around `System.out`
* Provides a custom print stream
* Handles timestamp printing

---

## Project Structure

```
singletonComponents/
 ├── SingletonThreadSafePrinter.java
 ├── CustomSystem.java

Main.java
```

---

## How It Works

1. Multiple threads request the printer instance.
2. Singleton ensures only one instance is created.
3. Lock guarantees thread-safe printing.
4. Each thread prints messages and timestamps without output overlap.

---

## Sample Execution

```java
Thread t1 = new Thread(() -> {
    SingletonThreadSafePrinter printer = SingletonThreadSafePrinter.instance();
    printer.print("Completed Execution of Thread: ");
    printer.println("1");
    printer.printTimeStamp();
});

Thread t2 = new Thread(() -> {
    SingletonThreadSafePrinter printer = SingletonThreadSafePrinter.instance();
    printer.print("Completed Execution of Thread: ");
    printer.println("2");
    printer.printTimeStamp();
});

t1.start();
t2.start();
```

---

## Example Output

```
Completed Execution of Thread: 2
2026-02-27T00:15:30
Completed Execution of Thread: 1
2026-02-27T00:15:31
```

Output order may vary depending on thread scheduling, but printing remains consistent and non-overlapping.

---

## Design Principles Followed

* Encapsulation of shared resources
* Thread safety using locks
* Lazy initialization for efficiency
* Single Responsibility principle
* Clear separation of concerns

---

## Why This Project Matters

This project demonstrates:

* Practical understanding of Singleton pattern
* Handling concurrency in real-world scenarios
* Writing thread-safe utility components
* Clean and maintainable object-oriented design

It is useful for showcasing knowledge of core Java concurrency and design patterns in interviews.

---

## Possible Future Enhancements

* Support for logging levels
* File-based output streams
* Asynchronous logging support
* Buffered printing
* Integration with logging frameworks

---

## Author

Kartik Sethi | 
Software Engineer | Java Backend Developer | Competitive Programmer
