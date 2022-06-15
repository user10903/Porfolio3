package AbominodoModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Model {
public String getData() throws FileNotFoundException, IOException {
 
    if(!(new File("C:\\Users\\DELL\\Desktop\\AbominodoStart.txt").isFile())) {
        Files.createFile(Paths.get("C:\\Users\\DELL\\Desktop\\AbominodoStart.txt"));
    }
    String data;
    try (BufferedReader reader = new BufferedReader(
    new FileReader("C:\\Users\\DELl\\Desktop\\AbominodoStart.txt"))) {
        StringBuilder string = new StringBuilder();

        String line = reader.readLine();
        string.append("<html>");
        
        while(line != null) {
        string.append(line);
        string.append("<br />");
        line = reader.readLine();
        }
        string.append("</html>");
        data = string.toString();
        
    } catch (Exception er) {
        data = er.getMessage();
    }
    return data;
 }
}   
