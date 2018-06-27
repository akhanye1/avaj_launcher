/*
 * Created by katleho Khanye (akhanye)
 * */

package src;

public class AircraftFactory {
	private	int			counter;

	public Flyable newAircraft(String type, String name, int longitude,
			int latitude, int height) throws Exception{
		Flyable			temp;

		if (height < 0) {
			throw new Exception("Wether you are superman or a spaceship, return to sender.");
		} 
		else if (height > 100) {
			Writer.writeln(name + " is beyond the threshold, height is resetted to 100");
			height = 100;
		}
		Coordinates coordinates;
		switch (type) {
			case "Baloon":
				coordinates = new Coordinates(longitude, latitude, height);
				temp = new Baloon(name, coordinates);
				break;	
			case "JetPlane":
				coordinates = new Coordinates(longitude, latitude, height);
				temp = new JetPlane(name, coordinates);
				break;
			case "Helicopter": 
				coordinates = new Coordinates(longitude, latitude, height);
				temp = new Helicopter(name, coordinates);
				break;
			default:
				throw new Exception("Aircraft type not recorgnised");
		}
		return (temp);
	}

	public void			setCounter(int counter) { this.counter = counter; }
	public int			getCounter() { return this.counter; }
}
