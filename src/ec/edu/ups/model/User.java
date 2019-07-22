/**
 * @(#)User.java	0.0.2, 12-Jun-2019 
 * 
 * Universidad Politécnica Salesiana
 * Carrera de Computación
 * Cuenca - Ecuador	
 */
package ec.edu.ups.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @since 11-Jun-2019
 * @version 0.0.1
 * @author Sarmiento Bryan, Serpa Roberto, Zhizhpon Eduardo
 */
public class User {
    
    private int useId;
    private String useDNI;
    private String useName;
    private String useLastNamel;
    private Date useBirthDay;
    private String useAddress;
    private char useType;
    private String useEmail;
    private String usePassword;
    private List<Phone> usePhones;

    public User(int useId, String useDNI, String useName, String useLastNamel, 
            Date useBirthDay, String useAddress, char useType, String useEmail,
            String usePassword) {
        this.useId = useId;
        this.useDNI = useDNI;
        this.useName = useName;
        this.useLastNamel = useLastNamel;
        this.useBirthDay = useBirthDay;
        this.useAddress = useAddress;
//        this.useWorkAdd = useWorkAdd;
        this.useType = useType;
        this.useEmail = useEmail;
        this.usePassword = usePassword;
    }

    public int getUseId() {
        return useId;
    }

    public void setUseId(int useId) {
        this.useId = useId;
    }

    public String getUseDNI() {
        return useDNI;
    }

    public void setUseDNI(String useDNI) {
        this.useDNI = useDNI;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getUseLastNamel() {
        return useLastNamel;
    }

    public void setUseLastNamel(String useLastNamel) {
        this.useLastNamel = useLastNamel;
    }

    public Date getUseBirthDay() {
        return useBirthDay;
    }

    public void setUseBirthDay(Date useBirthDay) {
        this.useBirthDay = useBirthDay;
    }

    public String getUseAddress() {
        return useAddress;
    }

    public void setUseAddress(String useAddress) {
        this.useAddress = useAddress;
    }

    public char getUseType() {
        return useType;
    }

    public void setUseType(char useType) {
        this.useType = useType;
    }

    public String getUseEmail() {
        return useEmail;
    }

    public void setUseEmail(String useEmail) {
        this.useEmail = useEmail;
    }

    public String getUsePassword() {
        return usePassword;
    }

    public void setUsePassword(String usePassword) {
        this.usePassword = usePassword;
    }
    
    public List<Phone> getUsePhones() {
        return usePhones;
    }

    public void setUsePhones(List<Phone> usePhones) {
        this.usePhones = usePhones;
    }
    
    public boolean createPhone(Phone phone){
        if (this.usePhones == null)
            this.usePhones = new ArrayList<>();
        this.usePhones.add(phone);
        return true;
    }
    
    public Phone readPhone(int phoIndex){
        if (this.usePhones == null)
            throw new NullPointerException();
        return this.usePhones.get(phoIndex);
    }
    
    public boolean updatePhone(int phoIndex, Phone phone){
        if (this.usePhones == null)
            throw new NullPointerException();
        this.usePhones.set(phoIndex, phone);
        return true;
    }
    
    public boolean deletePhone(int phoIndex){
        if (this.usePhones == null)
            throw new NullPointerException();
        this.usePhones.remove(phoIndex);
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "useId=" + useId + ", useDNI=" + useDNI + ", useName=" 
                + useName + ", useLastNamel=" + useLastNamel + ", useBirthDay=" 
                + useBirthDay + ", useAddress=" + useAddress + ", useType=" 
                + useType + ", useEmail=" + useEmail + ", usePassword=" 
                + usePassword + ", usePhones=" + usePhones.toString() + '}';
    }
    
    
}
