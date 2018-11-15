package ejercicio2;

public class Ejercicio2 {

	public static Long combiRecSinMem(Integer n, Integer k) {
		Long res = 0L;
		
		if (k == 0 || k == n) {
			res = 1L;
		} else if (k == 1 || k == n -1) {
			res = (long) n;
		} else {
			res = combiRecSinMem(n-1,k-1) + combiRecSinMem(n-1, k);
		}
		
		return res;
	}
	
}
