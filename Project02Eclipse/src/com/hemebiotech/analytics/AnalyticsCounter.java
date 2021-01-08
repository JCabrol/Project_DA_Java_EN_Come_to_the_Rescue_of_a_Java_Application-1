package com.hemebiotech.analytics;

import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args)
	{
		ReadSymptomDataFromFile readSymptomData = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		TreeMap<String,Integer> symptoms = readSymptomData.getSymptoms();/*Read the data in the specified file and put it in a TreeMap,
																		in the alphabetical order, counting the occurrences of each symptom.*/
		System.out.println(symptoms);

		// next generate output
		/*try {
			FileWriter writer = new FileWriter ("result.out");
			writer.write("headache: " + headacheCount + "\n");
			writer.write("rash: " + rashCount + "\n");
			writer.write("dilated pupils: " + pupilCount + "\n");
			writer.close();
		}
		catch (IOException e) {
			System.out.println("Impossible to create the file result.out or to write inside.");
		}

		 */
	}
}
