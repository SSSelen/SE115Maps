import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Scanner reader = null;
        int line = 0;
        String[] linearray = null;
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
            line = 0;

            try {
                if (reader.hasNextLine()) {
                    line++;
                    String firstLine = reader.nextLine();
                    citynumber = Integer.parseInt(firstLine);
                    if (citynumber <= 0) {
                        System.err.println("<Error Line:" + line + "><Error:City number must be a positive number.");
                        return;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("<Error line:" + line + "><Error:Invalid city number>");
                return;
            }

            CountryMap x1 = new CountryMap(citynumber);

            try {
                if (reader.hasNextLine()) {
                    line++;
                    String isimler = reader.nextLine();
                    arr = isimler.split(" ");
                    if (arr.length != citynumber) {
                        System.err.println("<Error line:" + line + "><Error:The city number does not align with city labels>");
                        return;
                    }
                    for (int i = 0; i < arr.length; i++) {
                        x1.addCity(i, arr[i]);
                    }
                }
            } catch (Exception e) {
                System.err.println("<Error line:" + line + "><Error:Failed to process city names>");
                return;
            }

            //try {
                if (reader.hasNextLine()) {
                    line++;
                    int yolnumber = Integer.parseInt(reader.nextLine());
                    /*if (yolnumber <= 0) {
                        System.err.println("<Error line:" + line + "><Error:Number of roads must be a positive number>");
                        return;
                    }

                     */
                    for (int i = 0; i < yolnumber; i++) {
                        if (reader.hasNextLine()) {
                            line++;
                            yol = reader.nextLine().split(" ");
                            city1 = yol[0];
                            city2 = yol[1];
                            dakika = Integer.parseInt(yol[2]);
                            if(yol[2]==null){
                                System.err.println("<Error line:"+line+"><Error:Absent Road>");
                            }
                            /*if (yol.length != 3) {
                                System.err.println("<Error line:" + line + "><Error:Invalid road format. Each road should have 3 parts>");
                                return;
                            }

                             */

                            x1.addInfo(city1, city2, dakika);
                        }
                    }
                }
            /*} catch (Exception e) {
                System.err.println("<Error line:" + line + "><Error:Failed to process road data>");
                return;
            }

             */

            try {
                if (reader.hasNextLine()) {
                    line++;
                    hedef = reader.nextLine().split(" ");
                    if (hedef.length != 2) {
                        System.err.println("<Error line:" + line + "><Error:Start and end cities should be two>");
                        return;
                    }
                    start = hedef[0];
                    end = hedef[1];
                }
            } catch (Exception e) {
                System.err.println("<Error line:" + line + "><Error:Failed to process start and end cities>");
                return;
            }

            reader = new Scanner(Paths.get("src/deneme.txt"));
            while (reader.hasNextLine()) {
                reader.nextLine();
                line++;
            }

            reader.close();

            linearray = new String[line];
            reader = new Scanner(Paths.get("src/deneme.txt"));
            int index = 0;
            while (reader.hasNextLine()) {
                linearray[index] = reader.nextLine();
                index++;
            }

            System.out.println("File read is successful!");

            WayFinder x2 = new WayFinder(x1);
            x2.shortyol(start, end, "src/output.txt");

            int zaman = x2.getZaman();
            String[] road = x2.getRoad();
            outputing(zaman, road, "src/output.txt", x1.getCityNumber());

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } finally {
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
            writer.write("Fastest Way: " + b + "\n");
            writer.write("Total Time: " + zaman + " min\n");
            writer.write(" ");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
