/*
 * Create by Katleho Khanye (akhanye)
 * */

package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	private static BufferedWriter	out = null;
	private static FileWriter		fstream;

	public Writer() {
		try {
			fstream = new FileWriter("simulation.txt");
			out = new BufferedWriter(fstream);
		}
		catch (IOException err) {
			System.out.println("New file exception : " + err.getMessage());
		}
	}

	public static void	write(String str) {
		try {
			out.write(str);
		}
		catch (IOException err) {
			System.out.println("Write Exception : " + err.getMessage());
		}
	}

	public static void	writeln(String str) {
		try {
			out.write(str);
			out.write("\n");
		}
		catch (IOException err) {
			System.out.println("Writeln Exception : " + err.getMessage());
		}
	}

	public static void	close() {
		try {
			out.flush();
			out.close();
		}
		catch (IOException err) {
			System.out.println("Close Exception : " + err.getMessage());
		}
	}
}
