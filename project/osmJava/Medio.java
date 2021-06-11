public class Medio extends Jogador{
    private int recuperacao;
    public Medio(){
        super();
    }

    public Medio(String nomeDoJogador,int numeroDoJogador,
                    int velocidade, int resistencia,int destreza,int impulsao,
                    int jogoDeCabeca,int remate,int passe,int recuperacao){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.recuperacao=recuperacao;
    }

    public Medio(Jogador j,int recuperacao){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.recuperacao=recuperacao;
    }

    public Medio(Medio med){
        super(med.get_nomeJogador(), med.get_numeroJogador(),
                med.get_velocidade(), med.get_resistencia(),
                med.get_destreza(), med.get_impulsao(),
                med.get_cabeca(),med.get_remate(),
                med.get_passe());
        this.recuperacao=med.recuperacao;
    }

    public int getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(int recuperacao) {
        this.recuperacao = recuperacao;
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public Medio clone(){
        return new Medio(this);
    }

    public String toString(){
        return "Medio\n"+super.toString()+"Recuperacao: " + this.getRecuperacao() + "\n";
    }

    @Override
    public String posicao(){
        return "Medio";
    }

    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Medio){
            return (int) (((Medio) j).get_cabeca()*0.3+skillBase);
        }
        if (j instanceof Avancado){
            return skillBase;
        }
        if (j instanceof Defesa){
            return skillBase;
        }
        else return 0;
    }
}
