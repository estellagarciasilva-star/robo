package br.com.joaocarloslima.robo.model;

import java.util.Random;

public class Ricochete implements Rota {

    private Direcao direcao = Direcao.DIREITA;

    private Random random = new Random();

    @Override
    public String getNome() {
        return "Ricochete";
    }

    @Override 
    public Direcao proximaDirecao(Sala sala, Posicao atual){
         
        Posicao proxima = atual.mover(direcao);

        if(!sala.livre(proxima)) {
            Direcao[] direcoes = Direcao.values();

            int numero = random.nextInt(direcoes.length);

            direcao = direcoes[numero];
        }

    return direcao;

    }

}
