package ejercicio2;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import us.lsi.dyv.problemasdelistas.ProblemasDeListas;

public class Test {
	
	public static void main(String[] args) {
		Cancion c1 = new CancionImpl("Soldadito Marinero", Duration.ofSeconds(190));
		Cancion c2 = new CancionImpl("Calle sin luz", Duration.ofSeconds(200));
		Cancion c3 = new CancionImpl("Jesucristo García", Duration.ofSeconds(210));
		Cancion c4 = new CancionImpl("Bohemian Rhapsody", Duration.ofSeconds(345));
		Cancion c5 = new CancionImpl("Lobo solitario", Duration.ofSeconds(254));
		Cancion c6 = new CancionImpl("Donde nace el R&R", Duration.ofSeconds(198));
		Cancion c7 = new CancionImpl("Debajo del puente", Duration.ofSeconds(247));
		Cancion c8 = new CancionImpl("Puro frenesí", Duration.ofSeconds(201));
		Cancion c9 = new CancionImpl("It was so easy", Duration.ofSeconds(221));
		Cancion c10 = new CancionImpl("Hace you ever seen the rain?", Duration.ofSeconds(286));
		
		Cancion[] tracks = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10};
		List<Cancion> trackList = Arrays.asList(tracks);
		
		Cancion t = ProblemasDeListas.getKesimo(trackList, 1);
		
		System.out.println(t);
		

	}

}
