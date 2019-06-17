/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import ec.edu.ups.controller.OfficeController;
import ec.edu.ups.model.City;
import ec.edu.ups.model.Province;
import ec.edu.ups.model.Office;
import java.util.Scanner;



/**
 *
 * @author edd
 */
public class Main {
    
    public static void main(String [] args){
        
        RentalUI renUi = new RentalUI();
        //renUi.setVisible(true);
        Scanner sc = new Scanner(System.in);
        
        OfficeController of = new OfficeController();
        
        System.out.println("\n\t ** Lista Provincias:\n");
        
        for (Province pro: of.getProvinces()) {
            System.out.println("Id: " + pro.getProId() + "\tName: " + pro.getProName());
        }
        
        System.out.print("\tIngrese Id de una provincia: ");
        int proId = Integer.parseInt(sc.nextLine());
        
        System.out.println("\n\t ** Lista Ciudades:\n");
        
        for (City cit: of.getCities(proId)) {
            System.out.println("Id: " + cit.getCitId() + "\tName: " + cit.getCitName());
        }
        
        System.out.print("\tIngrese Id de una ciudad: ");
        int citId = Integer.parseInt(sc.nextLine());
        
        System.out.println("\n\t ** Lista Oficinas\n");
        for (Office off: of.getOffices(citId)) {
            System.out.println("Id: " + off.getOffId() + "\tMainSt: " + off.getOffMainSt());
        }
        
        System.out.print("\tIngrese Id de una oficina: ");
        int offId = Integer.parseInt(sc.nextLine());
        
        
        
        of.loadOffice(proId, citId, offId);
        
//        of.insertProvince(new Province(1, "Azuay"));
//        of.insertProvince(new Province(2, "Pichincha"));
//        of.insertProvince(new Province(3, "Guayas"));
//        of.insertProvince(new Province(4, "Ambato"));
        
        //of.loadOffices();
        
        System.out.println("\n\n" + of);
        
        
    }
    
    public void prueba(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\t ** Prueba de Proyecto");
        
//        VehicleRentalSystem vrs = new VehicleRentalSystem();
        
        OfficeController office = new OfficeController();
        System.out.print("ProId:");
        int proId = Integer.parseInt(sc.nextLine());
        System.out.print("ProNombre:");
        String proName = sc.nextLine();
       // office.createProvince(proId, proName);
        
        System.out.print("ProIndex:");
        int index = Integer.parseInt(sc.nextLine());
        System.out.print("cityId:");
        int cityId = Integer.parseInt(sc.nextLine());
        System.out.print("cityName:");
        String cityName = sc.nextLine();
       // office.createCity(index, cityId, cityName);
        
        System.out.println(office.toString());
        
        System.out.println("\n");
        
        System.out.print("proIndex:");
        int proIndex = Integer.parseInt(sc.nextLine());
        System.out.print("cityIndex:");
        int cityIndex = Integer.parseInt(sc.nextLine());
        
        System.out.print("offId:");
        int offId = Integer.parseInt(sc.nextLine());
        System.out.print("offMainSt:");
        String offMainSt = sc.nextLine();
        System.out.print("offNumber:");
        int offNumber = Integer.parseInt(sc.nextLine()); 
        System.out.print("offCodPostal:");
        String offCodPostal = sc.nextLine();
        
       // office.createOffice(proIndex, cityIndex, offId, offMainSt, null, offNumber, offCodPostal);
        
        System.out.println("\n\n");
        System.out.println(office.toString());
    }
    
}
