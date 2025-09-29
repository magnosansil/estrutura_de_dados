// 8. Faça um programa em Java que peça a idade e a altura de 5 pessoas, armazene cada informação no seu respectivo vetor. Imprima a idade e a altura na ordem inversa a ordem lida.

import java.util.Scanner;

public class Questao08 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] idades = new int[5];
    double[] alturas = new double[5];

    for (int i = 0; i < 5; i++) {
      System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
      idades[i] = scanner.nextInt();
      System.out.print("Digite a altura da pessoa " + (i + 1) + ": ");
      alturas[i] = scanner.nextDouble();
    }

    System.out.println("Idades na ordem inversa:");
    for (int i = 4; i >= 0; i--) {
      System.out.println(idades[i]);
    }

    System.out.println("Alturas na ordem inversa:");
    for (int i = 4; i >= 0; i--) {
      System.out.println(alturas[i]);
    }

    scanner.close();
  }
}
