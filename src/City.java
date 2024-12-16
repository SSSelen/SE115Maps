//import java.util.Arrays; görmemişiz?
public class City {
    //aaaa her bir city için genel özellik (bbook)
   // private String cityname;

    private String[] komsu;
    private int komsunumber;
    public String cityname;
    private int[] dakika;

    public City(String name, int neighbour){
        this.cityname=name;
        this.komsu = new String[neighbour];
        this.komsunumber = 0;
        this.dakika = new int[neighbour];
    }

    public City(String[] arr) {
        //maindeki arrda hata
    }

    public String getCityName(){
        return cityname;
    }

    public int getKomsuNumber(){
        return komsunumber;
    }

    public void addKomsu(String neighbour, int dakika){
        komsu[komsunumber] = neighbour;
        this.dakika[komsunumber] = dakika;
        komsunumber++;
    }

    public void displayCityInfo(){
        //System.out.println("Şehir 1: "+Arrays.toString(cityname[0].toCharArray()));
        //System.out.println("Şehirke: "+Arrays.toString(cityname));
        // System.out.println(cityname[i]);

        System.out.println("Komsşular: ");
        for(int i = 0; i<komsunumber; i++){
            System.out.println(komsu[i]+ " " + dakika[i]);
        }
        System.out.println();
    }

   /* private String cityname;
    private int road;
    private int[] minute;
    private int[] neighbourcount;

        public City(String cityname, int road, int minute, int neighbourcount){
            this.cityname=cityname;
            this.road=road;
            this.minute=minute;
            this.neighbourcount=neighbourcount;
        }

        public String getCity(){
            return cityname;
        }
        public int getRoad(){
            return road;
        }
        public int getMinute(){
            return minute;
        }

        public String setCity(){
            return this.cityname;
        }
        public int setRoad(){
            return this.road;
        }
        public int setMinute(){
            return this.minute;
        }

        public void displayCityInfo(){
            System.out.println("City: "+cityname+"Road: "+road+ "Minute: "+minute);
        }

    */
    }


