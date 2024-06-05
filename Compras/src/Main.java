import Classe_De_Excecoes.SenhaCurtaException;
import Classes.*;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        String nickname = null;
        String senha = null;
        String nome = null;
        String cpf = null;
        String endereco = null;
        int idade = 0;
        boolean senhaValida = true;

        while (senhaValida) {
            System.out.println("\n\n\n\n-----------------------------------");
            System.out.println("Seja bem vindo à loja!");
            System.out.println("Digite o seu nickname: ");
            nickname = entrada.nextLine();
            System.out.println("Digite a sua senha");
            try {
                senha = entrada.nextLine();
                if (senha.length() < 4) {
                    throw new SenhaCurtaException("");
                } else {
                    senhaValida = false;
                }
            } catch (SenhaCurtaException ex) {
                System.out.println("A senha deve ter pelo menos 4 caracteres.");
            }
            System.out.println("-----------------------------------\n\n\n");
        }

        Usuario usuario = new Usuario(nome, cpf, endereco, idade, nickname, senha);
        ListaDeDesejos listaDeDesejos = new ListaDeDesejos();

        int exit = 10;
        while (exit != 0) {
            System.out.println("\n\n\n----------------------------------------");
            System.out.println("Seja bem-vindo, usuário(a) de nickname: " + usuario.getNickname());
            System.out.println("O senhor(a) gostaria de colocar numa lista de desejos dos produtos que você gostaria de obter no futuro ?");
            System.out.println("Digite 0 para sair ou 1 para continuar");
            exit = entrada.nextInt();
            entrada.nextLine();

            while (exit == 1) {
                System.out.println("Fale o nome do produto que você deseja: ");
                String nomeDoDesejo = entrada.nextLine();

                Desejo desejo = new Desejo(nomeDoDesejo);
                listaDeDesejos.adicionarDesejo(desejo);

                System.out.println(listaDeDesejos);
                System.out.println("Gostaria de remover todos os itens da lista? Aperte 2");
                System.out.println("Digite 1, se quiser continuar a preencher a lista");
                System.out.println("Digite 0 para sair da lista de desejos");
                exit = entrada.nextInt();
                entrada.nextLine();

                if (exit == 2) {
                    listaDeDesejos.removerTodosDesejos();
                    System.out.println("Todos os itens foram removidos com sucesso.");
                    System.out.println("Digite 0 para sair ou 1 para continuar a preencher a lista");
                    exit = entrada.nextInt();
                    entrada.nextLine();
                }
            }
            System.out.println(listaDeDesejos);
            System.out.println("----------------------------------------\n\n\n");
            System.out.println("Digite o limite da carteira");
            double limite = entrada.nextDouble();
            CarteiraDaConta carteira = new CarteiraDaConta(limite);
            int sair = 10;
            while (sair != 0) {
                entrada.nextLine();
                System.out.println("Digite o nome do produto");
                String nomeDaCompra = entrada.nextLine();
                System.out.println("Digite o valor da compra");
                double valor = entrada.nextDouble();

                Compra compra = new Compra(valor, nomeDaCompra);
                boolean compraRealizada = carteira.comprarOsProdutos(compra);

                if (compraRealizada && compra.getValor() > 0) {
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("Seu saldo atual é " + carteira.getSaldo());
                    System.out.println("Digite 0 para sair ou 1 para continuar");
                    sair = entrada.nextInt();

                    System.out.println("\n-----------------------------------");
                    System.out.println("COMPRAS REALIZADAS\n");
                    Collections.sort(carteira.getCompras());
                    for (Compra e : carteira.getCompras()) {
                        System.out.println(e.getNomeDaCompra() + " - " + e.getValor());
                    }
                    System.out.println("\nSaldo do cartão: " + carteira.getSaldo());
                    System.out.println("Cadastre os seus dados pessoais para que os produtos sejam entregues!");
                    System.out.println("-----------------------------------\n\n\n");
                } else {
                    if (compra.getValor() <= 0) {
                        System.out.println("Valor da compra deve ser positivo. Tente novamente!");
                    } else {
                        System.out.println("Saldo insuficiente. Tente novamente!");
                    }
                    System.out.println("Seu saldo atual é " + carteira.getSaldo());


                    System.out.println("Digite 0 para sair ou 1 para continuar");
                    sair = entrada.nextInt();
                }
            }

            int leave = 10;
            while (leave != 0){
                entrada.nextLine();
                System.out.println("Digite o seu nome real, usuário de nickname " + usuario.getNickname());
                nome = entrada.nextLine();
                System.out.println("Digite o seu cpf ");
                cpf = entrada.nextLine();
                System.out.println("Digite a sua idade ");
                idade = entrada.nextInt();
                entrada.nextLine(); // Consumir a linha nova após ler o inteiro
                System.out.println("Digite o seu endereço ");
                endereco = entrada.nextLine();
                Usuario usuario2 = new Usuario(nome, cpf, endereco, idade, nickname, senha);
                usuario2.dadosParaEntrega();
                leave = 0;
            }
        }
    }
}
