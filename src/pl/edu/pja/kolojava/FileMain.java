package pl.edu.pja.kolojava;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileMain {

    public static void main(String[] args) {
        //  Czytanie
        try {
            FileReader fr = new FileReader("mobydick.txt"); //  tutaj mozemy czytac po char albo tablicy charow
            BufferedReader bufferedReader = new BufferedReader(fr); //  opakowujemy i mozemy czytac linia po linii
            String readLine = bufferedReader.readLine();
            int ileJestLinii = 0;

            Map<String, Integer> mapaWystapienSlow = new HashMap<>();

            while(readLine != null){
                ileJestLinii++;
                readLine = bufferedReader.readLine();
                if (readLine == null || readLine.length() == 0){
                    continue;
                }
                String[] splitReadLine = readLine.split(" ");

                for (String token : splitReadLine) {
                    if (mapaWystapienSlow.containsKey(token)){
                        Integer integer = mapaWystapienSlow.get(token);
                        integer++;
                        mapaWystapienSlow.put(token, integer);
                    } else {
                        mapaWystapienSlow.put(token, 1);
                    }
                }
            }
            bufferedReader.close();
            fr.close(); // WAZNE JEST BY SOBIE SPRZATAC!
            System.out.println("Jest " + ileJestLinii + " linii w Moby Dicku.");

            List<Map.Entry<String, Integer>> entryList = mapaWystapienSlow.entrySet()
                    .stream()
                    .sorted((entry1, entry2) ->
                            Integer.compare(entry1.getValue(), entry2.getValue()))
                    .collect(Collectors.toList());
            System.out.println(entryList); //   printujemy tokeny i ile razy sie pojawily

            FileWriter fileWriter = new FileWriter("tokeny.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<String, Integer> entry : entryList) {
                bufferedWriter.write(entry.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.flush(); //  zaapisz wszystko do pliku
            bufferedWriter.close();
            fileWriter.close(); //SPRZATAMY PO SOBIE!

        } catch (FileNotFoundException e) {
            System.err.println("Nie ma takiego pliku.");
        } catch (IOException e) {
            System.err.println("IO exception podczas czytania z pliku.");
        }

    }

}
