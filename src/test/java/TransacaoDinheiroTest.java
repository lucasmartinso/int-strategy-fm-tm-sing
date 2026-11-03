import org.example.ConfiguracaoPagamento;
import org.example.Consumidor;
import org.example.TransacaoDinheiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransacaoDinheiroTest {
    @BeforeEach
    void configurar() {
        ConfiguracaoPagamento.getInstance().setLimiteDinheiro(1000.0f);
    }

    @Test
    void deveCalcularValorTotalSemTaxa() {
        TransacaoDinheiro transacao = new TransacaoDinheiro();
        assertEquals(100.0f, transacao.calcularValorTotal(100.0f));
    }

    @Test
    void deveAutorizarTransacaoDentroDoLimite() {
        TransacaoDinheiro transacao = new TransacaoDinheiro();
        assertEquals(true, transacao.executar(100.0f, new Consumidor(), new Consumidor()));
    }

    @Test
    void deveAutorizarTransacaoIgualAoLimite() {
        TransacaoDinheiro transacao = new TransacaoDinheiro();
        assertEquals(true, transacao.executar(1000.0f, new Consumidor(), new Consumidor()));
    }

    @Test
    void deveNegarTransacaoAcimaDoLimite() {
        TransacaoDinheiro transacao = new TransacaoDinheiro();
        assertEquals(false, transacao.executar(1500.0f, new Consumidor(), new Consumidor()));
    }

    @Test
    void deveRetornarExcecaoParaValorZero() {
        TransacaoDinheiro transacao = new TransacaoDinheiro();
        assertThrows(IllegalArgumentException.class,
                () -> transacao.executar(0, new Consumidor(), new Consumidor()));
    }
}
