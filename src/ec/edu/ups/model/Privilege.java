/**
 * @(#)Privilege.java	0.0.1, 11-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class Privilege {
    
    private int priId;
    private String priName;
    private double priDiscountPct;
    
    public Privilege(int priId, String priName, double priDiscountPot) {
        this.priId = priId;
        this.priName = priName;
        this.priDiscountPct = priDiscountPot;
    }

    public int getPriId() {
        return priId;
    }

    public void setPriId(int priId) {
        this.priId = priId;
    }

    public String getPriName() {
        return priName;
    }

    public void setPriName(String priName) {
        this.priName = priName;
    }

    public double getPriDiscountPot() {
        return priDiscountPct;
    }

    public void setPriDiscountPot(double priDiscountPct) {
        this.priDiscountPct = priDiscountPct;
    }
//
//    public List<User> getPriUser() {
//        return priUsers;
//    }
//
//    public void setPriUsers(List<User> priUsers) {
//        this.priUsers = priUsers;
//    }
//
//    public boolean createUser(User user){
//        if (this.priUsers == null)
//            this.priUsers = new ArrayList<>();
//        this.priUsers.add(user);
//        return true;
//    }
//    
//    public User readUser(int useId){
//        if (this.priUsers == null)
//            throw new NullPointerException();
//        return this.priUsers.get(useId);
//    }
//    
//    public boolean updateUser(int useId, User user){
//        if (this.priUsers == null)
//            throw new NullPointerException();
//        this.priUsers.set(useId, user);
//        return true;
//    }
//    
//    public boolean deleteUser(int useId){
//        if (this.priUsers == null)
//            throw new NullPointerException();
//        this.priUsers.remove(useId);
//        return true;
//    }

    @Override
    public String toString() {
        return "Privilege{" + "priId=" + priId + ", priName=" + priName 
                + ", priDiscountPct=" + priDiscountPct + '}';
    }
    
    
    
    
    
}
