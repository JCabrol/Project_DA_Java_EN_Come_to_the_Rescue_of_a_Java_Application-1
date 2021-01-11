package com.hemebiotech.analytics;

import java.util.Scanner;

public class Menu {

    public int displayMenu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the action you want to perform:"+"\n"+
                "1 : Select a file to be analysed."+"\n"+
                "2 : Open result file."+"\n"+
                "3 : Exit Analytics Counter"+"\n");
        int result;
        try
        {
            result = sc.nextInt();
        }
        catch (Exception e)
        {
            System.out.println("You didn't choose an available action. Please enter 1, 2 or 3, then press enter.");
            result = 0;
        }
        return result;
    }

    public int secondaryMenu()
    {
        int actionChosen;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Choose where you want to put the symptoms read:"+
                "\n"+"1- Create a new file."+
                "\n"+"2- Add symptoms to an existing file."+"\n");
        try
        {
            actionChosen = sc2.nextInt();
            if (!((actionChosen==1)||(actionChosen==2)))
            {
                System.out.println("You didn't choose an available action. Please enter 1 or 2, then press enter.");
                actionChosen = 0;
            }
        }
        catch (Exception e)
        {
            System.out.println("You didn't choose an available action. Please enter 1 or 2, then press enter.");
            actionChosen = 0;
        }
        return actionChosen;
    }
}
