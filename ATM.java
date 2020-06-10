import java.util.*;
import java.lang.Math;

public class ATM{
    
    static List<Integer> bills = new ArrayList<Integer>();

    public static void main(String []args){
        int[] money = {10000, 20000, 50000, 100000, 200000, 500000};
        List<Integer> withdraw = new ArrayList<Integer>();
        
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter an amount to withdraw");

        int amounts = myObj.nextInt();  // Read user input
        System.out.println("You withdrawed: " + amounts);  // Output user input

        withdraw = withdrawMoney(money, amounts);
        for(int i = 0; i < bills.size(); i++){
            System.out.println(withdraw.get(i) + " " +  bills.get(i));
            for(int j = i + 1; j < bills.size(); j++){
                if(bills.get(i).equals(bills.get(j))){
                    i++;
                }
            }
        }
    }
    
    private static List withdrawMoney(int[] money, int n){
        double div;
        int mod;
        List<Double> divs = new ArrayList<Double>();
        List<Integer> mods = new ArrayList<Integer>();
        List<Integer> results = new ArrayList<Integer>();
        
        
        while(n > 0){
            for(int i = 0; i < money.length; i++)
            {
                div = Math.floor(n / money[i]);
                mod = n % money[i];
                
                if(div !=0){
                    divs.add(div);
                }
                
                if(mod != n){
                    mods.add(mod);
                }
            }
            bills.add(money[divs.indexOf(Collections.min(divs))]);
            results.add((Collections.min(divs)).intValue());
            n = n - bills.get(bills.size() - 1);
            divs.clear();
        }
        return results;
    }
}