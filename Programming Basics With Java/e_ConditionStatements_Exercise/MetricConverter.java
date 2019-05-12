package e_ConditionStatements_Exercise;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double size = Double.parseDouble(scanner.nextLine());
        String sourceMetric = scanner.nextLine();
        String destinationMetric = scanner.nextLine();

        if(sourceMetric.equals("mm")){
            size = size / 1000;
        }else if (sourceMetric.equals("cm")){
            size = size / 100;
        }else if (sourceMetric.equals("mi")){
            size = size / 0.000621371192;
        }else if (sourceMetric.equals("in")){
            size = size / 39.3700787;
        }else if (sourceMetric.equals("km")){
            size = size / 0.001;
        }else if (sourceMetric.equals("ft")){
            size = size / 3.2808399;
        }else if (sourceMetric.equals("yd")){
            size = size / 1.0936133;
        }

        if(destinationMetric.equals("mm")){
            size = size * 1000;
        }else if (destinationMetric.equals("cm")){
            size = size * 100;
        }else if (destinationMetric.equals("mi")){
            size = size * 0.000621371192;
        }else if (destinationMetric.equals("in")){
            size = size * 39.3700787;
        }else if (destinationMetric.equals("km")){
            size = size * 0.001;
        }else if (destinationMetric.equals("ft")){
            size = size * 3.2808399;
        }else if (destinationMetric.equals("yd")){
            size = size * 1.0936133;
        }

        System.out.printf("%.8f", size);

    }
}
