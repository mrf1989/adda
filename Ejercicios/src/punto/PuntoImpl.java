package punto;

public class PuntoImpl implements Punto {
	private Double x;
	private Double y;
	
	public PuntoImpl() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public PuntoImpl(Double x, Double y) {
		this.x = x;
		this.y = y;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public Cuadrante getCuadrante() {
		Cuadrante c = null;
		if (x > 0 && y > 0) {
			c = Cuadrante.PRIMER_CUADRANTE;
		} else if (x < 0 && y > 0) {
			c = Cuadrante.SEGUNDO_CUADRANTE;
		} else if (x < 0 && y < 0) {
			c = Cuadrante.TERCER_CUADRANTE;
		} else if (x > 0 && y < 0) {
			c = Cuadrante.CUARTO_CUADRANTE;
		}
		return c;
	}
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
