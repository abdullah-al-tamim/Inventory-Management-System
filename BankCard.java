
package projectims;


public class BankCard extends Payment{
    private String accNumber;
    private static final String password = "abcd";

    public BankCard() {
    }

    

    public BankCard(double totalAmount, String accNumber) {
        super(totalAmount);
        this.accNumber = accNumber;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getPassword() {
        return password;
    }

    
}
