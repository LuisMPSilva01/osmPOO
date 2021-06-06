public class Lateral extends Jogador{
    private int cruzamento;

    public Lateral(){
        super();
        this.cruzamento=0;
    }

    public Lateral(String nomeDoJogador,int numeroDoJogador,
                       int velocidade, int resistencia,int destreza,int impulsao,
                       int jogoDeCabeca,int remate,int passe,int cruzamento){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.cruzamento=cruzamento;
    }

    public Lateral(Jogador j,int cruzamento){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.cruzamento=cruzamento;
    }

    public Lateral(Lateral lat){
        super(lat.get_nomeJogador(), lat.get_numeroJogador(),
                lat.get_velocidade(), lat.get_resistencia(),
                lat.get_destreza(), lat.get_impulsao(),
                lat.get_cabeca(),lat.get_remate(),
                lat.get_passe());
        this.cruzamento=lat.getCruzamento();
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }


    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public Lateral clone(){
        return new Lateral(this);
    }

    public String toString(){
        return "Lateral\n"+super.toString()+"Cruzamento: " + this.getCruzamento() + "\n";
    }
    @Override
    public String posicao(){
        return "Lateral";
    }

    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Lateral){
            return (int) (((Lateral) j).getCruzamento()*0.3+skillBase);
        }
        else return 0;
    }
}
