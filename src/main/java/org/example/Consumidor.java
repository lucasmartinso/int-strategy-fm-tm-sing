package org.example;

public class Consumidor {
    private String nome;
    private boolean transacaoAutorizada;

    public String getNome() {
        return nome;
    }

    public boolean isTransacaoAutorizada() {
        return transacaoAutorizada;
    }

    public void pagar(float amount, Consumidor reciver, String tipo) {
        Pagamento pagamento = new Pagamento(amount, this, reciver);
        this.transacaoAutorizada = pagamento.pagamento(TransacaoFactory.obterTransacao(tipo));
    }

    public void receber(float amount, Consumidor payer, String tipo) {
        Pagamento pagamento = new Pagamento(amount, payer, this);
        this.transacaoAutorizada = pagamento.pagamento(TransacaoFactory.obterTransacao(tipo));
    }
}
