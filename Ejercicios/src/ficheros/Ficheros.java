package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Ficheros {
	
	public static List<String> leer(String path) throws FileNotFoundException, IOException {
		List<String> res = new ArrayList<>();
		String line;
		File file = new File(path);
		FileReader f = new FileReader(file);
		BufferedReader buffer = new BufferedReader(f);
		while ((line = buffer.readLine()) != null) {
			res.add(line);
		}
		buffer.close();
		return res;
	}
	
	public static <E> void escribir(List<E> ls, String path) throws IOException {
		FileWriter f = new FileWriter(path);
		PrintWriter pw = new PrintWriter(f);
		int e = 0;
		while (e < ls.size()) {
			pw.println(ls.get(e));
			e = e + 1;
		}
		f.close();
	}
	
}
