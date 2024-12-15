//import java.util.Arrays; görmemişiz?
public class City {


    //aaaa her bir city için genel özellik (bbook)
   // private String cityname;

    public String[] cityname;

    public City(){
        cityname=null;
    }

    public City(String[] a){
        this.cityname=a;
    }

    public String[] getCityName(){
        return cityname;
    }

    public void displayCityInfo(){
        //System.out.println("Şehir 1: "+Arrays.toString(cityname[0].toCharArray()));
        //System.out.println("Şehirke: "+Arrays.toString(cityname));
        if (cityname != null && cityname.length > 0) {
            System.out.print("Şehirlerd: ");
            for (int i = 0; i < cityname.length; i++) {
                System.out.print(cityname[i]);
                if (i < cityname.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Şehirler: [Boş]");
        }
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


