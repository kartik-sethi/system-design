# Mediator Pattern Auction System

A production-grade, extensible auction bidding framework built in Java using core design patterns and clean architecture principles.

This project demonstrates how to design a scalable, loosely coupled, and reusable interaction management system similar to real-world auction platforms while showcasing strong object-oriented design, SOLID principles, and practical design pattern usage.

---

## Features

* Centralized bid coordination using mediator
* Loose coupling between bidders
* Real-time bid notification system
* Dynamic bidder registration
* Encapsulated auction business logic
* Clean separation of domain and communication layers
* Extensible bidding workflow
* Simple and readable architecture

---

## Design Pattern Used

### Mediator Pattern (Core Pattern)

The system follows a centralized communication model where:

* Multiple bidders interact through a mediator
* Bidders never communicate directly with each other
* The mediator coordinates bidding logic and notifications

This removes complex dependencies between bidders and promotes maintainable and scalable interaction design.

---

## Project Structure

```
io.github.kartiksethi
│
├── bidder
│   ├── Bidder.java
│   └── BidderImpl.java
│
├── mediator
│   ├── AuctionMediator.java
│   └── AuctionMediatorImpl.java
│
├── models
│   ├── Item.java
│   └── Bid.java
│
└── Main.java
```

---

## Class Diagram

The following diagram illustrates the relationships between bidders and the mediator and how the Mediator pattern centralizes communication.

<p align="center">
  <img src="class-diagram.jpeg" width="750">
</p>

---

## How the System Works

### Step 1 — Bidders Join the Auction

Bidders register themselves with the mediator.

```
auctionMediator.addBidder(bidder);
```

---

### Step 2 — Bidder Places a Bid

A bidder submits a bid through the mediator.

```
bidder.placeBid(amount);
```

---

### Step 3 — Mediator Validates Bid

The mediator checks:

* Whether the bid is higher than the current highest bid
* Updates the auction state if valid

---

### Step 4 — All Bidders Are Notified

The mediator broadcasts the bid update to all participants.

```
sendNotification(message);
```

---

## Core Components

### Bidder Interface

Represents participants in the auction.

Responsibilities:

* Placing bids through mediator
* Receiving notifications
* Identifying the bidder

Key methods:

```
placeBid()
receiveNotification()
getName()
```

---

### BidderImpl

Concrete implementation of a bidder.

Responsibilities:

* Delegating bid placement to mediator
* Handling incoming notifications

This keeps bidders lightweight and decoupled.

---

### AuctionMediator Interface

Defines the contract for managing bidder communication.

Responsibilities:

* Registering bidders
* Coordinating bid placement
* Sending notifications
* Providing access to auction item

---

### AuctionMediatorImpl

Central coordination component of the system.

Responsibilities:

* Maintaining list of bidders
* Tracking the highest bid
* Enforcing auction rules
* Broadcasting notifications

This class contains the core business logic of the auction.

---

### Domain Models

#### Item

Represents the auction item.

Encapsulates item-specific details.

---

#### Bid

Represents a bid placed by a bidder.

Stores:

* Bidder information
* Item reference
* Bid amount

---

## Example Usage

```java
public class Main {
    public static void main(String[] args) {
        Item item = new Item("Rolex watch");

        AuctionMediator mediator = new AuctionMediatorImpl(item);

        Bidder bidder1 = new BidderImpl("Alice", mediator);
        Bidder bidder2 = new BidderImpl("Bob", mediator);
        Bidder bidder3 = new BidderImpl("Charlie", mediator);

        mediator.addBidder(bidder1);
        mediator.addBidder(bidder2);
        mediator.addBidder(bidder3);

        bidder1.placeBid(10);
        bidder2.placeBid(20);
        bidder3.placeBid(15);
    }
}
```

---

## Extending the System

To add new auction behavior:

1. Implement new mediator rules inside AuctionMediatorImpl
2. Extend Bidder implementation for custom bidder types
3. Add new notification strategies if required

No existing bidder classes need modification.

---

## SOLID Principles Demonstrated

Single Responsibility Principle
Mediator manages coordination, bidders handle user interaction.

Open/Closed Principle
New bidder types can be added without changing mediator logic.

Dependency Inversion Principle
System depends on abstractions like Bidder and AuctionMediator.

Loose Coupling Principle
Bidders do not reference each other directly.

---

## Real-World Relevance

This architecture is widely used in:

* Auction platforms
* Chat room systems
* Air traffic control systems
* Workflow orchestration engines
* Multiplayer game coordination
* Event coordination systems

It also forms the conceptual foundation behind:

* Messaging brokers
* Workflow engines
* Orchestration services in microservices

---

## Author

Kartik Sethi
Associate Software Engineer
Java | Spring Boot | System Design | Competitive Programming

---

## License

MIT License
