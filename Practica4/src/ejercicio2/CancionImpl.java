package ejercicio2;

import java.time.Duration;

public class CancionImpl implements Cancion {
	private String nombre;
	private Duration duracion;
	
	public CancionImpl(String nombre, Duration duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Duration getDuracion() {
		return this.duracion;
	}
	
	public String toString() {
		return this.nombre + " - " + this.duracion.getSeconds() + " segundos.";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancionImpl other = (CancionImpl) obj;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public int compareTo(Cancion c) {
		return this.duracion.compareTo(c.getDuracion());
	}
	
	

}
