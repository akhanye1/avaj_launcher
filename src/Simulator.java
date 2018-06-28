/*
 * Created by Katleho Khanye (akhanye)
 *
 * */

package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Exception;
import java.util.*;

public class Simulator {
	private static void lineOkay (String line, int lineCounter,
									AircraftFactory aircraftfactory,
									List<Flyable> flyables) throws Exception{
		String 	splits[] = line.split(" ");
		Flyable	tempFlight;

		if (lineCounter == 0) {
			if (splits.length == 1) {
				aircraftfactory.setCounter(Integer.parseInt(splits[0]));
				if (aircraftfactory.getCounter() <= 0)
					throw new Exception("Cannot run 0 or less simulations");
			}
			else
				throw new Exception("Invalid file type, does JAVA have segfaults?");
		}
		else if (lineCounter > 0) {
			if (splits.length == 5) {
				String type = splits[0];
				String name = splits[1];
				int		longitude = Integer.parseInt(splits[2]);
				int		latitude = Integer.parseInt(splits[3]);
				int		height = Integer.parseInt(splits[4]);
				if (longitude < 0 || latitude < 0)
					throw new Exception("We really don't accept aliens here.");
				if ((tempFlight = aircraftfactory.newAircraft(type, name, longitude, 
							latitude, height)) != null)
					flyables.add(tempFlight);
			}
			else
				throw new Exception("Invalid file type, does JAVA have segfaults?");
		}
	}

	public static void main(String[] args) {
		AircraftFactory aircraftfactory = new AircraftFactory();
		String			line = null;
		int				lineCounter;
		WeatherTower	weathertower = new WeatherTower();
		List<Flyable>	flyables = new ArrayList<>();
		Writer			writer = new Writer();

		if (args.length != 1) {
			System.out.println("Usage: java com.aircraft.simulator.Simulator <filename>");
			return ;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			lineCounter = 0;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					lineOkay(line, lineCounter, aircraftfactory, flyables);
					lineCounter++;
				}
			}
			if (lineCounter == 0 || flyables.size() == 0)
				throw new Exception("Empty file");
			for (Flyable tempflyable : flyables) {
				tempflyable.registerTower(weathertower);
			}
			for (int i = 0; i < aircraftfactory.getCounter(); i++) {
				weathertower.changeWeather();
				weathertower.conditionsChanged();
			}
		}
		catch (FileNotFoundException err) {
			System.out.println("File not found " + err.getMessage());
		}
		catch (IOException err) {
			System.out.println("IO Exception caught : " + err.getMessage());
		}
		catch (NumberFormatException err) {
			System.out.println("Error convert to number : " + err.getMessage());
		}
		catch (AircraftException err) {
			System.out.println("Aircraft Exception : " + err.getMessage());
		}
		catch (Exception err) {
			System.out.println("Exception : " + err.getMessage());
		}
		finally {
			Writer.close();
		}
	}
}
