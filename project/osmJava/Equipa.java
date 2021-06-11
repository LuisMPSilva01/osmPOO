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
        if(!this.numeroDisponivel(player.get_numeroJogador())) player.set_numeroJogador(this.genarateAvailableNumber());
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

    public static int nGRs(List<Jogador> players){
        return (int) players.stream().filter(j -> j instanceof GuardaRedes).count();
    }
    public static int nDefs(List<Jogador> players){
        return (int) players.stream().filter(j -> j instanceof Defesa).count();
    }
    public static int nLats(List<Jogador> players){
        return (int) players.stream().filter(j -> j instanceof Lateral).count();
    }
    public static int nMeds(List<Jogador> players){
        return (int) players.stream().filter(j -> j instanceof Medio).count();
    }
    public static int nAvans(List<Jogador> players){
        return (int) players.stream().filter(j -> j instanceof Avancado).count();
    }

    public static Jogador getBestGR(List<Jogador> players){
        int i=0;
        int skill=-1;
        Jogador best=null;
        for (int j=0;j<players.size();j++){
            Jogador jug=players.get(j);
            if(GuardaRedes.skill(jug)>skill){
                i=j;
                skill=GuardaRedes.skill(jug);
                best=jug.clone();
            }
        }
        players.remove(i);
        return best;
    }

    public static Jogador getBestDef(List<Jogador> players){
        int i=0;
        int skill=-1;
        Jogador best=null;
        for (int j=0;j<players.size();j++){
            Jogador jug=players.get(j);
            if(Defesa.skill(jug)>skill){
                i=j;
                skill=Defesa.skill(jug);
                best=jug.clone();
            }
        }
        players.remove(i);
        return best;
    }

    public static Jogador getBestMed(List<Jogador> players){
        int i=0;
        int skill=-1;
        Jogador best=null;
        for (int j=0;j<players.size();j++){
            Jogador jug=players.get(j);
            if(Medio.skill(jug)>skill){
                i=j;
                skill=Medio.skill(jug);
                best=jug.clone();
            }
        }
        players.remove(i);
        return best;
    }

    public static Jogador getBestAvan(List<Jogador> players){
        int i=0;
        int skill=-1;
        Jogador best=null;
        for (int j=0;j<players.size();j++){
            Jogador jug=players.get(j);
            if(Avancado.skill(jug)>skill){
                i=j;
                skill=Avancado.skill(jug);
                best=jug.clone();
            }
        }
        players.remove(i);
        return best;
    }
    public static Jogador getBestLat(List<Jogador> players){
        int i=0;
        int skill=-1;
        Jogador best=null;
        for (int j=0;j<players.size();j++){
            Jogador jug=players.get(j);
            if(Lateral.skill(jug)>skill){
                i=j;
                skill=Lateral.skill(jug);
                best=jug.clone();
            }
        }
        players.remove(i);
        return best;
    }

}

