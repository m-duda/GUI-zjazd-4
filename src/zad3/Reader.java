package zad3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader extends Thread{

    Towar towar;
    private int count =0;

    Reader (Towar t){
        this.towar=t;
    }

    @Override
    public void run () {
        FileReader fr = null;
        try {
            fr = new FileReader("../Towary.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku");
        }
        BufferedReader br = new BufferedReader(fr);

        String textLine = null;
        try {
            textLine = br.readLine();
        } catch (IOException e) {
        }


        while (textLine != null) {
            String[] linia = textLine.split("\\s+");
            Towar t = new Towar(Integer.parseInt(linia[0]), Double.parseDouble(linia[1]));
            count++;
            if (count % 200 == 0) {
                System.out.println("utworzono " + count + " obiektów");
            }
            towar.put(t);
            try {
                textLine = br.readLine();
            } catch (IOException e) {
            }
        }
        try {
            br.close();
        } catch (IOException e) {
        }
        towar.put(null);
    }
}
