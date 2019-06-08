package k_Examples;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner;

        //URL url = new URL("https://softuni.bg");
        //URLConnection urlConnection = url.openConnection();
        //scanner = new Scanner(urlConnection.getInputStream());
        //while (scanner.hasNext()){
        //    System.out.println(scanner.nextLine());
        //}

        int rowCount = Integer.parseInt(scanner.nextLine());
        int colCount = Integer.parseInt(scanner.nextLine());

        String[][] asd = new String[rowCount][colCount];

        for (int r = 0; r < asd.length; r++) {
            for (int c = 0; c < asd[r].length; c++) {
                asd[r][c] = scanner.nextLine();
            }
        }

        //String[][] asd = {{"asd", "asd"}, {"dsa", "dsa"}};

        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Java 4Ever");

        for (int rows = 0; rows < asd.length; rows++) {
            Row row = sheet.createRow(rows);

            for (int cols = 0; cols < asd[rows].length; cols++) {
                Cell cell = row.createCell(cols);
                String value = asd[rows][cols];
                cell.setCellValue(value);
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("Java.xls"))) {
            workbook.write(fileOutputStream);
            fileOutputStream.flush();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
