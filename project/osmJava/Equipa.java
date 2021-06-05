import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Equipa {
    private String nomeDaEquipa;
    private List<Jogador> jogadores;

    public Equipa(){
        this.nomeDaEquipa = "";
        this.jogadores = new ArrayList<>();
    }

    public Equipa(String nomeDaEquipa){
        this.nomeDaEquipa = nomeDaEquipa;
        this.jogadores = new ArrayList<>();
    }

    public Equipa(Equipa eq){
        this.nomeDaEquipa = eq.getNome();
        this.jogadores = eq.getJogadores();
    }

    public boolean equipaValida(Equipa team){
        return (11>=team.jogadores.size());
    }

    public void addJogador(Jogador player){
        player.addToHistorial(this.nomeDaEquipa);
        this.jogadores.add(player.clone());
    }

    public Jogador getJogador(int numero){
        Jogador j=null;
        for (int i=0;i<this.jogadores.size();i++){
            if(numero==this.jogadores.get(i).get_numeroJogador()) return j=this.jogadores.get(i).clone();
        }
        return j;
    }


    public List<Jogador> getJogadores(){
        return this.jogadores.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public String getNome(){
        return this.nomeDaEquipa;
    }

    public void setNome(String nomeDaEquipa){
        this.nomeDaEquipa=nomeDaEquipa;
    }

    public void apagaJogador(int numero){
        for (int i=0;i<this.jogadores.size();i++){
            if(this.jogadores.get(i).get_numeroJogador()==numero){
                this.jogadores.remove(i);
                break;
            }
        }
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public String toString(){
        String r =  "Equipa:" + this.nomeDaEquipa + "\n";
        for (Jogador j : jogadores){
            r += j.toString();
        }
        return r;
    }

    public void addjogadorHistorial(){
        for(int i=0;i<this.jogadores.size();i++){
            List<String> historial = this.jogadores.get(i).getHistorial();
            if(historial.size()==0 || !historial.get(historial.size()-1).equals(this.nomeDaEquipa))
                this.jogadores.get(i).addToHistorial(nomeDaEquipa);
        }
    }

    public Equipa clone(){
        return new Equipa(this);
    }

    public List<Integer> numerosDisponiveis(){
        List<Integer> lista = new ArrayList<>();
        for (int i=1;i<200;i++){
            lista.add(i);
        }
        List<Integer> ocupados =this.jogadores.stream().map(Jogador::get_numeroJogador).collect(Collectors.toList());
        lista = lista.stream().filter(i->!(ocupados.contains(i))).collect(Collectors.toList());
        return lista;
    }

    public boolean numeroDisponivel(int n){
        return this.numerosDisponiveis().contains(n);
    }
    public int genarateAvailableNumber(){
        return this.numerosDisponiveis().get(0);
    }
}

