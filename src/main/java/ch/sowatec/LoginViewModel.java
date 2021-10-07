package ch.sowatec;
/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
@SuppressWarnings("unused")
public class LoginViewModel {

    private String token;
    private Long userId;

    public LoginViewModel(String token, Long userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
