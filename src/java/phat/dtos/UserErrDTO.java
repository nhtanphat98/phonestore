/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.dtos;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class UserErrDTO implements Serializable{
    private String userIDErr, passwordErr, fullNameErr, roleIDErr, confirmErr;
    public UserErrDTO() {
    }

    public UserErrDTO(String userIDErr, String passwordErr, String fullNameErr, String roleIDErr, String confirmErr) {
        this.userIDErr = userIDErr;
        this.passwordErr = passwordErr;
        this.fullNameErr = fullNameErr;
        this.roleIDErr = roleIDErr;
        this.confirmErr = confirmErr;
    }

    public String getConfirmErr() {
        return confirmErr;
    }

    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

    
    
    public UserErrDTO(String userIDErr, String passwordErr, String fullNameErr, String roleIDErr) {
        this.userIDErr = userIDErr;
        this.passwordErr = passwordErr;
        this.fullNameErr = fullNameErr;
        this.roleIDErr = roleIDErr;
    }

    public UserErrDTO(String userIDErr, String passwordErr) {
        this.userIDErr = userIDErr;
        this.passwordErr = passwordErr;
    }

    public String getUserIDErr() {
        return userIDErr;
    }

    public void setUserIDErr(String userIDErr) {
        this.userIDErr = userIDErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getFullNameErr() {
        return fullNameErr;
    }

    public void setFullNameErr(String fullNameErr) {
        this.fullNameErr = fullNameErr;
    }

    public String getRoleIDErr() {
        return roleIDErr;
    }

    public void setRoleIDErr(String roleIDErr) {
        this.roleIDErr = roleIDErr;
    }

    

    
}
