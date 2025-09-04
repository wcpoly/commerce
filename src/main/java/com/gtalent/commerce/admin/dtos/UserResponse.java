package com.gtalent.commerce.admin.dtos;

import com.gtalent.commerce.admin.models.User;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserResponse {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String country;
    private String address;
    private String city;
    private String zipcode;
    private String role;
    private boolean hasNewsletter;
    private LocalDateTime lastSeenAt;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private List<UserSegmentResponse> userSegments;

    public UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());

        return userResponse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isHasNewsletter() {
        return hasNewsletter;
    }

    public void setHasNewsletter(boolean hasNewsletter) {
        this.hasNewsletter = hasNewsletter;
    }

    public LocalDateTime getLastSeenAt() {
        return lastSeenAt;
    }

    public void setLastSeenAt(LocalDateTime lastSeenAt) {
        this.lastSeenAt = lastSeenAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<UserSegmentResponse> getUserSegments() {
        return userSegments;
    }

    public void setUserSegments(List<UserSegmentResponse> userSegments) {
        this.userSegments = userSegments;
    }
}

