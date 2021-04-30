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

    public boolean equipaValida(Equipa team){
        return (11>=team.jogadores.size());
    }

    public void addJogador(Jogador player){
        if(player instanceof Avancado){
            Avancado avan = (Avancado) player;
            this.jogadores.add(avan.clone());
        }
        if(player instanceof Defesa){
            Defesa def = (Defesa) player;
            this.jogadores.add(def.clone());
        }
        if(player instanceof GuardaRedes){
            GuardaRedes gr = (GuardaRedes) player;
            this.jogadores.add(gr.clone());
        }
        if(player instanceof Lateral){
            Lateral lat = (Lateral) player;
            this.jogadores.add(lat.clone());
        }
        if(player instanceof Medio){
            Medio med = (Medio) player;
            this.jogadores.add(med.clone());
        }
    }

    public Jogador getJogador(String ID){
        for(Jogador player : this.jogadores){
            if(player.get_ID().equals(ID)) {
                if(player instanceof Avancado){
                    Avancado avan = (Avancado) player;
                    return avan.clone();
                }
                if(player instanceof Defesa){
                    Defesa def = (Defesa) player;
                    return def.clone();
                }
                if(player instanceof GuardaRedes){
                    GuardaRedes gr = (GuardaRedes) player;
                    return gr.clone();
                }
                if(player instanceof Lateral){
                    Lateral lat = (Lateral) player;
                    return lat.clone();
                }
                if(player instanceof Medio){
                    Medio med = (Medio) player;
                    return med.clone();
                }
            }
        }
        return null;
    }

    public String getNome(){
        return this.nomeDaEquipa;
    }

    public void setNome(String nomeDaEquipa){
        this.nomeDaEquipa=nomeDaEquipa;
    }
}

