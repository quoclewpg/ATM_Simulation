import java.util.*;
import java.lang.Math;

public class ATM{

     public static void main(String []args){
        int n = 750000;
        int[] money = {10000, 20000, 50000, 100000, 200000, 500000};
        
        double div;
        int mod, bills;
        List<Double> divs = new ArrayList<Double>();
        List<Integer> mods = new ArrayList<Integer>();
        

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
            bills = money[divs.indexOf(Collections.min(divs))];
            System.out.format("Withdraw %.0f of %d bill\n", Collections.min(divs), bills);
            n = n - bills;
            divs.clear();
        }
    }
}