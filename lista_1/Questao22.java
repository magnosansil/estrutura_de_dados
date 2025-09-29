// 22. Sua organização acaba de contratar um estagiário para trabalhar no Suporte de Informática, com a intenção de fazer um levantamento nas sucatas encontradas nesta área. A primeira tarefa dele é testar todos os cerca de 200 mouses que se encontram lá, testando e anotando o estado de cada um deles, para verificar o que se pode aproveitar deles.Foi requisitado que você desenvolva um programa em Java para registrar este levantamento. O programa deverá receber um número indeterminado de entradas, cada uma contendo: um número de identificação do mouse o tipo de defeito:

// -necessita da esfera;
// -necessita de limpeza; a.necessita troca do cabo ou conector; a.quebrado ou inutilizado Uma identificação igual a zero encerra o programa.

// Ao final o programa deverá emitir o seguinte relatório:

// Quantidade de mouses: 100

// Situação Quantidade Percentual
// 1- necessita da esfera 40 40%
// 2- necessita de limpeza 30 30%
// 3- necessita troca do cabo ou conector 15 15%
// 4- quebrado ou inutilizado 15 15%

import java.util.Scanner;

public class Questao22 {
  public static double calcularPercentual(int quantidade, int total) {
        if (total == 0) return 0.0;
        return (quantidade * 100.0) / total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] defeitos = new int[5];
        int totalMouses = 0;

        System.out.println("Cadastro de Mouses - Digite 0 para encerrar\n");

        while (true) {
            System.out.print("Número de identificação do mouse (0=fim): ");
            int id = scanner.nextInt();

            if (id == 0) break;

            System.out.println("Tipos de defeito:");
            System.out.println("1 - necessita da esfera");
            System.out.println("2 - necessita de limpeza");
            System.out.println("3 - necessita troca do cabo ou conector");
            System.out.println("4 - quebrado ou inutilizado");
            System.out.print("Informe o defeito (1-4): ");
            int defeito = scanner.nextInt();

            if (defeito < 1 || defeito > 4) {
                System.out.println("Defeito inválido! Informe um valor entre 1 e 4.\n");
                continue;
            }

            defeitos[defeito]++;
            totalMouses++;
            System.out.println("Mouse cadastrado!\n");
        }

        // Relatório final
        System.out.println("\nRelatório:");
        System.out.println("Quantidade de mouses: " + totalMouses + "\n");

        System.out.println("Situação                               Quantidade   Percentual");
        System.out.printf("1- necessita da esfera                 %5d   %.0f%%\n",
                defeitos[1], calcularPercentual(defeitos[1], totalMouses));
        System.out.printf("2- necessita de limpeza                %5d   %.0f%%\n",
                defeitos[2], calcularPercentual(defeitos[2], totalMouses));
        System.out.printf("3- necessita troca do cabo ou conector %5d   %.0f%%\n",
                defeitos[3], calcularPercentual(defeitos[3], totalMouses));
        System.out.printf("4- quebrado ou inutilizado             %5d   %.0f%%\n",
                defeitos[4], calcularPercentual(defeitos[4], totalMouses));

        scanner.close();
    }
}
