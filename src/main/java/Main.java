

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<String> buff = new ArrayList<String>();


        Scanner s = new Scanner(System.in);
        System.out.printf("Type in the Address of Moss anaysis result: ");
        String str = s.nextLine();
        String line="";

        Document doc = Jsoup.connect(str).get();
        String filename = "T_results.csv";
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);

        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(fos)));


        int count =0;
        Elements elem = doc.select("tr");
        for (Element e : elem) {

            for (int i = 0; i < e.text().length(); i++) {
               // System.out.print(e.text().charAt(i));
                //fos.write(e.text().charAt(i));
                line+= e.text().charAt(i);
                if (e.text().charAt(i) == ')' || e.text().charAt(i) == '}' || e.text().charAt(i) == '{') {

                   // line+= e.text().charAt(i);
                    line += ',';
                    //System.out.println();
                    //fos.write(',');
                    //fos.write('\n');
                }
            }
            count ++;

            /*if(count%3==0 ){
                line += '\n';
            }else {
                line += ',';
            }*/
           // line+=',';
            line +='\n';
            buff.add(line);
            bw.write(line);
            line ="";



            String linediv = "\n_____________________________________\n\n";
            //System.out.print(linediv);



        }
        bw.flush();
        bw.close();
        //System.out.println(elem.text());
        fos.close();
    }


}