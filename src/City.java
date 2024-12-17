public class City {
    //book

    private String[] komsu;
    private int komsunumber;
    private String cityname;
    private int[] dakika;

    public City(String name, int neighbour){
        this.cityname=name;
        this.komsu = new String[neighbour];
        this.komsunumber = 0;
        this.dakika = new int[neighbour];
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
        System.out.println(cityname+ " Komsşular: ");
        for(int i = 0; i<komsunumber; i++){
            System.out.println(komsu[i]+ " " + dakika[i]);
        }
        System.out.println();
    }
}


