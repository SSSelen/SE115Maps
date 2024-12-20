import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Formatter;
import java.io.FileWriter;
import java.util.Random;
//import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    /*public static void main(String[] args) throws IOException {
//throws kullanımı okey miş */
    public static void main(String[] args) {

        /*if(args.length==0){
            System.out.println("Error:1");
            System.out.println("Usage");
            return;
        }

         */

        int line = 0; //ARRAYLERİ DE TANIMLASAM
        String[] linearray = new String[line];
        int index = 0;
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Entet file: ");
        String filename = args[0];

         */

        Scanner reader = null;
        Random rd = new Random();
        int r = 0;
        String[] yol = null;
        String city1 = null;
        String city2 = null;
        int dakika = 0;
        int citynumber = 0;
        String[] arr = null;
        String start = null;
        String end = null;
        String[] hedef = null;

        try {
            reader = new Scanner(Paths.get("src/deneme.txt"));
            //reader = new Scanner(new File(filename));
            line=0;
            if (reader.hasNextLine()) {
                line++;
                String firstLine = reader.nextLine();
                if(firstLine==null){
                    throw new IllegalArgumentException("Şehir eksik");
                }
                citynumber = Integer.parseInt(firstLine);
            } else{
                throw new IllegalArgumentException("sayısı eksik");
            }

            CountryMap x1 = new CountryMap(citynumber);

            if (reader.hasNextLine()) {
                line++;
                String isimler = reader.nextLine();
                arr = isimler.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    x1.addCity(i, arr[i]);
                }
            }

            if (reader.hasNextLine()) {
                line++;
                int yolnumber = Integer.parseInt(reader.nextLine());
                for (int i = 0; i < yolnumber; i++) {
                    if (reader.hasNextLine()) {
                        line++;
                        yol = reader.nextLine().split(" ");
                        city1 = yol[0];
                        city2 = yol[1];
                        dakika = Integer.parseInt(yol[2]);

                        x1.addInfo(city1, city2, dakika);
                    }else{
                        throw new IllegalArgumentException("Eksik yol");
                    }
                }
            }

            if (reader.hasNextLine()) {
                line++;
                hedef = reader.nextLine().split(" ");
                start = hedef[0];
                end = hedef[1];
            }

            //int line =1;
            reader = new Scanner(Paths.get("src/deneme.txt"));
            while (reader.hasNextLine()) {
                reader.nextLine();
                line++;
            }
            reader.close();
            //String[] linearray = new String[line];
            linearray = new String[line];
            reader = new Scanner(Paths.get("src/deneme.txt"));
            //int index = 0;
            while (reader.hasNextLine()) {
                linearray[index] = reader.nextLine();
                index++;
            }

            System.out.println("File read is successful!");

            //x1.displayCountryMapInfo();//citydi

            WayFinder x2 = new WayFinder(x1);
            x2.shortyol(start, end, "src/output.txt");

            int zaman = x2.getZaman();
            String[] road = x2.getRoad();
            outputing(zaman, road, "src/output.txt", x1.getCityNumber());

        } catch (Exception e) {//IOExceptiondi( boş dosya atarsa)  (6 yol atıyorum ama eskiks yol atarsa da error veiyorum
            System.err.println("<"+(line-1) + "><Error description>");//<getMessage.e>?
        } /*catch  (NumberFormatException e){
            System.err.println("Şehir sayısı 0.");
            //aynı dosya isminde var
        } */ finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
    private static void outputing(int zaman, String[] road, String string, int citynumber) {
        if (zaman == -1) {
            System.out.println("No path exists.");
            return;
        }
        String b = "";
        for (int i = 0; i < citynumber && road[i] != null; i++) {
            b += road[i];
            if (i + 1 < citynumber && road[i + 1] != null) {
                b += " -> ";
            }
        }
        System.out.println();
        System.out.println("Fastest Way: " + b);
        System.out.println("Total Time: " + zaman + " min");

        try (FileWriter writer = new FileWriter(string)) {
            writer.write("Fastest Way: " + b+ "\n");
            writer.write("Total Time: " + zaman + " min\n");
            writer.write(" ");
        } catch (Exception e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}