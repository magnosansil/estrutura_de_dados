// 2. Faça um programa em Java que leia um vetor de 10 números reais e mostre-os na ordem inversa.

import java.util.Scanner;

public class Questao02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numeros = new double[10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um número real: ");
            numeros[i] = scanner.nextDouble();
        }

        System.out.println("Os números digitados na ordem inversa são:");
        for (int i = 9; i >= 0; i--) {
            System.out.println(numeros[i]);
        }

        scanner.close();
    }
}
