
public class StopWatch {

private long startTime;
private long stopTime;
    
public void start() {
startTime = System.currentTimeMillis();
 }
public void stop() {
stopTime = System.currentTimeMillis();
}
public long getTime() {
return stopTime - startTime;
}
public void restart(){
startTime = System.currentTimeMillis();   
}
    
/*public static void main(String [] args){
Scanner input = new Scanner(System.in);

StopWatch obj = new StopWatch();
System.out.println("ENTER START");
  String start = input.nextLine();
  if(start.equals("start")){
   obj.start();
  }
    System.out.println("ENTER STOP");
  String stop = input.nextLine();
  if(stop.equals("stop")){
    obj.stop();
  }
     System.out.println("THE TIME IS : " +  obj.getTime() );
 }  */ 
    
   
}

