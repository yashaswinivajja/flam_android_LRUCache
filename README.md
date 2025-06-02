# flam_android_LRUCache
This project implements an **LRU (Least Recently Used) Cache** in Java using a custom doubly linked list and `HashMap` for efficient O(1) access, insertion, and deletion. 
## Core Concept
An LRU Cache stores key-value pairs with a limited capacity. When the cache exceeds the capacity, it evicts the **least recently used** item.
## Features
- Constant time `get()` and `put()` operations.
- Automatic eviction of least recently used entries.
- Backed by:
  - HashMap for O(1) access.
  - Doubly linked list for maintaining usage order.
## File Structure
- `Main.java`: Demonstrates usage of the cache.
- `LRUCache.java`: Implementation of the LRU Cache.
## Example Input
<img width="360" alt="Screenshot 2025-06-03 at 12 41 10 AM" src="https://github.com/user-attachments/assets/7027234e-f70c-4d05-9842-7dc8a37f5592" />
## Output
<img width="1512" alt="Screenshot 2025-06-02 at 10 19 41 PM" src="https://github.com/user-attachments/assets/a9187eed-f154-47c0-8e56-65d77a3bbea2" />
