/*
 * Created by Katleho Khanye (akhanye)
 * */

package src;

import java.util.Random;
import java.util.*;

public class WeatherProvider {
	static WeatherProvider	weatherprovider;
	static String			weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

	private int	generateRandom(int temp[]) {
		Random 	rand = new Random();
		int		tempNum;
		boolean	found;

		do {
			found = false;
			tempNum = rand.nextInt(4);
			for (int i = 0; i < 4; i++) {
				found = tempNum == temp[i];
				if (found)
					break ;
			}
		} while (found);
		return (tempNum);
	}

	private void	swapValues(int a, int b) {
		String temp;

		temp = weather[a];
		weather[a] = weather[b];
		weather[b] = temp;
	}

	WeatherProvider() {
		int	tempPlace[] = {-1, -1, -1, -1};

		for (int i = 0; i < 4; i++) {
			tempPlace[i] = generateRandom(tempPlace);
			swapValues(i, tempPlace[i]);
		}
		weatherprovider = this;
	}

	public static 	WeatherProvider getProvider() {
		weatherprovider = null;
		weatherprovider = new WeatherProvider();
		return (weatherprovider);
	}

	private int		getWeatherRand(Coordinates coordinates, int checkIndex) {
		int temp;

		temp = (checkIndex == 0) ? coordinates.getLongitude() :
			coordinates.getLatitude();
		if (temp < 25)
			return (0);
		else if (temp > 25 && temp < 50)
			return (1);
		else if (temp > 50 && temp < 75)
			return (2);
		return (3);
	}

	public String 	getCurrentWeather(Coordinates coordinates) {
		int	selFrom[] = new int[2];
		int	rightIndex;

		selFrom[0] = getWeatherRand(coordinates, 0);
		selFrom[1] = getWeatherRand(coordinates, 1);
		rightIndex = (coordinates.getHeight() < 50) ? 0 : 1;
		return (weather[rightIndex]);
	}
}
