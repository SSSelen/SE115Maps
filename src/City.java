public class City {


    //aaaa her bir city için genel özellik (bbook)
   // private String cityname;

    public String cityname;

    public City(){
        cityname=null;
    }

    public City(String a){
        this.cityname=a;
    }

    public String getCityName(){
        return cityname;
    }

    public void displayCityInfo(){
        System.out.println("Şehirke: "+cityname);
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


