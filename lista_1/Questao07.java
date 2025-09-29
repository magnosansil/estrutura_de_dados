// 7. Faça um programa em Java que leia um vetor de 5 números inteiros, mostre a soma, a multiplicação e os números.

import java.util.Scanner;

public class Questao07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[5];
        int soma = 0;
        int multiplicacao = 1;

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite um número inteiro: ");
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
            multiplicacao *= numeros[i];
        }

        System.out.println("Números digitados:");
        for (int i = 0; i < 5; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();

        System.out.println("Soma dos números: " + soma);
        System.out.println("Multiplicação dos números: " + multiplicacao);

        scanner.close();
    }
  
}
