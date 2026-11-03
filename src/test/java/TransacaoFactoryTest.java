import org.example.TransacaoCartao;
import org.example.TransacaoDinheiro;
import org.example.TransacaoFactory;
import org.example.TransacaoPix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransacaoFactoryTest {
    @Test
    void deveRetornarTransacaoPix() {
        assertTrue(TransacaoFactory.obterTransacao("Pix") instanceof TransacaoPix);
    }

    @Test
    void deveRetornarTransacaoCartao() {
        assertTrue(TransacaoFactory.obterTransacao("Cartao") instanceof TransacaoCartao);
    }

    @Test
    void deveRetornarTransacaoDinheiro() {
        assertTrue(TransacaoFactory.obterTransacao("Dinheiro") instanceof TransacaoDinheiro);
    }

    @Test
    void deveRetornarExcecaoParaTransacaoInexistente() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> TransacaoFactory.obterTransacao("Boleto"));
        assertEquals("Transacao Inexistente", e.getMessage());
    }

    @Test
    void deveRetornarExcecaoParaTransacaoInvalida() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> TransacaoFactory.obterTransacao("Factory"));
        assertEquals("Transacao Invalida", e.getMessage());
    }
}
