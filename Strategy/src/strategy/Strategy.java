package strategy;

/**
 *
 * @author DELL
 */
public interface Strategy {
	public void executeAlgorithm();

class ConcreteStrategy1 implements Strategy {
        @Override
	public void executeAlgorithm() {
		System.out.println("ConcreteStrategy 1");
	}
}
class ConcreteStrategy2 implements Strategy{
        @Override
	public void executeAlgorithm(){
		System.out.println("ConcreteStrategy 2");
	}
}
class ConcreteStrategy3 implements Strategy{
        @Override
	public void executeAlgorithm(){
		System.out.println("ConcreteStrategy 3");

}
}
}
