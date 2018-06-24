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
			switch (this.weathertower.getWeather(this.coordinates)) {
				case "SUN":
					this.coordinates.setLatitude(10);
					this.coordinates.setHeight(2);
					break;
				case "RAIN":
					this.coordinates.setLatitude(5);
					break;
				case "FOG":
					this.coordinates.setLatitude(1);
					break;
				case "SNOW":
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
