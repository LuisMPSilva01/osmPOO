/**
* A classe Medio é uma extensão da classe jogador que adiciona 
* certas caracteristicas (variaveis) especificas dete tipo de jogador.
*/

public class Medio extends Jogador{
    /**
     * Variaveis especificas deste tipo de jogador.
     */
    private int recuperacao;

    /**
     * Este método é usado para criar um Medio base, sem atributos.
     */
    public Medio(){
        super();
    }

    /**
     * Este método é usado para criar um Medio com os atributos recebidos pela função.
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
     * @param recuperacao Inteiro com a recuperacao do jogador.
     */
    public Medio(String nomeDoJogador,int numeroDoJogador,
                    int velocidade, int resistencia,int destreza,int impulsao,
                    int jogoDeCabeca,int remate,int passe,int recuperacao){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.recuperacao=recuperacao;
    }

    /**
     * Este método é usado para criar um Medio a partir de um jogador existente e da variavel especifoca do Medio.
     * 
     * @param j Jogador com os atributos desejados.
     * @param recuperacao Inteiro com o recuperacao do jogador.
     */
    public Medio(Jogador j,int recuperacao){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.recuperacao=recuperacao;
    }

    /**
     * Este método é usado para criar um Medio a partir de outro Medio.
     * 
     * @param med Medio do qual serão copiadas as informações.
     */
    public Medio(Medio med){
        super(med.get_nomeJogador(), med.get_numeroJogador(),
                med.get_velocidade(), med.get_resistencia(),
                med.get_destreza(), med.get_impulsao(),
                med.get_cabeca(),med.get_remate(),
                med.get_passe());
        this.recuperacao=med.recuperacao;
    }

    /**
     * Este método retorna a caracteristica recuperacao de um Medio.
     * 
     * @return Inteiro com o recuperacao do Medio.
     */
    public int getRecuperacao() {
        return recuperacao;
    }

    /**
     * Este método edita o parâmetro recuperacao de um Medio.
     * 
     * @param recuperacao Inteiro que será colocado como recuperacao do Medio.
     */
    public void setRecuperacao(int recuperacao) {
        this.recuperacao = recuperacao;
    }

    /**
     * Este método recebe uma string e divide-a nos diverson componentes de um Medio.
     * 
     * @param input String com características do Medio.
     * @return Medio com as características presentes na sring.
     */
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

    /**
     * Este método clona um Medio.
     * 
     * @return Medio clonado.
     */
    public Medio clone(){
        return new Medio(this);
    }

    /**
     * Este método transforma as características de um Medio numa string.
     * 
     * @return String com as características.
     */
    public String toString(){
        return "Medio\n"+super.toString()+"Recuperacao: " + this.getRecuperacao() + "\n";
    }

    /**
     * Este método retorna uma string com a posição de um jogador.
     * 
     * @return String com a posição de um jogador.
     */
    @Override
    public String posicao(){
        return "Medio";
    }

    /**
     * Este método calcula a skill de um jogador, mediante as suas características.
     * 
     * @param j Jogador cuja skill será calculada.
     * @return Inteiro correspondente a skill do jogador.
     */
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
