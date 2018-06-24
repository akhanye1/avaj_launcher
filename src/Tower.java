/* 
 *	Created by Katleho Khanye (akhanye)
 * */

package	com.aircraft.simulator;

import	java.util.List;
import	java.util.ArrayList;

public class Tower {
	private List<Flyable>	observers = new ArrayList<>();

	public void				register(Flyable flyable) {
	}

	public void 			unregister(Flyable flyable) {
	}

	protected void			conditionsChanged() {
	}
}
