// 14. Utilizando arrays, faça um programa em Java que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
// "Telefonou para a vítima?"
// "Esteve no local do crime?"
// "Mora perto da vítima?"
// "Devia para a vítima?"
// "Já trabalhou com a vítima?"

// O programa deve no final emitir uma classificação sobre a participação da pessoa no crime. Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como "Cúmplice" e 5 como "Assassino". Caso contrário, ele será classificado como "Inocente".


import java.util.Scanner;

public class Questao14{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] perguntas = {
            "Telefonou para a vítima?",
            "Esteve no local do crime?",
            "Mora perto da vítima?",
            "Devia para a vítima?",
            "Já trabalhou com a vítima?"
        };
        
        int respostasPositivas = 0;

        for (String pergunta : perguntas) {
            System.out.print(pergunta + " (sim/não): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("sim")) {
                respostasPositivas++;
            }
        }

        String classificacao;
        if (respostasPositivas == 5) {
            classificacao = "Assassino";
        } else if (respostasPositivas >= 3) {
            classificacao = "Cúmplice";
        } else if (respostasPositivas == 2) {
            classificacao = "Suspeita";
        } else {
            classificacao = "Inocente";
        }

        System.out.println("Classificação: " + classificacao);
        scanner.close();
    }
}
