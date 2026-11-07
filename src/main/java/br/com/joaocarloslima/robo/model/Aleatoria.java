
package br.com.joaocarloslima.robo.model;

import java.util.Random;

public class Aleatoria implements Rota {

    private Random random = new Random();

    @Override
    public String getNome() {
        return "Aleatória";
    }

    @Override
    public Direcao proximaDirecao(Sala sala, Posicao atual) {

        Direcao[] direcoes = Direcao.values();

        int numero = random.nextInt(direcoes.length);

        return direcoes[numero];
    }
}
