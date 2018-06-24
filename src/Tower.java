/* 
 *	Created by Katleho Khanye (akhanye)
 * */

package	com.aircraft.simulator;

import	java.util.List;
import	java.util.ArrayList;

public class Tower {
	private List<Flyable>	observers = new ArrayList<>();

	private String			getTypeName(Flyable flyable) {
		if (flyable instanceof Baloon)
			return ("Baloon");
		else if (flyable instanceof Helicopter)
			return ("Helicopter");
		else
			return ("JetPlane");
	}

	public void				register(Flyable flyable) {
		Aircraft aircraft = (Aircraft)flyable; 

		System.out.print("Tower : " + getTypeName(flyable) + "#");
		System.out.print(aircraft.name + "(" + aircraft.id + ") ");
		System.out.println("Your presence is acknowledged");
		observers.add(flyable);
	}

	public void 			unregister(Flyable flyable) {
		Aircraft aircraft = (Aircraft)flyable;

		for (Flyable iterTemp : observers) {
			Aircraft iter = (Aircraft)iterTemp;
			if (iter.id == aircraft.id) {
				System.out.print("Tower : " + getTypeName(iterTemp) + " #");
				System.out.print(iter.name + "(" + iter.id + ") ");
				System.out.print(" I cannot say I will miss you");
				System.out.println(", you are the weakest link goodbye");
				observers.remove(iter);
				break ;
			}
		}
	}

	protected void			conditionsChanged() {

	}
}
