package alpha.profile.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;


import javax.persistence.*;
import java.util.UUID;


@Table("profile")
public class User {


    @PrimaryKeyColumn(name="USERID", type= PrimaryKeyType.PARTITIONED)
    private UUID userId;

    @Column(name="FIRSTNAME",length=50,nullable=false,unique=true)
    private String firstname;

    @Column(name="LASTNAME",length=50,nullable=false,unique=true)
    private String lastname;

    @PrimaryKeyColumn(name="EMAIL", type=PrimaryKeyType.CLUSTERED)
    private String email;

    @Column(name="MOBILE",length=10,nullable=false)
    private String mobile;

    @Column(name="PASSWORD",length=30,nullable=false)
    private String password;

    //default constructor
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

    public User(UUID userId, String firstname,String lastname,String email, String mobile, String password) {
        super();
        this.userId = userId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public String getUserid() {
        return UUID.randomUUID().toString();
    }

    public void setUserid(UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname +", email=" + email + ", mobile=" + mobile + ", password="
                + password + "]";
    }
}