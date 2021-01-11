package com.hemebiotech.analytics;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ChooseFileToRead {

    public String returnPath()
    {
        String path = "";
        JFrame dialogFrame = new JFrame();
        dialogFrame.setAlwaysOnTop(true);
        JFileChooser choice = new JFileChooser();
        int result=choice.showDialog(dialogFrame,"Select");
        if(result==JFileChooser.APPROVE_OPTION){
            path = choice.getSelectedFile().getAbsolutePath();
            System.out.println(path);

        }
        else
        {System.out.println("You didn't choose any file.");
        }
        return path;
    }
}