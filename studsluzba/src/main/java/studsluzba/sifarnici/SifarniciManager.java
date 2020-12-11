package studsluzba.sifarnici;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SifarniciManager {
		
	public static String getPath(Sifarnik s) {
		URL url = null;
		if (s == Sifarnik.DRZAVA_GRADOVI) {
			url = SifarniciManager.class.getResource("/sifarnici/drzava.txt");
			return url.getPath();
		}
		if (s == Sifarnik.SMER_SEMESTAR) {
			url = SifarniciManager.class.getResource("/sifarnici/semestarSmer.txt");
			return url.getPath();
		}
		if (s == Sifarnik.SREDNJE_SKOLE) {
			url = SifarniciManager.class.getResource("/sifarnici/srednjeSkole.txt");
			return url.getPath();
		}
		return "";
	}
	
	public List<String> getSrednjeSkoleData() {
		String path = getPath(Sifarnik.SREDNJE_SKOLE);
		
		List<String> res = new ArrayList<String>();
		System.out.println("SREDNJA SKOLA LOADER");
		try {
			Scanner scanner = new Scanner(new File(path));
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				res.add(line);
			}
			scanner.close();
			return res;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DrzavaGradovi> getDrzavaData() {
		String path = getPath(Sifarnik.DRZAVA_GRADOVI);
		
		List<DrzavaGradovi> res = new ArrayList<DrzavaGradovi>();
		System.out.println("DRZAVA LOADER");
		try {
			Scanner scanner = new Scanner(new File(path));
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String[] split = line.split(":");
				String drzava = split[0];
				String[] gradovi = split[1].split(",");
				res.add(new DrzavaGradovi(drzava, gradovi));
			}
			scanner.close();
			return res;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<SmerSemestar> getSmerSemestarData() {
		String path = getPath(Sifarnik.SMER_SEMESTAR);
		
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
			scanner.close();
			return res;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
