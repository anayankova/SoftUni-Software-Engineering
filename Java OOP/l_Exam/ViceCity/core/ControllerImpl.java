package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;
import viceCity.repositories.GunRepository;

public class ControllerImpl implements Controller {

    private GunRepository gunRepository;


    public ControllerImpl() {
    }

    @Override
    public String addPlayer(String name) {
        Player player = null;
        if (CivilPlayer.class.getSimpleName().equals(name)) {
            player = new CivilPlayer(name);
        } else if (MainPlayer.class.getSimpleName().equals(name)){
            player = new MainPlayer();
        }
        String message = String.format("Successfully added civil player: %s!", name);
        return message;
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        String message = "";
        if (Pistol.class.getSimpleName().equals(type)) {
            gun = new Pistol(name);
            message = String.format("Successfully added %s of type: %s", name, type);
            this.gunRepository.add(gun);
        } else if (Rifle.class.getSimpleName().equals(type)){
            gun = new Rifle(name);
            message = String.format("Successfully added %s of type: %s", name, type);
            this.gunRepository.add(gun);
        }else{
            message = "Invalid gun type!";
        }
        return message;
    }

    @Override
    public String addGunToPlayer(String name) {




        String message = String.format("Successfully added %s to the Main Player: Tommy Vercetti", name);
        return message;
    }

    @Override
    public String fight() {
        return null;
    }
}
