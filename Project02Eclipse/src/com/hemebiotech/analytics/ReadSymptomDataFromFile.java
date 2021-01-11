package com.hemebiotech.analytics;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;


/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {


	private final String filepath;


	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}

	public String getFilepath() {
		return filepath;
	}

	@Override


	public TreeMap <String, Integer> getSymptoms() {
		TreeMap<String,Integer> result = new TreeMap<>();


		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {						//Verify it's not the end of the file.
					String lowerCaseLine = line.toLowerCase();//Put all symptoms in lower case, to be sure there is not the same two times.
					if (result.containsKey(lowerCaseLine))
					{
						result.replace(lowerCaseLine, result.get(lowerCaseLine)+1);//If symptom already exists, add one occurrence to this symptom in the result.
					}
					else if(!(lowerCaseLine.equals("")))//Verify the line is not empty.
					{
						result.put(lowerCaseLine,1);//If symptom doesn't exist, create a new symptom with one occurrence in the result.
					}
					line = reader.readLine();//read the following line.
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("The specified file cannot be read. Please verify its existence and its location.");
			}
		}


		return result;
	}

	public TreeMap <String, Integer> addSymptomsInResults(TreeMap<String,Integer> result) {
//this method is used to add symptoms from a result file to a result Treemap
		if (filepath != null) {
			try {

				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();


				while (line != null) {						//Verify it's not the end of the file.
					String[] symptomAndNumber = line.split("="); //separate symptom and number of occurrences in the line
					String symptom = symptomAndNumber[0];
					int numberOccurrence = Integer.parseInt(symptomAndNumber[1]);
					String lowerCaseSymptom = symptom.toLowerCase();//Put all symptoms in lower case, to be sure there is not the same two times.
					if (result.containsKey(lowerCaseSymptom))
					{
						result.replace(lowerCaseSymptom, result.get(lowerCaseSymptom)+numberOccurrence);
						//If symptom already exists, add number of occurrences for this symptom in the result.
					}
					else if(!(lowerCaseSymptom.equals("")))//Verify the line is not empty.
					{
						result.put(lowerCaseSymptom,1);//If symptom doesn't exist, create a new symptom with one occurrence in the result.
					}
					line = reader.readLine();//read the following line.
				}
				reader.close();
			} catch (IOException e) {
				System.out.println("The specified file cannot be read. Please verify its existence and its location.");
			}
		}


		return result;
	}
}
