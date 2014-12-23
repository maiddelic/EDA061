package computer;

import Memory.Memory;

public class Computer {
	private Memory mem;
	private Program prog;

	public Computer(Memory memory) {
		this.mem = memory;
	}

	public void load(Program program) {
		this.prog = program;
	}

	public void run() {
		prog.run(mem);
	}
}
