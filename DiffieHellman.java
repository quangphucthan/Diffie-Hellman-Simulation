import java.util.*;

public class DiffieHellman {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the prime numbers p and g: ");
        String[] input = sc.nextLine().split(" ");

        sc.close();

        int p = Integer.parseInt(input[0]);
        int g = Integer.parseInt(input[1]);

        System.out.println("Generating keys for Alice and Bob...");

        int SA = generatePrivateKey(p);
        int SB = generatePrivateKey(p);

        System.out.println("Alice's secret number is: " + SA);
        System.out.println("Bob's secret number is: " + SB);

        System.out.println("------------------------------");

        int TA = diffeeHellman(p, g, SA);
        int TB = diffeeHellman(p, g, SB);

        System.out.println("Alice's TA is: " + TA);
        System.out.println("Bob's TB is: " + TB);

        System.out.println("Computing shared secrety keys...");

        int aliceSK = diffeeHellman(p, TB, SA);
        int bobSK = diffeeHellman(p, TA, SB);

        System.out.println("Alice's generated secret key is: " + aliceSK);
        System.out.println("Bob's generated secret key is: " + bobSK);

    }
    public static int generatePrivateKey(int p) {
        return rand.nextInt(p - 1) + 1;
    }

    public static int diffeeHellman(int p, int g, int secret) {
        // If the secret is 0, return 1 as per the Diffie-Hellman protocol
        if (secret == 0) {
            return 1;
        }

        // Calculate g^secret mod p using modular exponentiation
        long result = 1;
        long base = g % p;

        // Use the method of exponentiation by squaring
        while (secret > 0) {
            // If the current bit is 1, multiply the result by the current power of base
            if (secret % 2 == 1) {
                result = (result * base) % p;
            }
            
            // Square the base for the next bit position
            base = (base * base) % p;
            
            // Shift to the next bit of the exponent
            secret /= 2;
        }
        
        return (int) result;
    }

}