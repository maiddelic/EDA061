package test;

import Memory.LongMemory;
import computer.Computer;
import computer.Program;

public class MainTest {
	
	public static void main(String[] args) {
	    Program factorial = new Factorial();
	    System.out.println(factorial);
	    Computer computer = new Computer(new LongMemory(64));
	    computer.load(factorial);
	    computer.run();
	}
}
