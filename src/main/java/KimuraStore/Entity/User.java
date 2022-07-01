package KimuraStore.Entity;

import java.util.Date;

public class User {
    private int id;
    private String password;
    private String display_name;
    private String email;
    private String resetPasswordToken;
    private Date resetPasswordTokenTimeCreated;
    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public void setResetPasswordToken(String resetPasswordToken) {
        this.resetPasswordToken = resetPasswordToken;
    }

    public Date getResetPasswordTokenTimeCreated() {
        return resetPasswordTokenTimeCreated;
    }

    public void setResetPasswordTokenTimeCreated(Date resetPasswordTokenTimeCreated) {
        this.resetPasswordTokenTimeCreated = resetPasswordTokenTimeCreated;
    }
}
