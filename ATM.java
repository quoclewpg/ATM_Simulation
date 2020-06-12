import java.util.*;
import java.lang.Math;

public class ATM{
    static List<Long> bills = new ArrayList<Long>();

    public static void main(String []args){

        boolean stop = true;
        while(stop){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter the amount:  (quit to exit) ");

            String n = myObj.nextLine();  // Read user input
            long[] money = {500, 1000, 2000, 5000, 10000, 20000, 50000, 100000, 200000, 500000};

            if(n.equalsIgnoreCase("quit")){
                System.out.println("Thank you, Bye!");
                stop = false;
            }
            else{
                System.out.println("The amount you want to withdraw is: $" + n);  // Output user input
                List<Long> amounts = new ArrayList<Long>();
                amounts = withdrawMoney(money, Long.parseLong(n));

                for(int i = 0; i < bills.size(); i++){
                    if( amounts.get(i) > 1){
                        System.out.println(amounts.get(i) + " of $" +  bills.get(i) + " Bills");
                    }
                    else{
                        System.out.println(amounts.get(i) + " of $" +  bills.get(i) + " Bill");
                    }
                    for(int j = i + 1; j < bills.size(); j++){
                        if(bills.get(i).equals(bills.get(j))){
                            i++;
                        }
                    }
                }
                amounts.clear();
                bills.clear();
            }
        }
    }

    private static List<Long> withdrawMoney(long[] money, long n){
        double div;
        long mod;
        List<Double> divs = new ArrayList<Double>();
        List<Long> mods = new ArrayList<Long>();
        List<Long> results = new ArrayList<Long>();
        
        
        while(n > 0){
            for(int i = 0; i < money.length; i++)
            {
                div = Math.floor(n / money[i]);
                mod = n % money[i];
                
                if(div !=0){
                    divs.add(div);
                }
            }
            bills.add(money[divs.indexOf(Collections.min(divs))]);
            results.add((Collections.min(divs)).longValue());
            n = n - bills.get(bills.size() - 1);
            divs.clear();
        }
        return results;
    }
}
