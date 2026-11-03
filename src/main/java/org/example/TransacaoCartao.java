package org.example;

public class TransacaoCartao extends TransacaoBase {
    @Override
    protected float calcularTaxa(float amount) {
        return amount * ConfiguracaoPagamento.getInstance().getTaxaCartao();
    }
}
