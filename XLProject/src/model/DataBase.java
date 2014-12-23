package model;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Observable;
import java.util.Set;
import java.util.Map.Entry;

import xl.Address;


public class DataBase extends Observable implements Environment {
	private HashMap<Address, Slot> map;
	private SlotFactory factory;

	public DataBase() {
		map = new HashMap<Address, Slot>();
		factory = new SlotFactory();
	}

	public void insert(String string, int row, int col) {
		Slot slotObject = factory.createSlot(string);
		Address add = new Address(row, col);
		if (map.containsKey(add)) {
			Slot temp = map.get(add);
			map.put(add, slotObject);
			try {
				changeState();
			} catch (XLException e) {
				map.put(add, temp);
				changeState();
				throw e;
			}
		} else {
			map.put(add, slotObject);
			try {
				changeState();
			} catch (XLException e) {
				map.remove(add);
				changeState();
				throw e;
			}
		}
	}

	public void remove(Address address) {
		if (map.containsKey(address)) {
			Slot slot = map.get(address);
			map.put(address, new ErrorSlot());
			try {
				changeState();
				map.remove(address);
			} catch (XLException e) {
				map.put(address, slot);
				changeState();
				throw e;
			}
		}
	}

	public void saveToFile(String fileName) {
		XLPrintStream ps;
		try {
			ps = new XLPrintStream(fileName);
			Set<Entry<Address, Slot>> entrySet = map.entrySet();
			ps.save(entrySet);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile(XLBufferedReader reader) {
		map.clear();
		reader.load(map);
		try {
			changeState();
		} catch (XLException e) {
			map.clear();
			changeState();
			throw e;
		}
	}

	public void changeState() {
		setChanged();
		notifyObservers();
	}

	public double value(Object address) {
		if (map.containsKey(address)) {
			Slot slot = map.get(address);
			Address add = (Address) address;
			map.put( add, new ErrorSlot());
			try {
				double value = slot.value(this);
				map.put(add, slot);
				return value;
			} catch (XLException e) {
				map.put(add, slot);
				throw e;
			}
		} else {
			throw new XLException("Null reference");
		}
	}

	public String editorString(int row, int col) {
		Address address = new Address(row, col);
		if (map.containsKey(address)) {
			return map.get(address).toString();
		} else {
			return "";
		}
	}

	public String toString(int row, int col) {
		Address address = new Address(row, col);
		if (map.containsKey(address)) {
			return map.get(address).toString(this);
		} else {
			return "";
		}
	}

	public void clearAll() {
		map.clear();
		changeState();
	}

}
