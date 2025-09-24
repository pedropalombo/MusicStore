# Disc Store Microservices

A Java Spring Boot microservices project for managing a **disc store**. Each entity (`Person`, `Order`, `Disc`) is a separate microservice, communicating via **Feign proxies**, persisting data with **JPA/H2**, and exposing REST APIs.

---

## **Table of Contents**

- [Project Overview](#project-overview)  
- [Microservices](#microservices)  
- [APIs](#apis)  
- [Data Initialization](#data-initialization)  
- [Running the Project](#running-the-project)  
- [Notes](#notes)  

---

## **Project Overview**

- **Person Service** → Manages customers and their cashback.  
- **Order Service** → Manages orders, linked to customers (Person) and discs (Disc).  
- **Disc Service** → Manages disc catalog (name, author, genre, price).  
- Each microservice runs independently on **different ports** and communicates using **Feign clients**.  

---

## **Microservices & Ports**

| Service         | Port  | Functionality                                           |
|-----------------|-------|--------------------------------------------------------|
| Person Service  | 8100  | Create, read, update, delete customers; cashback API  |
| Order Service   | 8200  | Create and view orders; linked to Person and Disc     |
| Disc Service    | 8300  | Create, read, update, delete discs                    |

---

## **API Endpoints**

### **Person Service (localhost:8100)**

- `GET /person` → List all persons  
- `GET /person/{id}` → Get a person by ID  
- `POST /person` → Create a new person  
- `PUT /person/{id}` → Update a person  
- `DELETE /person/{id}` → Delete a person  
- `GET /person/{personId}/order` → Get all orders for a person  
- `PUT /person/{id}/cashback` → Update a person’s cashback  

---

### **Disc Service (localhost:8300)**

- `GET /disc` → List all discs  
- `GET /disc/{id}` → Get a disc by ID  
- `POST /disc` → Create a new disc  
- `PUT /disc/{id}` → Update a disc  
- `DELETE /disc/{id}` → Delete a disc  

---

### **Order Service (localhost:8200)**

- `GET /order` → List all orders  
- `GET /order/{id}` → Get an order by ID  
- `POST /order` → Create a new order (linked to Person and Discs)  
- `GET /order/person/{personId}` → List all orders for a person  

---

## **Data Initialization**

- All services use **H2 in-memory database**.  
- Preloaded data can be found in `data.sql` for each service:  
  - **Person Service** → Preloaded customers with cashback  
  - **Disc Service** → Preloaded discs catalog  
  - **Order Service** → Preloaded orders and associated discs  
- Use the H2 console to inspect data:  
  - Person: `http://localhost:8100/h2-console`  
  - Order: `http://localhost:8200/h2-console`  
  - Disc: `http://localhost:8300/h2-console`  

---

## **Running the Project**

1. Open each microservice in your IDE (IntelliJ, Eclipse, etc.)  
2. Start services in order:  
   1. **Person Service** → port 8100  
   2. **Disc Service** → port 8300  
   3. **Order Service** → port 8200  
3. Use Postman, curl, or browser to interact with APIs  
4. H2 console can be used to inspect the database  

---

## **Notes**

- Feign proxies are used for communication between services.  
- Cashback for a customer is automatically updated when an order is created.  
- All services are fully independent and can be extended individually.  
- H2 is in-memory; restarting a service will reset its database.  
