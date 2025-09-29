// 9. Faça um programa em Java que leia um vetor A com 10 números inteiros, calcule e mostre a soma dos quadrados dos elementos do vetor.

public class Questao09 {
    public static void main(String[] args) {
        int[] vetorA = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int somaDosQuadrados = 0;

        for (int i = 0; i < vetorA.length; i++) {
            somaDosQuadrados += vetorA[i] * vetorA[i];
        }

        System.out.println("A soma dos quadrados dos elementos do vetor A é: " + somaDosQuadrados);
    }
}
