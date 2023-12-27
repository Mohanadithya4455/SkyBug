
import java.util.*;
public class Task1{
public static void main(String args[]){
    System.out.println("Start the Game");
    Scanner sc=new Scanner(System.in);
    Random r=new Random();
    int start=1,end=100;
    int score=0;
    System.out.println("Minimum number of Attempts:");
    int limit=sc.nextInt();
    String str="Yes";
    while(str.equals("Yes")){
     int random=r.nextInt(end-start+1)-start;
     int i=0;

     boolean win=false;
     while(i<limit&&!win){
     System.out.println("Guess the number:");
     int guess=sc.nextInt();
      if(guess==random){
        score++;
        System.out.println("Guess is correct");
        win=true;
      }
      else if(guess<random){
        System.out.println("Guess is too Low");
      }
      else{
        System.out.println("Guess is too high");
      }
      i++;
    }
    if(!win){
        System.out.println("Sorry,You lost the game");
    }
    else{
        System.out.println("You won the game");
    }
    System.out.println("Want to play again(Yes/No)");
    String temp=sc.next();
    if(!str.equals(temp)){
        str="No";
    }
    }
    System.out.println("Your score is:"+score);
}
}















