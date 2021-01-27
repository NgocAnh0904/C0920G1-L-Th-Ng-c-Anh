package com.codegym.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Pattern(regexp = "^KH-\\d{4}$", message = "Id không đúng định dang")
    private String id;
    @NotEmpty
    private String name;
    @NotEmpty
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    private String dateOfBirth;
    @NotEmpty
    private String gender;
    @NotEmpty
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Khong dung dinh dang")
    private String cmnd;
    @NotEmpty
    @Pattern(regexp = "^(\\+84|0)(90|91)\\d{7}$", message = "Khong dung dinh dang")
    private String phoneNumb;
    @NotEmpty
    @Email(message = "Khong dung dinh dang")
    private String email;
    @NotEmpty
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerType customerType;

    public Customer() {
    }
    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getPhoneNumb() {
        return phoneNumb;
    }

    public void setPhoneNumb(String phoneNumb) {
        this.phoneNumb = phoneNumb;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
