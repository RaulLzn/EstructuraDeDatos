package raul.EjercicioPractica;

import raul.EjercicioPractica.Parque.Atraccion;
import raul.EjercicioPractica.Parque.Parque;
import raul.EjercicioPractica.Visitante.Visitante;
import raul.Model.util.Iterator.Iterator;

public class Main {
    public static void main(String[] args) {
        // Crear un parque de atracciones
        Parque parque = new Parque();

        // Crear algunas atracciones
        Atraccion montanaRusa = new Atraccion("Montaña Rusa", 10);
        Atraccion noria = new Atraccion("Noria", 15);

        // Agregar las atracciones al parque
        parque.agregarAtraccion(montanaRusa);
        parque.agregarAtraccion(noria);

        // Crear algunos visitantes
        Visitante juan = new Visitante("Juan");
        Visitante maria = new Visitante("Maria");
        Visitante pedro = new Visitante("Pedro");

        // Agregar visitantes al parque
        parque.agregarVisitante(juan);
        parque.agregarVisitante(maria);
        parque.agregarVisitante(pedro);

        // Agregar visitantes a las atracciones
        montanaRusa.agregarVisitanteAAtraccion(juan);
        montanaRusa.agregarVisitanteAAtraccion(maria);
        noria.agregarVisitanteAAtraccion(pedro);

        // Mostrar información
        System.out.println("Estado actual del parque:");
        System.out.println("Atracciones:");

        Iterator<Atraccion> atraccionesIterator = parque.atraccionesIterator();
        while (atraccionesIterator.hasNext()) {
            Atraccion atraccion = atraccionesIterator.next();
            System.out.println("- " + atraccion.getNombre());
            System.out.println("  Capacidad: " + atraccion.getCapacidad());
            System.out.println("  Visitantes actuales: " + atraccion.getVisitantesActuales().size());
            System.out.println("  Cola de espera: " + atraccion.getColaDeEspera().size());
            System.out.println("  Atracción activa: " + (atraccion.isAtraccionActiva() ? "Sí" : "No"));
            System.out.println("  Visitantes en la Atraccion actual: ");
            atraccion.imprimirVisitantesActuales();
            for (int ii = 0; ii < atraccion.visitantesActuales.size(); ii++){
                System.out.println(atraccion.visitantesActuales.get(ii));
            }
        }

        System.out.println("\nVisitantes actuales en el parque:");
        Iterator<Visitante> visitantesIterator = parque.visitantesActualesIterator();
        while (visitantesIterator.hasNext()) {
            Visitante visitante = visitantesIterator.next();
            System.out.println("- " + visitante.getNombre());
        }



    }
}

