/**
* A classe Defesa é uma extensão da classe jogador que adiciona 
* certas caracteristicas (variaveis) especificas dete tipo de jogador.
*/

import java.util.concurrent.ThreadLocalRandom;

public class Defesa extends Jogador{
    /**
     * Variaveis especificas deste tipo de jogador.
     */
    private int marcacao;

    /**
     * Este método é usado para criar um Defesa base, sem atributos.
     */
    public Defesa(){
        super();
        marcacao=0;
    }

    /**
     * Este método é usado para criar um Defesa com os atributos recebidos pela função.
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
     * @param marcacao Inteiro com a marcacao do jogador.
     */
    public Defesa(String nomeDoJogador,int numeroDoJogador,
                    int velocidade, int resistencia,int destreza,int impulsao,
                    int jogoDeCabeca,int remate,int passe,int marcacao){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.marcacao=marcacao;
    }

    /**
     * Este método é usado para criar um Defesa a partir de um jogador existente e da variavel especifoca do Defesa.
     * 
     * @param j Jogador com os atributos desejados.
     * @param marcacao Inteiro com o marcacao do jogador.
     */
    public Defesa(Jogador j,int marcacao){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.marcacao=marcacao;
    }

    /**
     * Este método é usado para criar um Defesa a partir de outro Defesa.
     * 
     * @param def Defesa do qual serão copiadas as informações.
     */
    public Defesa(Defesa def){
        super(def.get_nomeJogador(), def.get_numeroJogador(),
                def.get_velocidade(), def.get_resistencia(),
                def.get_destreza(), def.get_impulsao(),
                def.get_cabeca(),def.get_remate(),
                def.get_passe());
        this.marcacao=def.getMarcacao();
    }

    /**
     * Este método recebe uma string e divide-a nos diverson componentes de um Defesa.
     * 
     * @param input String com características do Defesa.
     * @return Defesa com as características presentes na sring.
     */
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

    /**
     * Este método clona um Defesa.
     * 
     * @return Defesa clonado.
     */
    public Defesa clone(){
        return new Defesa(this);
    }

    /**
     * Este método retorna a caracteristica marcacao de um Defesa.
     * 
     * @return Inteiro com o marcacao do Defesa.
     */
    public int getMarcacao() {
        return marcacao;
    }

    /**
     * Este método edita o parâmetro marcacao de um Defesa.
     * 
     * @param marcacao Inteiro que será colocado como marcacao do Defesa.
     */
    public void setMarcacao(int marcacao) {
        this.marcacao = marcacao;
    }

    /**
     * Este método testa a igualdade entre 2 Defesas.
     * 
     * @param o Defesa que será comparado.
     * @return True se forem iguais, False caso contrário.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Defesa def = (Defesa) o;
        return super.equals(o) && this.marcacao==def.getMarcacao();
    }

    /**
     * Este método transforma as características de um Defesa numa string.
     * 
     * @return String com as características.
     */
    public String toString(){
        return "Defesa\n" +super.toString()+"Marcacao: " + this.getMarcacao() + "\n";
    }

    /**
     * Este método retorna uma string com a posição de um jogador.
     * 
     * @return String com a posição de um jogador.
     */
    @Override
    public String posicao(){
        return "Defesa";
    }

    /**
     * Este método calcula a skill de um jogador, mediante as suas características.
     * 
     * @param j Jogador cuja skill será calculada.
     * @return Inteiro correspondente a skill do jogador.
     */
    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Defesa){
            return (int) (((Defesa) j).getMarcacao()*0.3+skillBase);
        }
        if (j instanceof Medio){
            return skillBase;
        }
        if (j instanceof Defesa){
            return (int) (skillBase*0.6);
        }
        else return 0;
    }
}
