import java.util.concurrent.ThreadLocalRandom;

public class Defesa extends Jogador{
    private int marcacao;
    public Defesa(){
        super();
        marcacao=0;
    }

    public Defesa(String nomeDoJogador,int numeroDoJogador,
                    int velocidade, int resistencia,int destreza,int impulsao,
                    int jogoDeCabeca,int remate,int passe,int marcacao){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.marcacao=marcacao;
    }

    public Defesa(Jogador j,int marcacao){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.marcacao=marcacao;
    }

    public Defesa(Defesa def){
        super(def.get_nomeJogador(), def.get_numeroJogador(),
                def.get_velocidade(), def.get_resistencia(),
                def.get_destreza(), def.get_impulsao(),
                def.get_cabeca(),def.get_remate(),
                def.get_passe());
        this.marcacao=def.getMarcacao();
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
                Integer.parseInt(campos[8]),
                ThreadLocalRandom.current().nextInt(0, 100+1));
    }

    public Defesa clone(){
        return new Defesa(this);
    }

    public int getMarcacao() {
        return marcacao;
    }

    public void setMarcacao(int marcacao) {
        this.marcacao = marcacao;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Defesa def = (Defesa) o;
        return super.equals(o) && this.marcacao==def.getMarcacao();
    }

    public String toString(){
        return "Defesa\n" +super.toString()+"Marcacao: " + this.getMarcacao() + "\n";
    }

    @Override
    public String posicao(){
        return "Defesa";
    }

    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Defesa){
            return (int) (((Defesa) j).getMarcacao()*0.3+skillBase);
        }
        if (j instanceof Medio){
            return skillBase;
        }
        if (j instanceof Avancado){
            return (int) (skillBase*0.6);
        }
        else return 0;
    }
}
