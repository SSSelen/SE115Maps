public class City {
    String city;
    int road;
    int minute;


        private String title;
        private String author;
        private double price;

        public Book(String title, String author, double price){
            this.title=title;
            this.author=author;
            this.price=price;
        }

        public String getCity(){
            return city;
        }
        public int getRoad(){
            return road;
        }
        public int getMinute(){
            return minute;
        }

        public String setCity(){
            return this.city;
        }
        public int setRoad(){
            return this.road;
        }
        public int setMinute(){
            return this.minute;
        }

        public void displayBookInfo(){
            System.out.println("City: "+city+"Road: "+road+ "Minute: "+minute);
        }
    }

}
