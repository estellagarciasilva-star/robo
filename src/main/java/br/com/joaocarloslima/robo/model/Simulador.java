
package br.com.joaocarloslima.robo.model;

import java.util.ArrayList;
import java.util.List;

public class Simulador {

    public static final int LIMITE_PASSOS = 300;

    private static final Posicao BASE = new Posicao(0, 0);

    private Sala sala = new Sala();
    private Robo robo = new Robo(BASE, new Aleatoria());

    private List<Rota> rotas() {

        List<Rota> lista = new ArrayList<>();

        lista.add(new Aleatoria());
        lista.add(new Ricochete());
        lista.add(new ZigueZague());

        return lista;
    }

    public List<String> nomesDasRotas() {

        List<String> nomes = new ArrayList<>();

        for (Rota rota : rotas()) {
            nomes.add(rota.getNome());
        }

        return nomes;
    }

    public void escolherRota(String nome) {

        for (Rota rota : rotas()) {

            if (rota.getNome().equals(nome)) {
                robo.setRota(rota);
                break;
            }
        }
    }

    public boolean passo() {

        if (robo.getPassos() >= LIMITE_PASSOS) {
            return false;
        }

        robo.andar(sala);

        return true;
    }

    public List<Resultado> ranking() {

        List<Resultado> resultados = new ArrayList<>();

        for (Rota rota : rotas()) {

            Sala salaDoTeste = new Sala();

            Robo roboDoTeste = new Robo(BASE, rota);

            for (int i = 0; i < LIMITE_PASSOS; i++) {
                roboDoTeste.andar(salaDoTeste);
            }

            resultados.add(new Resultado(
                    rota.getNome(),
                    salaDoTeste.getPercentualLimpo(),
                    roboDoTeste.getBatidas()
            ));
        }

        return resultados;
    }

    public void reiniciar() {

        String nomeRota = robo.getNomeDaRota();

        sala = new Sala();

        Rota rotaAtual = new Aleatoria();

        for (Rota rota : rotas()) {

            if (rota.getNome().equals(nomeRota)) {
                rotaAtual = rota;
                break;
            }
        }

        robo = new Robo(BASE, rotaAtual);
    }

    public Sala getSala() {
        return sala;
    }

    public Robo getRobo() {
        return robo;
    }
}
