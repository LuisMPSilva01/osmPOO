import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class formacao1433 extends Formacao{

    public formacao1433(List<Jogador> players,String equipa) throws NotEnoughPlayerException{
        super();
        if(players.size()<14) throw new NotEnoughPlayerException("Numero total de jogadores insuficiente");
        else if(Equipa.nGRs(players)<1) throw new NotEnoughPlayerException("Numero de gr insuficiente");
        else if(Equipa.nDefs(players)+Equipa.nMeds(players)+Equipa.nAvans(players)<6)
            throw new NotEnoughPlayerException("Numero de medios/defesas/atacantes insuficientes");
        else if(Equipa.nLats(players)<4) throw new NotEnoughPlayerException("Numero de laterais insuficientes");
        else {

            List<Jogador> inics= new ArrayList<>();
            inics.add(Equipa.getBestGR(players));
            inics.add(Equipa.getBestDef(players));
            inics.add(Equipa.getBestDef(players));
            inics.add(Equipa.getBestLat(players));
            inics.add(Equipa.getBestLat(players));
            inics.add(Equipa.getBestLat(players));
            inics.add(Equipa.getBestLat(players));
            inics.add(Equipa.getBestMed(players));
            inics.add(Equipa.getBestAvan(players));
            inics.add(Equipa.getBestAvan(players));
            inics.add(Equipa.getBestAvan(players));

            super.setInicial(inics);
            super.setPosicoes(Arrays.asList("GuardaRedes","Defesa","Defesa","Lateral","Lateral"
                    ,"Lateral","Lateral","Medio","Avancado","Avancado","Avancado"));
            super.setEquipa(equipa);
            super.setSuplentes(players);
        }
    }
    public formacao1433(formacao1433 f){
        super(f);
    }
    public GameTeams clone(){
        return (GameTeams) new formacao1433(this);
    }
}
