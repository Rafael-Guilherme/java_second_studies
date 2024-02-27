import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class ProgramProducts {
    public static void main(String[] args) {
        
        File file = new File("/home/rafael/Área de Trabalho/Java/Aulas/primeiro_programa/second_programm/source.csv");
        Scanner sc = null;

        String onlyPath = file.getParent();
        
        List<Product> list = new ArrayList<>();
        
        boolean success = new File(onlyPath + "/out").mkdir();
        System.out.println("Directory created successfully!" + success);
        
        String path = onlyPath + "/out/summary.csv";

        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] firstLine = sc.nextLine().split("[,]", 0);
                String name = firstLine[0];
                double price = Double.parseDouble(firstLine[1]);
                int quantity = Integer.parseInt(firstLine[2]);

                Product p = new Product(name, price, quantity);
                list.add(p);
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
                for(Product p : list) {
                    bw.write(p.getName() + "," + p.total());
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println("Error writing file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
