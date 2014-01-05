import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Jumble extends JFrame {

public JFrame frame;  
public static String button;
public static int timesSubmitted=0;
int index=0;

String str;
JLabel output, scoreDisplay, skippedWordsAlert, errorAlert;
JButton start, submit, nextWord, reset;
int countNext=1, score,timesSkipped = 0, errors=0 ;
TextField txt1 = new TextField("Type here",25);

public void runJumbleGame(){
Jumble frame = new Jumble();
frame.setTitle("Jumble");
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);// sets the location of the JFrame to the centre of the screen
}

 public Jumble() {
 start = new JButton("START");
 submit = new JButton("SUBMIT");
 nextWord = new JButton("NEXT WORD");
 reset = new JButton("RESET");

 submit.setVisible(false);//initially these 3 buttons are invisible
 nextWord.setVisible(false);
 reset.setVisible(false);

 output = new JLabel("Please click on \"start\" to begin the game");
 output.setFont(new Font("Serif", Font.BOLD, 20));
 scoreDisplay = new JLabel("Score: " + score);
 skippedWordsAlert = new JLabel("  Skipped : " + timesSkipped);
 errorAlert = new JLabel("   Errors: " + errors);

 JPanel panel1 = new JPanel();
 panel1.add(start);
 panel1.add(submit);
 panel1.add(nextWord);
 panel1.add(reset);
 panel1.setBackground(new Color(0, 154, 255));

 JPanel panel2 = new JPanel( );
 panel2.add(output);
 panel2.setBackground(new Color(0, 154, 255));

 JPanel panel4 = new JPanel();
 panel4.add(txt1);
 panel4.setBackground(new Color(0, 154, 255));

 JPanel panel5 = new JPanel();
 panel5.add(scoreDisplay);
 panel5.add(skippedWordsAlert);
 panel5.add(errorAlert);
 panel5.setBackground(new Color(0, 154, 255));

 JPanel panel3 = new JPanel(new BorderLayout( ));
 panel3.add(panel1, BorderLayout.NORTH);
 panel3.add(panel2, BorderLayout.SOUTH);
 panel3.add(panel4,BorderLayout.CENTER );
 panel3.add(panel5,BorderLayout.LINE_END);
 panel3.setBackground(new Color(0, 154, 255));
 add(panel3);

 theHandler2 handler2 = new theHandler2();

 start.addActionListener(handler2);
 submit.addActionListener(handler2);
 nextWord.addActionListener(handler2);
 reset.addActionListener(handler2);

 }

  public class theHandler2 implements ActionListener{
    
 StopWatch timer = new StopWatch();  

 public void actionPerformed(ActionEvent e)
 {

 button = e.getActionCommand();

 if(button.equals("START")){//if start, call the start method
 timer.start();  
 start(); 
 }
 if(button.equals("SUBMIT")){// if submit, call the submit method
 timer.stop();
 submit();
 submit.setEnabled(false);
 JOptionPane.showMessageDialog(null, "YOU TOOK " + timer.getTime() + " milliseconds to make a decision");
 timer.restart();
 }
 if(button.equals("RESET")){//if reset call the reset method
reset();
submit.setEnabled(true);
 }
 if (button.equals("NEXT WORD")){// if next Call the nextWord method
 nextWord();
 submit.setEnabled(true);
 }

 }

 StaticWordLibrary scram = new StaticWordLibrary();

public void start(){

//timer.start();
   
start.setVisible(false);
submit.setVisible(true);
nextWord.setEnabled(false);
nextWord.setVisible(true);
reset.setVisible(true);
txt1.setText(null);

output.setText(scram.getScrambledWord(index));
}

 public void reset(){
score=0;
countNext=1;
timesSubmitted=0;
timesSkipped=0;
index=0;
errors=0;
scoreDisplay.setText("Score: " + score);
skippedWordsAlert.setText("  Skipped: " + timesSkipped);
errorAlert.setText("   Errors: " + errors);
submit.setVisible(true);
nextWord.setVisible(true);
nextWord.setEnabled(false);
reset.setEnabled(false);
txt1.setText(null);

output.setText(scram.getScrambledWord(index));
 }


public void submit(){
str = txt1.getText();
reset.setEnabled(true);
nextWord.setEnabled(true);

if(str.equals(scram.getWord(index))){
score++;
scoreDisplay.setText("Score: " + score);    
}
if(!str.equals(scram.getWord(index)) && !str.equals("")){
errors++;
errorAlert.setText("Errors: " + errors);


    if(errors > 3){//this will close the program if the user has skipped more than 3 words
    JOptionPane.showMessageDialog(null, "You made 4 ERRORS!!! GAME OVER ");
    JOptionPane.showMessageDialog(null, "YOUR SCORE IS:" + score+"\n"+ "1-10:BAD    10-20:GOOD    20-30:VERY GOOD   30-45:AMZAING!!","Game Over",JOptionPane.PLAIN_MESSAGE);
    System.exit(0);
    }
}

if(index==44){ // condition to handle last word in array list
JOptionPane.showMessageDialog(null, "YOUR SCORE IS:" + score+"\n"+ "1-10:BAD    10-20:GOOD    20-30:VERY GOOD   30-45:AMZAING!!");
System.exit(0);
}
    
timesSubmitted++;

}//end SUBMIT method

public void nextWord(){
str = txt1.getText();
index++;
nextWord.setEnabled(false);
reset.setEnabled(true);
submit.setEnabled(true);
txt1.setText(null);

output.setText(scram.getScrambledWord(index));

if(str.equals("")){
timesSkipped++;
skippedWordsAlert.setText("  Skipped: " + timesSkipped);

  if(timesSkipped > 3){//this will close the program if the user has skipped more than 3 words
  JOptionPane.showMessageDialog(null, "You skipped 4 words!!! GAME OVER ");
  JOptionPane.showMessageDialog(null, "YOUR SCORE IS:" + score+"\n"+ "1-10:BAD    10-20:GOOD    20-30:VERY GOOD   30-45:AMZAING!!","Game Over",JOptionPane.PLAIN_MESSAGE);
  System.exit(0);
}

}
}

}

}