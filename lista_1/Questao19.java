// 19. Uma empresa de pesquisas precisa tabular os resultados da seguinte enquete feita a um grande quantidade de organizações:
// "Qual o melhor Sistema Operacional para uso em servidores?"
// As possíveis respostas são:
// 1- Windows Server
// 2- Unix
// 3- Linux
// 4- Netware
// 5- Mac OS
// 6- Outro
// Você foi contratado para desenvolver um programa em Java que leia o resultado da enquete e informe ao final o resultado da mesma. O programa deverá ler os valores até ser informado o valor 0, que encerra a entrada dos dados. Não deverão ser aceitos valores além dos válidos para o programa (0 a 6). Os valores referentes a cada uma das opções devem ser armazenados num vetor. Após os dados terem sido completamente informados, o programa deverá calcular a percentual de cada um dos concorrentes e informar o vencedor da enquete.
// O formato da saída foi dado pela empresa, e é o seguinte:
// Sistema Operacional Votos %
// ------------------- ----- ---
// Windows Server 1500 17%
// Unix 3500 40%
// Linux 3000 34%
// Netware 500 5%
// Mac OS 150 2%
// Outro 150 2%
// ------------------- -----
// Total 8800

// O Sistema Operacional mais votado foi o Unix, com 3500 votos, correspondendo a 40% 

import java.util.Scanner;

public class Questao19 {
   public static double calcularPercentual(int votos, int total) {
        if (total == 0) return 0.0;
        return (votos * 100.0) / total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sistemas = {
            "",
            "Windows Server",
            "Unix",
            "Linux",
            "Netware",
            "Mac OS",
            "Outro"
        };

        int[] votos = new int[7];
        int totalVotos = 0;

        System.out.println("Enquete: Qual o melhor Sistema Operacional para uso em servidores?");
        System.out.println("As opções são:");
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + " - " + sistemas[i]);
        }
        System.out.println("Digite 0 para encerrar.\n");

        while (true) {
            System.out.print("Número da opção (0=fim): ");
            int opcao = scanner.nextInt();

            if (opcao == 0) break;

            if (opcao < 1 || opcao > 6) {
                System.out.println("Informe um número válido entre 1 e 6, ou 0 para encerrar!");
                continue;
            }

            votos[opcao]++;
            totalVotos++;
        }

        System.out.println("\nResultado da votação:\n");
        System.out.printf("%-19s %-5s %s\n", "Sistema Operacional", "Votos", "%");
        System.out.println("------------------- ----- ---");

        int maisVotos = 0;
        int indiceMaisVotado = 0;

        for (int i = 1; i <= 6; i++) {
            if (votos[i] > 0) {
                double percentual = calcularPercentual(votos[i], totalVotos);
                System.out.printf("%-19s %-5d %.0f%%\n", sistemas[i], votos[i], percentual);

                if (votos[i] > maisVotos) {
                    maisVotos = votos[i];
                    indiceMaisVotado = i;
                }
            } else {
                System.out.printf("%-19s %-5d %.0f%%\n", sistemas[i], 0, 0.0);
            }
        }

        System.out.println("------------------- -----");
        System.out.printf("%-19s %d\n", "Total", totalVotos);

        double percentualMaisVotado = calcularPercentual(maisVotos, totalVotos);
        System.out.println("\nO Sistema Operacional mais votado foi o " +
                sistemas[indiceMaisVotado] + ", com " + maisVotos +
                " votos, correspondendo a " + String.format("%.0f", percentualMaisVotado) + "%");
        
        scanner.close();
    }
}
