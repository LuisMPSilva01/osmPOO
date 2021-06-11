public class GuardaRedes extends Jogador{
    private int elasticidade;

    public GuardaRedes(){
        super();
        this.elasticidade = 0;
    }

    public GuardaRedes(String nomeDoJogador,int numeroDoJogador,
                  int velocidade, int resistencia,int destreza,int impulsao,
                  int jogoDeCabeca,int remate,int passe,int elasticidade){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.elasticidade=elasticidade;
    }

    public GuardaRedes(Jogador j,int elasticidade){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.elasticidade=elasticidade;
    }

    public GuardaRedes(GuardaRedes gr){
        super(gr.get_nomeJogador(), gr.get_numeroJogador(),
                gr.get_velocidade(), gr.get_resistencia(),
                gr.get_destreza(), gr.get_impulsao(),
                gr.get_cabeca(),gr.get_remate(),
                gr.get_passe());
        this.elasticidade=gr.getElasticidade();
    }

    public int getElasticidade() {
        return this.elasticidade;
    }
    public void setElasticidade(int elasticidade) {
        this.elasticidade=elasticidade;
    }


    public GuardaRedes clone(){
        return new GuardaRedes(this);
    }

    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        GuardaRedes gr = (GuardaRedes) o;
        return super.equals(o) && this.elasticidade==gr.getElasticidade();
    }

    public String toString(){
        return "GuardaRedes\n"+super.toString()+"Elastecidade: " + this.getElasticidade() + "\n";
    }

    @Override
    public String posicao(){
        return "GuardaRedes";
    }

    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof GuardaRedes){
            return (int) (((GuardaRedes) j).getElasticidade()*0.3+skillBase);
        }
        else return 0;
    }
}

