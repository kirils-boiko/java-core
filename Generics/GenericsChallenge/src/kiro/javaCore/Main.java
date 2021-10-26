package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
	    FootballPlayer messi = new FootballPlayer("Messi");
        FootballPlayer benzema = new FootballPlayer("Benzema");

        BaseballPlayer john = new BaseballPlayer("John");
        BaseballPlayer bond = new BaseballPlayer("Bond");

        Team<FootballPlayer> footballTeam = new Team<>("PSG");
        Team<FootballPlayer> footballTeam2 = new Team<>("Liverpool");
        Team<BaseballPlayer> baseballTeam = new Team<>("Baseball Team 1");

        footballTeam.addPlayer(messi);
        footballTeam.addPlayer(benzema);

        footballTeam2.addPlayer(messi);
        footballTeam2.addPlayer(benzema);

        baseballTeam.addPlayer(john);
        baseballTeam.addPlayer(bond);

        footballTeam.matchResult(footballTeam2, 3, 4);

        LeagueTable<Team<FootballPlayer>> footballLeague = new LeagueTable<>();
        LeagueTable<Team<BaseballPlayer>> baseballLeague = new LeagueTable<>();

        footballLeague.addTeam(footballTeam);
        footballLeague.addTeam(footballTeam2);

        baseballLeague.addTeam(baseballTeam);
//        baseballLeague.addTeam(footballTeam);   // compile-time error

        footballLeague.printTeams();

    }
}
