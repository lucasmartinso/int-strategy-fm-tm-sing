package org.example;

public interface Transacao {
    boolean executar(float amount, Consumidor payer, Consumidor reciver);
    float calcularValorTotal(float amount);
}
