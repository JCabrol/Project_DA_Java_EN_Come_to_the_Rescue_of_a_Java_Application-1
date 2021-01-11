package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class WriteSymptomsInFile implements ISymptomWriter {


    private String fileOut;
    /**
     *
     * @param fileOut a full or partial path to file within results will be written.
     */

    public WriteSymptomsInFile (String fileOut)
    {
        this.fileOut= fileOut;
    }
    @Override
    public void writeInFile (TreeMap<String,Integer> symptoms)
    {

        FileWriter writer;
        try {
            writer = new FileWriter (fileOut);	//Create a new file to write results inside.

            while (symptoms.firstEntry() != null)	//Verify the TreeMap is not empty; if it's empty the program ends.
            {
                writer.write(symptoms.firstEntry() + "\n");	//Write the first symptom still in the TreeMap
                //in the file and then go to a new line.
                symptoms.remove(symptoms.firstKey(),symptoms.get(symptoms.firstKey())); //remove symptom already written in file.
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Impossible to create the specified file or to write inside.");
        }
    }

    public void writeInNewFile (TreeMap<String,Integer> symptoms)
    {
        boolean nameOK = false;
        String fileName="";
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Write the name you want for your file:"+"\n");
        while(!nameOK) {
            try {
                fileName = sc3.nextLine();
                System.out.println("You chose the name:" + fileName);
                nameOK = true;
            } catch (Exception e) {
                System.out.println("You didn't choose an available name. Please try another time.");
            }
        }
        System.out.println("Select the folder to put your file:");
        FileChooser chooseDirectory = new FileChooser();
        String pathDirectory = chooseDirectory.returnPathFolder();
        this.fileOut = pathDirectory+ "\\" +fileName;
        System.out.println("You are creating the file: "+fileOut+" and you are writing symptoms inside."+"\n");
        FileWriter writer;
        try {
            writer = new FileWriter (fileOut);	//Create a new file to write results inside.

            while (symptoms.firstEntry() != null)	//Verify the TreeMap is not empty; if it's empty the program ends.
            {
                writer.write(symptoms.firstEntry() + "\n");	//Write the first symptom still in the TreeMap
                //in the file and then go to a new line.
                symptoms.remove(symptoms.firstKey(),symptoms.get(symptoms.firstKey())); //remove symptom already written in file.
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Impossible to create the specified file or to write inside.");
        }
    }

    public void writeInExistingFile (TreeMap<String,Integer> symptoms)
            //this method is used to add symptoms to a result file already existing.
    {
        System.out.println("Choose the file you want to write inside:"+"\n");
        FileChooser chooseFile = new FileChooser();// first the user select the file to complete.
        this.fileOut = chooseFile.returnPath();
        System.out.println("You are adding symptoms in the file : "+fileOut+"\n");
        ReadSymptomDataFromFile allSymptoms = new ReadSymptomDataFromFile(fileOut);
        symptoms=allSymptoms.addSymptomsInResults(symptoms);//the symptoms in the file are added in the TreeMap result.
        FileWriter writer;
        try {
            writer = new FileWriter (fileOut);	//Create a new file with the same name of the older one to write results inside.
            while (symptoms.firstEntry() != null)	//Verify the TreeMap is not empty; if it's empty the program ends.
            {
                writer.write(symptoms.firstEntry() + "\n");	//Write the first symptom still in the TreeMap
                //in the file and then go to a new line.
                symptoms.remove(symptoms.firstKey(),symptoms.get(symptoms.firstKey())); //remove symptom already written in file.
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Impossible to create the specified file or to write inside.");
        }
    }

}
