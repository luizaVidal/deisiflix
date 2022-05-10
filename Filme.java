package pt.ulusofona.deisi.aed.deisiflix;

import java.util.Arrays;

public class Filme {

    int filmID, budget, numberVotes;
    double duration, averageVotes;
    String title, releaseDate;
    Pessoa[] actors;
    Pessoa[] director;
    GeneroCinematografico[] genres;

    Filme(int id, String title, double duration, int budget, String releaseDate){
        this.filmID = id;
        this.title = title;
        this.duration = duration;
        this.budget = budget;
        this.releaseDate = releaseDate;
    }


    Filme(int id, String title, String releaseDate, int numberVotes, double averageVotes, int budget,
          double duration, Pessoa[] actors, Pessoa[] director, GeneroCinematografico[] genres){
        this.filmID = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.numberVotes = numberVotes;
        this.averageVotes = averageVotes;
        this.budget = budget;
        this.duration = duration;
        this.actors = actors;
        this.director = director;
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "" + filmID + " | " + title + " | " + releaseDate + " | " + numberVotes + " | " + averageVotes;
    }
}
