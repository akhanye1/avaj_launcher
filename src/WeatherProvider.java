/*
 * Created by Katleho Khanye (akhanye)
 * */

package com.aircraft.simulator;

import java.util.Random;

public class WeatherProvider {
	static WeatherProvider	weatherprovider;
	static String			weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

	private WeatherProvider() {

	}

	private void	generateRandom(int Max, int random[], int maxCounter) {
		Random rand = new Random();

		for (int i = 0; i < maxCounter; i++) {
			random[i] =  rand.nextInt(Max);
		}
	}

	public static 	WeatherProvider getProvider() { return (weatherprovider); }

	private String	getWeatherByCoordinates(Coordinates coordinates,
						int longRandom[], int latRandom[], int heightRandom[]) {
		Random rand = new Random();


		return ("");

	}

	public String 	getCurrentWeather(Coordinates coordinates) {
		int	longRandom[] = new int[4];
		int	latRandom[] = new int[4];
		int heightRandom[] = new int[4];

		generateRandom(1000, longRandom, 4);
		generateRandom(100, latRandom, 4);
		generateRandom(100, heightRandom, 4);
		return getWeatherByCoordinates(coordinates, longRandom, latRandom, heightRandom);
	}
}
