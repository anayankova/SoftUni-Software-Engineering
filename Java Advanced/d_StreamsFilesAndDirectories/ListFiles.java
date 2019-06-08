package d_StreamsFilesAndDirectories;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir + "/res-lab/Files-and-Streams");

        //boolean isExisting = file.exists();
        //long length = file.length();
        //boolean isDirectory = file.isDirectory();
        //File[] files = file.listFiles();

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File f : files) {
                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n",
                                f.getName(), f.length());
                    }
                }
            }
        }


    }
}
