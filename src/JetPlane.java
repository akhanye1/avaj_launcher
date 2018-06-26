/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weathertower = null;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		if (this.weathertower != null) {
			Writer.write("JetPlane#" + this.name);
			Writer.write("("+this.id+") : ");
			switch (this.weathertower.getWeather(this.coordinates)) {
				case "SUN":
					Writer.writeln("With this weather I can make it to mars");
					this.coordinates.setLatitude(10);
					this.coordinates.setHeight(2);
					break;
				case "RAIN":
					Writer.writeln("Where are wipers when you need them");
					this.coordinates.setLatitude(5);
					break;
				case "FOG":
					Writer.writeln("I can't see a thing, Ooooh NO, oh it was a bird");
					this.coordinates.setLatitude(1);
					break;
				case "SNOW":
					Writer.writeln("Luckly I have a heater, imagine if I was in a Baloon, really");
					this.coordinates.setHeight(-7);	
					break;
			}
			if (this.coordinates.getHeight() == 0)
				weathertower.unregister(this);
		}
	}

	public void registerTower(WeatherTower weathertower) {
		this.weathertower = weathertower;
		weathertower.register(this);
	}
}
