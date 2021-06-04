
// Uma SmartBulb tem uma tonalidade (WARM, NEUTRAL, COLD) que pode ser controlada.

public class Avancado extends Jogador {
    public Avancado(){
        super();
    }

    public Avancado(String nomeDoJogador,int numeroDoJogador,
                   int velocidade, int resistencia,int destreza,int impulsao,
                   int jogoDeCabeca,int remate,int passe){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
    }

    public Avancado(Avancado avan){
        super(avan.get_nomeJogador(), avan.get_numeroJogador(),
              avan.get_velocidade(), avan.get_resistencia(),
              avan.get_destreza(), avan.get_impulsao(),
              avan.get_cabeca(),avan.get_remate(),
              avan.get_passe());
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

    public Avancado clone(){
        return new Avancado(this);
    }
}
