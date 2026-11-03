import org.example.ConfiguracaoPagamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ConfiguracaoPagamentoTest {
    @Test
    public void deveRetornarMesmaInstancia() {
        assertSame(ConfiguracaoPagamento.getInstance(), ConfiguracaoPagamento.getInstance());
    }

    @Test
    public void deveRetornarTaxaCartao() {
        ConfiguracaoPagamento.getInstance().setTaxaCartao(0.05f);
        assertEquals(0.05f, ConfiguracaoPagamento.getInstance().getTaxaCartao());
    }

    @Test
    public void deveRetornarLimiteDinheiro() {
        ConfiguracaoPagamento.getInstance().setLimiteDinheiro(1000.0f);
        assertEquals(1000.0f, ConfiguracaoPagamento.getInstance().getLimiteDinheiro());
    }
}
