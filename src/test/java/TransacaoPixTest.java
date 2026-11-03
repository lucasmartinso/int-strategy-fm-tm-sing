import org.example.Consumidor;
import org.example.TransacaoPix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransacaoPixTest {
    @Test
    void deveCalcularValorTotalSemTaxa() {
        TransacaoPix transacao = new TransacaoPix();
        assertEquals(100.0f, transacao.calcularValorTotal(100.0f));
    }

    @Test
    void deveAutorizarTransacao() {
        TransacaoPix transacao = new TransacaoPix();
        assertEquals(true, transacao.executar(100.0f, new Consumidor(), new Consumidor()));
    }

    @Test
    void deveRetornarExcecaoParaValorZero() {
        TransacaoPix transacao = new TransacaoPix();
        assertThrows(IllegalArgumentException.class,
                () -> transacao.executar(0, new Consumidor(), new Consumidor()));
    }

    @Test
    void deveRetornarExcecaoParaValorNegativo() {
        TransacaoPix transacao = new TransacaoPix();
        assertThrows(IllegalArgumentException.class,
                () -> transacao.executar(-10.0f, new Consumidor(), new Consumidor()));
    }
}
