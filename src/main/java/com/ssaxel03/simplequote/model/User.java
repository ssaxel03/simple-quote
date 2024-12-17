package com.ssaxel03.simplequote.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "auth_user")
public class User extends AbstractModel{

    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String role;

    @OneToMany(
            // propagate changes on user entity to item entities
            cascade = CascadeType.ALL,

            // make sure to remove items if unlinked from user
            orphanRemoval = true,

            // user foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user",

            // NOT fetch items from database together with user
            fetch = FetchType.EAGER
    )
    private List<Item> items;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", creationTime=" + getCreationTime() +
                ", updateTime=" + getUpdateTime() +
                ", username=" + username +
                ", password=" + username +
                ", items=" + items +
                ", company=" + company +
                '}';
    }

}
