/*
 * Created by katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class AircraftFactory {
	private	Coordinates coordinates;
	private	int			counter;

	public Flyable newAircraft(String type, String name, int longitude,
			int latitude, int height) throws Exception{
		Flyable			temp;
		WeatherTower	weathertower = new WeatherTower();

		if (height > 100)
			throw new Exception("Height exceed maximum height allowed");
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
		temp.registerTower(weathertower);
		return (temp);
	}

	public void			setCounter(int counter) { this.counter = counter; }
	public int			getCounter() { return this.counter; }
}
