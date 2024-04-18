package raul.Parcial1.OCT_HEX;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import raul.Model.Stack.list.Stack;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

public class HexadecimalToOctal {
    private Stack<String> hexadecimal;
    private LinkedList<String> binary;
    private LinkedList<String> octal;

    public HexadecimalToOctal() {
        this.hexadecimal = new Stack<>();
        this.binary = new LinkedList<>();
        this.octal = new LinkedList<>();
    }

    /**
     * Convert the hexadecimal number to octal
     */
    public void convert() {
        String filePathR = "src/main/java/raul/Parcial1/OCT_HEX/in.hex";

        /**
         * Read the file and convert the hexadecimal number to binary
         */
        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    hexadecimal.push(String.valueOf(currentChar));
                }
            }
            convertToBinary();
            convertBinaryToOctal();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePathW = "src/main/java/raul/Parcial1/OCT_HEX/out.oct";

        /**
         * Write the octal number to a file
         */
        try (FileWriter writer = new FileWriter(filePathW)) {
            Iterator<String> iterator = octal.iterator();
            while(iterator.hasNext()){
                writer.write(iterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Convert the hexadecimal number to binary
     */
    private void convertToBinary() {
        while(!hexadecimal.isEmpty()){
            String conversion = String.format("%4s", Integer.toBinaryString(Integer.parseInt(hexadecimal.pop(), 16))).replace(' ', '0');
            binary.addFirst(conversion.split(""));
        }
    }

    /**
     * Convert the binary number to octal
     */
    public void convertBinaryToOctal(){
        String number="";
        int numberToWork=0;
        while(!binary.isEmpty()){
            number = arrayToString(binary.pollLastArray(3));
            numberToWork = Integer.parseInt(number, 2);
            String oct = Integer.toOctalString(numberToWork);
            octal.addFirst(oct);
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

    public static void main(String[] args) {
        HexadecimalToOctal hexToOct = new HexadecimalToOctal();
        hexToOct.convert();
    }

}
