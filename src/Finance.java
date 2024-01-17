import java.util.Scanner;

public class Finance {

	public static double calculate_month_rate(double interest_rate)
	{
		return (Math.pow(1 + (interest_rate / 100),1.0/12.0)-1)*100;
	}

	public static double calculate_monthly_rate(double Debt_Value, double interest_rate, double payback_duration)
	{
		double month_rate = calculate_month_rate(interest_rate);
		return Debt_Value * (month_rate/100)/(1 - Math.pow((1+month_rate/100),-payback_duration));
	}

	public static double calculate_overall_debt(double Debt_Value, double interest_rate, double payback_duration, double monthly_rate)
	{
		double overall_debt = Debt_Value;
		double remaining_debt = Debt_Value;
		double month_rate = calculate_month_rate(interest_rate);
		
		for (int i = 1; i <= payback_duration; i++)
		{
			double interest = remaining_debt * (month_rate/100);
			double Capital_repaid = monthly_rate - interest;
			remaining_debt = remaining_debt - Capital_repaid;
			overall_debt = overall_debt + interest;
		}
		return overall_debt;
	}

	public static double verification(double valuetocheck, Scanner scanner)
	{
		while (valuetocheck <= 0)
		{
			System.out.println("Your number must be positiv ! Choose an other value : ");
			valuetocheck = scanner.nextDouble();
		}
		return valuetocheck;
	}

	public static void main(String[] args) 
	{
		Scanner Finance = new Scanner(System.in);
		try {
		System.out.println("Enter your Debt value :");
		double Debt_Value = verification(Finance.nextDouble(),Finance);
		
		System.out.println("Enter your interest rate :");
		double interest_rate = verification(Finance.nextDouble(),Finance);
		
		System.out.println("Enter your payback duration in months :");
		double payback_duration = verification(Finance.nextDouble(),Finance);
		
		double monthly_rate = calculate_monthly_rate(Debt_Value, interest_rate, payback_duration);
		double overall_debt = calculate_overall_debt(Debt_Value, interest_rate, payback_duration, monthly_rate);

		System.out.print("Your monthly rate : " + monthly_rate + "\nYour Number of rate : " + payback_duration + "\nYour Overall Debt is : " + overall_debt);
		}
		finally{
			Finance.close();
		}
	}
}