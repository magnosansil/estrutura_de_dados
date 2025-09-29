// 3. Faça um programa em Java que leia 4 notas, mostre as notas e a média na tela.

import java.util.Scanner;

public class Questao03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;

        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];
        }

        System.out.println("As notas digitadas foram:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }

        double media = soma / 4;
        System.out.printf("A média das notas é: %.2f%n", media);

        scanner.close();
    }
}
