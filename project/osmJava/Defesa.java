public class Defesa extends Jogador{
    public Defesa(){
        super();
    }

    public Defesa(String nomeDoJogador,int numeroDoJogador,
                    int velocidade, int resistencia,int destreza,int impulsao,
                    int jogoDeCabeca,int remate,int passe){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
    }

    public Defesa(Defesa def){
        super(def.get_nomeJogador(), def.get_numeroJogador(),
                def.get_velocidade(), def.get_resistencia(),
                def.get_destreza(), def.get_impulsao(),
                def.get_cabeca(),def.get_remate(),
                def.get_passe());
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

    public Defesa clone(){
        return new Defesa(this);
    }
}
