package phonebook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class FileOperations {
	/**
	 * Ez az a fuggvény ami beolvassa a fájlbol a sorokat es Entry-ve alakitja,majd hozza adja a listahoz.
	 * CSV fajlbol fog olvasni.
	 * @param f  fajl neve amibol be kell olvasni. 
	 * @param list aza a lista amibe be fogja tenni a beolvasott adatokat.
	 */
    public ArrayList<Entry> read( ) {
    	ArrayList<Entry> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("db.txt", StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                String[] parts = line.split(",");

                list.add(toEntry(parts));


            }
            br.close();
            


        } catch (IOException e) {
            System.out.println(e.getMessage());

        }return list;

    }
    /**
     * Ez az a fuggveny ami a fajlba irasert felel. Vegig megy a listan es kiirja oket.
     * A fajl CSV formatumu lesz.
     * 
     * @param filename fajl neve amibe irni fog.
     * @param list a lista amibol irni fog.
     */
    public void save(String filename, ArrayList<Entry> list) {

        try {
            FileWriter fw = new FileWriter(filename, StandardCharsets.UTF_8);
            PrintWriter pw = new PrintWriter(fw);
            for (Entry entry : list) {
                pw.println(entry.toFile());
            }
            pw.close();


        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    
    /**
     * Ez ami a szettordelt  sorokat Entry-ve alakitsa.
     * 
     * @param list 
     * @return Entry tipusu objektumot add vissza.
     */

    public Entry toEntry(String[] list) {
        return new Entry(list[0], list[1], list[2], list[3], list[4], list[5]);
    }

}
