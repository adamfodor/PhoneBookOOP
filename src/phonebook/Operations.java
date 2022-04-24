package phonebook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Operations {
	
	private ArrayList<Entry> list;

	public Operations(ArrayList<Entry> l) {
		this.list = l;

	}

	Scanner input = new Scanner(System.in);
	Search sr = new Search();
	Modify m = new Modify();

	/**
	 * Ez az a fuggveny ami kiirja az indexukkle egyutt a tárolt adatokat.
	 */
	public void print() {
		clear();
		if (size(list) == 0) {
			System.out.println("Nincs tárolt adat\n");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(i + 1 + ". " + list.get(i));
			}
		}

	}

	/**
	 * Amikor uj rekordot akarunk hozza adni ez a fuggveny keri be sorba az
	 * adatokat.
	 * 
	 * @return Uj Entry
	 */
	public Entry addEntry() {
		clear();
		System.out.println("Vezeték név?");
		String ln = input.next();
		System.out.println("Kereszt név?");
		String fn = input.next();
		System.out.println("Becenév");
		String nn = input.next();
		System.out.println("cím:");
		String addr = input.next();
		System.out.println("Munkahely telefonszám:");
		String wnum = input.next();
		System.out.println("Magán telefon szám:");
		String pnum = input.next();

		return new Entry(ln, fn, nn, addr, wnum, pnum);
	}

	/**
	 * Ez aza fuggveny ami a listahoz fogja adni az uj Entry objektumot.
	 * 
	 * @param x Entry tipusu
	 */
	public void toList(Entry x) {
		list.add(x);

	}

	/**
	 * Letörli a konzolt és utána folytatja. Ha torolni szeretnenk a listabol ezeel
	 * lehet.
	 * @return True ha sikerult a törlés, False ha nem sikerult a torles.
	 */
	public boolean delete() {
		clear();
		boolean result = true;
		System.out.println("Melyiket szeretné törölni?");
		Entry choseen = chosing(list);
		if (choseen != null) {
			list.remove(choseen);

			result = true;
		} else {

			result = false;
		}
		return result;
	}

	protected int size(ArrayList<Entry> db) {
		return db.size();
	}

	/**
	 * Letorli a konzolt majd lehet valasztani ,hogy hogyan akarunk keresni.
	 */
	public void keres() {
		clear();
		sr.keres(list);
	}

	/**
	 * Letorli a konzolt. Kilistazza a rekordokat. és indexuk alapján lehet
	 * választani. Ellenorzi a bemenetet hogy szám legyen és ne olyat valasszon ami
	 * nincs benne.
	 * 
	 * @return Entry tipusu objektummal ter vissza vagy null ha nem sikerult a kivalasztas.
	 */
	public Entry chosing(ArrayList<Entry> l) {
		clear();
		print();
		Entry res = null;
		if (l.size() == 0) {
			res = null;
			return res;
		}
		try {
			int index = input.nextInt() - 1;
			if (index >= 0 && index < l.size()) {
				res = l.get(index);
			} else {
				
				res = null;
			}
		} catch (Exception e) {
			res = null;
		}
		clear();
		return res;
	}

	/**
	 * Ha modositani akarunk egy rekordot akkor ez lesz meghivva. Letorli a konzolt.
	 * @return true ha sikerult, false ha nem sikerult modositani.
	 */
	public boolean mod() {
		clear();
		boolean result = true;
		Entry chose = chosing(list);
		if (chose == null) {
			result = false;

			return result;
		} else {
			m.modAll(chose);

			result = true;
		}
		return result;
	}

	/**
	 * Ez a fuggveny letorli a konzolt.
	 */
	private void clear() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (IOException | InterruptedException e) {
			System.out.println("Hiba történt!");
			e.printStackTrace();
		}
	}

}
