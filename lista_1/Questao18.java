// 18. Uma grande emissora de televisão quer fazer uma enquete entre os seus telespectadores para saber qual o melhor jogador após cada jogo. Para isto, faz-se necessário o desenvolvimento de um programa em Java, que será utilizado pelas telefonistas, para a computação dos votos. Sua equipe foi contratada para desenvolver este programa, utilizando a linguagem de programação Java. Para computar cada voto, a telefonista digitará um número, entre 1 e 23, correspondente ao número da camisa do jogador. Um número de jogador igual a zero, indica que a votação foi encerrada. Se um número inválido for digitado, o programa deve ignorá-lo, mostrando uma breve mensagem de aviso, e voltando a pedir outro número. Após o final da votação, o programa deverá exibir:
// O total de votos computados; Os números e respectivos votos de todos os jogadores que receberam votos; O percentual de votos de cada um destes jogadores; O número do jogador escolhido como o melhor jogador da partida, juntamente com o número de votos e o percentual de votos dados a ele.
// Observe que os votos inválidos e o zero final não devem ser computados como votos. O resultado aparece ordenado pelo número do jogador. O programa deve fazer uso de arrays. O programa deverá executar o cálculo do percentual de cada jogador através de uma função. Esta função receberá dois parâmetros: o número de votos de um jogador e o total de votos. A função calculará o percentual e retornará o valor calculado. Abaixo segue uma tela de exemplo. O disposição das informações deve ser o mais próxima possível ao exemplo. Os dados são fictícios e podem mudar a cada execução do programa. Ao final, o programa deve ainda gravar os dados referentes ao resultado da votação em um arquivo texto no disco, obedecendo a mesma disposição apresentada na tela.
// Enquete:
// Quem foi o melhor jogador?
// Número do jogador (0=fim): 9
// Número do jogador (0=fim): 10
// Número do jogador (0=fim): 9
// Número do jogador (0=fim): 10
// Número do jogador (0=fim): 11
// Número do jogador (0=fim): 10
// Número do jogador (0=fim): 50
// Informe um valor entre 1 e 23 ou 0 para sair!
// Número do jogador (0=fim): 9
// Número do jogador (0=fim): 9
// Número do jogador (0=fim): 0

// Resultado da votação:

// Foram computados 8 votos.
// Jogador Votos %
// 9 4 50,0%
// 10 3 37,5%
// 11 1 12,5%

// O melhor jogador foi o número 9, com 4 votos, correspondendo a 50% do total de votos.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Questao18 {

    public static double calcularPercentual(int votosJogador, int totalVotos) {
        if (totalVotos == 0) return 0.0;
        return (votosJogador * 100.0) / totalVotos;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] votos = new int[24];
        int totalVotos = 0;

        System.out.println("Enquete:");
        System.out.println("Quem foi o melhor jogador?");

        while (true) {
            System.out.print("Número do jogador (0=fim): ");
            int num = scanner.nextInt();

            if (num == 0) break;
            if (num < 1 || num > 23) {
                System.out.println("Informe um valor entre 1 e 23 ou 0 para sair!");
                continue;
            }

            votos[num]++;
            totalVotos++;
        }

        System.out.println("\nResultado da votação:\n");
        System.out.println("Foram computados " + totalVotos + " votos.");

        System.out.println("Jogador   Votos   %");
        int melhorJogador = 0;
        int maiorVotos = 0;

        StringBuilder resultado = new StringBuilder();
        resultado.append("Resultado da votação:\n\n");
        resultado.append("Foram computados " + totalVotos + " votos.\n\n");
        resultado.append(String.format("%-10s%-8s%s\n", "Jogador", "Votos", "%"));

        for (int i = 1; i <= 23; i++) {
            if (votos[i] > 0) {
                double percentual = calcularPercentual(votos[i], totalVotos);
                System.out.printf("%-9d %-7d %.1f%%\n", i, votos[i], percentual);
                resultado.append(String.format("%-10d%-8d%.1f%%\n", i, votos[i], percentual));

                if (votos[i] > maiorVotos) {
                    maiorVotos = votos[i];
                    melhorJogador = i;
                }
            }
        }

        double percentualMelhor = calcularPercentual(maiorVotos, totalVotos);
        System.out.println("\nO melhor jogador foi o número " + melhorJogador +
                ", com " + maiorVotos + " votos, correspondendo a " +
                String.format("%.1f", percentualMelhor) + "% do total de votos.");

        resultado.append("\nO melhor jogador foi o número " + melhorJogador +
                ", com " + maiorVotos + " votos, correspondendo a " +
                String.format("%.1f", percentualMelhor) + "% do total de votos.\n");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resultado_enquete.txt"))) {
            writer.write(resultado.toString());
            System.out.println("\nResultado gravado em 'resultado_enquete.txt'");
        } catch (IOException e) {
            System.out.println("Erro ao gravar o arquivo: " + e.getMessage());
        }

        scanner.close();
    }
}
