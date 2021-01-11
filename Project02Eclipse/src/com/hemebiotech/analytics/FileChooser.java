package com.hemebiotech.analytics;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class FileChooser {

    public String returnPath()
    {
        String path = "";
        JFrame dialogFrame = new JFrame();
        dialogFrame.setAlwaysOnTop(true);
        JFileChooser choice = new JFileChooser();
        int result=choice.showDialog(dialogFrame,"Select");
        if(result==JFileChooser.APPROVE_OPTION){
            path = choice.getSelectedFile().getAbsolutePath();
            System.out.println("You are analysing the file:"+path);

        }
        else
        {System.out.println("You didn't choose any file."+"\n");
        }
        return path;
    }

    public String returnPathFolder()
    {
        String path = "";
        JFrame dialogFrame = new JFrame();
        dialogFrame.setAlwaysOnTop(true);
        JFileChooser choice = new JFileChooser();
        choice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result=choice.showDialog(dialogFrame,"Select");
        if(result==JFileChooser.APPROVE_OPTION){
            path = choice.getSelectedFile().getAbsolutePath();
            System.out.println("You chose the folder"+path);
        }
        else
        {System.out.println("You didn't choose any folder."+"\n");
        }
        return path;
    }
}