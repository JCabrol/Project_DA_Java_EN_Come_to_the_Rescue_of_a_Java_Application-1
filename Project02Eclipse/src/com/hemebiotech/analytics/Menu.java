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
            result = 0;
        }
        return result;
    }

}
