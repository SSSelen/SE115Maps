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
        try {
            reader = new Scanner(Paths.get("src/deneme.txt"));
            int line = 0;
            while (reader.hasNextLine()) {
                reader.nextLine();
                line++;
            }
            reader.close();

            reader = new Scanner(Paths.get("src/deneme.txt"));

            String[] linearray = new String[line];

            int index = 0;
            while (reader.hasNextLine()) {
                linearray[index] = reader.nextLine();
                index++;
            }


            System.out.println("File read is successful!");
            for (int i = 0; i < linearray.length; i++) {
                System.out.println(linearray[i]);
            }

        } catch (IOException x) {
            System.err.println("<File line number> <Error description>" + x.getMessage());
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

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


        /*Formatter f = null;

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
        */

    }
}
