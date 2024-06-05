package Classes;

import Interfaces.InterfaceDeDeletar;
import Interfaces.InterfaceDosDesejos;

import java.util.HashSet;
import java.util.Set;

public class ListaDeDesejos implements InterfaceDosDesejos, InterfaceDeDeletar {
    private Set<Desejo> desejos;


    public ListaDeDesejos() {
        this.desejos = new HashSet<>();
    }

    @Override
    public String toString() {
        return "Lista de desejos: " + this.desejos;
    }

    @Override
    public boolean listarOsDesejos(Desejo desejo) {
        this.desejos.add(desejo);
        return true;
    }

    public void adicionarDesejo(Desejo desejo) {
        listarOsDesejos(desejo);
    }

    public void removerTodosDesejos() {
        this.desejos.clear();
    }

    public Set<Desejo> getDesejos() {
        return desejos;
    }
}

