public class Exercise3 {
    public double calculate(double amount, int type, int years)
    {
        double result = 0;
        double disc = (years > 5) ? (double) 5 / 100 : (double)years / 100;

        switch(type){
            case 1:
                result = amount;
                return result;
            case 2:
                result = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));
                break;
            case 3:
                result = (0.7 * amount) - disc * (0.7 * amount);
                return result;
            case 4:
                result = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));
                break;
            default:
                return result;
        }
        return 0;
    }
}
