

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String URL = "https://cwe.mitre.org/data/definitions/400.html";
        Document doc = Jsoup.connect(URL).get();
        String filename = "testing.txt";
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);


        Elements elem = doc.select("div[class=\"top\"]");
        for (Element e : elem) {

            for (int i = 0; i < e.text().length(); i++) {
                System.out.print(e.text().charAt(i));
                fos.write(e.text().charAt(i));

                if (e.text().charAt(i) == ';' || e.text().charAt(i) == '}' || e.text().charAt(i) == '{') {

                    System.out.println();
                    fos.write('\n');
                }
            }


            String linediv = "\n_____________________________________\n\n";
            System.out.print(linediv);
            for (int idx = 0; idx < linediv.length(); idx++) {
                fos.write(linediv.charAt(idx));
            }

        }
        //System.out.println(elem.text());
        fos.close();
    }


}