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
public class Algo_de_chiffrement {
    public static void main(String[] args) {
    Chipher cipher = new Chipher();
    int[] N = {0, 0, 0, 1, 0, 1, 1, 1};
    int[] C = cipher.encrypt(N);
    System.out.print("Bloc chiffrement est : ");
    for (int i = 0; i < C.length; i++) {
      System.out.print(C[i] + " ");
    }
  }
}
