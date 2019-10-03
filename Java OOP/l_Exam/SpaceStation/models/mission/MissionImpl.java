package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.ArrayList;
import java.util.Collection;

public class MissionImpl implements Mission{
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for(Astronaut astronaut : astronauts){
            if(astronaut.getOxygen() > 0){
                for(String item : planet.getItems()){
                    astronaut.breath();
                    astronaut.getBag().getItems().add(item);
                    planet.getItems().remove(item);
                    if(astronaut.getOxygen() <= 0){
                        break;
                    }
                }
            }
        }
    }
}
