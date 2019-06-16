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
    private List<Phone> offPhones;
    private List<Vehicle> offVehicles;
    private List<Employee> offEmployees;

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

    public List<Phone> getOffPhones() {
        return offPhones;
    }

    public void setOffPhones(List<Phone> offPhones) {
        this.offPhones = offPhones;
    }

    public List<Vehicle> getOffVehicles() {
        return offVehicles;
    }

    public void setOffVehicles(List<Vehicle> offVehicles) {
        this.offVehicles = offVehicles;
    }

    public List<Employee> getoffEmployees() {
        return offEmployees;
    }

    public void setOffEmployees(List<Employee> offEmployees) {
        this.offEmployees = offEmployees;
    }

    public boolean createPhone(Phone Phone){
        if (this.offPhones == null)
            this.offEmployees = new ArrayList<>();
        this.offPhones.add(Phone);
        return true;
    }
    
    public Phone readPhone(int phoIndex){
        if(this.offPhones == null)
            throw new NullPointerException();
        return this.offPhones.get(phoIndex);
    }
    
    public boolean updatePhone(int phoIndex, Phone phone){
        if(this.offPhones == null)
            throw new NullPointerException();
        this.offPhones.set(phoIndex, phone);
        return true;
    }
    
    public boolean deletePhone(int phoIndex){
        if(this.offPhones == null)
            throw new NullPointerException();
        this.offPhones.remove(phoIndex);
        return true;
    }
    
    public boolean createVehicle(Vehicle vehicle){
        if (this.offVehicles == null)
            this.offVehicles = new ArrayList<>();
        this.offVehicles.add(vehicle);
        return true;
    }
    
    public Vehicle readVehicle(int vehIndex){
        if(this.offVehicles == null)
            throw new NullPointerException();
        return this.offVehicles.get(vehIndex);
    }
    
    public boolean updateVehicle(int vehIndex, Vehicle vehicle){
        if(this.offVehicles == null)
            throw new NullPointerException();
        this.offVehicles.set(vehIndex, vehicle);
        return true;
    }
    
    public boolean deleteVehicle(int vehIndex){
        if(this.offVehicles == null)
            throw new NullPointerException();
        this.offVehicles.remove(vehIndex);
        return true;
    }
    
    public boolean createEmployee(Employee employee){
        if (this.offEmployees == null)
            this.offEmployees = new ArrayList<>();
        this.offEmployees.add(employee);
        return true;
    }
    
    public User readEmployee(int empIndex){
        if(this.offEmployees == null)
            throw new NullPointerException();
        return this.offEmployees.get(empIndex);
    }
    
    public boolean updateEmployee(int empIndex, Employee employee){
        if(this.offEmployees == null)
            throw new NullPointerException();
        this.offEmployees.set(empIndex, employee);
        return true;
    }
    
    public boolean deleteEmployee(int empIndex){
        if(this.offEmployees == null)
            throw new NullPointerException();
        this.offEmployees.remove(empIndex);
        return true;
    }

    @Override
    public String toString() {
        return "Office{" + "offId=" + offId + ", offMainSt=" + offMainSt 
                + ", offSideSt=" + offSideSt + ", offNumber=" + offNumber 
                + ", offCodPostal=" + offCodPostal + ", offPhones=" + offPhones
                + ", offVehicles=" + offVehicles + ", offEmployees=" 
                + offEmployees+ '}';
    }
    
    
}
