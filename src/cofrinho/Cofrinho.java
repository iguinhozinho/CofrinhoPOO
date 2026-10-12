package cofrinho;

import java.util.ArrayList;
import java.util.Iterator;

public class Cofrinho {

    // guarda diferentes tipos de moeda na mesma lista
    private final ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();

    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    // procura uma moeda do mesmo tipo e valor pra remover
    public boolean remover(Moeda procurada) {
        Iterator<Moeda> iterador = listaMoedas.iterator();

        while (iterador.hasNext()) {
            Moeda atual = iterador.next();
            boolean mesmoTipo = atual.getClass() == procurada.getClass();
            boolean mesmoValor = Double.compare(atual.getValor(), procurada.getValor()) == 0;

            if (mesmoTipo && mesmoValor) {
                iterador.remove();
                return true;
            }
        }
        return false;
    }

    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho esta vazio.");
            return;
        }

        System.out.println("\nMoedas guardadas:");
        for (Moeda moeda : listaMoedas) {
            moeda.info(); // cada moeda mostra suas proprias infos usando seu proprio metodo
        }
    }

    public double totalConvertido() {
        double total = 0;
        for (Moeda moeda : listaMoedas) {
            total += moeda.converter(); // usa a conversão de cada tipo de moeda
        }
        return total;
    }
}
