
package ohtu;

public class Player implements Comparable<Player> {
    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }
    
    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return name + " " + team + " " + goals + "+" + assists + "=" + this.getPoints();
    }

    @Override
    public int compareTo(Player o) {
        if (this.getPoints() > o.getPoints()) {
            return 1;
        } else if (this.getPoints() < o.getPoints()) {
            return -1;
        } else {
            return 0;
        }
    }
      
}
