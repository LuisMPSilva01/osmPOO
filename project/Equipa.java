import java.util.*;
import java.util.stream.Collectors;

public class Equipa {
    private String nomeDaEquipa;
    private List<Jogador> jogadores;

    public Equipa(){
        this.morada       = "";
        this.dispositivos = new ArrayList<>();
        this.rooms        = new HashMap<>();
    }

    public Equipa(String morada){
        this.morada       = morada;
        this.dispositivos = new ArrayList<>();
        this.rooms        = new HashMap<>();
    }

    public boolean existsDevice(String id){
        return this.dispositivos.stream()
                                .anyMatch(d -> id.equals(d.getID()));
    }

    public void addDevice(Jogador sd){
        if(sd instanceof SmartSpeaker){
            SmartSpeaker ss = (SmartSpeaker) sd;
            this.dispositivos.add(ss.clone());
        }
        else if(sd instanceof Avancado){
            Avancado sb = (Avancado) sd;
            this.dispositivos.add(sb.clone());
        }
    }

    public Jogador getDevice(String id){
        for(Jogador sd : this.dispositivos){
            if(sd.getID().equals(id)) {
                Jogador s;
                if(sd instanceof SmartSpeaker){
                    SmartSpeaker ss = (SmartSpeaker) sd;
                    return ss.clone();
                }
                else if(sd instanceof Avancado){
                    Avancado sb = (Avancado) sd;
                    return sb.clone();
                }
            }
        }
        return null;
    }

    public void setAllOn (boolean b){
        if(b) this.dispositivos.stream().forEach(sd -> sd.setOn(true));
        else  this.dispositivos.stream().forEach(sd -> sd.setOn(false));
    }

    public boolean hasRoom (String room){
        return this.rooms.containsKey(room);
    }

    public void addRoom (String room){
        if(this.hasRoom(room) == false) {
            List<String> list = new ArrayList<>();
            this.rooms.put(room, list);
        }
    }

    public boolean roomHasDevice (String room, String id){
        if(this.hasRoom(room) == true && this.existsDevice(id) == true){
            return this.rooms.get(room).contains(id);
        }
        else return false;
    }

    public void addToRoom (String room, String id){
        if(this.roomHasDevice(room, id) == false)
            this.rooms.get(room).add(id);
    }
}
