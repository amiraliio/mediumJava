package com.medium.instance.models.DTO.user;

import com.medium.instance.models.DTO.media.BaseMedia;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity(name = "users")  // This tells Hibernate to make a table out of this class
public class WebUser extends BaseUser {

    @NotNull(message = "can not be null")
    @Size(min = 5, max = 30)
    @Column(nullable = false, length = 70, unique = true)
    private String firstName, lastName;

    @Columns(columns = {@Column(name = "url"),
            @Column(name = "type"),@Column(name = "height"),
            @Column(name = "width"),@Column(name = "sizeType")})
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "webUser")
    private BaseMedia avatar;

    @NotNull
    @Column(length = 400,nullable = false)
    private String emailVerificationToken;

    @NotNull
    @Column(nullable = false)
    private boolean emailISVerified = false;

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public boolean isEmailISVerified() {
        return emailISVerified;
    }

    public void setEmailISVerified(boolean emailISVerified) {
        this.emailISVerified = emailISVerified;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public BaseMedia getAvatar() {
        return avatar;
    }

    public void setAvatar(BaseMedia avatar) {
        this.avatar = avatar;
    }
}