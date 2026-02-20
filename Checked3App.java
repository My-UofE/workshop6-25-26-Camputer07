// Import libraries from io (input/output)
// package to handle file streams
import java.io.*;

public class Checked3App{
    public static void main(String[] args) throws IOException {
        System.out.println("### Enter main() ...");

        try {
            // Get filename as specified in the command argument
            String fileName = args[0];

            // Read and print the file contents
            readTxtFile(fileName);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("=== Please provide a file name!");
            System.out.println("=== Exception Name: " + e.getClass().getName());
            System.out.println("=== Exception Message: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("=== File doesn't exist!");
            System.out.println("=== Exception Name: " + e.getClass().getName());
            System.out.println("=== Exception Message: " + e.getMessage());
        }
        
        // Reached end of the file
        System.out.println("### Exit main()!");
    }

    public static void readTxtFile(String fileName) throws IOException {
        System.out.println("### Enter readTxtFile() ...");
    
        // Open a file for reading and pass to a buffer 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        
        // Define a variable which will store the lines as we load them
        String line;
    
        // Loop to read and print lines until file end
        line = String.format("Contents of '%s'", fileName);
        while(line!=null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        } 
        
        // Close buffer/file io stream
        bufferedReader.close();
        System.out.println("### Exit readTxtFile()!");

    }
}