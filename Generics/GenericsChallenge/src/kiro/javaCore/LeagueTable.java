package kiro.javaCore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class LeagueTable<T extends Team>  {

    private ArrayList<T> teamList = new ArrayList<>();

    public boolean addTeam(T team) {
        if (team.numPlayers() < 1)
            return false;

        teamList.add(team);
        return true;
    }

    public void printTeams() {
        Collections.sort(teamList);

        for (T team : teamList) {
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }



}
