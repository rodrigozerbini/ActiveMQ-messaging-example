# ActiveMQ Messaging Example

This repository demonstrates the use of Apache ActiveMQ for messaging with Java. It includes examples of both **Queue** and **Topic** messaging models. 

## Repository Structure

The repository is organized into two main folders, each demonstrating different messaging patterns using Apache ActiveMQ:

- **`queue`**: Contains classes for **queue-based messaging**.
  - **Queue** is a messaging model where each message is sent to a specific destination and is consumed by a single consumer. In this model, messages are processed in a point-to-point manner, ensuring that each message is only handled by one consumer. Queues are ideal for tasks that need to be processed exclusively by a single consumer, such as job queues.

- **`topic`**: Contains classes for **topic-based messaging**.
  - **Topic** is a messaging model where each message is broadcast to multiple subscribers. In this model, messages are published to a topic and delivered to all active subscribers of that topic. This publish/subscribe model is suitable for scenarios where you need to notify multiple consumers about an event simultaneously, such as in notification systems or real-time updates.

### Key Differences

- **Queue**: A message is delivered to **one consumer**. Used for exclusive task processing where each task/message is handled by a single entity.
- **Topic**: A message is delivered to **all subscribers**. Used for broadcasting information where multiple entities need to receive the same message.

By organizing the classes into `queue` and `topic` folders, this repository demonstrates how to implement these two different messaging patterns with Apache ActiveMQ.

### Folder: `queue`

This folder includes the following classes:

1. **Publisher**:
   - **Description**: Publishes multiple messages to a queue named "demo".
   - **Usage**: Run this class to send a series of predefined text messages to the queue.

2. **Consumer**:
   - **Description**: Consumes messages from the queue named "demo".
   - **Usage**: Run this class to receive and print messages from the queue.

3. **JsonPublisher**:
   - **Description**: Publishes a single JSON message to a queue named "JSON-queue".
   - **Usage**: Run this class to send a JSON formatted message to the queue.

4. **JsonConsumer**:
   - **Description**: Consumes JSON messages from the queue named "JSON-queue" and prints the JSON content.
   - **Usage**: Run this class to receive and process JSON messages from the queue.

### Folder: `topic`

This folder includes the following classes:

1. **Publisher**:
   - **Description**: Publishes a single message to a topic named "demo-topic".
   - **Usage**: Run this class to send a message to the topic.

2. **Consumer**:
   - **Description**: Consumes messages from the topic named "demo-topic".
   - **Usage**: Run this class to receive and print messages from the topic.

## Setup

To use the provided classes, ensure that you have Apache ActiveMQ installed and running on your local machine. The default connection URL is `tcp://localhost:61616`.

1. **Start ActiveMQ**: Follow the ActiveMQ [installation guide](http://activemq.apache.org/getting-started) to set up and start the ActiveMQ broker.

2. **Compile and Run**:
   - Compile the Java classes.
   - Execute the `main` methods in the classes as needed to test message publishing and consumption.

## Dependencies

- **Apache ActiveMQ**: For messaging. Version 5.17.3 is used in this project.
- **Java Development Kit (JDK) 11 or later**: The project is compiled using JDK 11.

## License

This project is licensed under the MIT License.

