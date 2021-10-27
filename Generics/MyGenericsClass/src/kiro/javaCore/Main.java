package kiro.javaCore;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        FootballPlayer john = new FootballPlayer("John");
        BaseballPlayer peter = new BaseballPlayer("Peter");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer messi = new SoccerPlayer("Messi");
        SoccerPlayer benzema = new SoccerPlayer("Benzema");

        MixedTeam mixedTeam = new MixedTeam("Mixed Team");
        mixedTeam.addPlayer(joe);
        mixedTeam.addPlayer(pat);
        mixedTeam.addPlayer(benzema);

        Team<FootballPlayer> footballTeam = new Team<>("Crows");
        footballTeam.addPlayer(joe);
        footballTeam.addPlayer(john);
        //footballTeam.addPlayer(peter);        // error

        Team<BaseballPlayer> baseballTeam = new Team<>("Wolfs");
        baseballTeam.addPlayer(peter);
        baseballTeam.addPlayer(pat);

        Team<SoccerPlayer> soccerTeam = new Team<>("Rabbits");
        soccerTeam.addPlayer(messi);
        soccerTeam.addPlayer(benzema);

        Team<SoccerPlayer> opponentSoccerTeam = new Team<>("Foxes");
        soccerTeam.addPlayer(new SoccerPlayer("Big Fox"));

        //  soccerTeam.matchResult(baseballTeam, 10, 0);    // error: baseballTeam is not the same type as soccerTeam
        soccerTeam.matchResult(opponentSoccerTeam, 2, 0);
        soccerTeam.matchResult(opponentSoccerTeam, 2, 1);
        soccerTeam.matchResult(opponentSoccerTeam, 3, 4);

        System.out.println("Rankings");
        System.out.println(soccerTeam.getName() + ": " + soccerTeam.ranking());
        System.out.println(opponentSoccerTeam.getName() + ": " + opponentSoccerTeam.ranking());

        System.out.println(soccerTeam.compareTo(opponentSoccerTeam));

    }
}
