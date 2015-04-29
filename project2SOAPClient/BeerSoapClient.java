import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import servicelayer.*;


/**
 * class BeerSoapClient: 
 * Client GUI for testing BeerService : (SOAP Service)
 */
public class BeerSoapClient extends JFrame{

   private static JPanel bottomContainerPanel, resultsPanel, buttonPanel, getPricePanel, setPricePanel, lblPriceEditPanel;
   private static JLabel resultLabel;
   private static JComboBox comboGetPrice, comboSetPrice;
   private static JTextField txtNewPrice;
   private static JButton btnGetBeers, btnSetBeerPrice, btnGetMethods, btnGetCheapest, btnGetCostliest, btnGetBeerPrice, btnShowAddUser;
   private static String username, password;
   private static BeerService service;
      
   // get service port
   private static BeerServer port;

   /**
    * main method: instantiates jframe and shows it
    * @param: oh come on, we all know what goes here
    */
   public static void main(String[] args){
      JFrame f = new BeerSoapClient();
      f.show();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   }
   
   /**
    * BeerSoapClient Constructor
    * 
    */
   public BeerSoapClient(){
      getService();
   
      setTitle("Beer Soap Client");
      setSize(650,400);
      setLocation(200,200);
      
      showLoginDialog(false);
   }
   
   /**
    * initializes service
    */
   public void getService(){
      service = new BeerService();
      port = service.getBeerServerPort();
   }  
   
   
   /**
    * show the login dialog:
    *
    * handles false attempts and exiting application
    * @param boolean  hasErrors : if form has errors during recursive call
    */
   public void showLoginDialog(boolean hasErrors){
      int option = -55;
      JTextField txtUsername = new JTextField();
      JTextField txtPassword = new JTextField();
      JLabel lblError = new JLabel("Username or password incorrect");
      lblError.setForeground(Color.RED);
      boolean loggedIn = false;
      
      Object[] fields;
      
      // doesnt have errors
      if(!hasErrors){
         fields = new Object[]{
            "Username", txtUsername,
            "Password", txtPassword,
         };
      }else{
          fields = new Object[]{
            "Error", lblError,
            "Username", txtUsername,
            "Password", txtPassword,
         };
      }
      
      option = JOptionPane.showConfirmDialog(null, fields, "Please Login", JOptionPane.OK_CANCEL_OPTION);
      if (option == JOptionPane.OK_OPTION){
          username = txtUsername.getText();
          password = txtPassword.getText();
          if( username!=null || password != null){
            try{
                if(port.validateUser(username, password)){
                  initGUI();
               
                  add(resultsPanel, BorderLayout.NORTH);
                  add(bottomContainerPanel, BorderLayout.SOUTH);
                } else{
                  showLoginDialog(true);
                }
            }
            catch(Exception e){
               showLoginDialog(true);
               e.printStackTrace();
            }
          }else{  
            showLoginDialog(false);
          }
      }
      else{if(option == JOptionPane.CANCEL_OPTION){
         int optionExit = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave?", "Confirm exit", JOptionPane.OK_CANCEL_OPTION);
         if (optionExit == JOptionPane.OK_OPTION){
            System.exit(0);
         }
         if( optionExit == JOptionPane.CANCEL_OPTION){
            showLoginDialog(false);
         }
      
      }}
   }
   
   /**
    * shorthand System.out.println()
    * 
    */
   public static void p(String s){
      System.out.println(s);
   }
   
   /**
    * initializes GUI for application
    */
   public static void initGUI(){
   
      // initialize buttons and textboxes
      bottomContainerPanel = new JPanel();
      bottomContainerPanel.setLayout(new GridLayout(4, 1));
      
      // label section
      resultsPanel = new JPanel();
      resultLabel = new JLabel();
      resultsPanel.add(resultLabel);
   
      // button section
      buttonPanel = new JPanel();
      
      // GetBeers
      btnGetBeers = new JButton("Get Beers");
      btnGetBeers.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            ArrayList<Object> beers = (ArrayList<Object>)port.getBeers(port.getToken(username, password));
            
            String beerText = "<html>Avaliable Beers are: <br> <br>";
            
            for(Object beer : beers){
               beerText += beer.toString() + "<br>";
            }
              
            beerText += "</html>";
            resultLabel.setText(beerText);
         }
      });
      
      // GetMethods      
      btnGetMethods = new JButton("Get Methods");
      btnGetMethods.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           ArrayList<Object> methods = (ArrayList<Object>)port.getMethods();
           String methodsText = "<html>Avaliable Methods are: <br> <br>";
           
           for(Object method : methods){
               methodsText += method.toString() + "<br>";
           }
           
           methodsText += "</html>";
           resultLabel.setText(methodsText);
         }
      });
      
      
      // GetCheapest
      btnGetCheapest = new JButton("Get Cheapest");
      btnGetCheapest.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           resultLabel.setText(port.getCheapest(port.getToken(username, password)));
         }
      });
      
      // GetCostliest
      btnGetCostliest = new JButton("Get Costliest");
      btnGetCostliest.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           resultLabel.setText(port.getCostliest(port.getToken(username, password)));
         }
      });
      
      // Show Add User
      btnShowAddUser = new JButton("Add User");
      btnShowAddUser.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           AddUserGUI addUser = new AddUserGUI(username, password);
           addUser.show();
           addUser.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         }
      });
     
      buttonPanel.add(btnGetBeers);
      buttonPanel.add(btnGetMethods);
      buttonPanel.add(btnGetCheapest);
      buttonPanel.add(btnGetCostliest);
      buttonPanel.add(btnShowAddUser);
   
      // Get Beer Price section   
      getPricePanel = new JPanel();
      setPricePanel = new JPanel();
      lblPriceEditPanel = new JPanel();
      
      ArrayList<Object> beers = (ArrayList<Object>)port.getBeers(port.getToken(username, password));
      String[] avaliableBeers = getConvertedBeers(beers);
      comboGetPrice = new JComboBox(avaliableBeers); // init combo with data
      comboSetPrice = new JComboBox(avaliableBeers); // init combo with data
      
      // get Beer Price Button
      btnGetBeerPrice = new JButton("Get Beer Price");
      btnGetBeerPrice.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
           String selectedBeer = (String)comboGetPrice.getSelectedItem();
           resultLabel.setText("Price of " + selectedBeer + " is: " + port.getPrice(selectedBeer, port.getToken(username, password)));
         }
      });
      
      JLabel lblChangeBeerPrice = new JLabel("Change price of existing beer");
      JLabel lblSelectBeerName = new JLabel("Choose Beer:");
      txtNewPrice = new JTextField(20);
      
      
      // set Beer Price Button
      btnSetBeerPrice = new JButton("Set Beer Price");
      btnSetBeerPrice.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            String selectedBeer = (String)comboSetPrice.getSelectedItem();
            boolean worked = port.setPrice(selectedBeer, Double.parseDouble(txtNewPrice.getText()), port.getToken(username, password));
            if(worked){
               resultLabel.setText("Price of " + selectedBeer + " is: " + port.getPrice(selectedBeer, port.getToken(username, password)));
            }
         }
      });

      
      getPricePanel.add(comboGetPrice);
      getPricePanel.add(btnGetBeerPrice);
      
      lblPriceEditPanel.add(lblChangeBeerPrice);
      
      setPricePanel.add(lblSelectBeerName);
      setPricePanel.add(comboSetPrice);
      setPricePanel.add(txtNewPrice);
      setPricePanel.add(btnSetBeerPrice);
      
      bottomContainerPanel.add(buttonPanel);
      bottomContainerPanel.add(getPricePanel);
      bottomContainerPanel.add(lblPriceEditPanel);
      bottomContainerPanel.add(setPricePanel);
   }
   
   /**
    * converts Vector to String[]
    * @param Vector vector: vector of beers
    * @return String[]: string array of beers
    */
   private static String[] convertVectorToStringArray(Vector vector){
      String[] avalBeers = new String[vector.size()];
      ArrayList<String> temp = new ArrayList<String>(); // initialize String array
      for(Object beer : vector){
         temp.add(beer.toString());
      }
      
      return temp.toArray(avalBeers); // return converted string[]
   }
   
   /**
    * converts ArrayList<Object> to String[]
    * @param Vector vector: vector of beers
    * @return String[]: string array of beers
    */
   private static String[] getConvertedBeers(ArrayList<Object> arrList){
      String[] avalBeers = new String[arrList.size()];
      
      return arrList.toArray(avalBeers); // return converted string[]
   }
   
   

}