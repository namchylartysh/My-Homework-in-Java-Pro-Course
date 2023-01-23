package homework19;

import java.io.*;
import java.util.Scanner;

/**
 * Java Professional Homework #19
 *
 * @author Artysh
 * @version 19.01 - 23.01
 */
public class Homework19 {


    public static void main(String[] args) {
        File file = new File(sep + "My Professional Java Course" +
                sep + "src" + sep + "homework19" + sep + "text.txt");


        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.length());

        byteArrayStreamDemo();
        fileOutputStreamDemo();
        fileInputStreamDemo();
        fileWriteDemo();
        fileReadDemo();

        localHistory();
    }

    static void byteArrayStreamDemo() {
        byte[] buffer = {66, 67, 68};
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        int x;
        while ((x = bais.read()) != -1) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void fileOutputStreamDemo() {
        byte[] buffer = {48, 49, 50};
        try (FileOutputStream fos = new FileOutputStream(sep + "My Professional Java Course" +
                sep + "src" + sep + "homework19" + sep + "byte_file.bin")){
            fos.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileInputStreamDemo() {
        byte[] buffer = new byte[3];
        try (FileInputStream fis = new FileInputStream(sep + "My Professional Java Course" +
                sep + "src" + sep + "homework19" + sep + "byte_file.bin")){
            fis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (byte b : buffer) {
            System.out.println(b + " " + (char) b);
        }
    }

    static void fileWriteDemo() {
        try (FileWriter fw = new FileWriter(sep + "My Professional Java Course" +
                sep + "src" + sep + "homework19" + sep + "char_file.txt")){
            fw.write("Hello dudes!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void fileReadDemo() {
        char[] buffer = new char[12];
        try (FileReader fr = new FileReader(sep + "My Professional Java Course" +
                sep + "src" + sep + "homework19" + sep + "char_file.txt")){
            fr.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(buffer));
    }

    static void localHistory() {
        File hist = new File(sep + "My Professional Java Course" + sep + "src" + sep + "homework19" + sep + "localHistory.txt");
        try (Scanner scanner = new Scanner(hist)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static final String sep = File.pathSeparator;
}
