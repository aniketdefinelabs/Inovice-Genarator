package com.define_labs.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Task1 vat = new Task1("VAT", 10);
        Task1 sgst = new Task1("SGST", 9);
        Task1 cgst = new Task1("CGST", 9);

        // Create tax groups
       
        Task2 vatGroup = new Task2("VAT");
        vatGroup.addTax(vat);
        Task2 gstGroup = new Task2("GST");
        gstGroup.addTax(sgst);
        gstGroup.addTax(cgst);

        // Create products
        Task3 petrol = new Task3("Petrol", 65, vatGroup);
        Task3 soap = new Task3("Soap", 10, gstGroup);
        Task3 oil = new Task3("Oil", 15, gstGroup);
        Task3 cookies = new Task3("Cookies", 18, gstGroup);
        Task3 faceWash = new Task3("FaceWash", 12, vatGroup);
        Task3 rice = new Task3("Rice", 12, gstGroup);

        // Create invoice
        Task4 invoice = new Task4();
        invoice.addProduct(petrol);
        invoice.addProduct(soap);
        invoice.addProduct(oil);
        invoice.addProduct(cookies);
        invoice.addProduct(faceWash);
        invoice.addProduct(rice);

       
        List<Task3> foundProducts = new ArrayList<>();

        while (true) {
            System.out.print("Enter the product name to search (or type 'exit' to quit): ");
            String productName = sc.nextLine();

            
            if (productName.equalsIgnoreCase("exit")) {
                break;
            }

          
            Task3 foundProduct = invoice.findProductByName(productName);
            if (foundProduct != null) {
                
                foundProducts.add(foundProduct);
                System.out.println("Product found: " + foundProduct.getName());

               
                System.out.println("\nInvoices for found products:");
                double totalPrice = 0;
                double totalTax = 0;

                System.out.println("-----------------------------");
                System.out.println("Product\tPrice\tTax");
                for (Task3 product : foundProducts) {
                    double tax = product.calculateTax();
                    System.out.println(product.getName() + "\t" + product.getPrice() + "\t" + tax);
                    totalPrice += product.getPrice();
                    totalTax += tax;
                }
                System.out.println("Total\t" + totalPrice + "\t" + totalTax);
                System.out.println("Grand Total: " + (totalPrice + totalTax));
                System.out.println("-----------------------------\n");
            } else {
                System.out.println("Product not found.\n");
            }
        }

        System.out.println("Thank you for using the program!");
        sc.close();
    }
}