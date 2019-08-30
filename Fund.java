import java.util.ArrayList;
public class Fund{
    Kartierer k;
    Gps gps;
    ArrayList<Tiere> tiere;
    String spezies;
    
    public Fund (Kartierer k, Gps gps, ArrayList<Tiere> tiere, int population, String spezies){
        this.k = k;
        this.gps = gps;
        this.tiere = tiere;
        this.spezies = spezies;
    }

    public int getAnzahl(){
        return tiere.size();
    }

    public String getSpezies(){
        return spezies;
    }

    public void addTier(Tiere t){
        tiere.add(t);
    }

    public String toString(){
        
        return ("Erstellt von: " + k + "\n"
        + "Ort:" + gps + "\nSpezies:" + spezies + "\nTiere " + tiere.toString());
    }

}