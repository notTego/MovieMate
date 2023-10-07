package misc;

public class Credentials {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public final String getName() {
        return name;
    }

    public final String getPassword() {
        return password;
    }

    public final String getAccountType() {
        return accountType;
    }

    public final String getCountry() {
        return country;
    }

    public final String getBalance() {
        return balance;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public final void setCountry(final String country) {
        this.country = country;
    }

    public final void setBalance(final String balance) {
        this.balance = balance;
    }
}
