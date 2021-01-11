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
				FileChooser choose = new FileChooser();
				String path = choose.returnPath();


				ReadSymptomDataFromFile readSymptomData = new ReadSymptomDataFromFile(path);
				TreeMap<String, Integer> symptoms = readSymptomData.getSymptoms();//Read the data in the specified file and put it in a TreeMap,
				//in the alphabetical order, counting the occurrences of each symptom.
				int secondaryAction =0;
				while(secondaryAction==0)
					{
					secondaryAction = myMenu.secondaryMenu(); 	/*the user choose if he wants to put new symptoms
					in a new file or to add it in an existing file.*/
					}
				if (secondaryAction==1)
				{
					System.out.println("You want to put symptoms in a new file.");
					WriteSymptomsInFile allSymptoms = new WriteSymptomsInFile("");
					allSymptoms.writeInNewFile(symptoms);//write the symptoms from the TreeMap in a new file called result.out, one per line.
					action = 0;
				}
				else if (secondaryAction==2)
				{
					System.out.println("You want to add symptoms in an existing file.");
					WriteSymptomsInFile allSymptoms = new WriteSymptomsInFile("");
					allSymptoms.writeInExistingFile(symptoms);//write the symptoms from the TreeMap in a new file called result.out, one per line.
					action = 0;
				}
				else
				{
					System.out.println("A problem occurred, please try another time."+"\n");
				}
			} else if (action == 2)    //If action equals 2, the result file is opened.
			//Then the menu is displayed again.
			{
				try {
					FileChooser chooseFile = new FileChooser();
					String pathFileResult = chooseFile.returnPath();
					Desktop.getDesktop().open(new java.io.File(pathFileResult));
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

