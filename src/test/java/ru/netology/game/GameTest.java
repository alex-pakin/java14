package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.NotRegisteredException;
import ru.netology.domain.Player;

import java.util.Collection;
import java.util.List;

public class GameTest {
    Player player1 = new Player(11,"Alex",20);
    Player player2 = new Player(22,"Alina",45);
    Player player3 = new Player(33,"Sasha",8);
    Player player4 = new Player(44,"Eva",9999);
    Player player5 = new Player(55,"Daniil",20);
    Player player6 = new Player(66,"Andrey",45);
    Player player7 = new Player(77,"Nikita",100);
    Player player8 = new Player(88,"Pavel",666);

    @Test
    void shouldRegisterPlayers () {

        Game players = new Game();
        players.register(player1);
        Collection <Player> actual = players.findAll();
        Collection <Player> expected = List.of(player1);
        Assertions.assertEquals(expected,actual);


        Game players1 = new Game();
        players1.register(player1);
        players1.register(player2);
        players1.register(player3);
        players1.register(player4);
        players1.register(player5);
        players1.register(player6);
        players1.register(player7);
        players1.register(player8);
        Collection <Player> actual1 = players1.findAll();
        Collection <Player> expected1 = List.of(player1,player2,player3,player4,player5,player6,player7,player8);
        Assertions.assertEquals(expected1,actual1);


        Game players2 = new Game();
        Collection <Player> actual2 = players2.findAll();
        Collection <Player> expected2 = List.of();
        Assertions.assertEquals(expected2,actual2);

    }

    @Test
    void shouldThrowNotRegisteredException () {
        Game players = new Game();
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);

        Assertions.assertThrows(NotRegisteredException.class, () -> players.round("James Bond","Alina"));

        Assertions.assertThrows(NotRegisteredException.class, () -> players.round("Alex","Michael Schumacher"));

        Assertions.assertThrows(NotRegisteredException.class, () -> players.round("Cristiano Ronaldo","Lionel Messi"));
    }

    @Test
    void shouldRoundPlayers () {
        Game players = new Game();
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
        players.register(player5);
        players.register(player6);
        players.register(player7);
        players.register(player8);


        int actual = players.round("Alina","Andrey");
        int expected = 0;
        Assertions.assertEquals(expected,actual);

        int actual1 = players.round("Eva","Nikita");
        int expected1 = 1;
        Assertions.assertEquals(expected1,actual1);

        int actual2 = players.round("Daniil","Pavel");
        int expected2 = 2;
        Assertions.assertEquals(expected2,actual2);
    }
}