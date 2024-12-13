public class City {
    private String cityname;
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
    }


