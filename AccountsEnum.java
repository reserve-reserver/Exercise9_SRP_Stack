public enum AccountsEnum {
    JOHN_DOE("John Doe", "1015890118", 1000.00, "Savings", true),
    JANE_SMITH("Jane Smith", "2894890016", 2000.00, "Checking", false),
    ALICE_JOHNSON("Alice Johnson", "6490380021", 1500.00, "Savings", true),
    BOB_BROWN("Bob Brown", "7802844028", 2500.00, "Checking", false),
    CHARLIE_DAVIS("Charlie Davis", "9801894038", 3000.00, "Savings", true),
    EMILY_WILSON("Emily Wilson", "2098781638", 3500.00, "Checking", false),
    FRANK_MARTIN("Frank Martin", "4520022158", 4000.00, "Savings", true),
    GRACE_ADAMS("Grace Adams", "6731593267", 4500.00, "Checking", false),
    HARRY_WALKER("Harry Walker", "8942164376", 5000.00, "Savings", true),
    IVY_HALL("Ivy Hall", "1053735485", 5500.00, "Checking", false),
    JACK_TAYLOR("Jack Taylor", "3264306594", 6000.00, "Savings", true),
    KATE_LEWIS("Kate Lewis", "5474877603", 6500.00, "Checking", false),
    LEO_HARRIS("Leo Harris", "7685448712", 7000.00, "Savings", true),
    MIA_CLARK("Mia Clark", "9896019821", 7500.00, "Checking", false),
    NOAH_ROBINSON("Noah Robinson", "2006590930", 8000.00, "Savings", true),
    OLIVIA_WRIGHT("Olivia Wright", "4217162049", 8500.00, "Checking", false),
    PETER_HALL("Peter Hall", "6427733158", 9000.00, "Savings", true),
    QUINN_JONES("Quinn Jones", "8638304267", 9500.00, "Checking", false),
    RACHEL_GREEN("Rachel Green", "0848875376", 10000.00, "Savings", true),
    STEVE_CLARK("Steve Clark", "3929033810", 10500.00, "Checking", false);

    private final String name;
    private final String accountNumber;
    private final double balance;
    private final String accountType;
    private final Boolean activeLoan;

    AccountsEnum(String name, String accountNumber, double balance, String accountType, Boolean activeLoan) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
        this.activeLoan = activeLoan;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public Boolean getActiveLoan() {
        return activeLoan;
    }

    @Override
    public String toString() {
        return "Account Details:\n" +
                "Account Holder: " + name + "\n" +
                "Account Number: " + accountNumber + "\n" +
                "Account Balance: " + balance + "\n" +
                "Account Type: " + accountType + "\n" +
                "Has a Loan: " + activeLoan;
    }
}