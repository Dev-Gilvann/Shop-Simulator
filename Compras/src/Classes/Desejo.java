package Classes;

import Classes_Abstracts.Desejo2_Abstract;

public class Desejo extends Desejo2_Abstract {
    private String nomeDoDesejo;

    public Desejo(String nomeDoDesejo)  {
        this.nomeDoDesejo = nomeDoDesejo;
    }

    @Override
    public String toString() {
        return "Nome do produto desejado: "+ this.nomeDoDesejo;
    }

    public String getNomeDoDesejo() {
        return nomeDoDesejo;
    }
}
