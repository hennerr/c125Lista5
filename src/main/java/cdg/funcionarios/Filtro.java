package cdg.funcionarios;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Filtro {

    public static void gerarCSVFuncionarioSemFilhos(Path arquivo) {
        List<Funcionario> func = leCSV(arquivo);

        gerarCSVnew("funcionario_filtro.csv", func);

    }

    private static void gerarCSVnew(String nomeArquivo, List<Funcionario> func) {
        String cabecalho = "Idade,Filhos,Salario\n";
        Path arquivoFinal = Paths.get(nomeArquivo);
        try {
            Files.writeString(arquivoFinal, cabecalho);
            StringBuilder builder = new StringBuilder();
            func.stream().
                    filter((f) -> f.getNum_filhos() != 0).
                    forEach((f) -> {
                        builder.append(f.getIdade() + ";").
                                append(f.getNum_filhos() + ";").
                                append(f.getSalario() + "\n");
                    });
            Files.writeString(arquivoFinal, builder.toString(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Funcionario> leCSV(Path arquivo) {
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            List<String> linhas = Files.readAllLines(arquivo);
            linhas.remove(0);

            linhas.forEach((linha) -> {
                String[] linhaSplit = linha.split(",");

                Funcionario funcionario = new Funcionario
                        (Integer.parseInt(linhaSplit[0]),
                                Integer.parseInt(linhaSplit[3]),
                                Double.parseDouble(linhaSplit[4]));
                funcionarios.add(funcionario);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

}