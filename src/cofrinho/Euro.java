package cofrinho;

public class Euro extends Moeda {

    // cotação do dia 5/10
    private static final double COTACAO_EM_REAIS = 5.61;

    public Euro(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Euro: € %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor * COTACAO_EM_REAIS;
    }
}
