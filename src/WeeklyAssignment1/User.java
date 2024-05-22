package WeeklyAssignment1;

public class User {
    private String fullName;
    private String mobileNumber;
    private String password;
    private String DOB;

    public User(String fullName, String mobileNumber, String password, String DOB) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.DOB = DOB;
    }

    @Override
    public String toString() {
        return "WeeklyAssignment1.User{" +
                "fullName='" + fullName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", password='" + password + '\'' +
                ", DOB=" + DOB +
                '}';
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
