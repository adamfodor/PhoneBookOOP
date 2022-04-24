package phonebook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Entry> people;

		FileOperations operations = new FileOperations();

		people = operations.read();
		Operations ops = new Operations(people);

		while (true) {
			System.out.println("1. Rekordok listazása");
			System.out.println("2. Rekord hozzáadása");
			System.out.println("3. Rekord törlése");
			System.out.println("4. Keresés");
			System.out.println("5. Rekord szerkesztése");
			System.out.println("0. Kilépés\n");

			Scanner input = new Scanner(System.in);
			try {
				int choice = input.nextInt();
				
				if (choice >= 0 && choice <= 5) {
					if (choice == 0) {
						operations.save("db.txt", people);
						System.exit(0);
					}
					if (choice == 1) {
						ops.print();
					}
					if (choice == 2) {
						ops.toList(ops.addEntry());
					}
					if (choice == 3) {
						if(ops.delete()) {
							System.out.println("sikeres törlés");
						}else {
							System.out.println("Sikertelen törlés");
						}
					}
					if (choice == 5) {
						
						if(ops.mod()) {
							System.out.println("Sikeres modositás");
						}else {
							System.out.println("Sikertelen modosítás");
						}
					}
					if (choice == 4) {
						ops.keres();
					}

				} else {
					System.out.println("0 és 4 között válasszon.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
