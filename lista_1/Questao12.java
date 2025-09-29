// 12. Foram anotadas as idades e alturas de 30 alunos. Faça um programa em Java que determine quantos alunos com mais de 13 anos possuem altura inferior à média de altura desses alunos.

public class Questao12 {
    public static void main(String[] args) {
        int[] idades = {14, 15, 12, 16, 17, 14, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41};
        double[] alturas = {1.60, 1.65, 1.55, 1.70, 1.75, 1.62, 1.80, 1.85, 1.90, 1.95, 2.00, 1.58, 1.68, 1.78, 1.88, 1.98, 2.05, 1.50, 1.52, 1.54, 1.56, 1.59, 1.61, 1.63, 1.64, 1.66, 1.67, 1.69, 1.71, 1.72};
        double somaAlturas = 0;
        for (int i = 0; i < alturas.length; i++) {
            somaAlturas += alturas[i];
        }
        double mediaAlturas = somaAlturas / alturas.length;

        int contador = 0;
        for (int i = 0; i < idades.length; i++) {
            if (idades[i] > 13 && alturas[i] < mediaAlturas) {
                contador++;
            }
        }

        System.out.println("Número de alunos com mais de 13 anos e altura inferior à média: " + contador);
    }
}