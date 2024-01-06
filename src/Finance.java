import java.util.Scanner;

public class Finance {

	public static void main(String[] args) {
		Scanner Finance = new Scanner(System.in);
		try {
		System.out.println("Enter your Debt value :");
		double Debt_Value = Finance.nextDouble();
		
		System.out.println("Enter your interest rate :");
		double interest_rate = Finance.nextDouble();
		
		System.out.println("Enter your payback duration in months :");
		double payback_duration = Finance.nextInt();
		
		double month_rate = (Math.pow(1 + (interest_rate / 100),1.0/12.0)-1)*100;
		double Num_rate = payback_duration ;
		double overall_debt = Debt_Value;
		double remaining_debt = Debt_Value;
		double monthly_rate = Debt_Value * (month_rate/100)/(1 - Math.pow((1+month_rate/100),-payback_duration));
		
		for (int i = 1; i <= payback_duration; i++)
		{
			double interest = remaining_debt * (month_rate/100);
			overall_debt = overall_debt + interest;
			double Capital_repaid = monthly_rate - interest;
			remaining_debt = remaining_debt - Capital_repaid;
		}
		
		System.out.print("Your monthly rate : " + monthly_rate + "\nYour Number of rate : " + Num_rate + "\nYour Overall Debt is : " + overall_debt);
		}
		finally{
			Finance.close();
		}
		
	}

}