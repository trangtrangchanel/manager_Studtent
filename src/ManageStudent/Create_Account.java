/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageStudent;

public class Create_Account {

 
    
    public Create_Account(){
        
    }
    String accout;
    String pass;
    String passAgain;

    public String getAccout() {
        return accout;
    }

    public String getPass() {
        return pass;
    }

    public String getPassAgain() {
        return passAgain;
    }

    public Create_Account(String accout, String pass, String passAgain) {
        this.accout = accout;
        this.pass = pass;
        this.passAgain = passAgain;
    }
     public Create_Account(String accout, String pass) {
        this.accout = accout;
        this.pass = pass;
       
    }
    
}
