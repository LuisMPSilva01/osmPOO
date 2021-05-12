import java.util.*;
import java.util.ArrayList;

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

    public boolean equipaValida(Equipa team){
        return (14>=team.jogadores.size());
    }

    public void addJogador(Jogador player){
        if(player instanceof Avancado){
            Avancado avan = (Avancado) player;
            this.jogadores.add(avan.clone());
        }
    }

    public Jogador getJogador(String ID){
        for(Jogador player : this.jogadores){
            if(player.get_ID().equals(ID)) {
                if(player instanceof Avancado){
                    Avancado avan = (Avancado) player;
                    return avan.clone();
                }
            }
        }
        return null;
    }

    public String getNome(){
        return this.nomeDaEquipa;
    }
}

