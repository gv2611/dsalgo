package breaker;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface OnlineAccount {
	int basePrice = 120;
	int regularMoviePrice = 45;
	int exclusiveMoviePrice = 80;
}
class Account implements OnlineAccount, Comparable<Account> {

    int noOfRegularMovies, noOfExclusiveMovies;
    String ownerName;
    int monthlyCost;
    
    private static int BASE_PRICE = 120;
    private static int REGULAR_MOVIE_PRICE = 45;
    private static int EXCLUSIVE_MOVIE_PRICE = 80;

    // 1) Add a parameterized constructor that initializes the attributes noOfExclusiveMovies and noOfExclusiveMovies.
    Account(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
        this.monthlyCost = computeMonthlyCost();
    }

    private int computeMonthlyCost() {
        return Account.BASE_PRICE +
        (Account.REGULAR_MOVIE_PRICE * this.noOfRegularMovies) +
        (Account.EXCLUSIVE_MOVIE_PRICE * this.noOfExclusiveMovies);
    }

    // 2. This method returns the monthly cost for the account.
    public int monthlyCost() {
        return this.monthlyCost;
    }

    // 3. Override the compareTo method of the Comparable interface such that two accounts can be compared based on their monthly cost.
    @Override
    public int compareTo(Account o) {
        return this.monthlyCost - o.monthlyCost();
    }
    
    // 4. Returns "Owner is [ownerName] and monthly cost is [monthlyCost] USD."
    public String toString() {
        return String.format("Owner is %s and monthly cost is %d USD.", this.ownerName, this.monthlyCost);
    }
}
public class AccountComparisons {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine();

        int t = Integer.parseInt(sub);

        ArrayList<Account> list = new ArrayList<Account>();

        for(int i=0; i<t; i++) {
        	String[] input = sc.nextLine().split(" ");
        	list.add(new Account(input[0],
        						Integer.parseInt(input[1]),
        						Integer.parseInt(input[2])));
        }
      	
        Collections.sort(list);

        System.out.println("Most valuable account details:");
        System.out.println(list.get(list.size() - 1));
    }
}