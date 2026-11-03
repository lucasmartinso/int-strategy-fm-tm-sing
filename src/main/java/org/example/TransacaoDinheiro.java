package org.example;

public class TransacaoDinheiro extends TransacaoBase {
    @Override
    protected float calcularTaxa(float amount) {
        return 0;
    }

    @Override
    protected boolean autorizar(float valorTotal) {
        return valorTotal <= ConfiguracaoPagamento.getInstance().getLimiteDinheiro();
    }
}
