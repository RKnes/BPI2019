public class Gps{
    public double lat; 
    public double longitude;
    String gebietseigenschaften; 
    public Gps( double lat, double longitude, String gebietseigenschaften ){
        this.lat = lat;
        this.longitude = longitude;
        this.gebietseigenschaften = gebietseigenschaften;    
    }

    public String toString(){
        return ( "latitude : " + lat + "\n" +
                 "longitude : " + longitude + "\n" +
                 gebietseigenschaften + "\n" ); 
    }
}