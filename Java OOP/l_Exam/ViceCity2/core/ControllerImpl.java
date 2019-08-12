package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER_FAMILY_NAME = "Vercetti";
    private Player mainPlayer;
    private List<Player> players;
    private Deque<Gun> gunQueue;
    private Neighbourhood gangNeighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.players = new ArrayList<>();
        this.gunQueue = new ArrayDeque<>();
        this.gangNeighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.players.add(player);
        return String.format(ConstantMessages.PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        String output;
        Gun gun = this.createGun(type, name);

        if (gun != null) {
            output = String.format(ConstantMessages.GUN_ADDED, name, type);
            this.addGunToQueue(gun);
        } else {
            output = ConstantMessages.GUN_TYPE_INVALID;
        }
        return output;
    }

    private void addGunToQueue(Gun gun) {
        this.gunQueue.offer(gun);
    }

    private Gun createGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        }
        return gun;
    }

    private boolean hasAvailableGuns() {
        return !this.gunQueue.isEmpty();
    }

    @Override
    public String addGunToPlayer(String name) {
        if (!this.hasAvailableGuns()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }
        Gun gun;
        if (name.equals(MAIN_PLAYER_FAMILY_NAME)) {
            gun = this.getAGunFromQueue();
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), this.mainPlayer.getName());
        }

        Player player = this.getPlayerByName(name);
        String output;

        if (player != null) {
            gun = this.getAGunFromQueue();
            player.getGunRepository().add(gun);
            output = String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
        } else {
            output = ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
        }
        return output;
    }

    private Gun getAGunFromQueue() {
        return this.gunQueue.poll();
    }

    private Collection<Player> getAllCivilPlayers() {
        return Collections.unmodifiableCollection(this.players);
    }

    private Player getPlayerByName(String name) {
        Player player = null;
        for (Player currentPlayer : this.getAllCivilPlayers()) {
            if (currentPlayer.getName().equals(name)) {
                player = currentPlayer;
                break;
            }
        }
        return player;
    }

    @Override
    public String fight() {
        int initialMainPlayerHP = this.mainPlayer.getLifePoints();
        int initialCiviliansHP = this.calculateAllCivilianHealthPoints();

        this.gangNeighbourhood.action(this.mainPlayer, this.getAllCivilPlayers());

        String output = this.postActionReport(initialMainPlayerHP, initialCiviliansHP);
        return output;
    }

    private int calculateAllCivilianHealthPoints() {
        int healthPoints = 0;
        for (Player civilian : this.getAllCivilPlayers()) {
            healthPoints += civilian.getLifePoints();
        }
        return healthPoints;
    }

    private String postActionReport(int initialMainPlayerHP, int initialCiviliansHP) {
        int afterFightMainPlayerHP = this.mainPlayer.getLifePoints();
        int afterFightCiviliansHP = this.calculateAllCivilianHealthPoints();

        boolean noFightingOccurred = initialMainPlayerHP == afterFightMainPlayerHP
                && initialCiviliansHP == afterFightCiviliansHP;

        if (noFightingOccurred) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            return this.getFightStats();
        }
    }

    private String getFightStats() {
        int allCiviliansCount = this.getCivilianPlayersCount();
        this.removeDeadCivilians();
        int killedCivilians = allCiviliansCount - this.getCivilianPlayersCount();

        StringBuilder report = new StringBuilder();
        report
                .append(ConstantMessages.FIGHT_HAPPENED)
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, killedCivilians))
                .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, this.players.size()));

        return report.toString();
    }

    private int getCivilianPlayersCount () {
        return this.players.size();
    }

    private void removeDeadCivilians() {
        this.players.removeIf(player -> !player.isAlive());
    }
}