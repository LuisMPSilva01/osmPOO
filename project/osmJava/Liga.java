import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Liga {
    private String nome;
    Map<String, Equipa> equipas;
    List<Jogo> jogos;



    public Liga(){
        this.nome = "Europa";
        this.equipas = new HashMap<>();
        this.jogos = new ArrayList<>();
    }
    public static Liga fromParse() throws LinhaIncorretaException {
        Liga l = Parser.parse();
        l.equipas.values().forEach(Equipa::addjogadorHistorial);
        return l;
    }


    public Map<String, Equipa> getEquipas() {
        return this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public void setEquipas(Map<String, Equipa> equipas) {
        this.equipas = equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone()));
    }

    public List<Jogo> getJogos() {
        return this.jogos.stream().map(Jogo::clone).collect(Collectors.toList());
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addicionaEquipa(Equipa e) {
        this.equipas.put(e.getNome(),e);
    }
    public List <String> nomeDasEquipas(){
        return this.getEquipas().values().stream().map(Equipa::getNome).collect(Collectors.toList());
    }

    public void updateJogadoresHistoriais(){
        this.equipas.values().forEach(Equipa::addjogadorHistorial);
    }

    public void removeEquipa(String nomeAtual) throws NomeNaoExisteExceptions{
        if(!this.getEquipas().containsKey(nomeAtual)) throw new NomeNaoExisteExceptions("Nome da equipa invalido");
        else{
            this.equipas.remove(nomeAtual);
        }
    }

    public void mudaNomeDeUmaEquipa(String nomeAtual,String novoNome) throws NomeNaoExisteExceptions,NomeJaExisteException{
        if(this.equipas.containsKey(novoNome)) throw new NomeJaExisteException("Nome da equipa ja existe");
        if(!this.equipas.containsKey(nomeAtual)) throw new NomeNaoExisteExceptions("Nome da equipa invalido");
        else{
            Equipa e=this.equipas.get(nomeAtual).clone();
            this.removeEquipa(nomeAtual);
            e.setNome(novoNome);
            e.addjogadorHistorial();
            this.equipas.put(novoNome,e);
        }
    }

    public void apagaJogador(String equipaAtual,int NumeroJogador) throws NomeNaoExisteExceptions,JogadorInexistenteExeption{
        if(!this.equipas.containsKey(equipaAtual)) throw new NomeNaoExisteExceptions("Equipa inexistente");
        this.equipas.get(equipaAtual).apagaJogador(NumeroJogador);
    }
    public void addJogador(String equipa,Jogador j) throws NomeNaoExisteExceptions{
        if(!this.equipas.containsKey(equipa)) throw new NomeNaoExisteExceptions("Equipa inexistente");
        this.equipas.get(equipa).addJogador(j);
    }

    public void alteraJodadorDeEquipa(int NumeroJogador,String equipaAtual,String novaEquipa) throws NomeNaoExisteExceptions,JogadorInexistenteExeption{
        if(!this.equipas.containsKey(novaEquipa)) throw new NomeNaoExisteExceptions("Equipa inexistente");
        if(this.equipas.get(equipaAtual).getJogador(NumeroJogador)==null) throw new JogadorInexistenteExeption("Jogador inexistente");
        else {
            Jogador j = this.equipas.get(equipaAtual).getJogador(NumeroJogador).clone();
            apagaJogador(equipaAtual,NumeroJogador);
            addJogador(novaEquipa,j);
        }
    }
}

