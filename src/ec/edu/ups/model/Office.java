/**
 * @(#)Office.java	0.0.1, 11-Jun-2019 
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
public class Office {
    
    private int offId;
    private String offMainSt;
    private String offSideSt;
    private int offNumber;
    private String offCodPostal;
    private List<Vehicle> offVehicles;
    private List<User> offUsers;

    public Office(int offId, String offMainSt, String offSideSt, int offNumber, 
            String offCodPostal) {
        this.offId = offId;
        this.offMainSt = offMainSt;
        this.offSideSt = offSideSt;
        this.offNumber = offNumber;
        this.offCodPostal = offCodPostal;
    }

    public int getOffId() {
        return offId;
    }

    public void setOffId(int offId) {
        this.offId = offId;
    }

    public String getOffMainSt() {
        return offMainSt;
    }

    public void setOffMainSt(String offMainSt) {
        this.offMainSt = offMainSt;
    }

    public String getOffSideSt() {
        return offSideSt;
    }

    public void setOffSideSt(String offSideSt) {
        this.offSideSt = offSideSt;
    }

    public int getOffNumber() {
        return offNumber;
    }

    public void setOffNumber(int offNumber) {
        this.offNumber = offNumber;
    }

    public String getOffCodPostal() {
        return offCodPostal;
    }

    public void setOffCodPostal(String offCodPostal) {
        this.offCodPostal = offCodPostal;
    }

    public List<Vehicle> getOffVehicles() {
        return offVehicles;
    }

    public void setOffVehicles(List<Vehicle> offVehicles) {
        this.offVehicles = offVehicles;
    }

    public List<User> getOffUsers() {
        return offUsers;
    }

    public void setOffUsers(List<User> offUsers) {
        this.offUsers = offUsers;
    }

    public boolean createVehicle(Vehicle vehicle){
        if (this.offVehicles == null)
            this.offVehicles = new ArrayList<>();
        this.offVehicles.add(vehicle);
        return true;
    }
    
    public Vehicle readVehicle(int vehId){
        if(this.offVehicles == null)
            throw new NullPointerException();
        return this.offVehicles.get(vehId);
    }
    
    public boolean updateVehicle(int vehId, Vehicle vehicle){
        if(this.offVehicles == null)
            throw new NullPointerException();
        this.offVehicles.set(vehId, vehicle);
        return true;
    }
    
    public boolean deleteVehicle(int vehId){
        if(this.offVehicles == null)
            throw new NullPointerException();
        this.offVehicles.remove(vehId);
        return true;
    }
    
    public boolean createUser(User user){
        if (this.offUsers == null)
            this.offUsers = new ArrayList<>();
        this.offUsers.add(user);
        return true;
    }
    
    public User readUser(int userIndex){
        if(this.offUsers == null)
            throw new NullPointerException();
        return this.offUsers.get(userIndex);
    }
    
    public boolean updateUser(int userIndex, User user){
        if(this.offUsers == null)
            throw new NullPointerException();
        this.offUsers.set(userIndex, user);
        return true;
    }
    
    public boolean deleteUser(int userIndex){
        if(this.offUsers == null)
            throw new NullPointerException();
        this.offUsers.remove(userIndex);
        return true;
    }
    
    @Override
    public String toString() {
        return "Office{" + "offId=" + offId + ", offMainSt=" + offMainSt 
                + ", offSideSt=" + offSideSt + ", offNumber=" + offNumber 
                + ", offCodPostal=" + offCodPostal + ", offVehicles=" 
                + offVehicles + '}';
    }
    
}
