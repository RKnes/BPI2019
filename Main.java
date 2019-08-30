import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    
    public static void main(String []args){
        //Anlegen von "persistenten" Daten
        ArrayList<Kartierer> kartiererList = new ArrayList<Kartierer>();
        ArrayList<Fund> fundList = new ArrayList<Fund>();
        Scanner sc1 = new Scanner(System.in);
        kartiererList.add(new Kartierer ("Max", "Musti"));
        kartiererList.add(new Kartierer ("Lisa","Freilich"));
        
        //Fakelogin starten
        Kartierer currentKartierer = fakelogin(kartiererList, sc1);
        boolean running = true;
    
        //Anlegen eines "persistenten" Funds
        ArrayList<Tiere> tierList = new ArrayList<Tiere>();
        tierList.add(new Biber(1));
        tierList.add(new Biber(2));
        tierList.add(new Biber(3));
        Fund f1 = new BiberFund(kartiererList.get(0), new Gps(1.00005931, 1.10000293,"Laendlich waldig feucht"),tierList, 3, "Biber", "sehr gut");
        fundList.add(f1);
        
        //Switch case für Hauptmenu
        do{
            System.out.println("Eingeloggter Kartierer " + currentKartierer);
            mainMenu();
            switch(sc1.nextInt()){
                case 1:
                    kartiererAnzeigen(kartiererList);
                    break;
                case 2: 
                    fundUebersichtAnzeigen(fundList);
                    break;
                case 3:
                    System.out.print("Bitte geben sie die gewuenschte FundNr an : ");
                    bestimmtenFundZeigen(sc1.nextInt(),fundList); 
                    break;
                case 4: 
                    kartiererList.add(kartiererAnlegen(sc1));
                    break;
                case 5: 
                    fundList.add(fundAnlegen(sc1,currentKartierer));
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Ungueltige Eingabe");
            }
        }while(running);
    }


    public static void fundUebersichtAnzeigen(ArrayList<Fund> fundList){
        spacer2();
        for(int i = 0; i < fundList.size(); i++){
            System.out.println("Fund Nummer - " + (i+1) + " Art/Spezies - " + fundList.get(i).getSpezies());
        }
        spacer2();
    }
    public static void kartiererAnzeigen(ArrayList<Kartierer> list){
        spacer2();
        System.out.println("Kartierer : ");
        for(Kartierer k: list){
            System.out.println(k);
        }
        spacer2();
    }

    public static void bestimmtenFundZeigen(int fundNr, ArrayList<Fund> list){
        spacer2();
        System.out.println(list.get(fundNr-1));
        spacer2();
    }

    public static Kartierer fakelogin(ArrayList<Kartierer> k, Scanner s){
        //Kartierer Ausgeben
        System.out.println("Kartierer : ");
        for(int i = 0; i < k.size() ; i++){
            System.out.println((i+1) + " - " + k.get(i));
        }
        //Auswahl zurueckgeben
        System.out.print("Bitte waehlen einen Kartierer > ");
        int tmp = s.nextInt();
        return k.get(tmp-1);
    }

    public static Kartierer kartiererAnlegen(Scanner s){
        System.out.print("Vorname : ");
        String vorname = s.next();
        System.out.print("\nNachname : ");
        return new Kartierer(vorname, s.next());
    }

    public static Fund fundAnlegen(Scanner s, Kartierer k){
        ArrayList<Tiere> tierList = new ArrayList<Tiere>();
        System.out.println("1 - Biber\n2 - Wildkatze");
        System.out.print("Welche spezies wurde gefunden: ");
        int tmp = s.nextInt();
        System.out.print("Wieviele dieser Spezies wurden gefunden: ");
        int anzahl = s.nextInt();
        for(int i = 0; i < anzahl; i++){
            System.out.print("Bitte geben sie das geschaetzte Alter fuer Tier " + (i+1) + " an: ");
            tierList.add(tmp == 1? new Biber(s.nextInt()) : new Wildkatze(s.nextInt()) );
        }
        System.out.print("Beschreiben sie das Terrain: ");
        s.nextLine();
        String terrain = s.nextLine();
        System.out.print("Bitte geben sie den Laengengrad(Fließkomma) an: ");
        double longitude = s.nextDouble();
        System.out.print("Bitte geben sie den Breitengrad(Fließkomma) an: ");
        double latitude = s.nextDouble(); s.nextLine();
         if(tmp == 1){
             System.out.print("Bitte beschreiben sie die Wasserqualitaet: ");
             return new BiberFund(k, new Gps(longitude, latitude, terrain),tierList, anzahl, "Biber", s.nextLine());
        }else{
             System.out.print("Bitte geben sie die Anzahl der Maeuseloecher an: ");
             return new WildkatzenFund(k, new Gps(longitude, latitude, terrain),tierList, anzahl, "Wildkatze", s.nextInt());
        }
        
        
    }

    private static void mainMenu(){
        spacer();
        System.out.println("1 - Kartierer Anzeigen");
        System.out.println("2 - FundUebersicht Anzeigen");
        System.out.println("3 - Bestimmten Fund Anzeigen");
        System.out.println("4 - Kartierer anlegen");
        System.out.println("5 - Fund anlegen");
        System.out.println("6 - Exit");
        spacer();
    }
    private static void spacer(){
        System.out.println("------------------------------------------");
    }
    private static void spacer2(){
        System.out.println("##########################################");
    }
}