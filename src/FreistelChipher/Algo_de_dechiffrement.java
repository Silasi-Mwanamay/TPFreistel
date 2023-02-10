/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FreistelChipher;

/**
 *
 * @author Saint Jean Pierre
 */
public class Algo_de_dechiffrement {
     private static final int[] permutation = {4, 6, 0, 2, 7, 3, 1, 5};
  private static final int k1 = 0b1010;
  private static final int k2 = 0b1100;

  private static final int[] PI = {4, 6, 0, 2, 7, 3, 1, 5};
  private static final int[] PI_INVERSE = {3, 5, 7, 1, 6, 0, 2, 4};
  private static final int P = 2013;
  private static final int[] KEYS = {k1, k2};

  public static int decrypt(int C) {
    int[] C_bits = divideInto4BitBlocks(C);
    int[] G = new int[2];
    int[] D = new int[2];
    int G1, D1, G0, D0;

    // First Round
    G[1] = permuteInv(C_bits[1] ^ KEYS[1]);
    D[1] = C_bits[0] ^ (G[1] | KEYS[1]);

    // Second Round
    G[0] = permuteInv(D[1] ^ KEYS[0]);
    D[0] = G[1] ^ (G[0] | KEYS[0]);

    int N = (G[0] << 4) | D[0];
    return permuteInv(N);
  }

  private static int[] divideInto4BitBlocks(int C) {
    int[] result = new int[2];
    result[0] = C >> 4;
    result[1] = C & 0xF;
    return result;
  }

  private static int permuteInv(int input) {
    int result = 0;
    for (int i = 0; i < permutation.length; i++) {
      int bit = (input >> permutation[i]) & 1;
      result |= (bit << i);
    }
    return result;
  
}
    public static void main(String[] args) {
        // TODO code application logic here
        int C = 0b10101010;
        int decrypted = Algo_de_dechiffrement.decrypt(C);
        System.out.println("Bloc crypté : " + Integer.toBinaryString(C));
        System.out.println("Bloc déchiffré : " + Integer.toBinaryString(decrypted));
       
    }
    
}
