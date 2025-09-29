// 24. Faça um programa em Java que simule um lançamento de dados. Lance o dado 100 vezes e armazene os resultados em um vetor . Depois, mostre quantas vezes cada valor foi conseguido. Dica: use um vetor de contadores(1-6) e uma função para gerar números aleatórios, simulando os lançamentos dos dados.

import java.util.Random;

public class Questao24 {

    public static void main(String[] args) {
        int[] contagem = new int[6];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int resultado = random.nextInt(6) + 1;
            contagem[resultado - 1]++;
        }

        System.out.println("Resultados dos lançamentos:");
        for (int i = 0; i < contagem.length; i++) {
            System.out.println("Valor " + (i + 1) + ": " + contagem[i] + " vezes");
        }
    }
}
