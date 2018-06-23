/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weathertower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
	}

	public void registerTower(WeatherTower weathertower) {
		System.out.println("Jetplane Register weather tower");
	}
}
