package org.example;

public class TransacaoFactory {

    public static Transacao obterTransacao(String tipo) {
        Class classe = null;
        Object objeto = null;

        try {
            classe = Class.forName("org.example.Transacao" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Transacao Inexistente");
        }

        if(!(objeto instanceof Transacao)) {
            throw new IllegalArgumentException("Transacao Invalida");
        }

        return (Transacao) objeto;
    }
}
