/**
* A classe jogador é uma extensão da classe jogador que adiciona 
* certas caracteristicas (variaveis) especificas dete tipo de jogador.
*/

import java.util.ArrayList;
import java.util.List;

public class Jogador {
    /**
     * Parâmetros da classe jogador.
     */
    private List<String> historial;
    private String nomeJogador;
    private int numeroJogador;
    private int velocidade, resistencia, destreza, impulsao, cabeca, remate, passe;
    
    /**
     * Este método é usado para criar um jogador base, sem atributos.
     */
    public Jogador(){
        this.nomeJogador ="";
        this.numeroJogador = 0;
        this.velocidade=0;
        this.resistencia=0;
        this.destreza=0;
        this.impulsao=0;
        this.cabeca=0;
        this.remate=0;
        this.passe=0;
        this.historial=new ArrayList<String>();
    }

    /**
     * Este método é usado para criar um jogador com os atributos recebidos pela função.
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
     */
    public Jogador(String nomeDoJogador,int numeroDoJogador,
                   int velocidade, int resistencia,int destreza,int impulsao,
                   int jogoDeCabeca,int remate,int passe){
        this.nomeJogador = nomeDoJogador;
        this.numeroJogador = numeroDoJogador;
        this.velocidade=velocidade;
        this.resistencia=resistencia;
        this.destreza=destreza;
        this.impulsao=impulsao;
        this.cabeca=jogoDeCabeca;
        this.remate=remate;
        this.passe=passe;
        this.historial= new ArrayList<String>();
    }
    
    /**
     * Este método é usado para criar um jogador a partir de outro jogador.
     * 
     * @param player jogador do qual serão copiadas as informações.
     */
    public Jogador(Jogador player){
        this.nomeJogador = player.get_nomeJogador();
        this.numeroJogador = player.get_numeroJogador();
        this.velocidade= player.get_velocidade();
        this.resistencia=player.get_resistencia();
        this.destreza=player.get_destreza();
        this.impulsao=player.get_impulsao();
        this.cabeca=player.get_cabeca();
        this.remate=player.get_remate();
        this.passe=player.get_passe();
        this.historial=player.getHistorial();
    }

//////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Este método retorna a caracteristica nomeJogador de um jogador.
     * 
     * @return String com o nomeJogador do jogador.
     */
    public String get_nomeJogador(){
        return this.nomeJogador;
    }

    /**
     * Este método retorna a caracteristica numeroJogador de um jogador.
     * 
     * @return Inteiro com o numero do jogador.
     */
    public int get_numeroJogador(){
        return this.numeroJogador;
    };

    /**
     * Este método retorna a caracteristica velocidade de um jogador.
     * 
     * @return Inteiro com o velocidade do jogador.
     */
    public int get_velocidade(){
        return this.velocidade;
    }

    /**
     * Este método retorna a caracteristica resistencia de um jogador.
     * 
     * @return Inteiro com o resistencia do jogador.
     */
    public int get_resistencia(){
        return this.resistencia;
    }

    /**
     * Este método retorna a caracteristica destreza de um jogador.
     * 
     * @return Inteiro com o destreza do jogador.
     */
    public int get_destreza(){
        return this.destreza;
    }

    /**
     * Este método retorna a caracteristica impulsao de um jogador.
     * 
     * @return Inteiro com o impulsao do jogador.
     */
    public int get_impulsao(){
        return this.impulsao;
    }

    /**
     * Este método retorna a caracteristica cabeca de um jogador.
     * 
     * @return Inteiro com o cabeca do jogador.
     */
    public int get_cabeca(){
        return this.cabeca;
    }

    /**
     * Este método retorna a caracteristica remate de um jogador.
     * 
     * @return Inteiro com o remate do jogador.
     */
    public int get_remate(){
        return this.remate;
    }

    /**
     * Este método retorna a caracteristica passe de um jogador.
     * 
     * @return Inteiro com o passe do jogador.
     */
    public int get_passe(){
        return this.passe;
    }

    /**
     * Este método retorna a caracteristica historial de um jogador.
     * 
     * @return Lista com o historial do jogador.
     */
    public List<String> getHistorial(){
        return new ArrayList<String>(this.historial);
    }

////////////////////////////////////////////////////////////////////////////////77

    public void set_nomeJogador(String nomeJogador){
        this.nomeJogador=nomeJogador;
    }

    /**
     * Este método edita o parâmetro numeroJogador de um jogador.
     * 
     * @param numeroJogador Inteiro que será colocado como numeroJogador do jogador.
     */
    public void set_numeroJogador(int numeroJogador){
        this.numeroJogador=numeroJogador;
    }

    /**
     * Este método edita o parâmetro velocidade de um jogador.
     * 
     * @param velocidade Inteiro que será colocado como velocidade do jogador.
     */
    public void set_velocidade(int velocidade){
        this.velocidade=velocidade;
    }

    /**
     * Este método edita o parâmetro resistencia de um jogador.
     * 
     * @param resistencia Inteiro que será colocado como resistencia do jogador.
     */
    public void set_resistencia(int resistencia){
        this.resistencia=resistencia;
    }

    /**
     * Este método edita o parâmetro destreza de um jogador.
     * 
     * @param destreza Inteiro que será colocado como destreza do jogador.
     */
    public void set_destreza(int destreza){
        this.destreza=destreza;
    }

    /**
     * Este método edita o parâmetro impulsao de um jogador.
     * 
     * @param impulsao Inteiro que será colocado como impulsao do jogador.
     */
    public void set_impulsao(int impulsao){
        this.impulsao=impulsao;
    }

    /**
     * Este método edita o parâmetro jogoDeCabeca de um jogador.
     * 
     * @param jogoDeCabeca Inteiro que será colocado como jogoDeCabeca do jogador.
     */
    public void set_jogoDeCabeca(int jogoDeCabeca){
        this.cabeca=jogoDeCabeca;
    }
    
    /**
     * Este método edita o parâmetro remate de um jogador.
     * 
     * @param remate Inteiro que será colocado como remate do jogador.
     */
    public void set_remate(int remate){
        this.remate=remate;
    }

    /**
     * Este método edita o parâmetro passe de um jogador.
     * 
     * @param passe Inteiro que será colocado como passe do jogador.
     */
    public void set_passe(int passe){
        this.passe=passe;
    }

////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Este método procura um jogador numa lista de jogadores.
     * 
     * @param jogadores Lista de jogadores.
     * @param nJogador Numero do jogador pretendido.
     * @return Jogador pretendido.
     * @throws JogadorInexistenteExeption Input error.
     */
    public static Jogador searchForPlayer(List<Jogador> jogadores,int nJogador) throws JogadorInexistenteExeption{
        Jogador j=null;
        for (Jogador player: jogadores){
            if (player.get_numeroJogador()==nJogador) {
                j=player;
                break;
            }
        }
        if (j==null) throw new JogadorInexistenteExeption("Jogador nao encontrado");
        else return j.clone();
    }

    /**
     * Este método procura pelo indice de um jogador numa lista de jogadores.
     * 
     * @param jogadores Lista de jogadores.
     * @param nJogador Numero do jogador pretendido.
     * @return Inteiro correspondete ai indice do jogador.
     * @throws JogadorInexistenteExeption Input error.
     */
    public static int searchForPlayerIndice(List<Jogador> jogadores,int nJogador) throws JogadorInexistenteExeption{
        int i=-1;
        int j=0;
        for (Jogador player: jogadores){
            if (player.get_numeroJogador()==nJogador) {
                i=j;
                break;
            }
            j++;
        }
        if (i==-1) throw new JogadorInexistenteExeption("Jogador nao encontrado");
        else return i;
    }

    /**
     * Este método clona um jogador.
     * 
     * @return Jogador clonado.
     */
    public Jogador clone(){
        return new Jogador(this);
    }

    /**
     * Este método testa a igualdade entre 2 jogadores.
     * 
     * @param o Jogador que será comparado.
     * @return True se forem iguais, False caso contrário.
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if(this.getClass() != o.getClass()) return false;
        Jogador j = (Jogador) o;
        return this.get_nomeJogador().equals(j.get_nomeJogador()) &&
               this.get_numeroJogador()==j.get_numeroJogador() &&
               this.get_velocidade()==j.get_velocidade() &&
               this.get_resistencia()==j.get_resistencia() &&
               this.get_destreza()==j.get_destreza() &&
               this.get_impulsao()==j.get_impulsao() &&
               this.get_cabeca()==j.get_cabeca() &&
               this.get_remate()==j.get_remate() &&
               this.get_passe()==j.get_passe();
    }

    /**
     * Este método transforma as características de um jogador numa string.
     * 
     * @return String com as características.
     */
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: ").append(this.get_nomeJogador()).append(";\n");
        sb.append("Numero: ").append(this.get_numeroJogador()).append(";\n");
        sb.append("Velocidade: ").append(this.get_velocidade()).append(";\n");
        sb.append("Resistencia: ").append(this.get_resistencia()).append(";\n");
        sb.append("Destreza: ").append(this.get_destreza()).append("\n");
        sb.append("Impulsao: ").append(this.get_impulsao()).append("\n");
        sb.append("Cabeca: ").append(this.get_cabeca()).append("\n");
        sb.append("Remate: ").append(this.get_remate()).append("\n");
        sb.append("Passe: ").append(this.get_passe()).append("\n");
        return sb.toString();
    }

    /**
     * Este método adiciona o nome de uma equipa ao historial do jogador.
     * 
     * @param nomeEquipa String com o nome da equipa a adicionar.
     */
    public void addToHistorial(String nomeEquipa){
        this.historial.add(nomeEquipa);
    }

    /**
     * Este método calcula a skill de um jogador, mediante as suas características.
     * 
     * @param j Jogador cuja skill será calculada.
     * @return Inteiro correspondente a skill do jogador.
     */
    public int overallAsAPlayer(){
        return (velocidade+resistencia+destreza+impulsao+cabeca+remate+passe)/7;
    }

    /**
     * Este método retorna uma string com a posição de um jogador.
     * 
     * @return String com a posição de um jogador.
     */
    public String posicao(){
        return "Nao alocado";
    }
}
