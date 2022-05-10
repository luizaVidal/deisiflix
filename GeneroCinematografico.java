package pt.ulusofona.deisi.aed.deisiflix;

public class GeneroCinematografico {

    String genre;
    int filmID;

    GeneroCinematografico() {

    }

    GeneroCinematografico(String genreName, int id){
        this.genre = genreName;
        this.filmID = id;
    }

    @Override
    public String toString() {
        return "" + genre + " | " + filmID;
    }

}
