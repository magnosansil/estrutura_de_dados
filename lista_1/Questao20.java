// 20. As Organizações Tabajara resolveram dar um abono aos seus colaboradores em reconhecimento ao bom resultado alcançado durante o ano que passou. Para isto contratou você para desenvolver a aplicação que servirá como uma projeção de quanto será gasto com o pagamento deste abono.
// Após reuniões envolvendo a diretoria executiva, a diretoria financeira e os representantes do sindicato laboral, chegou-se a seguinte forma de cálculo:

// Cada funcionário receberá o equivalente a 20% do seu salário bruto de dezembro;
// O piso do abono será de 100 reais, isto é, aqueles funcionários cujo salário for muito baixo, recebem este valor mínimo;
// Neste momento, não se deve ter nenhuma preocupação com colaboradores com tempo menor de casa, descontos, impostos ou outras particularidades. Seu programa em Java deverá permitir a digitação do salário de um número indefinido (desconhecido) de salários. Um valor de salário igual a 0 (zero) encerra a digitação. Após a entrada de todos os dados, o programa deverá calcular o valor do abono concedido a cada colaborador, de acordo com a regra definida acima.

// Ao final, o programa deverá apresentar:

// O salário de cada funcionário, juntamente com o valor do abono;
// O número total de funcionário processados;
// O valor total a ser gasto com o pagamento do abono;
// O número de funcionário que receberá o valor mínimo de 100 reais;
// O maior valor pago como abono; A tela abaixo é um exemplo de execução do programa, apenas para fins ilustrativos. Os valores podem mudar a cada execução do programa.

// Projeção de Gastos com Abono
// ============================
//  Salário: 1000
// Salário: 300
// Salário: 500
// Salário: 100
// Salário: 4500
// Salário: 0

// Salário - Abono
//  R$ 1000.00 - R$ 200.00
// R$ 300.00 - R$ 100.00
// R$ 500.00 - R$ 100.00
// R$ 100.00 - R$ 100.00
// R$ 4500.00 - R$ 900.00

// Foram processados 5 colaboradores
// Total gasto com abonos: R$ 1400.00
// Valor mínimo pago a 3 colaboradores Maior valor de abono pago: R$ 900.00

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Questao20 {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> salarios = new ArrayList<>();
        List<Double> abonos = new ArrayList<>();

        double totalAbonos = 0.0;
        int countMinimos = 0;
        double maiorAbono = 0.0;

        System.out.println("Projeção de Gastos com Abono");
        System.out.println("============================");

        while (true) {
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();

            if (salario == 0) break;

            double abono = salario * 0.20;
            if (abono < 100) {
                abono = 100;
                countMinimos++;
            }

            salarios.add(salario);
            abonos.add(abono);

            totalAbonos += abono;
            if (abono > maiorAbono) {
                maiorAbono = abono;
            }
        }

        System.out.println("\nSalário - Abono");
        for (int i = 0; i < salarios.size(); i++) {
            System.out.printf("R$ %.2f - R$ %.2f\n", salarios.get(i), abonos.get(i));
        }

        System.out.println("\nForam processados " + salarios.size() + " colaboradores");
        System.out.printf("Total gasto com abonos: R$ %.2f\n", totalAbonos);
        System.out.println("Valor mínimo pago a " + countMinimos + " colaboradores");
        System.out.printf("Maior valor de abono pago: R$ %.2f\n", maiorAbono);

        scanner.close();
    }
}
