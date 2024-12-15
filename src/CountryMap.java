import java.util.*;
public class CountryMap {
    //tüm citylerin toplamı bura(library)

    private int citynumber;
    private City[] cities;

    public CountryMap(){
        citynumber=0;
    }

    public CountryMap(int a){
        cities = new City[citynumber];
        this.citynumber=a;
    }

    public int getCityNumber(){
        return citynumber;
    }
    public void  setCityNumber(int citynumber){
        this.citynumber = citynumber;
    }
    public void addCity(City city){
        if(citynumber<cities.length) {
            //city.add(city);
            //System.out.println(city.getCity() + " added.");
            cities[citynumber] = city;
            System.out.println(city.getCityName() + " added.");
            citynumber++;
        }
    }
    public void displayCountryMapInfo(){
        System.out.println("City Number: "+citynumber);
        /*for(int i = 0; i <citynumber; i++){
            String cityname = cities[i].cityname;
        }
        */

    }

    /*
        private String libraryName;
        public CountryMap(String libraryName){
            this.libraryName=libraryName;
        }
        public void displayCountryMapInfo(){
        }
    }
*/
}
