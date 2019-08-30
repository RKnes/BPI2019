public class Kartierer{
    String vorname, nachname;
    public Kartierer(String vorname, String nachname){
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorName(){
        return vorname;
    }
    
    public String getNachName(){
        return nachname;
    }

    public String toString(){
        return (vorname + " " + nachname);
    }
}