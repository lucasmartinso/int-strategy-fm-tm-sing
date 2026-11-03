import org.example.ConfiguracaoPagamento;
import org.example.Consumidor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsumidorTest {
    @BeforeEach
    void configurar() {
        ConfiguracaoPagamento.getInstance().setTaxaCartao(0.05f);
        ConfiguracaoPagamento.getInstance().setLimiteDinheiro(1000.0f);
    }

    @Test
    void devePagarPix() {
        Consumidor consumidor = new Consumidor();
        Consumidor recebedor = new Consumidor();
        consumidor.pagar(100.0f, recebedor, "Pix");
        assertEquals(true, consumidor.isTransacaoAutorizada());
    }

    @Test
    void devePagarCartao() {
        Consumidor consumidor = new Consumidor();
        Consumidor recebedor = new Consumidor();
        consumidor.pagar(100.0f, recebedor, "Cartao");
        assertEquals(true, consumidor.isTransacaoAutorizada());
    }

    @Test
    void devePagarDinheiro() {
        Consumidor consumidor = new Consumidor();
        Consumidor recebedor = new Consumidor();
        consumidor.pagar(100.0f, recebedor, "Dinheiro");
        assertEquals(true, consumidor.isTransacaoAutorizada());
    }

    @Test
    void naoDevePagarDinheiroAcimaDoLimite() {
        Consumidor consumidor = new Consumidor();
        Consumidor recebedor = new Consumidor();
        consumidor.pagar(1500.0f, recebedor, "Dinheiro");
        assertEquals(false, consumidor.isTransacaoAutorizada());
    }

    @Test
    void deveReceberPix() {
        Consumidor consumidor = new Consumidor();
        Consumidor pagador = new Consumidor();
        consumidor.receber(100.0f, pagador, "Pix");
        assertEquals(true, consumidor.isTransacaoAutorizada());
    }

    @Test
    void deveReceberCartao() {
        Consumidor consumidor = new Consumidor();
        Consumidor pagador = new Consumidor();
        consumidor.receber(100.0f, pagador, "Cartao");
        assertEquals(true, consumidor.isTransacaoAutorizada());
    }

    @Test
    void deveReceberDinheiro() {
        Consumidor consumidor = new Consumidor();
        Consumidor pagador = new Consumidor();
        consumidor.receber(100.0f, pagador, "Dinheiro");
        assertEquals(true, consumidor.isTransacaoAutorizada());
    }

    @Test
    void naoDeveReceberDinheiroAcimaDoLimite() {
        Consumidor consumidor = new Consumidor();
        Consumidor pagador = new Consumidor();
        consumidor.receber(1500.0f, pagador, "Dinheiro");
        assertEquals(false, consumidor.isTransacaoAutorizada());
    }

    @Test
    void deveRetornarExcecaoParaPagamentoInexistente() {
        Consumidor consumidor = new Consumidor();
        Consumidor recebedor = new Consumidor();
        assertThrows(IllegalArgumentException.class,
                () -> consumidor.pagar(100.0f, recebedor, "Boleto"));
    }

    @Test
    void deveRetornarExcecaoParaPagamentoComValorZero() {
        Consumidor consumidor = new Consumidor();
        Consumidor recebedor = new Consumidor();
        assertThrows(IllegalArgumentException.class,
                () -> consumidor.pagar(0, recebedor, "Pix"));
    }
}
