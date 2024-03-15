package raul.EjercicioPractica.Parque;

import raul.EjercicioPractica.Visitante.Visitante;

import raul.Model.array.Array;
import raul.Model.queue.list.Queue;
import raul.Model.util.Iterator.Iterator;


public class Atraccion {
    public String nombre;
    public int capacidad;
    public Queue<Visitante> colaDeEspera;
    public Array<Visitante> visitantesActuales;
    public boolean atraccionActiva;

    public Atraccion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.colaDeEspera = new Queue<>();
        this.visitantesActuales = new Array<>(capacidad);
        this.atraccionActiva = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Queue<Visitante> getColaDeEspera() {
        return colaDeEspera;
    }

    public void setColaDeEspera(Queue<Visitante> colaDeEspera) {
        this.colaDeEspera = colaDeEspera;
    }

    public Array<Visitante> getVisitantesActuales() {
        return visitantesActuales;
    }

    public boolean isAtraccionActiva() {
        return atraccionActiva;
    }

    public void setAtraccionActiva(boolean atraccionActiva) {
        this.atraccionActiva = atraccionActiva;
    }

    public boolean agregarVisitanteAAtraccion(Visitante visitante) {
        if (!atraccionActiva) {
            return false;
        }else if (visitantesActuales.size() < capacidad) {
            visitantesActuales.add(visitante);
            return true;
        } else {
            colaDeEspera.insert(visitante);
            return true;
        }
    }

    public boolean eliminarVisitanteAtaraccion(Visitante visitante) {
        if (!visitantesActuales.isEmpty()) {
            for (int ii = 0; ii < visitantesActuales.size(); ii++) {
                if (visitantesActuales.get(ii).equals(visitante)) {
                    visitantesActuales.remove(ii);
                    if (!colaDeEspera.isEmpty()) {
                        agregarVisitanteAAtraccion(colaDeEspera.extract());
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public boolean imprimirVisitantesActuales(){
        Iterator<Visitante> iterator = visitantesActuales.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
