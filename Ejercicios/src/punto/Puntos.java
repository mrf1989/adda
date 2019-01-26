package punto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ficheros.Ficheros;

public class Puntos {

	public static Punto create(Double x, Double y) {
		return new PuntoImpl(x, y);
	}
	
	public static Punto create(String p) {
		String[] arr = p.replace("(", "").replace(")", "").split(",");
		Double x = Double.valueOf(arr[0].trim());
		Double y = Double.valueOf(arr[1].trim());
		return create(x, y);
	}
	
	public static List<Punto> createPuntos(List<String> ls) {
		List<Punto> r = new ArrayList<>();
		for (String str : ls) {
			Punto p = create(str);
			r.add(p);
		}
		return r;
	}
	
	public static List<Punto> createPuntos(String path) throws FileNotFoundException, IOException {
		List<String> ls = Ficheros.leer(path);
		return createPuntos(ls);
	}
	
}
