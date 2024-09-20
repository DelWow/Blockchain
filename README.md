# Simple Blockchain Implementation in Java
This project is a straightforward implementation of a blockchain in Java. It provides a foundation for understanding how blockchains work, including block creation, mining, and verification of chain integrity.

## Table of Contents
- Features
- Getting Started
   - Prerequisistes
   - Project Structure
   - Running the Application
- Blockchain Overview
- Code Structure
- License

## Features
- Create a blockchain with a configurable mining difficulty.
- Mine blocks and compute their hashes using SHA-256.
- Validate the integrity of the blockchain.
- Output the entire blockchain in a nicely formatted JSON structure.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) installed on your machine.
- Gson library for JSON serialization (add it to your project dependencies).

### Project Structure
```
simple-blockchain/
├── Main.java        # Entry point of the application
├── Block.java       # Represents a block in the blockchain
├── StringUtil.java  # Utility for hashing functions
└── LICENSE          # License file for the project
```

### Running the Application
1. Clone the repository
``` bash
git clone https://github.com/yourusername/simple-blockchain.git
cd simple-blockchain
```
2. Ensure the Gson library is included in your project. If you're using an IDE, you can add it as a dependency easily.
3. Compile the Java files:
``` bash
javac Main.java Block.java StringUtil.java
```
4. Run the application:
``` bash
java Main
```


## Expected Output
The application will output the mining process and the final blockchain in JSON format:
``` mathematica
Mining block 1...
Block has been Mined: [hash_value]
Mining block 2...
Block has been Mined: [hash_value]
...
The blockchain:
{
  "blockchain": [
    {
      "hash": "[hash_value]",
      "previousHash": "0",
      "data": "Hi I'm the first block",
      "timeStamp": [timestamp],
      "TokenId": 0
    },
    ...
  ]
}
```

## Validating the Blockchain
To verify the blockchain's integrity, call the ```isChainValid()``` method. If the chain is valid, you'll see a confirmation message:
``` java
if (isChainValid()) {
    System.out.println("Blockchain is valid.");
} else {
    System.out.println("Blockchain is not valid.");
}
```

## Blockchain Overview
A blockchain is a decentralized and distributed ledger that records transactions across many computers. This implementation simulates the core concepts of blockchain technology, including:

- Blocks: Containers that hold data and metadata, including the hash of the previous block.
- Mining: The process of solving cryptographic challenges to create new blocks and ensure network security.
- Validation: Ensuring that the blockchain remains consistent and tamper-proof.

## License 
This project is licensed under the MIT License. See the [LICENSE](https://github.com/DelWow/Simple-Blockchain-Implementation-in-Java/blob/main/LICENSE)  file for more details.

