/**
 * @(#)CompanyController.java	0.0.1, 22-Jul-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.controller;

/**
 * @since 22-Jul-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class CompanyController {
    
    private PrivilegeController conPrivilege;
    private VehCategoryController conCategory;

    public CompanyController() {
        conPrivilege = new PrivilegeController();
        conCategory = new VehCategoryController();
    }
    
    public PrivilegeController getConPrivilege() {
        return conPrivilege;
    }

    public void setConPrivilege(PrivilegeController conPrivilege) {
        this.conPrivilege = conPrivilege;
    }

    public VehCategoryController getConCategory() {
        return conCategory;
    }

    public void setConCategory(VehCategoryController conCategory) {
        this.conCategory = conCategory;
    }
    
}
