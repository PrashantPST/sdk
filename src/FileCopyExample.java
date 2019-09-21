import java.io.*;

public class FileCopyExample {
    private final static String INPUT = "in.txt";
    private final static String OUTPUT = "out.txt";

    public static void main(String[] args) {
        try(BufferedReader rd = new BufferedReader(new FileReader(INPUT));
            BufferedWriter wr = new BufferedWriter(new FileWriter(OUTPUT))) {
            String inputLine;

            while((inputLine = rd.readLine()) != null) {
                wr.write(inputLine + "\n");
            }
            wr.flush();

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
