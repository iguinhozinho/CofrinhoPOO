package cofrinho;

public class Dolar extends Moeda {

    // cotação do dia 5/10
    private static final double COTACAO_EM_REAIS = 5.00;

    public Dolar(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Dólar: US$ %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO_EM_REAIS;
    }
}
