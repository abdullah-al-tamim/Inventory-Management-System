/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectims;


public class User {
    private String userName, userId;
    private static final String password = "abcd";
    public User() {
    }

    public User(String userName, String userId) {
        this.userName = userName;
        this.userId = userId;
    }

    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", userId=" + userId + '}';
    }
    
    public boolean logIn(String pass){
        if (password.equals(pass)) {
            return true;
        }
        else return false;
    }
    
    public void logOut(){
        
        System.out.println("Wrong password! Try again.");
    }
}
