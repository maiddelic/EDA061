package computer;

import Memory.Memory;

import java.util.ArrayList;

import program.Command;
import program.ProgramCounter;

@SuppressWarnings("serial")
public class Program extends ArrayList<Command> {

	private ProgramCounter counter;

	public Program() {
		counter = new ProgramCounter();
	}

	public void run(Memory memory) {
		while (counter.getCounter() > -1) {
			get(counter.getCounter()).execute(memory, counter);
		}

	}

}
