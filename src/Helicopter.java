/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weathertower = null;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		if (this.weathertower != null) {
			Writer.write("Helicopter#" + this.name);
			Writer.write("("+this.id+") : ");
			switch (this.weathertower.getWeather(this.coordinates)) {
				case "SUN":
					Writer.writeln("The wind produced by the rotor is beautiful at this weather");
					this.coordinates.setLongitude(10);
					this.coordinates.setHeight(2);
					break;
				case "RAIN":
					Writer.writeln("My rotor is getting damp, haha get it");
					this.coordinates.setLongitude(5);
					break;
				case "FOG":
					Writer.writeln("The visibility is so poor, wait is that superman");
					this.coordinates.setLongitude(1);
					break;
				case "SNOW":
					Writer.writeln("Freezing, freezing keep moving to keep warm");
					this.coordinates.setHeight(-12);	
					break;
			}
			if (this.coordinates.getHeight() == 0) {
				weathertower.unregister(this);
			}
		}
	}

	public void registerTower(WeatherTower weathertower) {
		this.weathertower = weathertower;
		weathertower.register(this);
	}
}
