package DZ_Seminar_3.FileWorks;

import DZ_Seminar_3.Abonent.Abonent;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileWorks {

    public static void printAll(ArrayList<Abonent> list) throws WriteInFileException {
        String tempName;
        ArrayList<Abonent> tempArr;
        String wrString = "";
        String fileName = "";

        for (int i = 0; i < list.size(); i++) {
            tempName = list.get(i).lName;
            tempArr = new ArrayList<>();
            tempArr = getNamesakes(list, tempName);
            fileName = "DZ_Seminar_3" + tempName+".txt";
            try (FileWriter writer = new FileWriter(fileName)) {
                wrString = "";
                for (int j = 0; j < tempArr.size(); j++) {
                    wrString += tempArr.get(j);
                    wrString += "\n";

                }
                writer.write(wrString);
                writer.write("\n");
                writer.flush();
                writer.flush();
            } catch (IOException e) {
                    throw new WriteInFileException("Запись в файл не удалась", e);
            }
            }
        }

    public static ArrayList<Abonent> getNamesakes(ArrayList<Abonent> abList, String pos) {
        ArrayList<Abonent> tempArr = new ArrayList<>();
        String tempName = pos;
        for (int i = 0; i < abList.size(); i++) {
            if (abList.get(i).lName.equals(tempName)) {
                tempArr.add(abList.get(i));
            }
        }
        return  tempArr;
    }
}
