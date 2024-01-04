
import java.util.*;
class userActions{
      double cash;
      boolean b;
        userActions(double cash,boolean b){
            this.cash=cash;
            this.b=b;
        }
        public void deposit(double amount){
            cash=cash+amount;
            System.out.println(amount+" is deposited to your account.");
        }
        public void withdraw(double amount){
            if(cash>=amount){
                cash-=amount;
                System.out.println(amount+" is debited from your account.");
            }
            else{
                System.out.println("Your account balance is insufficient.");
            }
        }
        public void checkBalance(){
            System.out.println("Available balance:"+cash);
        }
        public void exit(){
             b=false;
        }
}
class A{
    userActions user;
    A(userActions user){
        this.user=user;
    }
    public void Options(){
        System.out.println("1.withdraw");
        System.out.println("2.deposit");
        System.out.println("3.check balance");
        System.out.println("4.Exit");
    }
    public void Action(int option){
     Scanner sc=new Scanner(System.in);
     if(option==1){
        System.out.println("Enter the withdraw amount");
        double a=sc.nextDouble();
        user.withdraw(a);
     }
     else if(option==2){
        System.out.println("Enter the deposit amount");
        double a=sc.nextDouble();
        user.deposit(a);
     }
     else if(option==3){
        user.checkBalance();
     }
     else if(option==4){
       System.out.println("Thank you for banking with us.");
        user.exit();
     }
    }
}
class Task5{
public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
    
    userActions user1=new userActions(500,true);
    A first=new A(user1);
    while(user1.b){
        first.Options();
        int option=sc.nextInt();
        first.Action(option);
        System.out.println();
    }
}
}