public class WayFinder {
    //valueof? parseınt?
    /* ?
    if(arr[1].compareTo[2]==-1){
    } else if(arr[2].compareTo[3]==-1){}
    boolean	equals(Object anObject)
boolean	equalsIgnoreCase(String anotherString)
     */
    private CountryMap x1;
    private int zaman;
    private String[] road;
    private int citynumber;
    private String start;
    private String end;
    private String[] array;

    public WayFinder(){
        this.zaman= zaman;
        this.citynumber=x1.getCityNumber();
        this.road = new String[citynumber];
        this.x1=x1;
        this.start=start;
        this.end=end;
        this.array=array;
    }

    public void shortyol(String s, String e){
        array = new String[citynumber];
        array[0] = s;
        roads(s, e, array, 0, 0);
    }

    public void roads(String yer, String finish, String[] arr, int roadlength, int now ){}


}