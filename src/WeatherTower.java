/*
 * Created by Katleho Khanye (akhanye)
 * */

package src;

public class WeatherTower extends Tower{
	private WeatherProvider weatherprovider = WeatherProvider.getProvider();

	public String	getWeather(Coordinates coordinates) {
		return weatherprovider.getCurrentWeather(coordinates);
	}

	void			changeWeather() {
		weatherprovider = WeatherProvider.getProvider();
	}
}
