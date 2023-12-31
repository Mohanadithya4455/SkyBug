import java.util.*;

class Task3
{
    public static void main(String args[]){
       fun();
    }
    public static void fun(){
         Scanner sc=new Scanner(System.in);
        System.out.println("Number of Subjects:");
        int n=sc.nextInt();
        int sum=0;
        for(int i=1;i<=n;i++){
            System.out.println("Enter the marks obtained in subject-"+i+":");
            int marks=sc.nextInt();
            while(marks>100){
                System.out.println("Invalid marks,Enter again:");
                marks=sc.nextInt();
            }
            sum+=marks;
        }
        int avg_percentage=sum/n;
         String grade=g(avg_percentage);
          display(sum, avg_percentage, grade);
    }
    public static String g(int avg_percentage){
    String grade="F";
         if(avg_percentage>=95&&avg_percentage<=100){
            grade="A+";
         }
         else if(avg_percentage>=90&&avg_percentage<95){
            grade="A";
         }
         else if(avg_percentage>=85&&avg_percentage<90){
            grade="B+";
         }
         else if(avg_percentage>=80&&avg_percentage<85){
            grade="B";
         }
         else if(avg_percentage>=75&&avg_percentage<80){
            grade="C+";
         }
         else if(avg_percentage>=70&&avg_percentage<75){
            grade="C";
         }
         else if(avg_percentage>=65&&avg_percentage<70){
            grade="D+";
         }
         else if(avg_percentage>=60&&avg_percentage<65){
            grade="D+";
         }
         else{
            grade="F";
         }
         return grade;
    }
    public static void display(int sum,int avg_percentage,String grade){
        System.out.println("Total marks obtained by the Student:"+sum);
        System.out.println("Average percentage obtained by Student:"+avg_percentage);
        System.out.println("Grade of the Student:"+grade);
    }

}