package Classes_Abstracts;
import Interfaces.InterfaceDosDados;

public abstract class Pessoa_Abstract implements InterfaceDosDados {
    private String nome;
    private String cpf;
    private String endereco;
    private int idade;

    public Pessoa_Abstract(String nome, String cpf, String endereco, int idade){
            this.nome = nome;
            this.cpf = cpf;
            this.endereco = endereco;
            this.idade = idade;
    }

    public void dadosParaEntrega(){

    }

    @Override
    public String toString() {
        return "Nome: "+nome+", idade: "+idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }
}
