import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Formacao implements GameTeams{
    private List<String> posicoes;
    private Map<Integer, Integer> substituicoes;
    private List<Jogador> inicial;
    private List<Jogador> suplentes;
    String equipa;
    int subsDisponiveis;

    public Formacao(){
        this.substituicoes=new Hashtable<>();
        this.subsDisponiveis=3;
    }

    public Formacao(List<String> posicoes,List<Jogador> inicial,List<Jogador> suplentes,String equipa){
        this.substituicoes=new Hashtable<>();
        this.posicoes=posicoes;
        this.inicial=inicial.stream().map(Jogador::clone).collect(Collectors.toList());
        this.suplentes=suplentes.stream().map(Jogador::clone).collect(Collectors.toList());
        this.equipa=equipa;
        this.subsDisponiveis=3;
    }

    public Formacao(Formacao f){
        this.substituicoes=f.getSubstituicoes();
        this.posicoes=f.getPosicoes();
        this.inicial=f.getInicial();
        this.suplentes=f.getSuplentes();
        this.equipa=f.getNomeEquipa();
        this.subsDisponiveis=f.getSubsDisponiveis();
    }

    public int getTeamSkill() {
        int skill=0;
        List<String> estrutura = getEstrutura();
        List<Jogador> jogs= getInicial();
        if(estrutura.size()!=11||jogs.size()!=11) return -1;
        for (int i=0;i<11;i++){
            skill+=calculaSkillPosition(estrutura.get(i),jogs.get(i));
        }
        return (skill/11);
    }

    public int calculaSkillPosition(String position,Jogador j) {
        return switch (position) {
            case "GuardaRedes" -> GuardaRedes.skill(j);
            case "Defesa" -> Defesa.skill(j);
            case "Lateral" -> Lateral.skill(j);
            case "Medio" -> Medio.skill(j);
            case "Avancado" -> Avancado.skill(j);
            default -> -1;
        };

    }

    public void makeSubstituicao(int nJogadorNovo,int nJogadorAntigo) throws JogadorInexistenteExeption, PosicaoInvalidaException {
        this.substituicoes.put(nJogadorAntigo,nJogadorNovo);
        Jogador novo = Jogador.searchForPlayer(this.suplentes,nJogadorNovo);
        Jogador antigo = Jogador.searchForPlayer(this.inicial,nJogadorAntigo);

        int indiceOld=Jogador.searchForPlayerIndice(this.inicial,nJogadorAntigo);
        String pos = this.posicoes.get(indiceOld);

        int indiceNew=Jogador.searchForPlayerIndice(this.suplentes,nJogadorNovo);

        if(calculaSkillPosition(pos,novo)==0)
            throw new PosicaoInvalidaException("Posicao invalida para o jogador");

        this.inicial.remove(indiceOld);
        this.inicial.add(indiceOld,novo);

        this.suplentes.remove(indiceNew);
        this.suplentes.add(indiceNew,antigo);

        this.subsDisponiveis--;
    }

    public int getSubsDisponiveis() {return this.subsDisponiveis;}
    public List<String> getEstrutura() {
        return this.posicoes;
    }
    public String getNomeEquipa() {
        return this.equipa;
    }

    public List<String> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(List<String> posicoes) {
        this.posicoes = posicoes;
    }

    public Map<Integer, Integer> getSubstituicoes() {
        return substituicoes;
    }

    public void setSubstituicoes(Map<Integer, Integer> substituicoes) {
        this.substituicoes = substituicoes;
    }

    public List<Jogador> getInicial() {
        return this.inicial.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public void setInicial(List<Jogador> inicial) {
        this.inicial = inicial.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public List<Jogador> getSuplentes() {
        return this.suplentes.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public void setSuplentes(List<Jogador> suplentes) {
        this.suplentes = suplentes.stream().map(Jogador::clone).collect(Collectors.toList());
    }

    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public abstract GameTeams clone();
}
