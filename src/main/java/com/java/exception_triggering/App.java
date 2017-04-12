package com.java.exception_triggering;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {

		String fileName = "debug.log";

		// App.class.getClassLoader().getResourceAsStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)));

		String strLine;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String date = sdf.format(now).toString();

		String regex = ".*" + date + ".*" + "java.lang.OutOfMemoryError" + ".*";
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {

			boolean result = strLine.matches(regex);
			if (result) {
				System.out.println("Trigger the incident");
				System.out.println(strLine);
			}
		}

		// Close the input stream
		br.close();
	}
}
