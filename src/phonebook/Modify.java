package phonebook;

import java.util.Scanner;

public class Modify {

	Scanner input = new Scanner(System.in);
	/**
	 * Modositani leht a parameter keresztnevet(First name)
	 * @param x Entry object
	 */
	private void modFname(Entry x) {
		System.out.println("Korábbi keresztnév: " + x.getFirstName());
		System.out.println("Új keresztnév:");
		String temp = input.next();
		x.setFirstName(temp);
	}
	/**
	 *  Modositani leht a parameter vezetek nevet(Last name)
	 * @param x entry object
	 */
	private void modLname(Entry x) {
		System.out.println("Korábbi vezetéknév: " + x.getLastName());
		System.out.println("Új vezetéknév:");
		String temp = input.next();
		x.setLastName(temp);
	}
	/**
	 *  Modositani leht a parameter bece nevet(Nick name)
	 * @param x Entry object
	 */

	private void modNname(Entry x) {
		System.out.println("Korábbi becenév: " + x.getNickname());
		System.out.println("Új becenév:");
		String temp = input.next();
		x.setNickname(temp);
	}
	/**
	 * Modositani lehet a parameter privat telefonszamat(Private number)
	 * @param x Entry object
	 */
	private void modPnum(Entry x) {
		System.out.println("Korábbi  privát telefonszám: " + x.getPrivateNum());
		System.out.println("Új privát telefonszám:");
		String temp = input.next();
		x.setPrivateNum(temp);
	}
	/**
	 * Modositani leht a parameter munkas telefonszamt(Working number)
	 * @param x Entry object
	 */
	private void modWnum(Entry x) {
		System.out.println("Korábbi munkás telefonszám: " + x.getWorkNum());
		System.out.println("Új munkás telefonszám:");
		String temp = input.next();
		x.setWorkNum(temp);
	}
	/**
 	* Modositani leht a parameter cimet(Address)
 	* @param x Entry object
 	*/
	private void modAddr(Entry x) {
		System.out.println("Korábbi cím: " + x.getAddress());
		System.out.println("Új cím:");
		String temp = input.next();
		x.setAddress(temp);
	}
	
	/**
	 * Ebben a fuggvenyben lehget kiválasztani, hogy mit szeretnenk modositani.
	 * @param x Entry tipusu objektum
	 * @return true ha sikerult a modositas, False ha nem sikerult modositani.
	 */
	public boolean modAll(Entry x) {
		boolean res = true;
		System.out.println("mit szeretne modositani?");
		System.out.println("""
				1. Vezetéknév
				2. Keresztnév
				3. Becenév
				4. Privát telefonszám
				5. Munkás telefonszám
				6. Cím""");
		try {
			int choose = input.nextInt();
			if (choose >= 1 && choose <= 6) {
				if (choose == 1) {
					modLname(x);
				}
				if (choose == 2) {
					modFname(x);
				}
				if (choose == 3) {
					modNname(x);
				}
				if (choose == 4) {
					modPnum(x);
				}
				if (choose == 5) {
					modWnum(x);
				}
				if (choose == 6) {
					modAddr(x);
				}

				res = true;

			} else {

				res = false;
			}
		} catch (Exception e) {
			System.out.println("Számot írjon be");
			res = false;
		}
		return res;
	}

}
