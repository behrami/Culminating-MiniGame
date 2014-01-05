import javax.swing.*;  // needed for the Jgui items
import java.awt.*;   // needed for LayoutManager
import java.awt.event.*;  // needed for ActionListener

public class Hangman extends JFrame 
{
  private static JLabel output, output2, output3, picture,incorrectChoicesDisplay, timesSkippedDisplay;
  private static ImageIcon icon;
  public JButton A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,X,Y,Z, start, next, quit; 
  private static String hint, increasingWrong = "" ;
  private static int wordsSkipped = 0;
  public String redisplay;
  JButton [] create = {A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,X,Y,Z};
  int randomNumberGenerated,incorrectGuesses;
  String randomWordGenerated;
   
public void runHangman(){
Hangman frame2 = new Hangman();
frame2.setTitle("Jumble");

frame2.pack();
frame2.setVisible(true);
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame2.setLocationRelativeTo(null);// sets the location of the JFrame to the centre of the screen
frame2.setExtendedState(JFrame.MAXIMIZED_BOTH); // MAXIMIZES THE JFRAME
}
    
 public Hangman(){
 super("HANGMAN GAME");    
 output = new JLabel("");    
 output.setFont(new Font("Serif", Font.BOLD, 20));
 output2 = new JLabel("");
 output2.setFont(new Font("Serif", Font.BOLD, 25));
 output3 = new JLabel("");
 output3.setFont(new Font("Serif", Font.BOLD, 100));
 picture = new JLabel();
 incorrectChoicesDisplay = new JLabel("");
 incorrectChoicesDisplay.setFont(new Font("Serif", Font.BOLD, 20));
 timesSkippedDisplay = new JLabel("");
 incorrectChoicesDisplay.setFont(new Font("Serif", Font.BOLD, 20));
    
 JPanel panel1 = new JPanel();   
 panel1.setBackground(Color.BLACK);
 add(panel1);

 JPanel threeButtonPanel = new JPanel();//this panel will include the START,NEXT QUIT buttons
 threeButtonPanel.setBackground(Color.ORANGE);
 threeButtonPanel.add(incorrectChoicesDisplay); 
 threeButtonPanel.add(timesSkippedDisplay);
 add(threeButtonPanel); 
 
 JPanel imagePanel = new JPanel();
 imagePanel.add(picture);
 imagePanel.setBackground(Color.WHITE);
 add(imagePanel);
 
 JPanel panel2 = new JPanel(new GridLayout(2, 1));
 panel2.add(panel1);
 panel2.add(threeButtonPanel);
 panel2.add(imagePanel);
 panel2.add(output);
 panel2.add(output2);
 panel2.add(output3);
 panel2.setBackground(Color.YELLOW);
 add(panel2);  
 
theHandler handler = new theHandler();    

String [] buttonName = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
for(int i=0;i< create.length;i++){
create[i] = new JButton();
panel1.add(create[i]);
create[i].addActionListener(handler);
create[i].setText(buttonName[i]);
create[i].setEnabled(false);
}

start = new JButton("START");
threeButtonPanel.add(start);
start.addActionListener(handler);
next = new JButton("NEXT");
threeButtonPanel.add(next);
next.addActionListener(handler);
quit = new JButton("QUIT");
threeButtonPanel.add(quit);
quit.addActionListener(handler);
 }    
 
 public class theHandler implements ActionListener{
 
 public void actionPerformed(ActionEvent e){  

String buttonClicked = e.getActionCommand();
    
if(buttonClicked.equals("START") ){  
start.setEnabled(false);
setButtonsEnabled(create);
randomNumberGenerated = generateRandomNumber();
randomWordGenerated =generateRandomWord();
output2.setText(hintForRandomWord());
displayLines();
picture.setIcon(new ImageIcon("welcome.jpg"));   
}
if(buttonClicked.equals("NEXT")){
JOptionPane.showMessageDialog(null, "THE WORD THAT YOU SKIPPED WAS: " + randomWordGenerated); 
wordsSkipped++;  
timesSkippedDisplay.setText("SKIPPED x " + wordsSkipped);
incorrectChoicesDisplay.setText("");// refresh since user gets 7 chances PER word to get the correct answer
  if(wordsSkipped > 3){
  JOptionPane.showMessageDialog(null, "We are sorry, you've lost...the program will shutdown now", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);                              
  System.exit(0);
  }
refresh();
}

else if(!randomWordGenerated.contains(buttonClicked)  && !buttonClicked.equals("START") && !buttonClicked.equals("NEXT")  ){
incorrectGuesses++;
increasingWrong = increasingWrong + buttonClicked;
incorrectChoicesDisplay.setText("WRONG GUESSES:" + increasingWrong ); 
switch(incorrectGuesses){
  case 1: picture.setIcon(new ImageIcon("hang1.jpg"));break;   
  case 2: picture.setIcon(new ImageIcon("hang2.jpg"));break;   
  case 3: picture.setIcon(new ImageIcon("hang3.jpg"));break;    
  case 4: picture.setIcon(new ImageIcon("hang4.jpg"));break;   
  case 5: picture.setIcon(new ImageIcon("hang5.jpg"));break;   
  case 6: picture.setIcon(new ImageIcon("hang6.jpg"));break;   
  case 7: picture.setIcon(new ImageIcon("hang7.jpg"));{
          JOptionPane.showMessageDialog(null, "We are sorry, you've lost...the program will shutdown now", "GAME OVER!", JOptionPane.PLAIN_MESSAGE);                              
          System.exit(0);}
}
}
 
char [] lineArray = output3.getText().toCharArray();
for(int i=0; i < randomWordGenerated.length(); i++)
{  
        if(randomWordGenerated.charAt(i) == 'A'&& buttonClicked.equals("A")) {
        lineArray [i * 2] = 'A';   }  
        if(randomWordGenerated.charAt(i) == 'B' && buttonClicked.equals("B") ){
        lineArray [i * 2] = 'B';   }  
        if(randomWordGenerated.charAt(i) == 'C' && buttonClicked.equals("C") ){
        lineArray [i * 2] = 'C';   }  
        if(randomWordGenerated.charAt(i) == 'D' && buttonClicked.equals("D") ){
        lineArray [i * 2] = 'D';   }  
        if(randomWordGenerated.charAt(i) == 'E' && buttonClicked.equals("E") ){
        lineArray [i * 2] = 'E';   }  
        if(randomWordGenerated.charAt(i) == 'F' && buttonClicked.equals("F") ){
        lineArray [i * 2] = 'F';   }  
        if(randomWordGenerated.charAt(i) == 'G' && buttonClicked.equals("G") ){
        lineArray [i * 2] = 'G';   }  
        if(randomWordGenerated.charAt(i) == 'H' && buttonClicked.equals("H") ){
        lineArray [i * 2] = 'H';   }  
        if(randomWordGenerated.charAt(i) == 'I' && buttonClicked.equals("I") ){
        lineArray [i * 2] = 'I';   }  
        if(randomWordGenerated.charAt(i) == 'J' && buttonClicked.equals("J") ){
        lineArray [i * 2] = 'J';   }  
        if(randomWordGenerated.charAt(i) == 'K' && buttonClicked.equals("K") ){
        lineArray [i * 2] = 'K';   }  
        if(randomWordGenerated.charAt(i) == 'L' && buttonClicked.equals("L") ){
        lineArray [i * 2] = 'L';   }  
        if(randomWordGenerated.charAt(i) == 'M' && buttonClicked.equals("M") ){
        lineArray [i * 2] = 'M';   }  
        if(randomWordGenerated.charAt(i) == 'N' && buttonClicked.equals("N") ){
        lineArray [i * 2] = 'N';   }  
        if(randomWordGenerated.charAt(i) == 'O' && buttonClicked.equals("O") ){
        lineArray [i * 2] = 'O';   }  
        if(randomWordGenerated.charAt(i) == 'P' && buttonClicked.equals("P") ){
        lineArray [i * 2] = 'P';   }   
        if(randomWordGenerated.charAt(i) == 'Q' && buttonClicked.equals("Q") ){
        lineArray [i * 2] = 'Q';   }  
        if(randomWordGenerated.charAt(i) == 'R' && buttonClicked.equals("R") ){
        lineArray [i * 2] = 'R';   }  
        if(randomWordGenerated.charAt(i) == 'S' && buttonClicked.equals("S") ){
        lineArray [i * 2] = 'S';   }  
        if(randomWordGenerated.charAt(i) == 'T' && buttonClicked.equals("T") ){
        lineArray [i * 2] = 'T';   }  
        if(randomWordGenerated.charAt(i) == 'U' && buttonClicked.equals("U") ){
        lineArray [i * 2] = 'U';   }  
        if(randomWordGenerated.charAt(i) == 'V' && buttonClicked.equals("V") ){
        lineArray [i * 2] = 'V';   }  
        if(randomWordGenerated.charAt(i) == 'X' && buttonClicked.equals("X") ){
        lineArray [i * 2] = 'X';   }  
        if(randomWordGenerated.charAt(i) == 'Y' && buttonClicked.equals("Y") ){
        lineArray [i * 2] = 'Y';   }  
        if(randomWordGenerated.charAt(i) == 'Z' && buttonClicked.equals("Z") ){
        lineArray [i * 2] = 'Z';   }  
           
String redisplay = new String(lineArray);//converts back to String
output3.setText(redisplay);
}
String redisplay = new String(lineArray);
redisplay = redisplay.replaceAll(" ", "");//removes all spaces 
        if(redisplay.compareTo(randomWordGenerated) == 0){//if the output with spaces removed is same as word generated...
        JOptionPane.showMessageDialog(null,"CORRECT! THE WORD WAS: " + randomWordGenerated);
        refresh();       
        }  
        
}//end action listener 
}//end handler class      
   
 //---------------------------------------FIND PLACE TO PLACE THESE METHODS--------------------------------------------------------------------

private int generateRandomNumber(){          /////////// this will generate a random number
int i = (int)((4) * Math.random() + 0); 
return i;
}

private String generateRandomWord(){        /////this will use the random number to randomize a word
 
String [] words = {"ABA", "ABCA", "ABCDA", "ABCDEA","ABCDEAF"};
String randomWordGenerated = (words[randomNumberGenerated]);
return randomWordGenerated;
}  

private String hintForRandomWord(){

if(randomWordGenerated.equals("ABA") ){      
hint = "corresponds to aba";  
}  
else if(randomWordGenerated.equals("ABCA")){
hint = "corresponds to abca";
}
else if(randomWordGenerated.equals("ABCDA")){
hint = "corresponds to abcda";
}
else if(randomWordGenerated.equals("ABCDEA")){
hint = "corresponds to abcdea";
}
return hint;  
}

private void displayLines(){    // method to display the number of lines which will equal the number of characters in the RANDOM WORD
String displayLines = ""; 

for (int i = 0 ; i < generateRandomWord().length(); i++ ){
displayLines =  "_ " + displayLines ; 
output3.setText(displayLines); 
}
} 
private void refresh(){ ///this method calls the generate random number, hintForRandomNumber, and displayLines...used to RESET
randomNumberGenerated = generateRandomNumber();
randomWordGenerated =generateRandomWord(); 
output2.setText(hintForRandomWord());
displayLines();
increasingWrong = ""; // resets the string and start from null again
incorrectGuesses = 0;
picture.setIcon(new ImageIcon("blank.jpg")) ;  
incorrectChoicesDisplay.setText("");
}  

public void setButtonsEnabled(JButton[] temp){    
for(int i=0; i < temp.length; i++){
temp[i].setEnabled(true);
 }
 }

 }//end handler class
 
//.........................................................................................................................................
 
 

    



     
  
 

