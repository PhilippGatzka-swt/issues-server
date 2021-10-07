package ch.sowatec;

public class LoginViewModel {

    private String jwtToken;
    private Long id;

    public LoginViewModel(String token, Long id) {
        this.jwtToken = token;
        this.id = id;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public Long getId() {
        return id;
    }
}
