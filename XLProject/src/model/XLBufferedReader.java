package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import xl.Address;


//TODO move to another package
public class XLBufferedReader extends BufferedReader {
	private SlotFactory factory;
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
        factory = new SlotFactory();
    }
    
  //TODO Change Object to something appropriate
    public void load(HashMap<Address, Slot> map) {
    	try {
        	String entry[];
            while (ready()) {
                entry = readLine().split("=",2);
                Address address = new Address(entry[0]);
                Slot slot = factory.createSlot(entry[1]);
                map.put(address, slot);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
