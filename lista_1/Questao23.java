// 23. A ACME Inc., uma empresa de 500 funcionários, está tendo problemas de espaço em disco no seu servidor de arquivos. Para tentar resolver este problema, o Administrador de Rede precisa saber qual o espaço ocupado pelos usuários, e identificar os usuários com maior espaço ocupado. Através de um programa, baixado da Internet, ele conseguiu gerar o seguinte arquivo, chamado "usuarios.txt":
// usuarios.txtalexandre 456123789 anderson 1245698456 antonio 123456456 carlos 91257581 cesar 987458 rosemary 789456125
// Neste arquivo, o nome do usuário possui 15 caracteres.

// A partir deste arquivo, você deve criar um programa em Java que gere um relatório, chamado "relatório.txt", no seguinte formato:


// ACME Inc. Uso do espaço em disco pelos usuários
// ------------------------------------------------------------------------
// Nr. Usuário Espaço utilizado % do uso
//  1 alexandre 434,99 MB 16,85%
// 2 anderson 1187,99 MB 46,02%
// 3 antonio 117,73 MB 4,56%
// 4 carlos 87,03 MB 3,37%
// 5 cesar 0,94 MB 0,04%
// 6 rosemary 752,88 MB 29,16%

// Espaço total ocupado: 2581,57 MB
// Espaço médio ocupado: 430,26 MB

// O arquivo de entrada deve ser lido uma única vez, e os dados armazenados em memória, caso sejam necessários, de forma a agilizar a execução do programa. A conversão da espaço ocupado em disco, de bytes para megabytes deverá ser feita através de uma função separada, que será chamada pelo programa principal. O cálculo do percentual de uso também deverá ser feito através de uma função, que será chamada pelo programa principal.



import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    String nome;
    long bytes;

    Usuario(String nome, long bytes) {
        this.nome = nome.trim();
        this.bytes = bytes;
    }
}

public class Questao23 {

    public static double bytesParaMB(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }

    public static double percentualUso(long bytes, long total) {
        return (bytes * 100.0) / total;
    }

    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                int idx = 0;
                while (idx + 15 < linha.length()) {
                    String nome = linha.substring(idx, idx + 15).trim();
                    idx += 15;
                    int nextSpace = linha.indexOf(' ', idx);
                    if (nextSpace == -1) nextSpace = linha.length();
                    String bytesStr = linha.substring(idx, nextSpace).trim();
                    long bytes = Long.parseLong(bytesStr);
                    usuarios.add(new Usuario(nome, bytes));
                    idx = nextSpace + 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        long totalBytes = usuarios.stream().mapToLong(u -> u.bytes).sum();

        double mediaMB = bytesParaMB(totalBytes) / usuarios.size();

        try (PrintWriter pw = new PrintWriter(new FileWriter("relatorio.txt"))) {
            pw.println("ACME Inc.               Uso do espaço em disco pelos usuários");
            pw.println("------------------------------------------------------------------------");
            pw.printf("%-4s %-15s %20s %10s%n", "Nr.", "Usuário", "Espaço utilizado", "% do uso");

            int i = 1;
            for (Usuario u : usuarios) {
                double mb = bytesParaMB(u.bytes);
                double perc = percentualUso(u.bytes, totalBytes);
                pw.printf("%-4d %-15s %10.2f MB %10.2f%%%n", i++, u.nome, mb, perc);
            }

            pw.println();
            pw.printf("Espaço total ocupado: %.2f MB%n", bytesParaMB(totalBytes));
            pw.printf("Espaço médio ocupado: %.2f MB%n", mediaMB);

        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        }

        System.out.println("Relatório gerado com sucesso em relatorio.txt");
    }
}
