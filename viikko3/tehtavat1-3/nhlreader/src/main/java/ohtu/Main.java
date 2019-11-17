package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        //Choose nationality
        String nationality = "FIN";
        
        System.out.println("Players from " + nationality + " " + LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
        System.out.println("");

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        ArrayList<Player> playerList = new ArrayList<>();
        for (Player player : players) {
            if (player.getNationality().equals(nationality)) {
                playerList.add(player);
            }
        }
        Collections.sort(playerList, Collections.reverseOrder());
        for (Player player : playerList) {
            System.out.println(player);
        }
    }
  
}