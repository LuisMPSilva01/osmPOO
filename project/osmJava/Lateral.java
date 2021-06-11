/**
* A classe Lateral é uma extensão da classe jogador que adiciona 
* certas caracteristicas (variaveis) especificas dete tipo de jogador.
*/

public class Lateral extends Jogador{
    /**
     * Variaveis especificas deste tipo de jogador.
     */
    private int cruzamento;

    /**
     * Este método é usado para criar um Lateral base, sem atributos.
     */
    public Lateral(){
        super();
        this.cruzamento=0;
    }

    /**
     * Este método é usado para criar um Lateral com os atributos recebidos pela função.
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
     * @param cruzamento Inteiro com a cruzamento do jogador.
     */
    public Lateral(String nomeDoJogador,int numeroDoJogador,
                       int velocidade, int resistencia,int destreza,int impulsao,
                       int jogoDeCabeca,int remate,int passe,int cruzamento){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.cruzamento=cruzamento;
    }

    /**
     * Este método é usado para criar um Lateral a partir de um jogador existente e da variavel especifoca do Lateral.
     * 
     * @param j Jogador com os atributos desejados.
     * @param cruzamento Inteiro com o cruzamento do jogador.
     */
    public Lateral(Jogador j,int cruzamento){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.cruzamento=cruzamento;
    }

    /**
     * Este método é usado para criar um Lateral a partir de outro Lateral.
     * 
     * @param lat Lateral do qual serão copiadas as informações.
     */
    public Lateral(Lateral lat){
        super(lat.get_nomeJogador(), lat.get_numeroJogador(),
                lat.get_velocidade(), lat.get_resistencia(),
                lat.get_destreza(), lat.get_impulsao(),
                lat.get_cabeca(),lat.get_remate(),
                lat.get_passe());
        this.cruzamento=lat.getCruzamento();
    }

    /**
     * Este método retorna a caracteristica cruzamento de um Lateral.
     * 
     * @return Inteiro com o cruzamento do Lateral.
     */
    public int getCruzamento() {
        return cruzamento;
    }

    /**
     * Este método edita o parâmetro cruzamento de um Lateral.
     * 
     * @param cruzamento Inteiro que será colocado como cruzamento do Lateral.
     */
    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    /**
     * Este método recebe uma string e divide-a nos diverson componentes de um Lateral.
     * 
     * @param input String com características do Lateral.
     * @return Lateral com as características presentes na sring.
     */
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

    /**
     * Este método clona um Lateral.
     * 
     * @return Lateral clonado.
     */
    public Lateral clone(){
        return new Lateral(this);
    }

    /**
     * Este método transforma as características de um Lateral numa string.
     * 
     * @return String com as características.
     */
    public String toString(){
        return "Lateral\n"+super.toString()+"Cruzamento: " + this.getCruzamento() + "\n";
    }

    /**
     * Este método retorna uma string com a posição de um jogador.
     * 
     * @return String com a posição de um jogador.
     */
    @Override
    public String posicao(){
        return "Lateral";
    }

    /**
     * Este método calcula a skill de um jogador, mediante as suas características.
     * 
     * @param j Jogador cuja skill será calculada.
     * @return Inteiro correspondente a skill do jogador.
     */
    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Lateral){
            return (int) (((Lateral) j).getCruzamento()*0.3+skillBase);
        }
        else return 0;
    }
}
