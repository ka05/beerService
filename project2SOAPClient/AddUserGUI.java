import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import servicelayer.*;


/**
 * class AddUserGUI:
 *
 * handles adding a new user to the database
 */

public class AddUserGUI extends JFrame{

   private static JPanel formPanel, msgPanel;
   private static JButton btnAddUser;
   private static JPasswordField txtPassword, txtConfirmPassword;
   private static JTextField txtUserName, txtUserAge;
   private static JLabel lblMessage, lblReturnMessage, lblUserName, lblPassword, lblConfirmPassword, lblUserAge;
   
   private static String clientUsername, clientPassword;
   // beer service
   private static BeerService service;
      
   // get service port
   private static BeerServer port;
   
   /**
    * AddUserGUI constructor
    * @return
    */
   public AddUserGUI(String username, String password){
      clientUsername = username;
      clientPassword = password;
      getService();
      setTitle("Add User");
      setSize(400,300);
      setLocation(100,200);
      
      initGUI();
      
      setLayout(new GridLayout(2,1));
      add(msgPanel);
      add(formPanel);
      
      
   }

   /**
    * initializes service
    */
   public void getService(){
      service = new BeerService();
      port = service.getBeerServerPort();
   }  

   /**
    * initializes GUI for application
    */
   public void initGUI(){
      
      formPanel = new JPanel();
      formPanel.setLayout(new GridLayout(5,2));
      
      msgPanel = new JPanel();
      msgPanel.setLayout(new GridLayout(2,1));
      
      txtUserName = new JTextField();
      txtUserAge = new JTextField();
      // txtPassword = new JTextField();
      txtPassword = new JPasswordField(10);
      // txtConfirmPassword = new JTextField();
      txtConfirmPassword = new JPasswordField(10);
      
      lblUserName = new JLabel("Username: ");
      lblUserAge = new JLabel("Age: ");
      lblPassword = new JLabel("Password: ");
      lblConfirmPassword = new JLabel("Confirm Password: ");
      lblMessage = new JLabel("Please Fill out the following");
      lblReturnMessage = new JLabel("");

      
      JButton btnAddUser = new JButton("Add User");
      btnAddUser.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           if(validateFields()){               
               if(executeAddUser()){
                  successMsg("You Have been added to the DB");
               }else{
                  errorMsg("Something Went Wrong");
               }                
           }
         }
      });
      msgPanel.add(lblMessage);
      msgPanel.add(lblReturnMessage);
      
      formPanel.add(lblUserName);
      formPanel.add(txtUserName);
      formPanel.add(lblUserAge);
      formPanel.add(txtUserAge);
      formPanel.add(lblPassword);
      formPanel.add(txtPassword);
      formPanel.add(lblConfirmPassword);
      formPanel.add(txtConfirmPassword);
      formPanel.add(btnAddUser);
   }

   /**
    * validates user entered fields:
    *
    * if all field filled out and passwords match
    * 
    * @return boolean: if the user entered fields validated
    */
   public static boolean validateFields(){
      // If they are all filled in    
      if(!checkOneEmpty()){
         // check if password fields match
         if(txtPassword.getText().equals(txtConfirmPassword.getText())){
            if(isNumeric(txtUserAge.getText())){
               return true;
            }
            else{
               errorMsg("Please enter a number for age");
               return false;
            }
         }
         else{
            errorMsg("Passwords Don't Match");
            return false;
         }
      }
      else{
         errorMsg("Must Fill in all of the blank fields");
         return false;
      }
     
   }
   
   /**
    * determines if a String is numeric (is String is an int)
    * @param String str: string to check
    * @return boolean: if string is numeric
    */
   public static boolean isNumeric(String str){  
     try{  
       double d = Double.parseDouble(str);  
     }  
     catch(NumberFormatException nfe){  
       return false;  
     }  
     return true;  
   }
   
   /**
    * checks to see if one of the fields in the GUI are empty
    * @return boolean: if oneField is empty or not
    */
   public static boolean checkOneEmpty(){
      boolean oneEmpty = false;
      Component[] components = formPanel.getComponents();
      
      for(Component comp : components){
         
         if(comp instanceof JTextField){  
              //System.out.println(((JTextField)comp).getText());
              if(((JTextField)comp).getText().equals("")){
                  oneEmpty = true;
              }
         }
         
         if(comp instanceof JPasswordField){
            System.out.println(((JPasswordField)comp).getPassword());
              if(((JPasswordField)comp).getPassword().equals("")){
                  oneEmpty = true;
              }
         }
      }
      return oneEmpty;
   }
   
   /**
    * sets an error message on the GUI if error occurs
    * @param String msg: error message
    */
   public static void errorMsg(String msg){
      lblReturnMessage.setForeground(Color.RED);
      lblReturnMessage.setText(msg);
   }
   
   /**
    * sets an success message on the GUI if success occurs
    * @param String msg: error success
    */
   public static void successMsg(String msg){
   lblReturnMessage.setForeground(Color.GREEN);
      lblReturnMessage.setText(msg);
   }

   /**
    * adds the user to the DB
    * @return
    */
   public boolean executeAddUser(){
      return port.addUser(port.getToken(clientUsername, clientPassword), txtUserName.getText(), txtUserAge.getText(), txtPassword.getText());
   }

} // end class AddUserGUI