import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseEngine {
    public static void writeBinaryFile(String fileLocation, List<String> fileData){
        File file = new File(fileLocation);

        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos);
             DataOutputStream dos = new DataOutputStream(bos))
        {
            for(String line : fileData){
                dos.writeBytes(line);
                dos.writeBytes("\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> readBinaryFile(String fileLocation) {
        File file = new File(fileLocation);
        List<Integer> fileData = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis);
             DataInputStream dis = new DataInputStream(bis))
        {
            int readByte;
            while ((readByte = dis.read()) != -1){
                fileData.add(readByte);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return fileData;
    }

    public static List<Character> asciiToCharArray(List<Integer> asciiValues){
        return asciiValues.stream().map(v -> (char) ((int) v)).toList();
    }

    public static void main(String[] args) {
        List<String> fileData = new ArrayList<>();
        fileData.add("Hello");
        fileData.add("Test");
        writeBinaryFile("IndexerProject/src/test.out", fileData);
        List<Character> data = asciiToCharArray(readBinaryFile("IndexerProject/src/test.out"));
        data.forEach(System.out::print);
    }

}
