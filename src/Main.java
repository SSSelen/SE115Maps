import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
//import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        Scanner reader = null;
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
    }
}
