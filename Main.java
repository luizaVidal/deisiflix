package pt.ulusofona.deisi.aed.deisiflix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

}
    static ArrayList<String> ignoredLines1 = new ArrayList<>(); // movies
    static ArrayList<String> ignoredLines2 = new ArrayList<>(); // movie votes
    static ArrayList<String> ignoredLines3 = new ArrayList<>(); // people
    static ArrayList<String> ignoredLines4 = new ArrayList<>(); // genres
    static ArrayList<Filme> films = new ArrayList<>(); // film validation

    static void lerFicheiros() throws IOException {

        films = new ArrayList<>();
        ignoredLines1 = new ArrayList<>(); // deisi_movies ignored lines
        ignoredLines2 = new ArrayList<>(); // deisi_movie_votes ignored lines
        ignoredLines3 = new ArrayList<>(); // deisi_people ignored lines
        ignoredLines4 = new ArrayList<>(); // deisi_genres ignored lines

        String line1, line2, line3, line4 = "";

        // reading file movies
        FileReader fr1 = new FileReader("deisi_movies.txt");
        BufferedReader reader1 = new BufferedReader(fr1);
        while (((line1 = reader1.readLine()) != null)) {
            String data[] = line1.split(",");
            if ((data.length !=5)){
                ignoredLines1.add(line1);
            } else {

                int filmID1 = Integer.parseInt(data[0].trim());
                String filmTitle = data[1];
                double duration = Double.parseDouble(data[2].trim());
                int budget = Integer.parseInt(data[3].trim());

                // date (D-M-Y)
                String releaseDate = data[4];
                // changing date format to (Y-M-D)
                String releaseDay = releaseDate.substring(0,2);
                String releaseMonth = releaseDate.substring(3,5);
                String releaseYear = releaseDate.substring(6,10);
                // final date (Y-M-D)
                String releaseFDate = releaseYear + "-" + releaseMonth + "-" + releaseDay;

                Filme film = new Filme(filmID1, filmTitle, duration, budget, releaseFDate);
                films.add(film);
            }
        }
        // reading file movie_votes
        FileReader fr2 = new FileReader("deisi_movie_votes.txt");
        BufferedReader reader2 = new BufferedReader(fr2);
        while ((line2 = reader2.readLine()) != null) {
            String data[] = line2.split(",");
            if(data.length != 3){
                ignoredLines2.add(line2);
            } else {
                int filmID2 = Integer.parseInt(data[0].trim());
                double averageVotes = Double.parseDouble(data[1].trim());
                int numberVotes = Integer.parseInt(data[2].trim());

                // conecting film id from deisi_movies with film id from deisi_movie_votes
                for (int i = 0; i < films.size(); i++){
                    if (filmID2 == films.get(i).filmID){ // same ID == same movie
                        films.get(i).numberVotes = numberVotes;
                        films.get(i).averageVotes = averageVotes;
                    }
                }
            }
        }
        // reading file people
        FileReader fr3 = new FileReader("deisi_people.txt");
        BufferedReader reader3 = new BufferedReader(fr3);
        while ((line3 = reader3.readLine()) != null) {
            String data[] = line3.split(",");
            if (data.length != 5){
                ignoredLines3.add(line3);
            }
        }
        // reading file genre
        FileReader fr4 = new FileReader("deisi_genres.txt");
        BufferedReader reader4 = new BufferedReader(fr4);
        while ((line4 = reader4.readLine()) != null) {
            String data[] = line4.split(",");
            if (data.length != 2){
                ignoredLines4.add(line4);
            }
        }
        reader1.close();
        reader2.close();
        reader3.close();
        reader4.close();
    }

    static ArrayList<Filme> getFilmes(){
        return films;
    }

    static ArrayList<String> getLinhasIgnoradas(String fileName){
        if (fileName == "deisi_movies.txt"){
            return ignoredLines1;
        }
        else if (fileName == "deisi_movie_votes.txt"){
            return ignoredLines2;
        }
        else if (fileName == "deisi_people.txt"){
            return ignoredLines3;
        }
        else { // if (fileName == "deisi_genre.txt"){...}
            return ignoredLines4;
        }

    }

}
