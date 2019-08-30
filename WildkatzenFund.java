import java.util.ArrayList;
public class WildkatzenFund extends Fund{
    int maeuseLoecher;
    public WildkatzenFund(Kartierer k, Gps gps, ArrayList<Tiere> tiere, int population, String spezies, int maeuseLoecher){
        super( k, gps, tiere, population, spezies);
        this.maeuseLoecher = maeuseLoecher;
    }

    public String toString(){
        return super.toString() + "\nAnzahl der Maeuseloecher: " + maeuseLoecher;
    }
}