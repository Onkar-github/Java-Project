 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tttgame;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Tttgame extends JPanel{
    char playerMark = 'X' ;
    JButton[] buttons = new JButton[9];
    
public Tttgame(){
    setLayout(new GridLayout(3,3));
    initializeButtons();
    
}

public void initializeButtons(){
    for(int i=0 ; i<=8 ; i++ )
    {
        buttons[i] = new JButton();
        buttons[i].setText("-");
        buttons[i].setBackground(Color.white );
       // buttons[i].setBounds(200,100,150,100);
        buttons[i].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
          {
                JButton buttonClicked = (JButton) e.getSource();
                buttonClicked.setText(String.valueOf(playerMark));
        
                
           if(playerMark == 'X')
            {
               playerMark = 'O' ;
               buttonClicked.setBackground(Color. CYAN);
            }
           else
            {
               playerMark = 'X' ;
               buttonClicked.setBackground(Color.ORANGE);
            }
          displayVictor();
           }
        });
        add(buttons[i]); 
    }
}
        
    public void displayVictor()
    {
        if( checkForWinner() == true )
        {
            if(playerMark == 'X')  playerMark ='O'  ;
            else playerMark = 'X' ;
         
        JOptionPane pane = new JOptionPane();
        int dialogResult = JOptionPane.showConfirmDialog(pane , "Game Over " +   playerMark  + " Wins. Would you like to play again? " , "Game Over" ,
                           JOptionPane.YES_NO_OPTION);
        
        if(dialogResult == JOptionPane.YES_OPTION)  resetTheButtons();
        else System.exit(0);
        }
        else if(checkDraw())
        {
            JOptionPane pane = new JOptionPane();
            int dialogResult = JOptionPane.showConfirmDialog( pane , " Draw ,Would you like to Play Again ? " ," Game Over" ,
                               JOptionPane.YES_NO_OPTION);
            
            if(dialogResult == JOptionPane.YES_OPTION )  resetTheButtons();
            else System.exit(0);
        }
    
    }
    
    
    
     private void resetTheButtons()
    {
        playerMark ='X';
        for(int i=0 ; i<9 ; i++ )
        {
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
        }
    }    
        
    public boolean checkDraw()
    {
        boolean full = true ;
        for(int i=0 ; i<9 ; i++)
            if(buttons[i].getText().charAt(0) == '-')   full = false ;
            return full ;
    }
    
public boolean checkForWinner()
{
    if(checkRows() == true || checkColumns() == true || checkDiagonals() == true) return true ;
    else return false ;
}

    public boolean checkRows()
    {
        int i=0 ;
        for(int j=0 ; j<3 ; j++){
            if(buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText())
                && buttons[i].getText().charAt(0) != '-'    )   { return true ; }
           i = i+3 ;
        }
        return false ;
    }
     
      public boolean checkColumns()
    {
        int i=0 ;
        for(int j=0 ; j<3 ; j++){
            if(buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText())
                && buttons[i].getText().charAt(0) != '-'    )   { return true ; }
           i++ ;
        }
        return false ;
    }
         
      public boolean checkDiagonals()
    {
          if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())
                && buttons[0].getText().charAt(0) != '-'    )   { return true ; }
 
          else if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
                && buttons[2].getText().charAt(0) != '-'    )   { return true ; }
          
          else return false ;
    }
     
      
      
    public static void main(String[] args) {
        JFrame window = new JFrame ( " Tic Tac Toe By Java Coding Community");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new Tttgame());
        window.setBounds(500,500,500,500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
    
}
