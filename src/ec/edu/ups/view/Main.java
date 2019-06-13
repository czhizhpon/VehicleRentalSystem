/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.view;

import ec.edu.ups.controller.OfficeController;
import ec.edu.ups.controller.VehicleRentalSystem;
import java.util.Scanner;



/**
 *
 * @author edd
 */
public class Main {
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\t ** Prueba de Proyecto");
        
        VehicleRentalSystem vrs = new VehicleRentalSystem();
        
        System.out.print("ProId:");
        int proId = Integer.parseInt(sc.nextLine());
        System.out.print("ProNombre:");
        String proName = sc.nextLine();
        vrs.createProvince(proId, proName);
        
        System.out.print("ProIndex:");
        int index = Integer.parseInt(sc.nextLine());
        System.out.print("cityId:");
        int cityId = Integer.parseInt(sc.nextLine());
        System.out.print("cityName:");
        String cityName = sc.nextLine();
        vrs.createCity(index, cityId, cityName);
        
        System.out.println(vrs.getVrsProvinces().toString());
        
        System.out.println("\n");
        
        OfficeController office = new OfficeController(vrs);
        System.out.print("proIndex:");
        int proIndex = Integer.parseInt(sc.nextLine());
        System.out.print("cityIndex:");
        int cityIndex = Integer.parseInt(sc.nextLine());
        
        System.out.print("offId:");
        
        //office.createOffice(proIndex, cityIndex, proId, proName, proName, cityIndex, proName)
        
        
    }
    
}
