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
public class Chipher {
  private int[] pi = {4, 6, 0, 2, 7, 3, 1, 5};
  private int[] pi_inv = {3, 0, 2, 4, 6, 1, 7, 5};
  private int[] P = {2, 0, 1, 3};
  private int[] keys = {1, 2};
  
  public int[] encrypt(int[] N) {
    int[] C = new int[8];
    
    // la variable pi permet de faire la permutation
    int[] N_permuted = applyPermutation(N, pi);
    
    // Step 3: Divide N into two 4-bit blocks
    int[] G0 = new int[4];
    int[] D0 = new int[4];
    System.arraycopy(N_permuted, 0, G0, 0, 4);
    System.arraycopy(N_permuted, 4, D0, 0, 4);
    
    // Step 4: First round
    int[] G1 = xor(applyPermutation(G0, P), intToBinary(keys[0], 4));
    int[] D1 = xor(G0, or(G0, intToBinary(keys[0], 4)));
    
    // Step 5: Second round
    int[] G2 = xor(applyPermutation(G1, P), intToBinary(keys[1], 4));
    int[] D2 = xor(G1, or(G1, intToBinary(keys[1], 4)));
    
    // Step 6: Concatenate G2 and D2
    System.arraycopy(G2, 0, C, 0, 4);
    System.arraycopy(D2, 0, C, 4, 4);
    
    // Step 7: Apply inverse permutation pi_inv
    C = applyPermutation(C, pi_inv);
    
    return C;
  }
private int[] applyPermutation(int[] N, int[] permutation) {
    int[] permuted = new int[N.length];
    for (int i = 0; i < permutation.length; i++) {
      permuted[i] = N[permutation[i]];
    }
    return permuted;
  }
  
  private int[] xor(int[] a, int[] b) {
    int[] result = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      result[i] = a[i] ^ b[i];
    }
    return result;
  }
  
  private int[] or(int[] a, int[] b) {
    int[] result = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      result[i] = a[i] | b[i];
    }
    return result;
  }
  
  private int[] intToBinary(int n, int numBits) {
    int[] binary = new int[numBits];
    for (int i = 0; i < numBits; i++) {
      binary[numBits - 1 - i] = n & 1;
      n = n; 
      n = n >> 1;
    }
    return binary;
  }
    
}
