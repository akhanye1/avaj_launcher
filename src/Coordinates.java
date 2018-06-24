/*
 * Created by Katleho Khanye (akhanye)
 */

package com.aircraft.simulator;

public class Coordinates {
	private int		longitude;
	private int		latitude;
	private int		height;

	Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int	getLongitude() { return (this.longitude); }
	public int	getLatitude() { return (this.latitude); }
	public int	getHeight() { return (this.height); }

	public void	setLongitude(int num) { this.longitude += num; }
	public void setLatitude(int num) { this.latitude += num; }

	public void	setHeight(int num) {
		this.height += num;
		if (this.height > 100)
			this.height = 100;
		else if (this.height < 0)
			this.height = 0;
	}
}
