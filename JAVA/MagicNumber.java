import javax.swing.*;

public class MagicNumber {
  
public void runMagicNumberGame(){
        
String answer, yesOrNo = "";
int sum=0;
           
JOptionPane.showMessageDialog(null, "PICK A NUMBER BETWEEN 1-63, you will be shown 6 sets of number and you must answer yes if your number is in the set or no if it's not");

do{
yesOrNo = JOptionPane.showInputDialog("1 3 5 7 9 11 13 15 \n17 19 21 23 25 27 29 31 \n33 35 37 39 41 43 45 47 \n49 51 53 55 57 59 61 63");   
yesOrNo = yesOrNo.trim();
if(yesOrNo.equalsIgnoreCase("yes")){
sum= sum+1;
}
}while( (!yesOrNo.equalsIgnoreCase("yes"))  && (!yesOrNo.equalsIgnoreCase("no")) ); 

do{ 
yesOrNo = JOptionPane.showInputDialog("2 3 6 7 10 11 14 15 \n18 19 22 23 26 27 30 31 \n34 35 38 39 42 43 46 47 \n50 51 54 55 58 59 62 63 ");        
if(yesOrNo.equals("yes")){
 sum= sum+2;
}
}while( (!yesOrNo.equalsIgnoreCase("yes"))  && (!yesOrNo.equalsIgnoreCase("no")) ); 

do{ 
yesOrNo = JOptionPane.showInputDialog("4 5 6 7 12 13 14 15 \n20 21 22 23 28 29 30 31 \n36 37 38 39 44 45 46 47 \n52 53 54 55 60 61 62 63 ");

if(yesOrNo.equals("yes")){
 sum= sum+4;
}
}while( (!yesOrNo.equalsIgnoreCase("yes"))  && (!yesOrNo.equalsIgnoreCase("no")) ); 

do{ 
yesOrNo = JOptionPane.showInputDialog("8 9 10 11 12 13 14 15 \n24 25 26 27 28 29 30 31 \n40 41 42 43 44 45 46 47 \n56 57 58 59 60 61 62 63 ");
if(yesOrNo.equals("yes")){
 sum= sum+8;
}
}while( (!yesOrNo.equalsIgnoreCase("yes"))  && (!yesOrNo.equalsIgnoreCase("no")) ); 
   

do{ 
yesOrNo = JOptionPane.showInputDialog("16 17 18 19 20 21 22 23 \n24 25 26 27 28 29 30 31\n48 49 50 51 52 53 54 55\n56 57 58 59 60 61 62 63");        
if(yesOrNo.equals("yes")){
 sum= sum+16;
}
}while( (!yesOrNo.equalsIgnoreCase("yes"))  && (!yesOrNo.equalsIgnoreCase("no")) ); 
     
do{ 
yesOrNo = JOptionPane.showInputDialog("32 33 34 35 36 37 38 39 \n40 41 42 43 44 45 46 47\n48 49 50 51 52 53 54 55\n56 57 58 59 60 61 62 63");        
if(yesOrNo.equals("yes")){
 sum= sum+32;
}
}while( (!yesOrNo.equalsIgnoreCase("yes"))  && (!yesOrNo.equalsIgnoreCase("no")) ); 
     
JOptionPane.showMessageDialog(null, "YOUR NUMBER WAS " + sum);
    }
}