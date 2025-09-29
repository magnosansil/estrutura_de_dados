// 4. Faça um programa em Java que leia um vetor de 10 caracteres, e diga quantas consoantes foram lidas. Imprima as consoantes.

import java.util.Scanner;

public class Questao04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] caracteres = new char[10];
        int countConsoantes = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite um caractere: ");
            String input = scanner.next();
            caracteres[i] = input.charAt(0);

            if (Character.isLetter(caracteres[i]) && !isVogal(caracteres[i])) {
                countConsoantes++;
            }
        }

        System.out.println("As consoantes digitadas foram:");
        for (char c : caracteres) {
            if (Character.isLetter(c) && !isVogal(c)) {
                System.out.println(c);
            }
        }

        System.out.println("Número de consoantes: " + countConsoantes);
        scanner.close();
    }

    private static boolean isVogal(char c) {
        char lowerC = Character.toLowerCase(c);
        return lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u';
    }
}
