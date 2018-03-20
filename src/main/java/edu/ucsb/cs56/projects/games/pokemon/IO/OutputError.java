package edu.ucsb.cs56.projects.games.pokemon.IO;


import javax.swing.*;


public class OutputError{  
    JFrame f;

    public OutputError (String message){  
        f=new JFrame();  
        JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);     
    }  

 
}  
