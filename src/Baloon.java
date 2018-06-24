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
		if (this.weathertower != null)
			weathertower.updateConditions();
	}

	public void registerTower(WeatherTower weathertower) {
		this.weathertower = weathertower;
		weathertower.register(this);
	}
}
