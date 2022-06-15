/** This interface represents a Command that the program logic can
 * execute or undo.
 * 
 * @author aarnott
 *
 */
public interface Command {
	public void execute();
	public void undo();
}