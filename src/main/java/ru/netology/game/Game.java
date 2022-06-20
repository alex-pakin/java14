package ru.netology.game;

import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public Collection<Player> findAll() {
        return players;
    }

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException
                    ("Игрок с именем " + playerName1 + " не зарегестрирован");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException
                    ("Игрок с именем " + playerName2 + " не зарегестрирован");
        }
        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotRegisteredException
                    ("Игроки с именем " + playerName1 + "," + playerName2 + " не зарегестрированы");
        }

        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() > 0) {
            return 1;
        }
        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() < 0) {
            return 2;
        }
        return 0;
    }
}

