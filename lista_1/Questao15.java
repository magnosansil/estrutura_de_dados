// Faça um programa em Java que leia um número indeterminado de valores, correspondentes a notas, encerrando a entrada de dados quando for informado um valor igual a -1 (que não deve ser armazenado). Após esta entrada de dados, faça:
// Mostre a quantidade de valores que foram lidos;
// Exiba todos os valores na ordem em que foram informados, um ao lado do outro;
// Exiba todos os valores na ordem inversa à que foram informados, um abaixo do outro;
// Calcule e mostre a soma dos valores;
// Calcule e mostre a média dos valores;
// Calcule e mostre a quantidade de valores acima da média calculada;
// Calcule e mostre a quantidade de valores abaixo de sete;
// Encerre o programa com uma mensagem;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Questao15 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Double> notas = new ArrayList<>();
    double soma = 0;
    int contador = 0;

    while (true) {
      System.out.print("Digite a nota (ou -1 para encerrar): ");
      double nota = scanner.nextDouble();
      if (nota == -1) {
        break;
      }
      notas.add(nota);
      soma += nota;
      contador++;
    }

    if (contador == 0) {
      System.out.println("Nenhuma nota válida foi informada.");
      scanner.close();

      return;
    }

    double media = soma / contador;
    int acimaDaMedia = 0;
    int abaixoDeSete = 0;

    System.out.println("Quantidade de valores lidos: " + contador);
    System.out.print("Valores informados: ");
    for (double nota : notas) {
      System.out.print(nota + " ");
    }
    System.out.println();

    Collections.reverse(notas);
    System.out.println("Valores na ordem inversa: ");
    for (double nota : notas) {
      System.out.println(nota);
    }

    System.out.println("Soma dos valores: " + soma);
    System.out.println("Média dos valores: " + media);

    for (double nota : notas) {
      if (nota > media) {
        acimaDaMedia++;
      }
      if (nota < 7) {
        abaixoDeSete++;
      }
    }

    System.out.println("Quantidade de valores acima da média: " + acimaDaMedia);
    System.out.println("Quantidade de valores abaixo de sete: " + abaixoDeSete);
    System.out.println("Programa encerrado.");

    scanner.close();
  }
}
