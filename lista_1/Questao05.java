// 5. Faça um programa em Java que leia 20 números inteiros e armazene-os num vetor. Armazene os números pares no vetor PAR e os números IMPARES no vetor impar. Imprima os três vetores.

import java.util.Scanner;

public class Questao05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[20];
        int[] pares = new int[20];
        int[] impares = new int[20];
        int countPares = 0;
        int countImpares = 0;

        for (int i = 0; i < 20; i++) {
            System.out.print("Digite um número inteiro: ");
            numeros[i] = scanner.nextInt();

            if (numeros[i] % 2 == 0) {
                pares[countPares] = numeros[i];
                countPares++;
            } else {
                impares[countImpares] = numeros[i];
                countImpares++;
            }
        }

        System.out.println("Números digitados:");
        for (int i = 0; i < 20; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        System.out.println("Números pares:");
        for (int i = 0; i < countPares; i++) {
            System.out.print(pares[i] + " ");
        }
        System.out.println();

        System.out.println("Números ímpares:");
        for (int i = 0; i < countImpares; i++) {
            System.out.print(impares[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
