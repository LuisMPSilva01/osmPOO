import java.util.List;
import java.util.Map;

public interface GameTeams {
    public String getNomeEquipa();
    public int getSubsDisponiveis();
    public List<Jogador> getInicial();
    public List<Jogador> getSuplentes();
    public void makeSubstituicao(int NewPlayer,int OldPlayer) throws JogadorInexistenteExeption, PosicaoInvalidaException;
    public Map<Integer, Integer> getSubstituicoes();
    public int getTeamSkill();
    public GameTeams clone();
}
