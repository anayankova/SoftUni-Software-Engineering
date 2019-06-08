package d_StreamsFilesAndDirectories;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth  = 3d;

        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res-lab/save.txt";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;
    }

}
