package org.example;

public class TransacaoPix extends TransacaoBase {
    @Override
    protected float calcularTaxa(float amount) {
        return 0;
    }
}
