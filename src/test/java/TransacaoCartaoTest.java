import org.example.ConfiguracaoPagamento;
import org.example.Consumidor;
import org.example.TransacaoCartao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransacaoCartaoTest {
    @BeforeEach
    void configurar() {
        ConfiguracaoPagamento.getInstance().setTaxaCartao(0.05f);
    }

    @Test
    void deveCalcularValorTotalComTaxa() {
        TransacaoCartao transacao = new TransacaoCartao();
        assertEquals(105.0f, transacao.calcularValorTotal(100.0f));
    }

    @Test
    void deveCalcularValorTotalComTaxaAlterada() {
        ConfiguracaoPagamento.getInstance().setTaxaCartao(0.10f);
        TransacaoCartao transacao = new TransacaoCartao();
        assertEquals(110.0f, transacao.calcularValorTotal(100.0f));
    }

    @Test
    void deveAutorizarTransacao() {
        TransacaoCartao transacao = new TransacaoCartao();
        assertEquals(true, transacao.executar(100.0f, new Consumidor(), new Consumidor()));
    }

    @Test
    void deveRetornarExcecaoParaValorZero() {
        TransacaoCartao transacao = new TransacaoCartao();
        assertThrows(IllegalArgumentException.class,
                () -> transacao.executar(0, new Consumidor(), new Consumidor()));
    }
}
