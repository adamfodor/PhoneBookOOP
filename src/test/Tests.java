package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import phonebook.Entry;
import phonebook.FileOperations;
import phonebook.Operations;
import phonebook.Search;

class Tests {

	ArrayList<Entry> db = new ArrayList<>();
	Operations ops = new Operations(db);
	FileOperations fileops = new FileOperations();
	Search src = new Search();
	
	Entry en = new Entry("adam", "fodor", "adi", "god", "1234", "0620");

	@Test // 1
	void listsize() {
		assertEquals(0, ops.size(db));
		db.add(en);
		assertEquals(1, ops.size(db));
	}

	@Test // 2
	void testToString() {
		assertEquals("Név: " + en.getLastName() + " " + en.getFirstName() + "\n" + "   Bece név: " + en.getNickname()
				+ "\n   Cím: " + en.getAddress() + "\n   Privát szám: " + en.getPrivateNum() + "\n   Munkahely szám: "
				+ en.getWorkNum() + "\n=================", en.toString());
	}

	@Test // 3
	void testTofile() {
		assertEquals("adam,fodor,adi,god,1234,0620", en.toFile());
	}

	@Test // 4
	void fileInput() {
		assertFalse(fileops.read().isEmpty());
	}

	@Test // 5
	void serachByName() {
		db.add(en);
		assertTrue(src.byName(db, "geza").isEmpty());
		assertFalse(src.byName(db, "adam").isEmpty());

	}

	@Test // 6
	void searchByNumber() {
		db.add(en);
		assertTrue(src.byNum(db, "666").isEmpty());
		assertFalse(src.byNum(db, "06").isEmpty());
		assertFalse(src.byNum(db, "1234").isEmpty());

	}
	
	@Test // 7
	void searchByAddress() {
		db.add(en);
		assertTrue(src.byAddress(db, "NYC").isEmpty());
		assertFalse(src.byAddress(db, "god").isEmpty());

	}
	
	@Test //8
	void choosing() {
		assertNull(ops.chosing(db));
	}
	@Test //9
	void celete() {
		assertFalse(ops.delete());
	}
	@Test //10
	void modifiy() {
		assertFalse(ops.mod());
	}
	
	
	
	

}
