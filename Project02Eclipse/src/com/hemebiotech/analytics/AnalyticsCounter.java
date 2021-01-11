package com.hemebiotech.analytics;


import java.awt.Desktop;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args)
	{
		int action = 0;	/*this integer defines the action to perform.
						0 is to display menu
						1 is to select a file to analyze
						2 is to open result file
						3 is to end the program	*/
		System.out.println("Welcome in Analytics Counter."+"\n");
		Menu myMenu = new Menu();
		while (action!=3)			//if action equals 3, the program ends.
		{
			if (action == 0)        //if action equals 0 the menu is displayed and the user has to choose an action.
			{
				action = myMenu.displayMenu();
			} else if (action == 1)        //If action equals 1 the user select a file to be read.
			//Then the symptoms found in the file are put in the result file.
			{
				ChooseFileToRead choose = new ChooseFileToRead();
				String path = choose.returnPath();


				ReadSymptomDataFromFile readSymptomData = new ReadSymptomDataFromFile(path);
				TreeMap<String, Integer> symptoms = readSymptomData.getSymptoms();//Read the data in the specified file and put it in a TreeMap,
				//in the alphabetical order, counting the occurrences of each symptom.

				WriteSymptomsInFile allSymptoms = new WriteSymptomsInFile("result.out");
				allSymptoms.writeInFile(symptoms);//write the symptoms from the TreeMap in a new file called result.out, one per line.
				action = 0;
			} else if (action == 2)    //If action equals 2, the result file is opened.
			//Then the menu is displayed again.
			{
				try {
					Desktop.getDesktop().open(new java.io.File("result.out"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				action = 0;
			} else                //If the user input doesn't correspond to a planned action, a message is displayed.
			//Then the menu is displayed again.
			{
				System.out.println("You didn't choose an available action. Please enter 1, 2 or 3, then press enter.");
				action = 0;
			}
		}
		System.out.println("Thank you for using our application."+"\n"+"See you next time on Analytics Counter.");
		System.exit(0);
	}
}

