# Routing Application with Priority Queue ADT

Team members

Diana Wanjiru – SCT212-0119/2022

John Mwega - SCT212-0055/2021

Kositany CK Kimetto – SCT212-0722/2022

Damiano Moru - SCT212-0163/2022

Princeton Machala - SCT212-0657/2021

Andrian Musyoka - SCT212-0597/2022

# Project Overview

This project demonstrates the implementation of a **Priority Queue Abstract Data Type (ADT)** and its application in solving a real-world problem: **routing**. The primary goal is to calculate the shortest path between locations in a graph, simulating a basic version of routing systems like those used in **Google Maps**.

## Data Structure: Priority Queue ADT

### Definition:

A **Priority Queue** is a data structure that retrieves elements based on their priority rather than their order of insertion. Each element is associated with a priority value, and the element with the highest priority (lowest numerical value) is dequeued first.

## Usage in Routing:

A **Priority Queue** is used to implement **Dijkstra's Algorithm**, a graph-based algorithm for finding the shortest paths between nodes. It manages nodes dynamically as the algorithm updates distances to minimize the total cost to the destination.

### Application Domain:

- **Routing**

### Problem Statement:

- Calculate the shortest route between two points in a graph where edges represent roads with weights (distances or travel times).

## Implementation Details:

### Graph Representation:

The graph is implemented as an **adjacency list**, where nodes represent **locations**, and edges represent **roads with weights**.

### Dijkstra's Algorithm:

The algorithm uses a **Priority Queue** to prioritize exploring the node with the shortest distance from the source.

### Routing Logic:

- Nodes are inserted into the **Priority Queue** with their updated distances.
- The algorithm terminates once the shortest path to the destination is determined.

# Project Overview

This project demonstrates the implementation of a **Priority Queue Abstract Data Type (ADT)** and its application in solving a real-world problem: **routing**. The primary goal is to calculate the shortest path between locations in a graph, simulating a basic version of routing systems like those used in **Google Maps**.

## Data Structure: Priority Queue ADT

### Definition:

A **Priority Queue** is a data structure that retrieves elements based on their priority rather than their order of insertion. Each element is associated with a priority value, and the element with the highest priority (lowest numerical value) is dequeued first.

## Usage in Routing:

A **Priority Queue** is used to implement **Dijkstra's Algorithm**, a graph-based algorithm for finding the shortest paths between nodes. It manages nodes dynamically as the algorithm updates distances to minimize the total cost to the destination.

### Application Domain:

- **Routing**

### Problem Statement:

- Calculate the shortest route between two points in a graph where edges represent roads with weights (distances or travel times).

## Implementation Details:

### Graph Representation:

The graph is implemented as an **adjacency list**, where nodes represent **locations**, and edges represent **roads with weights**.

### Dijkstra's Algorithm:

The algorithm uses a **Priority Queue** to prioritize exploring the node with the shortest distance from the source.

### Routing Logic:

- Nodes are inserted into the **Priority Queue** with their updated distances.
- The algorithm terminates once the shortest path to the destination is determined.
