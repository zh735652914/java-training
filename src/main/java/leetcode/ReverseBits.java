package leetcode;

/*
190. Reverse Bits
Easy

730

264

Add to List

Share
Reverse bits of a given 32 bits unsigned integer.



Example 1:

Input: 00000010100101000001111010011100
Output: 00111001011110000010100101000000
Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596,
so return 964176192 which its binary representation is 00111001011110000010100101000000.
Example 2:

Input: 11111111111111111111111111111101
Output: 10111111111111111111111111111111
Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293,
so return 3221225471 which its binary representation is 10111111111111111111111111111111.


Note:

Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output
 will be given as signed integer type and should not affect your implementation, as the internal binary representation
  of the integer is the same whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the
 input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */
//自己没想到。。。
class ReverseBitsSolution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >>> 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }
}

public class ReverseBits {
    public static void main(String[] args) {
//        int n = 43261596;
//        int n = -3;
        int n = 3;
        System.out.println(new ReverseBitsSolution().reverseBits(n));
    }
}
