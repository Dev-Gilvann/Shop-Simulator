package Classes;

import Classe_De_Excecoes.InvalidValorException;
import Classes_Abstracts.Compra_Abstract;

public class Compra extends Compra_Abstract implements Comparable<Compra> {
    private double valor;
    private String nomeDaCompra;

    public Compra(double valor, String nomeDaCompra) {
        try {
            if (valor <= 0) {
                throw new InvalidValorException("O valor da compra deve ser positivo.");
            }
            this.valor = valor;
            this.nomeDaCompra = nomeDaCompra;
        } catch (InvalidValorException e) {
            System.out.println(e.getMessage());
        }
    }
    public double getValor() {
        return valor;
    }



    public String getNomeDaCompra() {
        return nomeDaCompra;
    }

    @Override
    public String toString() {
        return "Nome da compra: "+nomeDaCompra+ ", valor: " +valor;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(outraCompra.valor));
    }
}
