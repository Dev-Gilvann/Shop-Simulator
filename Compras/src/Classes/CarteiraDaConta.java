package Classes;

import Classe_De_Excecoes.SaldoInsuficienteException;
import Interfaces.InterfaceDaCarteira;

import java.util.ArrayList;
import java.util.List;

public class CarteiraDaConta implements InterfaceDaCarteira {
    private double saldo;
    private double limite;
    private List<Compra> compras;

    public CarteiraDaConta(double limite){
        this.compras = new ArrayList<>();
        this.saldo = limite;
        this.limite = limite;
    }

    public boolean comprarOsProdutos(Compra compra){
        if(this.saldo >= compra.getValor()){
            this.saldo =  this.saldo - compra.getValor();
            this.compras.add(compra);
            return true;
        }else {
            try{
                throw new SaldoInsuficienteException("");
            }catch (SaldoInsuficienteException e){
                System.out.println("Saldo insuficiente Exception!");
            }
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
