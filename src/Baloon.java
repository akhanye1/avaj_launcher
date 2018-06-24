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
			switch (this.weathertower.getWeather(this.coordinates)) {
				case "SUN":
					this.coordinates.setLongitude(2);
					this.coordinates.setHeight(4);
					break;
				case "RAIN":
					this.coordinates.setHeight(-5);
					break;
				case "FOG":
					this.coordinates.setHeight(-3);
					break;
				case "SNOW":
					this.coordinates.setHeight(-15);	
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
