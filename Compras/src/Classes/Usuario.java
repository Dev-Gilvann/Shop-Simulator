package Classes;

import Classes_Abstracts.Pessoa_Abstract;

public class Usuario extends Pessoa_Abstract {
    private String nickname;
    private String senha;

    public Usuario(String nome, String cpf, String endereco, int idade, String nickname, String senha) {
        super(nome, cpf, endereco, idade);
        this.nickname = nickname;
        this.senha = senha;
    }

    public String getNickname() {
        return nickname;
    }

    @Override
    public String toString() {
        return "Usuario com nickname " + nickname + super.toString();
    }

    @Override
    public void dadosParaEntrega() {
        System.out.println("Muito obrigado por ter feito a compra em nossa loja!");
        System.out.println("Nome: "+getNome());
        System.out.println("Cpf: " + getCpf());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("As compras serao entregues de acordo com os dados fornecidos pelo usuário!");
    }
}
