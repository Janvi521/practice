package electro11.shops22.model;

public class CustomerCreateAccount {
    private String  firstName;
    private String  lastName;
    private String phoneNumber;
    private String emailAddress;
    private String emailpassword;
    private String UserPassword;

    public CustomerCreateAccount(String firstName, String lastName, String phoneNumber, String emailAddress, String emailpassword,String UserPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.emailpassword = emailpassword;
        this.UserPassword=UserPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailpassword(String emailpassword) {
        this.emailpassword = emailpassword;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmailpassword() {
        return emailpassword;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserPassword() {
        return UserPassword;
    }
}
