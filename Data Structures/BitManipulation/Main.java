/**
 * Comprehensive Bit Manipulation Operations in Java
 * 
 * Bit manipulation is a powerful technique that works directly with individual bits
 * in binary representation of numbers. It's memory efficient and extremely fast.
 * 
 * Key Concepts:
 * - Bits are numbered from right to left, starting at 0
 * - Binary representation: 8 = 1000 (bit 3 is set)
 * - Bitwise operators: &, |, ^, ~, <<, >>
 */
class BitManipulation {
    
    /**
     * 1. GET BIT OPERATION
     * 
     * Purpose: Check if a specific bit is set (1) or not (0)
     * Method: Use bitwise AND (&) with a mask
     * 
     * How it works:
     * - Create a mask by left-shifting 1 by the bit position
     * - AND the number with the mask
     * - If result is non-zero, bit is set; if zero, bit is not set
     * 
     * @param number The number to check
     * @param position The bit position to check (0-indexed from right)
     * @return true if bit is set, false otherwise
     */
    public static boolean getBit(int number, int position) {
        // Create mask: 1 << position
        // Example: position 2 -> 1 << 2 = 100 (binary) = 4 (decimal)
        int mask = 1 << position;
        
        // AND operation with mask
        // If bit at position is 1: result will be non-zero
        // If bit at position is 0: result will be zero
        return (number & mask) != 0;
    }
    
    /**
     * 2. SET BIT OPERATION
     * 
     * Purpose: Set a specific bit to 1
     * Method: Use bitwise OR (|) with a mask
     * 
     * How it works:
     * - Create a mask by left-shifting 1 by the bit position
     * - OR the number with the mask
     * - This forces the bit at that position to be 1
     * 
     * @param number The number to modify
     * @param position The bit position to set (0-indexed from right)
     * @return The number with the bit set
     */
    public static int setBit(int number, int position) {
        // Create mask: 1 << position
        int mask = 1 << position;
        
        // OR operation with mask
        // This will set the bit at position to 1, leaving others unchanged
        return number | mask;
    }
    
    /**
     * 3. CLEAR BIT OPERATION
     * 
     * Purpose: Set a specific bit to 0
     * Method: Use bitwise AND (&) with inverted mask
     * 
     * How it works:
     * - Create a mask by left-shifting 1 by the bit position
     * - Invert the mask using NOT (~) operator
     * - AND the number with the inverted mask
     * - This forces the bit at that position to be 0
     * 
     * @param number The number to modify
     * @param position The bit position to clear (0-indexed from right)
     * @return The number with the bit cleared
     */
    public static int clearBit(int number, int position) {
        // Create mask: 1 << position
        int mask = 1 << position;
        
        // Invert mask using NOT operator
        // Example: mask = 100, ~mask = 11111011 (assuming 8-bit)
        int invertedMask = ~mask;
        
        // AND operation with inverted mask
        // This will clear the bit at position, leaving others unchanged
        return number & invertedMask;
    }
    
    /**
     * 4. UPDATE BIT OPERATION
     * 
     * Purpose: Set a bit to either 0 or 1 based on a boolean value
     * Method: Combine clear and set operations
     * 
     * How it works:
     * - First clear the bit at the position
     * - Then set it to the desired value
     * 
     * @param number The number to modify
     * @param position The bit position to update (0-indexed from right)
     * @param value The boolean value (true = 1, false = 0)
     * @return The number with the bit updated
     */
    public static int updateBit(int number, int position, boolean value) {
        // First, clear the bit at position
        int cleared = clearBit(number, position);
        
        // Convert boolean to int (true = 1, false = 0)
        int bitValue = value ? 1 : 0;
        
        // Shift the bit value to the correct position and OR with cleared number
        return cleared | (bitValue << position);
    }
    
    // ADDITIONAL USEFUL BIT MANIPULATION OPERATIONS
    
    /**
     * TOGGLE BIT OPERATION
     * 
     * Purpose: Flip a bit (0 becomes 1, 1 becomes 0)
     * Method: Use bitwise XOR (^) with a mask
     * 
     * @param number The number to modify
     * @param position The bit position to toggle
     * @return The number with the bit toggled
     */
    public static int toggleBit(int number, int position) {
        int mask = 1 << position;
        // XOR operation flips the bit
        return number ^ mask;
    }
    
    /**
     * CHECK IF POWER OF 2
     * 
     * Purpose: Check if a number is a power of 2
     * Method: Use the property that powers of 2 have only one bit set
     * 
     * How it works:
     * - Powers of 2: 1, 2, 4, 8, 16... (binary: 1, 10, 100, 1000, 10000...)
     * - For power of 2: n & (n-1) == 0
     * 
     * @param number The number to check
     * @return true if power of 2, false otherwise
     */
    public static boolean isPowerOfTwo(int number) {
        // Must be positive and n & (n-1) must be 0
        return number > 0 && (number & (number - 1)) == 0;
    }
    
    /**
     * COUNT SET BITS (Population Count)
     * 
     * Purpose: Count the number of 1s in binary representation
     * Method: Brian Kernighan's algorithm
     * 
     * How it works:
     * - n & (n-1) removes the rightmost set bit
     * - Repeat until n becomes 0
     * 
     * @param number The number to count bits in
     * @return The number of set bits
     */
    public static int countSetBits(int number) {
        int count = 0;
        while (number != 0) {
            number = number & (number - 1); // Remove rightmost set bit
            count++;
        }
        return count;
    }
    
    /**
     * GET RIGHTMOST SET BIT
     * 
     * Purpose: Get the position of the rightmost set bit
     * Method: Use n & (-n) to isolate rightmost set bit
     * 
     * @param number The number to check
     * @return The rightmost set bit value
     */
    public static int getRightmostSetBit(int number) {
        // n & (-n) gives the rightmost set bit
        return number & (-number);
    }
    
    /**
     * CLEAR ALL BITS FROM RIGHT TO POSITION
     * 
     * Purpose: Clear all bits from right up to and including position
     * Method: Use mask with left shift
     * 
     * @param number The number to modify
     * @param position The position up to which to clear bits
     * @return The modified number
     */
    public static int clearBitsFromRight(int number, int position) {
        // Create mask: 11111000 (for position 2)
        int mask = ~((1 << (position + 1)) - 1);
        return number & mask;
    }
    
    /**
     * CLEAR ALL BITS FROM LEFT TO POSITION
     * 
     * Purpose: Clear all bits from left down to and including position
     * Method: Use mask with right shift
     * 
     * @param number The number to modify
     * @param position The position from which to clear bits
     * @return The modified number
     */
    public static int clearBitsFromLeft(int number, int position) {
        // Create mask: 00000111 (for position 3)
        int mask = (1 << position) - 1;
        return number & mask;
    }
    
    /**
     * SWAP BITS AT TWO POSITIONS
     * 
     * Purpose: Swap bits at two different positions
     * Method: Check if bits are different, then toggle both
     * 
     * @param number The number to modify
     * @param pos1 First position
     * @param pos2 Second position
     * @return The number with bits swapped
     */
    public static int swapBits(int number, int pos1, int pos2) {
        // Get bits at both positions
        boolean bit1 = getBit(number, pos1);
        boolean bit2 = getBit(number, pos2);
        
        // If bits are different, toggle both
        if (bit1 != bit2) {
            number = toggleBit(number, pos1);
            number = toggleBit(number, pos2);
        }
        
        return number;
    }
    
    /**
     * DEMONSTRATION AND TESTING
     */
    public static void main(String[] args) {
        int number = 12; // Binary: 1100
        System.out.println("Original number: " + number + " (Binary: " + Integer.toBinaryString(number) + ")");
        
        // Test Get Bit
        System.out.println("\n=== GET BIT ===");
        for (int i = 0; i < 4; i++) {
            System.out.println("Bit at position " + i + ": " + getBit(number, i));
        }
        
        // Test Set Bit
        System.out.println("\n=== SET BIT ===");
        int setBitResult = setBit(number, 1); // Set bit at position 1
        System.out.println("After setting bit 1: " + setBitResult + " (Binary: " + Integer.toBinaryString(setBitResult) + ")");
        
        // Test Clear Bit
        System.out.println("\n=== CLEAR BIT ===");
        int clearBitResult = clearBit(number, 3); // Clear bit at position 3
        System.out.println("After clearing bit 3: " + clearBitResult + " (Binary: " + Integer.toBinaryString(clearBitResult) + ")");
        
        // Test Update Bit
        System.out.println("\n=== UPDATE BIT ===");
        int updateBitResult = updateBit(number, 0, true); // Set bit 0 to 1
        System.out.println("After updating bit 0 to 1: " + updateBitResult + " (Binary: " + Integer.toBinaryString(updateBitResult) + ")");
        
        // Test Toggle Bit
        System.out.println("\n=== TOGGLE BIT ===");
        int toggleBitResult = toggleBit(number, 1); // Toggle bit at position 1
        System.out.println("After toggling bit 1: " + toggleBitResult + " (Binary: " + Integer.toBinaryString(toggleBitResult) + ")");
        
        // Test Power of 2
        System.out.println("\n=== POWER OF 2 ===");
        System.out.println("Is 16 power of 2? " + isPowerOfTwo(16));
        System.out.println("Is 12 power of 2? " + isPowerOfTwo(12));
        
        // Test Count Set Bits
        System.out.println("\n=== COUNT SET BITS ===");
        System.out.println("Number of set bits in " + number + ": " + countSetBits(number));
    }
}