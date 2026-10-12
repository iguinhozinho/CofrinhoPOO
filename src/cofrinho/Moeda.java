package cofrinho;

// classe base das moedas
public abstract class Moeda {

    protected double valor;

    public Moeda(double valor) {
        if (Double.isNaN(valor) || Double.isInfinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("O valor da moeda deve ser positivo.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public abstract void info();

    public abstract double converter();
}
