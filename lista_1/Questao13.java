// 13. Faça um programa em Java que receba a temperatura média de cada mês do ano e armazene-as em um array. Após isto, calcule a média anual das temperaturas e mostre todas as temperaturas acima da média anual, e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro, ...).

import java.util.Scanner;

public class Questao13 {
    public static void main(String[] args) {
        double[] temperaturas = new double[12];
        double soma = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {
            System.out.print("Digite a temperatura média do mês " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
            soma += temperaturas[i];
        }

        double media = soma / 12;
        System.out.println("Média anual das temperaturas: " + media);

        System.out.println("Temperaturas acima da média anual:");
        for (int i = 0; i < 12; i++) {
            if (temperaturas[i] > media) {
                System.out.println("Mês " + (i + 1) + ": " + temperaturas[i]);
            }
        }

        scanner.close();
    }
}
