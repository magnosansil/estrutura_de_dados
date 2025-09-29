// 11. Altere o programa anterior, intercalando 3 vetores de 10 elementos cada.

public class Questao11 {
    public static void main(String[] args) {
        int[] vetorA = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28};
        int[] vetorB = {2, 5, 8, 11, 14, 17, 20, 23, 26, 29};
        int[] vetorC = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30};
        int[] vetorD = new int[30];

        for (int i = 0; i < 10; i++) {
            vetorD[i * 3] = vetorA[i];
            vetorD[i * 3 + 1] = vetorB[i];
            vetorD[i * 3 + 2] = vetorC[i];
        }

        System.out.println("Vetor D (intercalado):");
        for (int i = 0; i < vetorD.length; i++) {
            System.out.print(vetorD[i] + " ");
        }
    }
}
