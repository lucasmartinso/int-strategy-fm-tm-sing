package org.example;

public class Pagamento {
    private float amount;
    Consumidor payer;
    Consumidor reciver;

    public Pagamento(float amount, Consumidor payer, Consumidor reciver) {
        this.amount = amount;
        this.payer = payer;
        this.reciver = reciver;
    }

    public boolean pagamento(Transacao transacao) {
        return transacao.executar(amount, payer, reciver);
    }
}
