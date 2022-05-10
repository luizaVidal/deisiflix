package pt.ulusofona.deisi.aed.deisiflix;

public class Pessoa {

    String name;
    char gender;
    int filmID, personID;

    Pessoa(){

    }
    Pessoa(String name, char gender, int id1, int id2){

        this.name = name;
        this.gender = gender;
        this.filmID = id1;
        this.personID = id2; // idk what comes first, assuming its filmID and then personID
    }

    // DIRECTOR,96372,Tom Clegg,M,69787
    @Override
    public String toString() {
        return "" + filmID + " | " + name + " | " + gender + " | " + personID;
    }


}
