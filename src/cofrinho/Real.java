package cofrinho;

public class Real extends Moeda {

    public Real(double valor) {
        super(valor);
    }

    @Override
    public void info() {
        System.out.printf("Real: R$ %.2f%n", valor);
    }

    @Override
    public double converter() {
        return valor;
    }
}
