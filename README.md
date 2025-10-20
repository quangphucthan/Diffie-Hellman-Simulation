# Diffie-Hellman-Simulation

This project is a simple command-line simulation of the Diffie-Hellman key exchange protocol, written in Java. It demonstrates how two parties (Alice and Bob) can securely establish a shared secret key over an insecure communication channel.

## What is Diffie-Hellman?

The Diffie-Hellman key exchange is a cryptographic protocol that allows two parties that have no prior knowledge of each other to jointly establish a shared secret key over an insecure channel. This key can then be used to encrypt subsequent communications using a symmetric key cipher.

## How It Works

The simulation follows the standard steps of the Diffie-Hellman protocol:

1. **Public Numbers**: The program first prompts the user to enter two public prime numbers: `p` (a large prime modulus) and `g` (a generator or primitive root modulo `p`). These numbers are not secret and can be known by anyone.

2. **Private Keys**: Two parties, Alice and Bob, secretly generate their own private keys.
   * Alice generates a private number `SA`.
   * Bob generates a private number `SB`.

3. **Public Keys**: Alice and Bob compute their public keys using their private keys and the public numbers.
   * Alice computes her public key `TA = g^SA mod p`.
   * Bob computes his public key `TB = g^SB mod p`.
     They exchange these public keys over the insecure channel.

4. **Shared Secret Key**: Alice and Bob can now compute the shared secret key independently.
   * Alice computes the shared secret: `SK = TB^SA mod p`.
   * Bob computes the shared secret: `SK = TA^SB mod p`.

Due to the mathematical properties of modular arithmetic, both Alice and Bob will arrive at the exact same secret key value, which can then be used for encrypted communication.

## How to Run

1. **Compile the Java code:**

   ```sh
   javac DiffieHellman.java
   ```

2. **Run the program:**

   ```sh
   java DiffieHellman
   ```

3. **Provide input:** The program will prompt you to enter the prime numbers `p` and `g`. For example, you can use `23` and `5`.

   ```sh
   Enter the prime numbers p and g: 23 5
   ```
