/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import ec.edu.ups.controller.OfficeController;
import java.util.Scanner;



/**
 *
 * @author edd
 */
public class Main {
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\t ** Prueba de Proyecto");
        
//        VehicleRentalSystem vrs = new VehicleRentalSystem();
        
        OfficeController office = new OfficeController();
        System.out.print("ProId:");
        int proId = Integer.parseInt(sc.nextLine());
        System.out.print("ProNombre:");
        String proName = sc.nextLine();
        office.createProvince(proId, proName);
        
        System.out.print("ProIndex:");
        int index = Integer.parseInt(sc.nextLine());
        System.out.print("cityId:");
        int cityId = Integer.parseInt(sc.nextLine());
        System.out.print("cityName:");
        String cityName = sc.nextLine();
        office.createCity(index, cityId, cityName);
        
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
        
        office.createOffice(proIndex, cityIndex, offId, offMainSt, null, offNumber, offCodPostal);
        
        System.out.println("\n\n");
        System.out.println(office.toString());
        
    }
    
}
