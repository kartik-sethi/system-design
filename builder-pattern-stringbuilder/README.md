# Custom StringBuilder (Builder Pattern)

This module contains a custom implementation of Java’s StringBuilder, built from scratch to understand how mutable strings work internally.

The goal of this project is learning Low-Level Design (LLD) and system design concepts, not replacing the JDK implementation.

---

## What this demonstrates

- Internal use of a mutable char[] buffer
- Dynamic capacity management using capacity doubling
- Amortized O(1) time complexity for append operations
- Efficient memory usage by avoiding frequent reallocations
- Fluent API design (append chaining)
- Deep cloning support

This implementation focuses on append-heavy workloads, which are common in real systems.

---

## Why this matters

The same buffer-growth strategy appears in many production systems:

- Redis internal output and replication buffers
- Kafka producer batching
- Log aggregation pipelines
- High-throughput backend services

Understanding this pattern builds strong intuition for performance-oriented system design.

---

## Core Design Idea

1. Start with a fixed initial capacity
2. Append characters to an internal buffer
3. When capacity is exceeded:
    - Allocate a larger buffer (double the size)
    - Copy existing data into the new buffer
4. This ensures high throughput with minimal reallocations

---

## Project Structure

```text
builder-pattern-stringbuilder/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── io/
                └── github/
                    └── kartiksethi/
                        └── builder/
                            └── stringbuilder/
                                └── CustomStringBuilder.java
```


---


---

## 🧪 Example Usage

```java
CustomStringBuilder sb = new CustomStringBuilder();
sb.append("Hello ").append("World").append(123);
System.out.println(sb); // Hello World123
```
---

## Notes

- This implementation is not thread-safe
- Designed purely for educational and LLD purposes
- Inspired by how AbstractStringBuilder works internally in the JDK

---

## Part of a Larger Repository

This module is part of a larger System Design & Low-Level Design repository containing multiple design patterns and core system components implemented in Java.

More patterns (HashMap, LRU Cache, Rate Limiter, etc.) are added incrementally.

---

## Author

Kartik Sethi  
Software Engineer | Java | System Design | Low-Level Design
