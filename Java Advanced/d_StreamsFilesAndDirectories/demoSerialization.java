package d_StreamsFilesAndDirectories;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class demoSerialization {
    public static void main(String[] args) {

        //Save objects to a file

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res-lab/save1.txt";

        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Mimi", "Gosho");

        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(names);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
