package uppgift5.models;

/**
 * @author Hamed Adeli,
 * h.adeli.meadeli@gmail.com
 * 12/16/2020
 */
public class AuthenticationModel {
    private String UserID;
    private String password;

    public AuthenticationModel() {

    }

    public AuthenticationModel(String userID, String password) {
        UserID = userID;
        this.password = password;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
