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
    public static void main(String[] args) {
        Scanner reader = null;
        Random rd = new Random();
        int r = 0;
        int citynumber = 0;
        String[] arr = null;
        try {
            reader = new Scanner(Paths.get("src/deneme.txt"));

            if (reader.hasNextLine()) {
                String firstLine = reader.nextLine();
                citynumber = Integer.parseInt(firstLine);
                CountryMap x1 = new CountryMap(citynumber);
                x1.displayCountryMapInfo();//citydi

            }
            if(reader.hasNextLine()){
                String isimler = reader.nextLine();
                arr= isimler.split(" ");
                for(int i = 0; i<arr.length; i++){
                    System.out.println("Array "+(i+1)+" "+arr[i]);
                }
            }
            //ya da stringler[] = new String[ilk satır]; ve stringler[i] = isimler[i];

            int line = 0;
            reader = new Scanner(Paths.get("src/deneme.txt"));
            while (reader.hasNextLine()) {
                reader.nextLine();
                line++;
            }
            reader.close();


            String[] linearray = new String[line];
            reader = new Scanner(Paths.get("src/deneme.txt"));

            int index = 0;
            while (reader.hasNextLine()) {
                linearray[index] = reader.nextLine();
                index++;
            }


            System.out.println("File read is successful!");
            for (int i = 0; i < linearray.length; i++) {
                System.out.println(linearray[i]);
            }

        } catch (IOException ErrorX) {
            System.err.println("<File line number> <Error description>" + ErrorX.getMessage());
        } catch  (NumberFormatException e){
            System.err.println("Şehir sayısı 0.");
        } finally {
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
