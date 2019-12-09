package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        //seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt";
        //ajan tasalla olevat tilastot osoitteessa
        //String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
        
        QueryBuilder query = new QueryBuilder();
 
    Matcher m = query.playsIn("NYR")
                     .hasAtLeast(5, "goals")
                     .hasFewerThan(10, "goals").build();
 
    for (Player player : stats.matches(m)) {
        System.out.println( player );
    }
        
        /*
        Matcher m = new And( new HasAtLeast(5, "goals"),
                             new HasAtLeast(5, "assists"),
                             new PlaysIn("PHI")
        );
        
        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        
        //Laajennukset
        
        Matcher ml1 = new And( 
            new Not( new HasAtLeast(1, "goals") ), 
            new PlaysIn("NYR")
        );
        
        System.out.println("");
        
        for (Player player : stats.matches(ml1)) {
            System.out.println(player);
        }
        
        Matcher ml2 = new Or( new HasAtLeast(20, "goals"),
                              new HasAtLeast(20, "assists")
        );
        
        System.out.println("");
        
        for (Player player : stats.matches(ml2)) {
            System.out.println(player);
        }
        
        Matcher ml3 = new And(
                      new HasAtLeast(20, "points"),
                      new Or( 
                      new PlaysIn("NYR"),
                      new PlaysIn("NYI"),
                      new PlaysIn("NJD")
        )
        );
        
        System.out.println("");
        
        for (Player player : stats.matches(ml3)) {
            System.out.println(player);
        }
        
        //Omat testit
        
        Matcher mo1 = new And( new HasFewerThan(5, "goals"),
                               new HasFewerThan(5, "assists"),
                               new PlaysIn("PHI")
        );
        
        System.out.println("");
        
        for (Player player : stats.matches(mo1)) {
            System.out.println(player);
        }       
        */
    }
}
