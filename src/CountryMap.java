import java.util.*;
public class CountryMap {
    //library

    private int citynumber;
    private City[] cities;

    public CountryMap(int a){
        this.citynumber=a;
        this.cities = new City[citynumber];
    }

    public void addCity(int a, String cityname){
        cities[a] = new City(cityname, citynumber-1);
    }

    public City getCity(String cityname){
        for(int i = 0; i<cities.length; i++){
            if (cities[i].getCityName().equals(cityname)) {
                return cities[i];
            }
        }
        return null;
    }

    public void addInfo(String city1name, String city2name, int dakika) {
        City city1 = getCity(city1name);
        City city2 = getCity(city2name);

        if (city1 != null && city2 != null) {
            city1.addKomsu(city2name, dakika);
            city2.addKomsu(city1name, dakika);
        }
    }

    public void displayCountryMapInfo(){
        System.out.println("City Number: "+citynumber);
        for(int i = 0; i <cities.length; i++){
            cities[i].displayCityInfo();
        }

        for(int i = 0; i <citynumber; i++){
            String cityname = cities[i].getCityName();
            System.out.print(cityname +" ");
        }
    }
}
