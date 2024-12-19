public class WayFinder {

    private CountryMap x1;
    private int zaman;
    private String[] road;
    private int citynumber;
    private String start;
    private String end;
    private String[] array;

    public WayFinder(CountryMap x1) {
        this.zaman = -1;
        this.citynumber = x1.getCityNumber();
        this.road = new String[citynumber];
        this.x1 = x1;
        this.start = start;
        this.end = end;
        this.array = array;
    }

    public void shortyol(String s, String e) {
        array = new String[citynumber];
        array[0] = s;
        roads(s, e, array, 0, 0);
    }

    public void roads(String yer, String finish, String[] array, int roadlength, int now) {
        int citynum = x1.getCityNum(yer);
        if (citynum == -1) {
            return;
        }

        if (yer.equals(finish)) {
            if (zaman == -1 || now < zaman) {
                zaman = now;
                for (int i = 0; i <= roadlength; i++) {
                    road[i] = array[i];
                }
            }
            } else {
                City city = x1.getCityArray(citynum);

                for (int i = 0; i < city.getKomsuNumber(); i++) {
                    String n = city.getKomsu(i);
                    int z = city.getDakika(i);

                    if (!control(n, array, roadlength)) {
                        array[roadlength+1] = n;
                        roads(n, finish, array, roadlength + 1, now + zaman);
                    }
                }
            }
            array[roadlength] = null;
        }

        public boolean control(String city, String[] array, int roadlength){
            for(int i = 0;i<=roadlength; i++){
                if(array[i] !=null && array[i].equals(city)){
                    return true;
                }
            }
            return false;
        }
}


