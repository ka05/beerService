package businesslayer;

import java.util.*;
import datalayer.*;
import utils.*;

/**
 * class BeerBusinessLayer:
 *
 * contains business logic for BeerService
 */

public class BeerBusinessLayer{
   
   // business hours
   private final int OPEN_TIME = 10; // 10:00 - 23:59 is open
   
   
   /* SERVICE METHODS */
  
   /**
    * grabs a Vector of beers after it
    * validates the token passed in and
    * ensures that the Service is "open" 
    * 
    * @param String token: token
    * @return Vector beers: vector of beers
    */
   public Vector getBeers(String token){
      Vector beers = new Vector();
      if(tokenValidates(token) && isOpen()){
         ArrayList<ArrayList<String>> beersResult = (new BeerDataLayer()).getBeers();
         
         for(ArrayList beerList : beersResult){
            beers.addAll(beerList);
         }
      }
      return beers;
   }
   
   /**
    * grabs the price of a given beer after it
    * validates the token passed in and
    * ensures that the Service is "open" 
    * 
    * @param
    * @param
    * @return
    */
   public double getPrice(String beer, String token){
      double price = 0.0;
      if(tokenValidates(token) && isOpen()){
         price = (new BeerDataLayer()).getPrice(beer);
      }
      
      if(price == 0.0){
         System.out.println("price is null");
      }
      return price;
   }
   
   /**
    * sets the price of a given beer after it
    * validates the token passed in and
    * ensures that the Service is "open" and
    * validates that the current user is an admin
    * 
    * @param String beer: name of beer to change price on
    * @param Double price: new price to set
    * @param String token: token
    * @return boolean: if price was set or not
    */
   public boolean setPrice(String beer, Double price, String token){
      if(validateUserAccessLevel(token) && isOpen()){
         if(tokenValidates(token)){
            return (new BeerDataLayer()).setPrice(beer, price);
         }else{
            return false;
         }
      }else{
         deleteToken(token);
         return false;
      }
      
   }
   
   /**
    * gets the cheapest beer avaliable after it
    * validates the token passed in and
    * ensures that the Service is "open" 
    * 
    * @param String token: token
    * @return String cheapest: cheapest beer's name
    */
   public String getCheapest(String token){
      String cheapest = "Error: token not valid, age < 21, username or password incorrect, or not open (Hours are : 10am - Midnight)";
      if(tokenValidates(token) && isOpen()){
         cheapest = (new BeerDataLayer()).getCheapest();
      }
      return cheapest;
   }
   
   /**
    * gets the costliest beer avaliable after it
    * validates the token passed in and
    * ensures that the Service is "open" 
    * 
    * @param String token: token
    * @return String costliest: costliest beer's name
    */
   public String getCostliest(String token){
      String costliest = "Error: token not valid, age < 21, username or password incorrect, or not open (Hours are : 10am - Midnight)";
      if(tokenValidates(token) && isOpen()){
         costliest = (new BeerDataLayer()).getCostliest();
      }
      return costliest;
   }
   
   /* TOKEN METHODS */
   

   /**
    * grabs a new Token and returns its tokenId
    * @param String username: username from serviceLayer
    * @param String password: password from serviceLayer
    * @return String tokenId: tokenId generated from Token class
    */
   public String getNewToken(String username, String password){
      String tokenId = "Error: Sorry, either your credintials were incorrect, you are under the age of 21 or the service is closed (Hours: 10am - Midnight)";
      if(isOpen()){
         Token token = new Token(username, password);
         tokenId = token.getTokenID();
      }
      return tokenId;
   }
   
   /**
    * inserts the token into the database
    * @param String tokenID: tokenId
    * @param String userID: userId
    * @param String expDate: expDate 
    */
   public void setToken(String tokenID, String userID, String expDate){
      (new BeerDataLayer()).insertToken(tokenID, userID, expDate);
   }
   
   
   /**
    * deletes a token from the database
    * @param String tokenId: id of token to del
    */
   public void deleteToken(String tokenId){
      (new BeerDataLayer()).deleteToken(tokenId);
   }
   
   /* USER DATA METHODS */
   
   /**
    * get the access level of the current user
    * @param String tokenId: id of token
    * @return boolean: whether the user is admin or not
    */
   public boolean validateUserAccessLevel(String tokenId){
      //get token 
      Token token = (new BeerDataLayer()).getToken(tokenId);
      // get userId from token
      String userID = token.getUserID();
      // get userAccesslevel using userID
      return (new BeerDataLayer()).validateUserAccessLevel(userID);
   }
   
   /**
    * get the access level of the current user
    * @param String tokenId: id of token
    * @return boolean: whether the user is admin or not
    */
   public String getUserAccessLevel(String tokenId){
      //get token 
      Token token = (new BeerDataLayer()).getToken(tokenId);
      // get userId from token
      String userID = token.getUserID();
      // get userAccesslevel using userID
      return (new BeerDataLayer()).getUserAccessLevel(userID);
   }
   
   public boolean addUser(String token, String username, String age, String password){
      if(validateUserAccessLevel(token) && isOpen()){
         if(tokenValidates(token)){
            return (new BeerDataLayer()).addUser(username, age, password);
         }else{
            return false;
         }
      }else{
         deleteToken(token);
         return false;
      }
   }
   
   /**
    * gets the users id in the DB
    * @param String username: username from client
    * @return String userID: user id
    */
   public String getUserID(String username){
      return (new BeerDataLayer()).getUserID(username);
   }
   
   
   /* VALIDATION METHODS */
   
   /**
    * checks to see if the token is valid:
    * if the token has not expired yet
    * 
    * @param String tokenId: tokenId from serviceLayer call
    * @return boolean: if the token is still valid
    */
   public boolean tokenValidates(String tokenId){
      Token token = (new BeerDataLayer()).getToken(tokenId);
      deleteToken(tokenId);
      if(token.validateTokenExpired()){
         return true;
      }
      else{
         return false;
      }
   }
   
   /**
    * validates if the user is of age (21 or older)
    * and if their username and password validates
    * 
    * @param String username: username from serviceLayer
    * @param String password: password from serviceLayer
    * @return boolean: if the user validates these checks
    */
   public boolean validateUser(String username, String password){
      // if user is 21 or above
      if((new BeerDataLayer()).checkUserAge(username)){
         // if user entered correct username and password   
         if((new BeerDataLayer()).checkUserPassword(username, password)){
            //System.out.println("BeerBusinessLayer - checkUserPassword - validated: " + password);
            return true;
         }else{
            return false;
         }
         
      }else{
         return false;
      }
   }
   
   /**
    * determines if service is open:
    * current hour is between 10am and midnight
    * @return boolean: if service is "open"
    */
   public boolean isOpen(){
      // grab current date
      long currHour = (new Utils()).getCurrentTimeStampInHours();
      // check against open time
   
      if( (int)currHour < OPEN_TIME ){
         return false;
      }else{     
         return true;
      }

   } // end isOpen
   
} // end BeerBusinessLayer class