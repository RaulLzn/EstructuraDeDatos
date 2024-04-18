package raul.Parcial1.STD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.function.ToIntFunction;

import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.array.Array;
import raul.Model.util.Iterator.Iterator;

public class STD {
    LinkedList<Integer> lista;
    LinkedList<Integer> elementos;
    float media;
    float mediana;
    Array<Integer> frecuencias;
    LinkedList<Integer> moda;

    public STD() {
        this.lista = new LinkedList<>();
        this.media = 0.0f;
        this.moda = new LinkedList<>();
        this.mediana = 0.0f;
        this.elementos = new LinkedList<>();
    }

    public void startCount() {
        String filePathR = "src/main/java/raul/Parcial1/STD/std.in";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePathR))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String firstNumber = line.replaceAll("\\D", "");
                lista.add(Integer.parseInt(firstNumber));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        calcularMedia();
        calcularMediana();
        establecerElementos();
        obtenerFrecuencias();
        calcularModa();

        String filePathW = "src/main/java/raul/Parcial1/STD/std.out";

        try (FileWriter writer = new FileWriter(filePathW)) {
            writer.write("Media: " + media + "\n");
            writer.write("Mediana: " + mediana + "\n");
            Iterator<Integer> elemento = elementos.iterator();
            Iterator<Integer> frecuencia = frecuencias.iterator();
            while (elemento.hasNext()) {
                writer.write("Frecuencia del " + elemento.next() + " es de: " + frecuencia.next() + "\n");
            }
            Iterator<Integer> modas = moda.iterator();
            while (modas.hasNext()) {
                writer.write("La moda es: " + modas.next() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void calcularMedia() {
        float suma = 0.0f;
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            suma += it.next();
        }
        media = suma / lista.size();
    }

    public void calcularMediana(){
        float mediana = 0;
        lista.sort(e -> e);
        int mid = lista.size()/2;
        int i=0;
        Iterator<Integer> iterator = lista.iterator();
        if (lista.size() % 2 == 1){
            while(i++ < mid){
                iterator.next();
            }
            mediana=iterator.next();
        }
        else{
            while(i++ < mid-1){
                iterator.next();
            }
            mediana+=iterator.next();
            mediana+=iterator.next();
            mediana /= 2;
        }
        this.mediana = mediana;
    }

    private void establecerElementos() {
        Iterator<Integer> iterator = lista.iterator();
        while (iterator.hasNext()) {
            Integer numero = iterator.next();
            if (!elementos.contains(numero)) {
                elementos.add(numero);
            }
        }
    }

    public void obtenerFrecuencias(){
        Iterator<Integer> iterator = elementos.iterator();
        frecuencias = new Array<>(elementos.size());
        while (iterator.hasNext()){
            frecuencias.add(contar(iterator.next()));
        }
    }

    private int contar(int n) {
        int count = 0;
        Iterator<Integer> iterator = lista.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == n) {
                count++;
            }
        }
        return count;
    }

    public void calcularModa(){
        int mayor = 0;
        Iterator<Integer> iterator = elementos.iterator();
        Iterator<Integer> iteratorF = frecuencias.iterator();
        while (iteratorF.hasNext()){
            Integer i = iteratorF.next();
            if (i>mayor) mayor = i;
        }
        for (int i=0; i<elementos.size(); i++){
            Integer s = iterator.next();
            if (frecuencias.get(i) == mayor){
                this.moda.add(s);
            }
        }
    }

    public static void main(String[] args) {
        STD std = new STD();
        std.startCount();
    }
}
