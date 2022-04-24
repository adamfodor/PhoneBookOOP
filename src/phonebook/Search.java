package phonebook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ez az osztaly szolgal a kereso metodusok megvalositasara es hasznalatara.
 */
public class Search {

	Scanner input = new Scanner(System.in);

	/**
	 * Ez a metodus felel a nev szerinti keresesert. Lehet vezetek nev, kereszt nev
	 * vagy bece nev alapjan keresni. Ha van talalat ki irja, ha nincs akkor nem ir
	 * ki semmit.
	 * 
	 * @param db
	 * 
	 */
	protected ArrayList<Entry> byName(ArrayList<Entry> db, String kire) {
		ArrayList<Entry> temp = new ArrayList<>();

		if (db.size() == 0) {
			System.out.println("Nincs talalat");
		} else {
			kire.replace(" ", "");
			Pattern p = Pattern.compile(kire, Pattern.CASE_INSENSITIVE);
			for (Entry entry : db) {
				String name = entry.getLastName() + entry.getFirstName() + entry.getNickname();
				Matcher m = p.matcher(name);
				if (m.find()) {
					temp.add(entry);
				}
			}
		}
		return temp;
	}

	/**
	 *
	 * @param db Ez a metodus felel a nev szerinti keresesert. Lehet privat es
	 *           munkas telefon szem alapjan keresni Ha van talalat ki irja, ha
	 *           nincs akkor nem ir ki semmit.
	 * @return
	 */
	protected ArrayList<Entry> byNum(ArrayList<Entry> db, String kire) {
		ArrayList<Entry> temp = new ArrayList<>();

		if (db.size() == 0) {
			System.out.println("Nincs találat");

		} else {
			Pattern p = Pattern.compile(kire, Pattern.CASE_INSENSITIVE);
			for (Entry entry : db) {
				String num1 = entry.getPrivateNum();
				String num2 = entry.getWorkNum();
				Matcher m1 = p.matcher(num1);
				Matcher m2 = p.matcher(num2);
				if (m1.find() || m2.find()) {
					temp.add(entry);
				}
			}
		}
		return temp;

	}

	/**
	 * Ez a metodus felel a nev szerinti keresesert. Lehet cím alapjan keresni. Ha
	 * van talalat ki irja, ha nincs akkor nem ir ki semmit.
	 * 
	 * @param db
	 * @return
	 * 
	 */
	protected ArrayList<Entry> byAddress(ArrayList<Entry> db, String cim) {
		ArrayList<Entry> temp = new ArrayList<>();

		if (db.size() == 0) {
			System.out.println("Nincs találat");

		} else {
			cim.replace(" ", "");
			Pattern p = Pattern.compile(cim, Pattern.CASE_INSENSITIVE);
			for (Entry entry : db) {
				String addr = entry.getAddress().replaceAll(" ", "");
				Matcher m = p.matcher(addr);
				if (m.find()) {
					temp.add(entry);
				}
			}
		}
		return temp;
	}

	/**
	 * Ez a metodu lesz meghivva ha keresni akarunk. Itt lehet valasztani, hogy
	 * milyen modon szeretnenk kersni.
	 * 
	 * @param db
	 * 
	 */
	protected void print(ArrayList<Entry> temp) {
		for (Entry x : temp) {
			System.out.println(x);
		}
	}

	public void keres(ArrayList<Entry> db) {
		System.out.println("Hogy szeretne keresni?");
		System.out.println("1. Nev alapján\n2. Telefon szám alapján\n3. Cím alapján\n0. Vissza");

		try {
			int choice = input.nextInt();

			if (choice >= 0 && choice <= 3) {
				if (choice == 1) {
					System.out.println("Kire szeretne keresni? ");
					String kire = input.next();
					print(byName(db, kire));
				} else if (choice == 2) {
					System.out.println("Melyik telefonszámra szeretne keresni?");
					String kire = input.next();
					print(byNum(db, kire));
				} else if (choice == 3) {
					System.out.println("Melyik címre szeretne kersni?");
					String cim = input.next();
					print(byAddress(db, cim));
				} else if (choice == 0) {
					return;
				}
			}
		} catch (Exception e) {
			System.out.println("Számot írjon be\nProbálja újra.");
		}

	}
}
