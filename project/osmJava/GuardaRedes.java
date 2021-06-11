/**
* A classe GuardaRedes é uma extensão da classe jogador que adiciona 
* certas caracteristicas (variaveis) especificas dete tipo de jogador.
*/

public class GuardaRedes extends Jogador{
    /**
     * Variaveis especificas deste tipo de jogador.
     */
    private int elasticidade;

    /**
     * Este método é usado para criar um GuardaRedes base, sem atributos.
     */
    public GuardaRedes(){
        super();
        this.elasticidade = 0;
    }

    /**
     * Este método é usado para criar um GuardaRedes com os atributos recebidos pela função.
     * 
     * @param nomeDoJogador String com o nome do jogador.
     * @param numeroDoJogador Inteiro com o numero do jogador.
     * @param velocidade Inteiro com a velocidade do jogador.
     * @param resistencia Inteiro com a resistencia do jogador.
     * @param destreza Inteiro com a destreza do jogador.
     * @param impulsao Inteiro com a impulsao do jogador.
     * @param jogoDeCabeca Inteiro com o jogoDeCabeca do jogador.
     * @param remate Inteiro com o remate do jogador.
     * @param passe Inteiro com o passe do jogador.
     * @param elasticidade Inteiro com a elasticidade do jogador.
     */
    public GuardaRedes(String nomeDoJogador,int numeroDoJogador,
                  int velocidade, int resistencia,int destreza,int impulsao,
                  int jogoDeCabeca,int remate,int passe,int elasticidade){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.elasticidade=elasticidade;
    }

    /**
     * Este método é usado para criar um GuardaRedes a partir de um jogador existente e da variavel especifoca do GuardaRedes.
     * 
     * @param j Jogador com os atributos desejados.
     * @param elasticidade Inteiro com o elasticidade do jogador.
     */
    public GuardaRedes(Jogador j,int elasticidade){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.elasticidade=elasticidade;
    }

    /**
     * Este método é usado para criar um GuardaRedes a partir de outro GuardaRedes.
     * 
     * @param gr GuardaRedes do qual serão copiadas as informações.
     */
    public GuardaRedes(GuardaRedes gr){
        super(gr.get_nomeJogador(), gr.get_numeroJogador(),
                gr.get_velocidade(), gr.get_resistencia(),
                gr.get_destreza(), gr.get_impulsao(),
                gr.get_cabeca(),gr.get_remate(),
                gr.get_passe());
        this.elasticidade=gr.getElasticidade();
    }

    /**
     * Este método retorna a caracteristica elasticidade de um GuardaRedes.
     * 
     * @return Inteiro com o elasticidade do GuardaRedes.
     */
    public int getElasticidade() {
        return this.elasticidade;
    }

    /**
     * Este método edita o parâmetro elasticidade de um GuardaRedes.
     * 
     * @param elasticidade Inteiro que será colocado como elasticidade do GuardaRedes.
     */
    public void setElasticidade(int elasticidade) {
        this.elasticidade=elasticidade;
    }

    /**
     * Este método clona um GuardaRedes.
     * 
     * @return GuardaRedes clonado.
     */
    public GuardaRedes clone(){
        return new GuardaRedes(this);
    }

    /**
     * Este método recebe uma string e divide-a nos diverson componentes de um GuardaRedes.
     * 
     * @param input String com características do GuardaRedes.
     * @return GuardaRedes com as características presentes na sring.
     */
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

    /**
     * Este método testa a igualdade entre 2 GuardaRedess.
     * 
     * @param o GuardaRedes que será comparado.
     * @return True se forem iguais, False caso contrário.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        GuardaRedes gr = (GuardaRedes) o;
        return super.equals(o) && this.elasticidade==gr.getElasticidade();
    }

    /**
     * Este método transforma as características de um GuardaRedes numa string.
     * 
     * @return String com as características.
     */
    public String toString(){
        return "GuardaRedes\n"+super.toString()+"Elastecidade: " + this.getElasticidade() + "\n";
    }

    /**
     * Este método retorna uma string com a posição de um jogador.
     * 
     * @return String com a posição de um jogador.
     */
    @Override
    public String posicao(){
        return "GuardaRedes";
    }

    /**
     * Este método calcula a skill de um jogador, mediante as suas características.
     * 
     * @param j Jogador cuja skill será calculada.
     * @return Inteiro correspondente a skill do jogador.
     */
    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof GuardaRedes){
            return (int) (((GuardaRedes) j).getElasticidade()*0.3+skillBase);
        }
        else return 0;
    }
}

