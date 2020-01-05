
package nfa;

import java.util.ArrayList;
import java.util.Scanner;


public class NFA {
    
    public static ArrayList symbol =new ArrayList();
    public static ArrayList state =new ArrayList();
    public static ArrayList FinalState =new ArrayList();
   
    public static void main(String[] args) {
      
        System.out.println("\n *********** Symbol  ************ ");
        boolean bo=true;
        while(bo){
            try{
                System.out.print(" 1- Enter symbol  2- stop : ");
                Scanner in=new Scanner(System.in);
                int num=in.nextInt();
                if(num == 1){
                    System.out.print("\n Enter symbol : ");
                    Scanner in2=new Scanner(System.in);
                    String s =in2.next();
                    symbol.add(s);
                }else if(num == 2){
                    bo=false;
                }        
            }catch(Exception e){
                System.out.println("\n Enter correctly !!");
            }
        
        }
          
         System.out.println("\n *********** States  ************ ");
         bo=true;
        while(bo){
            try{  
              System.out.print(" 1- Enter state  2- stop :  ");
              Scanner in=new Scanner(System.in);
              int num=in.nextInt();
              if(num == 1){
              System.out.print("\n Enter state : ");
              Scanner in2=new Scanner(System.in);
              String s =in2.next();
              state.add(s);
            }else if(num == 2){
                bo=false;
            }    
            
            }catch(Exception e){
                System.out.println("\n Enter correctly !!");
            }
        
        }
        
        
        System.out.println("\n *********** Start state  ************ \n");
        System.out.print("\n Enter start state : ");
        Scanner in=new Scanner(System.in);
        String startState = in.next();
        
       
        
        System.out.println("\n *********** Final States   ************ \n");
         String finalState=null;
        bo=true;
       while(bo){
             try{  
                System.out.print("\n  1- Enter final state 2- stop :  ");
                Scanner in3=new Scanner(System.in);
                int num=in3.nextInt();
                if(num == 1){
                System.out.print("\n Enter final state : ");
                Scanner in2=new Scanner(System.in);
                finalState = in2.next();
                FinalState.add(finalState);
        }else if(num == 2){
            bo=false;
        }
            
            }catch(Exception e){
                System.out.println("\n Enter correctly !!");
            }
    
        }
        
     
       System.out.println("\n ***********  Transition  Table  ************ \n");
       String arr[][]=new String[state.size()*symbol.size()][3];
       int row=0,ii=0,jj=0;
        for(int i=ii;i<state.size();i++){
            String s=(String) state.get(i);
            for(int j=0;j<symbol.size();j++){
                
              try{  
                 
                System.out.print(s+" -"+symbol.get(j)+" -> "+" (Enter 1- Next state 2- Nothing ) ");
                Scanner in3=new Scanner(System.in);
                int num=in3.nextInt();
                if(num == 1){
                    System.out.print(" >> Enter next state : ");
                    Scanner in2=new Scanner(System.in);
                    String state =in2.next();
            
                    arr[row][0]=s;
                    arr[row][1]=(String) symbol.get(j);
                    arr[row][2]=state;
                    row++;
                }else{
                    arr[row][0]=s;
                    arr[row][1]=(String) symbol.get(j);
                    arr[row][2]=null;
                    row++;
                }
                
            
            }catch(Exception e){
                System.out.println("\n Enter correctly !!");
                j--;
            }
            }
        }
        
         
        System.out.println("\n ***********  Test  ************ \n");
         bo=true;
        while(bo){
             try{  
        System.out.print("\n 1- Enter word   2- Exit :  ");
        Scanner in2=new Scanner(System.in);
        int num=in2.nextInt();
        if(num == 1){
            System.out.print("\n Enter word : ");
            Scanner in3=new Scanner(System.in);
            String s =in3.next();
            char a[]=s.toCharArray();
            
            String inital=null,next = null;
            for(int i=0;i<a.length;i++){
                 if(i == 0){
                     inital=startState;
                 }else {
                     inital=next;
                 }
                 for(int r=0;r<arr.length;r++){
                     if(arr[r][0].equals(inital) && arr[r][1].equals(a[i]+"") ){
                         next=arr[r][2]+"";
                     }
                    
                 }
            }
           
           System.out.println("\n ***********  Result  ************ \n");     
           int v=0;
           for(int i=0;i<FinalState.size();i++){
            if(next.equals(FinalState.get(i) )){
                    System.out.println(" Accepted !! ");
                    i=FinalState.size();
                    v=1;
            }
            }
            if(v == 0)
                System.out.println("Not Accepted !! ");
        }else if(num == 2){
            bo=false;
        }
            
            }catch(Exception e){
                System.out.println("\n Enter correctly !!");
            }
   
        }
        
             
        
        
        
        
    }
    
}
