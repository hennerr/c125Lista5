package cdg.funcionarios;


import java.nio.file.Path;
import java.nio.file.Paths;

public class Principal {

    public static void main(String[] args) {
        Path arquivo = Paths.get("funcionarios.csv");
        Filtro.gerarCSVFuncionarioSemFilhos(arquivo);
    }
}
