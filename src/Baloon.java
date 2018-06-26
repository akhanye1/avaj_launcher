/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weathertower = null;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		if (this.weathertower != null) {
			Writer.write("Baloon#" + this.name);
			Writer.write("("+this.id+") : ");
			switch (this.weathertower.getWeather(this.coordinates)) {
				case "SUN":
					Writer.writeln("Is weathers like this that make me enjoy the fresh air, lets have a picnic");
					this.coordinates.setLongitude(2);
					this.coordinates.setHeight(4);
					break;
				case "RAIN":
					Writer.writeln("Is that all you have, Rain, that is nothing");
					this.coordinates.setHeight(-5);
					break;
				case "FOG":
					Writer.writeln("Visiblity is poor, can't see a thing");
					this.coordinates.setHeight(-3);
					break;
				case "SNOW":
					Writer.writeln("Really snow, really snow, what else can go wrong");
					this.coordinates.setHeight(-15);	
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
