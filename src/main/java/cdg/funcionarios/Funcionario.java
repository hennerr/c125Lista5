package cdg.funcionarios;

public class Funcionario {

    private int idade;
    private double salario;
    private int num_filhos;

    public Funcionario (int idade, int num_filhos, double salario){
        this.idade = idade;
        this.salario = salario;
        this.num_filhos = num_filhos;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalario() {
        return salario;
    }

    public int getNum_filhos() {
        return num_filhos;
    }
}
