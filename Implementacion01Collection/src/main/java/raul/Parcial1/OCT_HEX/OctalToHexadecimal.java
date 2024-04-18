package raul.Parcial1.OCT_HEX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import raul.Model.Stack.list.Stack;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

public class OctalToHexadecimal {
    private Stack<String> octal;
    private LinkedList<String> binary;
    private LinkedList<String> hexadecimal;

    public OctalToHexadecimal() {
        this.octal = new Stack<>();
        this.binary = new LinkedList<>();
        this.hexadecimal = new LinkedList<>();
    }

    /**
     * Convert the octal number to hexadecimal
     */
    public void convert() {
        String filePathR = "src/main/java/raul/Parcial1/OCT_HEX/in.oct";

        /**
         * Read the file and convert the octal number to binary
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    octal.push(String.valueOf(currentChar));
                }
            }
            convertToBinary();
            convertBinaryToHexadecimal();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePathW = "src/main/java/raul/Parcial1/OCT_HEX/out.hex";

        /**
         * Write the hexadecimal number to a file
         */
        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<String> iterator = hexadecimal.iterator();
            while(iterator.hasNext()){
                writer.write(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert the octal number to binary
     */
    private void convertToBinary() {
        while(!octal.isEmpty()){
            String conversion = String.format("%3s", Integer.toBinaryString(Integer.parseInt(octal.pop()))).replace(' ', '0');
            binary.addFirst(conversion.split(""));
        }
    }

    /**
     * Convert the binary number to hexadecimal
     */
    private void convertBinaryToHexadecimal() {
        String number="";
        int numberToConvert=0;
        while(!binary.isEmpty()){
            number = arrayToString(binary.pollLastArray(4));
            numberToConvert = Integer.parseInt(number, 2);
            String hex = Integer.toHexString(numberToConvert);
            hexadecimal.addFirst(hex.toUpperCase());
        }
    }

    /**
     * Convert an array to a string
     * @param array
     * @return
     */
    private String arrayToString(Object[] array) {
        StringBuilder answer = new StringBuilder();
        for (Object element : array) {
            answer.append(element != null ? element.toString() : "");
        }
        return answer.toString();
    }

}
