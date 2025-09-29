// 16. Utilize um array para resolver o problema a seguir. Uma empresa paga seus vendedores com base em comissões. O vendedor recebe $200 por semana mais 9 por cento de suas vendas brutas daquela semana. Por exemplo, um vendedor que teve vendas brutas de $3000 em uma semana recebe $200 mais 9 por cento de $3000, ou seja, um total de $470. Escreva um programa em Java (usando um array de contadores) que determine quantos vendedores receberam salários nos seguintes intervalos de valores:
// $200 - $299
// $300 - $399
// $400 - $499
// $500 - $599
// $600 - $699
// $700 - $799
// $800 - $899
// $900 - $999
// $1000 em diante


public class Questao16 {
    public static void main(String[] args) {
        int[] contadores = new int[9];
        double[] vendas = {1500, 2500, 3500, 4500, 5500, 6500, 7500, 8500, 9500, 10500};

        for (double venda : vendas) {
            double salario = 200 + (venda * 0.09);
            if (salario >= 200 && salario < 300) {
                contadores[0]++;
            } else if (salario >= 300 && salario < 400) {
                contadores[1]++;
            } else if (salario >= 400 && salario < 500) {
                contadores[2]++;
            } else if (salario >= 500 && salario < 600) {
                contadores[3]++;
            } else if (salario >= 600 && salario < 700) {
                contadores[4]++;
            } else if (salario >= 700 && salario < 800) {
                contadores[5]++;
            } else if (salario >= 800 && salario < 900) {
                contadores[6]++;
            } else if (salario >= 900 && salario < 1000) {
                contadores[7]++;
            } else {
                contadores[8]++;
            }
        }

        String[] intervalos = {
            "$200 - $299",
            "$300 - $399",
            "$400 - $499",
            "$500 - $599",
            "$600 - $699",
            "$700 - $799",
            "$800 - $899",
            "$900 - $999",
            "$1000 em diante"
        };

        System.out.println("Número de vendedores por faixa salarial:");
        for (int i = 0; i < contadores.length; i++) {
            System.out.println(intervalos[i] + ": " + contadores[i]);
        }
    }
}
