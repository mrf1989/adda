package ejercicio2;

import java.time.Duration;

public interface Cancion extends Comparable<Cancion> {
	String getNombre();
	Duration getDuracion();
}
