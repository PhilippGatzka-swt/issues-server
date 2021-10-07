package ch.sowatec.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
@SuppressWarnings("unused")
@Table(name = "user")
@Entity
@NamedQuery(name="User.findAll", query = "SELECT u FROM User u")
public class User extends AbstractEntity {
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}