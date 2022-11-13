package dev.datecasp.libraryManager.entities;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "grantedUsers")
public class GrantedUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Primary Key autoincrementally generated, type Long")
    private Long grantedUserId;
    @Column(name="name", length = 15)
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    public GrantedUser() {}

    public GrantedUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return grantedUserId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.grantedUserId = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //ToString()
    @Override
    public String toString() {
        return "Granted User [id=" + grantedUserId + ", username=" + username + ", email=" + email + ", password=" + password + "]";
    }
}
