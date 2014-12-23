/**
 * 
 */
package program;

/**
 * @author maiddelic
 *
 */
public class ProgramCounter {
	private int counter;
	
	public ProgramCounter() {
	counter = 0;
	}
	public int getCounter(){
		return counter;
	}
	public void setCount(int i){
		counter = i;
	}
	public void increment(){
		counter++;
	}
	public void increment(int i){
		counter = counter+i;
	}
	public void decrement(){
		counter--;
	}
	public void decrement(int i){
		counter = counter-i;
	}
}
