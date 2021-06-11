/**
* A classe Avancado é uma extensão da classe jogador que adiciona 
* certas caracteristicas (variaveis) especificas dete tipo de jogador.
*/

import java.util.concurrent.ThreadLocalRandom;

public class Avancado extends Jogador {
    /**
     * Variaveis especificas deste tipo de jogador.
     */
    private int isolamento;

    /**
     * Este método é usado para criar um Avancado base, sem atributos.
     */
    public Avancado(){
        super();
        isolamento=0;
    }

    /**
     * Este método é usado para criar um Avancado com os atributos recebidos pela função.
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
     * @param isolamento Inteiro com o isolamento do jogador.
     */
    public Avancado(String nomeDoJogador,int numeroDoJogador,
                   int velocidade, int resistencia,int destreza,int impulsao,
                   int jogoDeCabeca,int remate,int passe,int isolamento){
        super(nomeDoJogador,numeroDoJogador,velocidade,resistencia,destreza,impulsao,jogoDeCabeca,remate,passe);
        this.isolamento=isolamento;
    }

    /**
     * Este método é usado para criar um Avancado a partir de um jogador existente e da variavel especifoca do Avancado.
     * 
     * @param j Jogador com os atributos desejados.
     * @param isolamento Inteiro com o isolamento do jogador.
     */
    public Avancado(Jogador j,int isolamento){
        super(j.get_nomeJogador(), j.get_numeroJogador(),
                j.get_velocidade(), j.get_resistencia(),
                j.get_destreza(), j.get_impulsao(),
                j.get_cabeca(),j.get_remate(),
                j.get_passe());
        this.isolamento=isolamento;
    }

    /**
     * Este método é usado para criar um Avancado a partir de outro Avancado.
     * 
     * @param avan Avancado do qual serão copiadas as informações.
     */
    public Avancado(Avancado avan){
        super(avan.get_nomeJogador(), avan.get_numeroJogador(),
              avan.get_velocidade(), avan.get_resistencia(),
              avan.get_destreza(), avan.get_impulsao(),
              avan.get_cabeca(),avan.get_remate(),
              avan.get_passe());
        this.isolamento=avan.getIsolamento();
    }

    /**
     * Este método recebe uma string e divide-a nos diverson componentes de um Avancado.
     * 
     * @param input String com características do Avancado.
     * @return Avancado com as características presentes na sring.
     */
    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
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
     * Este método clona um Avancado.
     * 
     * @return Avancado clonado.
     */
    public Avancado clone(){
        return new Avancado(this);
    }

    /**
     * Este método retorna a caracteristica isolamento de um Avancado.
     * 
     * @return Inteiro com o isolamento do Avancado..
     */
    public int getIsolamento() {
        return isolamento;
    }

    /**
     * Este método edita o parâmetro isolamento de um Avancado.
     * 
     * @param isolamento Inteiro que será colocado como isolamento do Avancado.
     */
    public void setIsolamento(int isolamento) {
        this.isolamento = isolamento;
    }

    /**
     * Este método testa a igualdade entre 2 Avancados.
     * 
     * @param o Avancado que será comparado.
     * @return Truee se forem iguais, False caso contrário.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Avancado avan = (Avancado) o;
        return super.equals(o) && this.isolamento==avan.getIsolamento();
    }

    /**
     * Este método transforma as características de um Avancado numa string.
     * 
     * @return String com as características.
     */
    public String toString(){
        return "Avancado\n" +super.toString()+"Isolamento: " + this.getIsolamento() + "\n";
    }

    /**
     * Este método retorna uma string com a posição de um jogador.
     * 
     * @return String com a posição de um jogador.
     */
    @Override
    public String posicao(){
        return "Avancado";
    }

    /**
     * Este método calcula a skill de um jogador, mediante as suas características.
     * 
     * @param j Jogador cuja skill será calculada.
     * @return Inteiro correspondente a skill do jogador.
     */
    public static int skill(Jogador j){
        int skillBase= (int) (j.overallAsAPlayer()*0.7);
        if (j instanceof Avancado){
            return (int) (((Avancado) j).getIsolamento()*0.3+skillBase);
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
