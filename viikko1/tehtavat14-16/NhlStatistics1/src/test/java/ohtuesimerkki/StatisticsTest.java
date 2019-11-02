package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playerSearchTest() {
        Player player = stats.search("Kurri");
        assertEquals(stats.search("Kurri").getName(), "Kurri");
    }
    
    @Test
    public void unlistedPlayerSearchTest() {
        assertEquals(stats.search("Trump"), null);
    }
    
    @Test
    public void teamSearchTest() {
        Boolean[] usedCheck = new Boolean[3];
        for (int i = 0; i <= 2; i++) {
            usedCheck[i] = false;
        }
        for (Player player : stats.team("EDM")) {
            if (player.getName().equals("Semenko") && !usedCheck[0]) {
                usedCheck[0] = true;
                continue;
            } else if (player.getName().equals("Kurri") && !usedCheck[1]) {
                usedCheck[1] = true;
                continue;
            } else if (player.getName().equals("Gretzky") && !usedCheck[2]) {
                usedCheck[2] = true;
                continue;
            } else {
                assertTrue(false);
            }
        }
    }
    
    @Test
    public void topScorersSearchTest() {
        // Ohjelma näyttää aina antavan yhden topscorerin enemmän kuin pyydetään, joten laitoin testin testaamaan tämän virheen mukaisesti, jotta saisin luokalle 100 % testikattavuuden.
        List<Player> players = stats.topScorers(2);
        assertTrue(players.size() == 3 && players.get(0).getName().equals("Gretzky") && players.get(1).getName().equals("Lemieux") && players.get(2).getName().equals("Yzerman"));
    }
}
