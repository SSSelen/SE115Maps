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
//throws kullanımı okey mi */
public static void main(String[] args){


    int line = 1; //ARRAYLERİ DE TANIMLASAM
    String[] linearray = new String[line];
    int index = 0;


        Scanner reader = null;
        Random rd = new Random();
        int r = 0;
        String[] yol = null;
        String city1 = null;
        String city2 = null;
        int dakika = 0;
        int citynumber = 0;
        String[] arr = null;

        try {
            reader = new Scanner(Paths.get("src/deneme.txt"));

            if (reader.hasNextLine()) {
                String firstLine = reader.nextLine();
                citynumber = Integer.parseInt(firstLine);
            }

            CountryMap x1 = new CountryMap(citynumber);

            if(reader.hasNextLine()){
                String isimler = reader.nextLine();
                arr= isimler.split(" ");
                for (int i = 0; i < arr.length; i++) {
                    x1.addCity(i, arr[i]);
                }
            }

            if(reader.hasNextLine()){
                int yolnumber = Integer.parseInt(reader.nextLine());
                for(int i = 0; i<yolnumber; i++){
                    if(reader.hasNextLine()){
                        yol = reader.nextLine().split(" ");
                        city1 = yol[0];
                        city2 = yol[1];
                        dakika = Integer.parseInt(yol[2]);

                        x1.addInfo(city1, city2, dakika);
                    }
                }
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

            x1.displayCountryMapInfo();//citydi

        } catch (Exception ErrorX) {//IOExceptiondi( boş dosya atarsa)  (6 yol atıyorum ama eskiks yol atarsa da error veiyorum
            System.err.println(linearray[index]+"<Line Number><Error description>" + ErrorX.getMessage());
        } /*catch  (NumberFormatException e){
            System.err.println("Şehir sayısı 0.");
            //aynı dosya isminde var
        } */finally {
            if (reader != null) {
                reader.close();
            }
        }

        //write
/*
        Formatter f = null;
        try {
            f = new Formatter("src/deneme.txt");
            r = rd.nextInt();
            f.format("%d", r);
        } catch (Exception e) {
            System.err.println("Something went wrong.");
        } finally {
            if (f != null) {
                f.close();
            }
        }
*/


        //append
        Formatter f = null;
        FileWriter fw = null;
        try {
        fw = new FileWriter("src/deneme.txt", true);
        f = new Formatter(fw);
        r = rd.nextInt();
        f.format("%d", r);
        fw.close();
        } catch (Exception e) {
        System.err.println("Something went wrong.");
        } finally {
        if (f != null) {
        f.close();
        }
        }
    }
}
