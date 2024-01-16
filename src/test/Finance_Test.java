import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.Scanner;

public class Finance_Test {

    @Test
    public void valid_input()
    {
        Finance finance = new Finance();
        Scanner Sc1 = new Scanner("5");
        double result1 = finance.verification(2,Sc1);
        Scanner Sc2 = new Scanner("2");
        double result2 = finance.verification(0,Sc2);
        Scanner Sc3 = new Scanner("2");
        double result3 = finance.verification(-5,Sc3);
        double limit = 0.0;
        double expectedValue = 2.0;
        double Tolerance = 0.1;

        assertThat(result1,is(closeTo(expectedValue,Tolerance)));
        assertThat(result2,greaterThan(limit));
        assertThat(result3,greaterThan(limit));
    }

    @Test 
    public void valid_month_rate()
    {
        Finance finance = new Finance();
        double interest_rate = 25;
        double month_rate = finance.calculate_month_rate(interest_rate);
        double expectedValue = 1.87;
        double Tolerance = 0.01;

        assertThat(month_rate,is(closeTo(expectedValue,Tolerance)));
    }

    @Test 
    public void valid_monthly_rate()
    {
        Finance finance = new Finance();
        double interest_rate = 25;
        double month_rate = finance.calculate_month_rate(interest_rate);
        double Debt_Value = 2000;
        double payback_duration = 12;
        double monthly_rate = finance.calculate_monthly_rate(Debt_Value, interest_rate, payback_duration);
        double expectedValue = 187.69;
        double Tolerance = 0.01;

        assertThat(monthly_rate,is(closeTo(expectedValue,Tolerance)));
    }

    @Test 
    public void valid_overall_debt()
    {
        Finance finance = new Finance();
        double interest_rate = 25;
        double month_rate = finance.calculate_month_rate(interest_rate);
        double Debt_Value = 2000;
        double payback_duration = 12;
        double monthly_rate = finance.calculate_monthly_rate(Debt_Value, interest_rate, payback_duration);
        double overall_debt = finance.calculate_overall_debt(Debt_Value, interest_rate, payback_duration, monthly_rate);
        double expectedValue = 2252;
        double Tolerance = 1;

        assertThat(overall_debt,is(closeTo(expectedValue,Tolerance)));
    }
}