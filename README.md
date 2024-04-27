# spring-boot-kafka
Apache Kafka is a distributed streaming platform that is used for building real-time data pipelines and streaming applications.
Kafka operates on a publish-subscribe model, and it has some specific concepts such as topics, producers, consumers, consumer groups, brokers, and more.
Let’s focus on understanding the concepts of consumers and consumer groups in Kafka.

Let's simplify it further:

### Consumer:

Think of a consumer as someone who reads from a newspaper. They pick up the newspaper and read the articles. In Kafka terms:
- The newspaper is like a Kafka topic, where messages (articles) are published.
- The reader is the consumer, which reads these messages from the topic.

### Consumer Group:

Now, imagine you have a group of friends who want to read the same newspaper together. They decide to divide the newspaper into sections, and each friend takes responsibility for reading a specific section. In Kafka terms:
- The friends are the consumers in the same consumer group.
- The sections of the newspaper are the partitions of a Kafka topic.
- Each friend (consumer) reads from a specific partition (section) of the topic (newspaper).

### Key Points:

- **Parallel Reading**: Just as each friend reads a different section, consumers in a group read from different partitions, allowing for parallel processing.

- **Scalability**: If you add more friends (consumers) to the group, they can also read from the remaining partitions, scaling up the reading process.

- **Fault Tolerance**: If one friend (consumer) leaves the group, the partitions they were responsible for get reassigned to the remaining friends, ensuring continuous reading without interruption.

In short, consumers read messages from Kafka topics, and consumer groups allow multiple consumers to work together, dividing the workload efficiently. Each consumer in a group reads from a different partition, providing scalability and fault tolerance.


### → Example

Let's consider a simplified example using Kafka's concepts of topics, partitions, consumers, and consumer groups.

### Scenario:

Imagine we have a Kafka topic named "orders" that contains information about orders placed on an e-commerce website. The "orders" topic has 4 partitions. We want to process these orders in real-time using Kafka consumers.

# Step 1: Creating the "orders" Topic

First, we create a Kafka topic named "orders" with 4 partitions. Each partition will store a subset of the orders data.

# Step 2: Starting Consumers

Next, we start two consumers, Consumer A and Consumer B, both belonging to the same consumer group named "order-processing-group."

# Step 3: Consumer Group Assignment

Kafka will automatically assign partitions to consumers in the consumer group. Let's say:
- Consumer A is assigned partitions 0 and 1.
- Consumer B is assigned partitions 2 and 3.

# Step 4: Processing Orders

- **Consumer A**: Reads orders from partitions 0 and 1.
- **Consumer B**: Reads orders from partitions 2 and 3.

# Step 5: Scaling

If we add another consumer, say Consumer C, to the same consumer group:
- Kafka will automatically rebalance the partitions.
- Consumer C might be assigned partitions 0 and 2 (assuming partitions 1 and 3 were already assigned to Consumers A and B, respectively).

# Step 6: Fault Tolerance

** If Consumer A crashes:**
- Kafka will detect this and reassign partitions 0 and 1 to Consumers B and C.
- Consumers B and C will continue processing orders without interruption.

**Summary:**

- **Topic**: "*orders*"
- **Partitions**: 4
- **Consumer Group**: "order-processing-group"
- **Consumers**:
    - Consumer A: Partitions 0, 1
    - Consumer B: Partitions 2, 3
    - (Potential) Consumer C: Partitions 0, 2

This setup allows for parallel processing of orders, scalability by adding more consumers, and fault tolerance in case of consumer failures, ensuring continuous processing of orders in real-time.

### Example #2
Let's use the example of Swiggy, a food delivery app, to illustrate how Kafka can work:

**Swiggy Order Flow with Kafka:**

1. **Placing an Order (Producer):** When a customer places an order on the Swiggy app, it acts as a **producer**. The order details, including items, customer location, and restaurant information, are packaged as a message and sent to a specific Kafka **topic** (e.g., "order-requests").

2. **Kafka as a Highway (Broker):** This topic acts like a designated lane on the Kafka highway. The Kafka **brokers** (central servers) receive the order message and ensure it's delivered to the right consumers.

3. **Delivery Partner Assignment (Consumer 1):** A separate microservice, responsible for assigning delivery partners, acts as a **consumer**. It's subscribed to the "order-requests" topic and listens for new messages. Once it receives an order message, it processes the information and assigns a suitable delivery partner based on location and availability.

4. **Order Confirmation (Producer Again):** The same microservice (acting as a producer again) sends a confirmation message to another topic (e.g., "order-confirmed") indicating the assigned delivery partner.

5. **Delivery Partner Notification (Consumer 2):** The delivery partner app acts as another **consumer**. It's subscribed to the "order-confirmed" topic and receives notifications about assigned orders. This allows the delivery partner to accept or decline the order and eventually pick it up from the restaurant.

6. **Order Status Updates (More Producers and Consumers):** Throughout the delivery process, various services (restaurants, delivery partner app, customer app) might act as producers and consumers, sending and receiving updates on the order status (e.g., "order-picked-up", "delivered") on dedicated Kafka topics.

**Benefits for Swiggy:**

- **Scalability:** Kafka can handle the high volume of orders Swiggy receives simultaneously.
- **Decoupling:** Different microservices (order management, delivery management) can work independently without worrying about each other's implementation details.
- **Real-time Updates:** Kafka enables real-time communication between services, ensuring everyone has the latest order information.
- **Resilience:** Even if a server goes down, Kafka ensures data isn't lost and deliveries progress smoothly.

This is a simplified example, but it demonstrates how Kafka acts as a central communication hub for Swiggy's order management system, ensuring smooth coordination between different parts of the operation.