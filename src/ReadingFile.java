import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Класс ReadingFile считывает файл в ArrayList.
 * @author Valera Goncharenko (goncharikvv@gmail.com).
 * @version $Id$.
 * @since 3.09.2019.
 */
class ReadingFile {


    public double parseDataFromCsvFile() {
        double  sum1 = 0;
        double  sum2 = 0;
        double  result = 0;
        List<List<String>> dataFromFile = new ArrayList<>();
        List<String>  csvFileDataOut;

        try {
            Scanner scanner = new Scanner(new FileReader("data-36234-full.csv"));
            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                String dataInRow = scanner.nextLine();
                String[] dataInRowArray = dataInRow.split(";");
                ArrayList<String> rowDataFromFile = new ArrayList<String>(Arrays.asList(dataInRowArray));
                dataFromFile.add(rowDataFromFile);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < dataFromFile.size(); i++) {

            if(dataFromFile.get(i).contains("\"Брянская область\"")){
                csvFileDataOut = dataFromFile.get(i);
                for (int j = 1; j < csvFileDataOut.size(); j++) {
                    double number = Double.parseDouble(csvFileDataOut.get(j).replaceAll("\"", ""));
                    sum1 = sum1 + number;

                }
            }
        }

        for (int i = 0; i < dataFromFile.size(); i++) {

            if(dataFromFile.get(i).contains("\"Белгородская область\"")){
                csvFileDataOut = dataFromFile.get(i);
                for (int j = 1; j < csvFileDataOut.size(); j++) {
                    double number = Double.parseDouble(csvFileDataOut.get(j).replaceAll("\"", ""));
                    sum2 = sum2 + number;
                }
            }
        }

        if(sum1 > sum2){
            result = (sum1 - sum2) / sum2 * 100;

            System.out.println(" В Белгородской области больше ДТП чем в Брянской на " + result + " %");
        }
        else {
            result = (sum2 - sum1) / sum1 * 100;
            System.out.println(" В Брянской области больше ДТП чем в Белгородской на " + result+ " %");
        }

        return result;
    }
}
