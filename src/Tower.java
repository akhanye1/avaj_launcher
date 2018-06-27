/* 
 *	Created by Katleho Khanye (akhanye)
 * */

package	src;

import	java.util.List;
import	java.util.ArrayList;
import	java.util.*;

public class Tower {
	private List<Flyable>	observers = new ArrayList<>();
	private	Flyable			deleteAircraft;

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

		Writer.write("Tower : " + getTypeName(flyable) + "#");
		Writer.write(aircraft.name + "(" + aircraft.id + ") ");
		Writer.writeln("Your presence is acknowledged");
		observers.add(flyable);
	}

	public void 			unregister(Flyable flyable) {
		Aircraft aircraft = (Aircraft)flyable;

		deleteAircraft = flyable;	
		Writer.write("Tower : " + getTypeName(flyable) + " #");
		Writer.write(aircraft.name + "(" + aircraft.id + ") ");
		Writer.write(" I cannot say I will miss you");
		Writer.writeln(", you are the weakest link goodbye");
	}

	protected void			conditionsChanged() {
		deleteAircraft = null;
		for (Iterator<Flyable> iter = observers.listIterator(); iter.hasNext();) {
			Flyable fly = iter.next();
			fly.updateConditions();
			if (deleteAircraft != null) {
				iter.remove();	
				deleteAircraft = null;
			}
		}
	}
}
