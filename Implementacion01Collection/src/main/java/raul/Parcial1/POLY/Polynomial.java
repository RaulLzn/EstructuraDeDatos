package raul.Parcial1.POLY;

import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

class Polynomial {
    private LinkedList<Integer> coefficients;

    public Polynomial(LinkedList<Integer> coefficients) {
        this.coefficients = new LinkedList<>();
        // Invertir la lista de coeficientes y agregarlos al polinomio
        LinkedList<Integer> reversedCoefficients = reverseLinkedList(coefficients);
        Iterator<Integer> iter = reversedCoefficients.iterator();
        while (iter.hasNext()) {
            this.coefficients.add(iter.next());
        }
    }

    /**
     * Invertir una lista enlazada
     * @param list Lista enlazada a invertir
     * @return Lista enlazada invertida
     */
    private LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversedList = new LinkedList<>();
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            reversedList.addFirst(iter.next());
        }
        return reversedList;
    }

    /**
     * Restar otro polinomio de este polinomio
     * @param other Polinomio a restar
     * @return Polinomio resultante
     */
    public Polynomial subtract(Polynomial other) {
        int maxSize = Math.max(coefficients.size(), other.coefficients.size());
        int[] resultCoefficients = new int[maxSize];
        
        Iterator<Integer> iter1 = coefficients.iterator();
        Iterator<Integer> iter2 = other.coefficients.iterator();
        for (int i = 0; i < maxSize; i++) {
            int coef1 = iter1.hasNext() ? iter1.next() : 0;
            int coef2 = iter2.hasNext() ? iter2.next() : 0;
            resultCoefficients[i] = coef1 - coef2;
        }
        
        return new Polynomial(new LinkedList<Integer>() {{
            for (int coef : resultCoefficients) {
                add(coef);
            }
        }});
    }

    /**
     * Derivar el polinomio
     * @return Polinomio derivado
     */
    public Polynomial derive() {
        LinkedList<Integer> resultCoefficients = new LinkedList<>();
        Iterator<Integer> iter = coefficients.iterator();
        int power = coefficients.size() - 1; // Comenzamos desde el coeficiente de mayor grado

        // Calcular la derivada de cada término y agregarla a la lista de coeficientes resultante
        while (iter.hasNext()) {
            int coef = iter.next();
            // Calcular el coeficiente derivado multiplicando el coeficiente original por el exponente actual
            // y reduciendo el exponente en uno
            int derivativeCoef = coef * power;
            // Reducir el exponente para el siguiente término
            power--;
            // Agregar el coeficiente derivado a la lista resultante
            resultCoefficients.add(derivativeCoef);
        }

        // Eliminar el término independiente (si existe)
        if (!resultCoefficients.isEmpty()) {
            resultCoefficients.pollLast();
        }
        LinkedList<Integer> result = reverseLinkedList(resultCoefficients);

        return new  Polynomial(result);
    }



    public int evaluate(int x) {
        int result = 0;
        int power = 0;
        Iterator<Integer> iter = coefficients.iterator();
        while (iter.hasNext()) {
            result += iter.next() * Math.pow(x, power);
            power++;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iter = coefficients.iterator();
        int power = coefficients.size() - 1;
        while (iter.hasNext()) {
            int coef = iter.next();
            if (coef != 0) {
                if (sb.length() > 0) {
                    sb.append(coef > 0 ? " + " : " - ");
                } else if (coef < 0) {
                    sb.append("-");
                }
                sb.append(Math.abs(coef));
                if (power > 0) {
                    sb.append("x");
                    if (power > 1) {
                        sb.append("^").append(power);
                    }
                }
            }
            power--;
        }
        return sb.toString();
    }
}