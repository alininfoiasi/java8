package java8inaction.chapter3;

import java.io.*;

public class ExecuteAroundExample {

    public static void main(String[] args) {
        try {
            String oneLine = processFile((BufferedReader b) -> b.readLine());
            System.out.println(oneLine);
            String twoLines = processFile((BufferedReader b) -> b.readLine() + " <separator> " + b.readLine());
            System.out.println(twoLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        InputStream inputStream = ExecuteAroundExample.class.getResourceAsStream("file.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"))) {
            return p.process(br);
        }
    }

}
