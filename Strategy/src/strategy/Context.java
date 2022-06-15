/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import strategy.Strategy.ConcreteStrategy1;
import strategy.Strategy.ConcreteStrategy2;
import strategy.Strategy.ConcreteStrategy3;

/**
 *
 * @author DELL
 */
public class Context {

	private final Strategy strategy1 = new ConcreteStrategy1();
        private final Strategy strategy2 = new ConcreteStrategy2();
        private final Strategy strategy3 = new ConcreteStrategy3();
        
	public void execute(){
		strategy1.executeAlgorithm();
                strategy2.executeAlgorithm();
                strategy3.executeAlgorithm();
	}
	public void setStrategy(Strategy strategy){
		strategy = strategy1;
                strategy = strategy2;
                strategy = strategy3;
	}
	public Strategy getStrategy(){
		return strategy1;
	}


}
