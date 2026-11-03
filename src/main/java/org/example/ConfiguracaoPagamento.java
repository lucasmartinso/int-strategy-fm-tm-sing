package org.example;

public class ConfiguracaoPagamento {

    private ConfiguracaoPagamento() {};
    private static ConfiguracaoPagamento instance = new ConfiguracaoPagamento();
    public static ConfiguracaoPagamento getInstance() { return instance; }

    private float taxaCartao = 0.05f;
    private float limiteDinheiro = 1000.0f;

    public float getTaxaCartao() { return taxaCartao; }

    public void setTaxaCartao(float taxaCartao) {
        this.taxaCartao = taxaCartao;
    }

    public float getLimiteDinheiro() {
        return limiteDinheiro;
    }

    public void setLimiteDinheiro(float limiteDinheiro) {
        this.limiteDinheiro = limiteDinheiro;
    }
}
