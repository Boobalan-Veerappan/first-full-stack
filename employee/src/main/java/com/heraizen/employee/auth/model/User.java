package com.heraizen.employee.auth.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;

@Data
public class User {

    @Id
    private String id;
    private String email;
    private String password;
    private boolean enabled;
	private String empno;
	private String name;
	private String mobile;
	private String dateofbirth;
	private String dateofjoin;
	private String address;
    
    @DBRef
    private Set<Role> roles=new HashSet<Role>();
    
    
    public void addRole(Role role) {
    	this.roles.add(role);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

}