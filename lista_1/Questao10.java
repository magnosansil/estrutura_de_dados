// 10. Faça um programa em Java que leia dois vetores com 10 elementos cada. Gere um terceiro vetor de 20 elementos, cujos valores deverão ser compostos pelos elementos intercalados dos dois outros vetores.

public class Questao10 {
    public static void main(String[] args) {
        int[] vetorA = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int[] vetorB = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int[] vetorC = new int[20];

        for (int i = 0; i < 10; i++) {
            vetorC[i * 2] = vetorA[i];
            vetorC[i * 2 + 1] = vetorB[i];
        }

        System.out.println("Vetor C (intercalado):");
        for (int i = 0; i < vetorC.length; i++) {
            System.out.print(vetorC[i] + " ");
        }
    }  
}
