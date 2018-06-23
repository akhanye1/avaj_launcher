/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weathertower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
	}

	public void registerTower(WeatherTower weathertower) {
		System.out.println("Baloon Registering weather tower");
	}
}
