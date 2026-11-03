package org.example;

public abstract class TransacaoBase implements Transacao {

    public final boolean executar(float amount, Consumidor payer, Consumidor reciver) {
        validarValor(amount);
        return autorizar(calcularValorTotal(amount));
    }

    public float calcularValorTotal(float amount) {
        return amount + calcularTaxa(amount);
    }

    private void validarValor(float amount) {
        if(amount <= 0) {
            throw new IllegalArgumentException("Transacao tem que ser um valor maior do que 0");
        }
    }

    protected abstract float calcularTaxa(float amount);

    protected boolean autorizar(float valorTotal) {
        return true; //aqui seria uma conexao via API
    }
}
