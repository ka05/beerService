package datalayer;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import utils.*;

import businesslayer.*;

/**
 * Token class: 
 * generates a token with userID and expirationDate
 * if the users credenitals are correct
 *
 */

public class Token{
   
   private static SecureRandom random = new SecureRandom();
   private static String tokenID;
   private static String expDate;
   private static String userID;
   
   /**
    * Token Contstructor used to initialize token from username or password
    *
    * @param String username: user entered username coming from client
    * @param String password: user entered password coming from client
    */
   public Token(String username, String password){
      if((new BeerBusinessLayer()).validateUser(username, password)){
         setToken(username);
      }
   }
   
   /**
    * Token Constructor used to initialize token from database
    *
    * @param String _tokenID: TokenID from DB
    * @param String _userID: UserID from DB
    * @param String _expDate: ExpDate from DB
    */
   public Token(String _tokenID, String _userID, String _expDate){
      tokenID = _tokenID;
      userID = _userID;
      expDate = _expDate;
   }
   
   
   /**
    * Sets a token by calling:
    * setTokenID and setTokenExpDate and setUserID
    * 
    * @param String username: username from client
    */
   private static void setToken(String username){
      setTokenID();
      setTokenExpDate();
      setUserID(username);
      (new BeerBusinessLayer()).setToken(tokenID, userID, expDate.toString());
   }
   
   /**
    * Sets the token Expiration date from
    * getCurrentTimeStampAddSeconds() in Utils Class
    * 
    */
   public static void setTokenExpDate(){
      expDate = (new Utils()).getCurrentTimeStampAddSeconds(5);
   }

   /**
    * sets this Token's tokenID using a hashing algorithm
    */
   public static void setTokenID(){
      tokenID = new BigInteger(130, random).toString(32);
   }
   
   /**
    * gets this Token's tokenID
    * @return String tokenID: the tokenID
    */
   public String getTokenID(){
      return tokenID;
   }
   
   /**
    * sets this Token's userID
    * @param String username: the user entered username from the client
    */
   public static void setUserID(String username){
      userID = (new BeerBusinessLayer()).getUserID(username);
   }   
   
   /**
    * gets this Token's userID
    * @return String userID: the userID who owns this token
    */
   public String getUserID(){
      return userID;
   }
      
   /**
    * validates if the token has expired based on:
    * if it has been 5 seconds since the token has expired
    * @return boolean if validated or no
    */
   public boolean validateTokenExpired(){
      // compare dates and return result
      if((new Utils()).getTimeDiff(expDate) > 0){
         // it has been 5 seconds 
         // discard token and return false
         
         return false;
      }
      else{
         return true;
      }
   }
   
   /**
    * deletes the Token from the database
    */
   public void deleteToken(){
      (new BeerBusinessLayer()).deleteToken(tokenID);
   }

}