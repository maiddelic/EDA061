package program;



import Memory.Memory;
public abstract class Command {
	
	public abstract void exec(Memory mem, ProgramCounter pc);
	
	public void execute(Memory memory, ProgramCounter counter) {
		counter.increment();
		exec(memory, counter);
	}
}
