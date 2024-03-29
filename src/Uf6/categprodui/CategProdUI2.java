package Uf6.categprodui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Uf6.categprodui.Menu;
import java.util.Scanner;
import java.sql.*;
import java.util.List;

/**
 *
 * @author mabardaji
 */
public class CategProdUI2 {

    private final Menu mainMenu;
    private Scanner uiReader;
    private StoreModel model;

    public CategProdUI2(StoreModel model) {
        //this.model = model;
        mainMenu = new Menu("Category and products Menú");
        uiReader = new Scanner(System.in);

    }

    public static void main(String[] args) {
        StoreModel model = new StoreModel();

        CategProdUI2 app = new CategProdUI2(model);

        app.run();
    }

    /**
     * application logic entry point
     */
    public void run() {
        boolean exit = false;  //set exit flag to false
        //control loop
        do {
            //display menu and read user's choice
            mainMenu.show();
            int option = mainMenu.getSelectedOption();

            //process user's choice: one control method for each functionality
            switch (option) {
                case 0:  //exit application
                    exit = doExit();
                    break;
                case 1:  //list all categories
                    doListAllCategories();
                    break;
                case 2:  //list category given its code
                    doListCategoryByCode();
                    break;
                case 3:  //add a new category
                    doAddCategory();
                    break;
                case 4:  //list all products
                    doListAllProducts();
                    break;
                case 5:  //add a new product
                    doAddProduct();
                    break;
                case 6:  //list products given their category
                    doListProductsByCategory();
                    break;
                default:  //default option
                    doDefault();
                    break;
            }
        } while (!exit);
    }

    private boolean doExit() {

        System.out.println("Sure to Exit(Yes/No)");
        String confirm = uiReader.nextLine();
        if (confirm.equalsIgnoreCase("YES")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * process default action
     */
    public void doDefault() {
        //System.out.println("Unknown option!");
        System.out.println("Not implemented yet!");
    }

    /**
     * reads from user data for a category
     *
     * @return category object or null in case of error
     */
    /*  BORRAR   
    public Category doInputCategory() {
        Category c;
        try {
//            String sid = doInput("id: ");
//            long id = Long.parseLong(sid);
            long id = 0;  //id is autoincrement
            String code = doInput("code: ");
            String name = doInput("name: ");
            c = new Category(id, code, name);            
        } catch (NumberFormatException ex) {
            c = null;
        }
        return c;
    }
   
    /**
     * reads from user data for a category
     * @return category object or null in case of error
     */
 /*  BORRAR 
    public Product doInputProduct() {
        Product p;
        try {
            //get a number formatter for our locale
//            String sid = doInput("id: ");
//            long id = Long.parseLong(sid);
            long id = 0;  //id is autoincrement
            String code = doInput("code: ");
            String name = doInput("name: ");
            String sstock = doInput("stock: " );
            int stock = Integer.parseInt(sstock);
            String sprice = doInput("price: " );
            double price = Double.parseDouble(sprice);
            String scatId = doInput("category id: " );
            long catId = Long.parseLong(scatId);
            Category cat = new Category(catId); 
            p = new Product(id, code, name, stock, price, cat);            
        } catch (NumberFormatException ex) {
            p = null;
        }
        return p;
    }  
BORRAR */
    /**
     * displays a message and gets ans answer from user
     *
     * @param message the message to display
     * @return user's answer
     */
    public String doInput(String message) {
        System.out.print(message);
        return uiReader.nextLine();
    }

    private void doListAllCategories() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void doListCategoryByCode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void doAddCategory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * get all products and display them
     */
    private void doListAllProducts() {
        try {
            List<Products> items = model.findAllProducts();
            for (Products show_product : items) {
                System.out.println(show_product);
            }   
        } catch (SQLException ex) {
            System.out.println("doListAllProducts - Error SQL" + ex.getMessage());
        }
        
        
    }

    private void doAddProduct() {
        Products prod = doInputProduct();
        if (prod!=null)
        {
            int result;
            try {
                result = model.addProduct(prod);
                if (result==1)
                {
                    System.out.println("product added...");
                }
                else
                {
                    System.out.println("Product not added");
                } 
            } catch (SQLException ex) {
                System.out.println("Error sql" + ex.getMessage());
            }
        }
        
       
    }

    private void doListProductsByCategory() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
     /**
     * reads from user data for a category
     * @return category object or null in case of error
     */
    public Products doInputProduct() {
        Products p;
        try {
            //get a number formatter for our locale
//            String sid = doInput("id: ");
//            long id = Long.parseLong(sid);
            int id = 0;  //id is autoincrement
            String code = doInput("code: ");
            String name = doInput("name: ");
            String sstock = doInput("stock: " );
            int stock = Integer.parseInt(sstock);
            String sprice = doInput("price: " );
            double price = Double.parseDouble(sprice);
            String scatId = doInput("category id: " );
            int catId = Integer.parseInt(scatId);
            Categories add = new Categories(catId);
            p = new Products(id, code, name, stock, price, add);            
        } catch (NumberFormatException ex) {
            p = null;
        }
        return p;
    }    

    private void doModifyCategory() {
        String code = doInput("Put the code of category to change: ");
        String name = doInput("Put the new name of the category: ");
        int rows_affected;
        rows_affected = model.updateCategoryByName(code, name);
        if (rows_affected>0)
        {
            System.out.println("categorys changed ... " + rows_affected);
        }
        else if (rows_affected==0)
        {
            System.out.println("Category doesn't change code input: " +  code);
        }
        else if (rows_affected==-2)
        {
            System.out.println("name input doesn't valid name-->" + name);
        }
        else if (rows_affected==-3)
        {
            //sout
        }
        
    }
}
