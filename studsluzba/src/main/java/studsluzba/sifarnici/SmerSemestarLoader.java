package studsluzba.sifarnici;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

public class SmerSemestarLoader {
	
	public static List<SmerSemestar> getEntitites() {
		URL url = SmerSemestarLoader.class.getResource("/sifarnici/semestarSmer.txt");
		String path = url.getPath();
		
		List<SmerSemestar> res = new ArrayList<SmerSemestar>();
		System.out.println("SMER SEMSESTAR LOADER");
		try {
			Scanner scanner = new Scanner(new File(path));
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] split = line.split(":");
				String smer = split[0];
				String sem = split[1];
				String[] p = split[2].split(",");
				res.add(new SmerSemestar(smer, sem, p));
			}
			return res;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
