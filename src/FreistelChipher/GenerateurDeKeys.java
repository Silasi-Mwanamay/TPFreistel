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
public class GenerateurDeKeys {
    public static int[] generationCle(int K, int perm, int decalGauche, int decalDroit) {
        int k1_ = K & 240;
        int k2_ = K & 15;
        int k1 = (k1_ ^ k2_) << decalGauche;
        int k2 = (k2_ & k1_) >> decalDroit;
        return new int[] {k1, k2};
        
    }
    public static void main(String[] args) {
        int K = 170;
        int permutation = 65274130;
        int decalGauche = 2;
        int decalDroit = 1;
        int[] keys = generationCle(K, permutation, decalGauche, decalDroit);
        System.out.println("k1: " + Integer.toBinaryString(keys[0]));
        System.out.println("k2: " + Integer.toBinaryString(keys[1]));
    }
    
}
