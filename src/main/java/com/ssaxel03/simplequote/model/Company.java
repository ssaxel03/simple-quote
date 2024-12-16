package com.ssaxel03.simplequote.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "company")
public class Company extends AbstractModel{

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String phone;

    @Pattern(regexp=".+@.+\\..+", message="Invalid email. Please try again.")
    private String email;

    private String website;

    @OneToOne(mappedBy = "company", cascade = CascadeType.ALL)
    private User user;

    @NotNull
    @NotBlank
    private String taxNumber;

    @NotNull
    @NotBlank
    private String primaryColor;

    @NotNull
    @NotBlank
    private String secondaryColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getPrimaryColor() {
        return primaryColor;
    }

    public void setPrimaryColor(String primaryColor) {
        this.primaryColor = primaryColor;
    }

    public String getSecondaryColor() {
        return secondaryColor;
    }

    public void setSecondaryColor(String secondaryColor) {
        this.secondaryColor = secondaryColor;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + getId() +
                ", creationTime=" + getCreationTime() +
                ", updateTime=" + getUpdateTime() +
                ", name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                ", email=" + email +
                ", website=" + website +
                ", user=" + user +
                ", taxNumber=" + taxNumber +
                '}';
    }
}
