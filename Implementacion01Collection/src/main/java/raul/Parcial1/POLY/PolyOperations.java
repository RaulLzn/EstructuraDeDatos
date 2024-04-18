package raul.Parcial1.POLY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

public class PolyOperations {
    public static void main(String[] args) {
        /**
         * Read the file and create the polynomials
         */
        LinkedList<Polynomial> polynomials = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/raul/Parcial1/POLY/polynomials.poly"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                LinkedList<Integer> coefficients = new LinkedList<>();
                for (String part : parts) {
                    coefficients.add(Integer.parseInt(part.trim()));
                }
                polynomials.add(new Polynomial(coefficients));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Perform the operations
         */
        Polynomial result = polynomials.peek();
        Iterator<Polynomial> iterator = polynomials.iterator();
        iterator.next(); // Saltar el primer polinomio
        while (iterator.hasNext()) {
            result = result.subtract(iterator.next());
        }
        System.out.println("Resultado de la resta de polinomios: " + result);

        /**
         * Derive the first polynomial
         */
        Polynomial derivative = polynomials.peek().derive();
        System.out.println("Derivada del polinomio: " + derivative);

        /**
         * Evaluate the polynomials in the interval (1, 3]
         */
        int a = 1; // Inicio del intervalo
        int b = 3; // Fin del intervalo
        Iterator<Polynomial> iter = polynomials.iterator();
        while (iter.hasNext()) {
            Polynomial polynomial = iter.next();
            int evaluationAtA = polynomial.evaluate(a);
            int evaluationAtB = polynomial.evaluate(b);
            int evaluationDifference = evaluationAtB - evaluationAtA;
            System.out.println("Evaluación del polinomio " + polynomial + " en el intervalo (" + a + ", " + b + "]: "
                    + evaluationDifference);
        }

        /**
         * Write the results to a file
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/raul/Parcial1/POLY/result.poly"))) {
            writer.write("Resultado de la resta de polinomios: " + result + "\n");
            writer.write("Derivada del primer polinomio: " + derivative + "\n");
            Iterator<Polynomial> it = polynomials.iterator();
            while (it.hasNext()) {
                Polynomial polynomial = it.next();
                writer.write("Evaluación del polinomio " + polynomial + " en el intervalo (" + a + ", " + b + "]: "
                        + evaluatePolynomialInInterval(polynomial, a, b) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Evaluate a polynomial in the interval (a, b]
     *
     * @param polynomial
     * @param a
     * @param b
     * @return
     */
    public static int evaluatePolynomialInInterval(Polynomial polynomial, int a, int b) {
        // Evaluamos el polinomio en b y restamos el resultado de evaluarlo en a
        return polynomial.evaluate(b) - polynomial.evaluate(a);
    }

}

