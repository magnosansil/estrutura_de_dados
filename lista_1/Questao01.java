// 1. Faça um programa em Java que leia um vetor de 5 números inteiros e mostre-os.

import java.util.Scanner;

public class Questao01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um número inteiro: ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Os números digitados foram:");
        for (int i = 0; i < 5; i++) {
            System.out.println(numeros[i]);
        }

        scanner.close();
    }
}