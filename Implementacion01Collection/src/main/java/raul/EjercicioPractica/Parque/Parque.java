package raul.EjercicioPractica.Parque;

import raul.EjercicioPractica.Visitante.Visitante;
import raul.Model.linkedlist.singly.LinkedList;
import raul.Model.util.Iterator.Iterator;

public class Parque {
    public LinkedList<Atraccion> atracciones;
    public LinkedList<Visitante> visitantesActuales;

    public Parque() {
        this.atracciones = new LinkedList<>();
        this.visitantesActuales = new LinkedList<>();
    }


    public Iterator<Atraccion> atraccionesIterator() {
        return atracciones.iterator();
    }

    public Iterator<Visitante> visitantesActualesIterator() {
        return visitantesActuales.iterator();
    }

    public void agregarAtraccion(Atraccion atraccion) {
        atracciones.add(atraccion);
    }

    public void agregarVisitante(Visitante visitante) {
        visitantesActuales.add(visitante);
    }

    public void eliminarVisitanteParque(Visitante visitante) {
        visitantesActuales.remove(visitante);
    }

    public void eliminarAtraccion(Atraccion atraccion) {
        atracciones.remove(atraccion);
    }

    public void cerrarAtraccion(Atraccion atraccion) {
        atraccion.setAtraccionActiva(false);
    }

    public void abrirAtraccion(Atraccion atraccion) {
        atraccion.setAtraccionActiva(true);
    }

}
