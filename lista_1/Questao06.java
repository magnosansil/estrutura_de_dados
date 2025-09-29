// 6. Faça um programa em Java que peça as quatro notas de 10 alunos, calcule e armazene num vetor a média de cada aluno, imprima o número de alunos com média maior ou igual a 7.0.

import java.util.Scanner;

public class Questao06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] notas = new double[10][4];
        double[] medias = new double[10];
        int countAprovados = 0;

        for (int i = 0; i < 10; i++) {
            double soma = 0;
            System.out.println("Aluno " + (i + 1) + ":");
            for (int j = 0; j < 4; j++) {
                System.out.print("Digite a nota " + (j + 1) + ": ");
                notas[i][j] = scanner.nextDouble();
                soma += notas[i][j];
            }
            medias[i] = soma / 4;
            if (medias[i] >= 7.0) {
                countAprovados++;
            }
        }

        System.out.println("Número de alunos com média maior ou igual a 7.0: " + countAprovados);

        scanner.close();
    }
}
