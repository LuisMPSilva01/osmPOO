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

    public Equipa clone(){
        return new Equipa(this);
    }
}

