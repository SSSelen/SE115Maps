import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
//import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(Paths.get("deneme.txt"));
            System.out.println("File read is successful!");
        } (IOException x){
            System.out.println("<File line number> <Error description>" + x.getFile());
        }
    }
}
