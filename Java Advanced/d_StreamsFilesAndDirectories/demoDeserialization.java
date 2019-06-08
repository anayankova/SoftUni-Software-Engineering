package d_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class demoDeserialization {
    public static void main(String[] args) {

        //Load objects from a file

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res-lab/save1.txt";

        try (FileInputStream fis = new FileInputStream(path);
             ObjectInputStream oos = new ObjectInputStream(fis)) {
            List<String> names =
                    (List<String>) oos.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
