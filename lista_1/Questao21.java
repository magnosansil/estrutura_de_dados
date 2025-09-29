// 21. Faça um programa em Java que carregue um array com os modelos de cinco carros (exemplo de modelos: FUSCA, GOL, VECTRA etc). Carregue um outro array com o consumo desses carros, isto é, quantos quilômetros cada um desses carros faz com um litro de combustível. Calcule e mostre:
// O modelo do carro mais econômico;
// Quantos litros de combustível cada um dos carros cadastrados consome para percorrer uma distância de 1000 quilômetros e quanto isto custará, considerando um que a gasolina custe R$ 2,25 o litro.
// Abaixo segue uma tela de exemplo. A disposição das informações deve ser o mais próxima possível ao exemplo. Os dados são fictícios e podem mudar a cada execução do programa.

// Comparativo de Consumo de Combustível
// Veículo 1
// Nome: fusca
// Km por litro: 7
// Veículo 2
// Nome: gol
// Km por litro: 10
// Veículo 3
// Nome: uno
// Km por litro: 12.5
// Veículo 4
// Nome: Vectra
// Km por litro: 9
// Veículo 5
// Nome: Peugeout
// Km por litro: 14.5

// Relatório Final
// 1 - fusca - 7.0 - 142.9 litros - R$ 321.43
// 2 - gol - 10.0 - 100.0 litros - R$ 225.00
// 3 - uno - 12.5 - 80.0 litros - R$ 180.00
// 4 - vectra - 9.0 - 111.1 litros - R$ 250.00
// 5 - peugeout - 14.5 - 69.0 litros - R$ 155.17

// O menor consumo é do peugeout.

import java.util.Scanner;

public class Questao21 {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] modelos = new String[5];
        double[] consumo = new double[5];

        final double DISTANCIA = 1000.0;
        final double PRECO_LITRO = 2.25;

        System.out.println("Comparativo de Consumo de Combustível");

        for (int i = 0; i < 5; i++) {
            System.out.println("Veículo " + (i + 1));
            System.out.print("Nome: ");
            modelos[i] = scanner.next();
            System.out.print("Km por litro: ");
            consumo[i] = scanner.nextDouble();
        }

        // Relatório final
        System.out.println("\nRelatório Final");

        double menorConsumo = Double.MAX_VALUE;
        int indiceMaisEconomico = -1;

        for (int i = 0; i < 5; i++) {
            double litros = DISTANCIA / consumo[i];
            double custo = litros * PRECO_LITRO;

            System.out.printf("%d - %s - %.1f - %.1f litros - R$ %.2f\n",
                    (i + 1), modelos[i], consumo[i], litros, custo);

            if (litros < menorConsumo) {
                menorConsumo = litros;
                indiceMaisEconomico = i;
            }
        }

        System.out.println("\nO menor consumo é do " + modelos[indiceMaisEconomico] + ".");

        scanner.close();
    }
}
