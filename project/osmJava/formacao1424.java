import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class formacao1424 extends Formacao{

    public formacao1424(List<Jogador> players, String equipa) throws NotEnoughPlayerException{
        super();
        if(players.size()<14) throw new NotEnoughPlayerException("Numero total de jogadores insuficiente");
        else if(Equipa.nGRs(players)<1) throw new NotEnoughPlayerException("Numero de gr insuficiente");
        else if(Equipa.nDefs(players)+Equipa.nMeds(players)+Equipa.nAvans(players)<8)
            throw new NotEnoughPlayerException("Numero de medios/defesas/atacantes insuficientes");
        else if(Equipa.nLats(players)<2) throw new NotEnoughPlayerException("Numero de laterais insuficientes");
        else {

            List<Jogador> inics= new ArrayList<>();
            inics.add(Equipa.getBestGR(players));
            inics.add(Equipa.getBestDef(players));
            inics.add(Equipa.getBestDef(players));
            inics.add(Equipa.getBestLat(players));
            inics.add(Equipa.getBestLat(players));
            inics.add(Equipa.getBestMed(players));
            inics.add(Equipa.getBestMed(players));
            inics.add(Equipa.getBestAvan(players));
            inics.add(Equipa.getBestAvan(players));
            inics.add(Equipa.getBestAvan(players));
            inics.add(Equipa.getBestAvan(players));

            super.setInicial(inics);
            super.setPosicoes(Arrays.asList("GuardaRedes","Defesa","Defesa","Lateral","Lateral"
                    ,"Medio","Medio","Avancado","Avancado","Avancado","Avancado"));
            super.setEquipa(equipa);
            super.setSuplentes(players);
        }
    }
    public formacao1424(formacao1424 f){
        super(f);
    }
    public GameTeams clone(){
        return (GameTeams) new formacao1424(this);
    }
}
