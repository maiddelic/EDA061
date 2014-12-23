/**
 * 
 */
package operand;

public abstract class Word implements Operand{
	
	public abstract long getValue();
	
	public abstract boolean equals(Word w);
	
	public abstract void mul(Word w1, Word w2);
	
	public abstract void add(Word w1, Word w2);
	
	public abstract void copy(Word w1);

		
	}

