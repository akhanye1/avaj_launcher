/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

public class WeatherProvider {
	static WeatherProvider	weatherprovider;
	static String			weather;

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() { return (weatherprovider); }
	public String getCurrentWeather(Coordinates coordinates) { return ""; }
}
