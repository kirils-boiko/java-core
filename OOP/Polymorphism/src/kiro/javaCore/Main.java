package kiro.javaCore;

public class Main {

    private static final Movie[] MOVIES = {new Jaws(), new IndependenceDay(),
        new MazeRunner(), new StarWars(), new Forgetable()};

    // Polymorphism allows to choose the getName() and plot() methods
    //  based on the actual subclass of the Movie during runtime;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Movie movie = randomMovie();
            System.out.println("Movie #" + i + ": " + movie.getName());
            System.out.println("Plot: " + movie.plot());
            System.out.println();
        }
    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5);
        System.out.println("Random number generated: " + randomNumber);
        return MOVIES[randomNumber];
    }

}
