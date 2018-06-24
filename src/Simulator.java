/*
 * Created by Katleho Khanye (akhanye)
 *
 * */

package com.aircraft.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Exception;
import java.util.*;

public class Simulator {
	private static void lineOkay (String line, int lineCounter,
									List<Flyable> flyables,
									AircraftFactory aircraftfactory) throws Exception{
		String 	splits[] = line.split(" ");
		Flyable	tempFlight;
		if (lineCounter == 0) {
			if (splits.length == 1)
				aircraftfactory.setCounter(Integer.parseInt(splits[0]));
			else
				throw new Exception("Invalid file type");
		}
		else if (lineCounter > 0) {
			if (splits.length == 5) {
				String type = splits[0];
				String name = splits[1];
				int		longitude = Integer.parseInt(splits[2]);
				int		latitude = Integer.parseInt(splits[3]);
				int		height = Integer.parseInt(splits[4]);
				if ((tempFlight = aircraftfactory.newAircraft(type, name, longitude, 
							latitude, height)) != null)
					flyables.add(tempFlight);
			}
			else
				throw new Exception("Invali file type");
		}
	}

	public static void main(String[] args) {
		AircraftFactory aircraftfactory = new AircraftFactory();
		List<Flyable>	flyables = new ArrayList<>();
		String			line = null;
		int				lineCounter;

		if (args.length != 1) {
			System.out.println("Usage: java com.aircraft.simulator.Simulator <filename>");
			return ;
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			lineCounter = 0;
			while ((line = br.readLine()) != null) {
				lineOkay(line, lineCounter, flyables, aircraftfactory);
				lineCounter++;
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
		catch (Exception err) {
			System.out.println("Exception : " + err.getMessage());
		}
	}
}
