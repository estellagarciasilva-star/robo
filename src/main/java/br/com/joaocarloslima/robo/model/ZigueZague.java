
package br.com.joaocarloslima.robo.model;

public class ZigueZague implements Rota {

    private Direcao horizontal = Direcao.DIREITA;
    private Direcao vertical = Direcao.BAIXO;

    @Override
    public String getNome() {
        return "Zigue-zague";
    }

    @Override
    public Direcao proximaDirecao(Sala sala, Posicao atual) {

        Posicao proxima = atual.mover(horizontal);

        if (!sala.livre(proxima)) {

            if (horizontal == Direcao.DIREITA) {
                horizontal = Direcao.ESQUERDA;
            } else {
                horizontal = Direcao.DIREITA;
            }

            Posicao proximaVertical = atual.mover(vertical);

            if (!sala.livre(proximaVertical)) {

                if (vertical == Direcao.BAIXO) {
                    vertical = Direcao.CIMA;
                } else {
                    vertical = Direcao.BAIXO;
                }
            }

            return vertical;
        }

        return horizontal;
    }
}
