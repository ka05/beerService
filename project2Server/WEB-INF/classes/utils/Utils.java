package utils;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.lang.Iterable;
import java.text.SimpleDateFormat;
import java.lang.Exception;
import java.text.ParseException;

// logger stuff
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

import datalayer.*;

/**
 * class Utils:
 *
 * utility functions used in projec2
 */

public class Utils{

	/**
	 * Hashing algorithm used to hash password when:
	 * being inserted into the database 
	 * being checked when user enters through client
	 * @param String password: a password to be hashed
	 * @return String generatedPassword: the hashed password
	 */
   public String md5Me(String password){
      String generatedPassword = null;
      
      try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5"); // BCrypt - is safer
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
      
      return generatedPassword;
   }
   
   /**
    * parses a Token object out of 
    * an ArrayList<HashMap<String,String>>
    * 
    * @param ArrayList<HashMap<String,String>> result: 
    * 	The result coming from the database
    * @return Token token: the token parsed out of the input
    */
   public Token parseToken(ArrayList<HashMap<String,String>> result){
      String tokenID = "", 
             userID = "", 
             expDate = "";
      for(HashMap map : result){
        
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();      
            if(entry.getKey().equals("tokenId")){
               tokenID = entry.getValue();
            }
            if(entry.getKey().equals("userId")){
               userID = entry.getValue();
            }    
            if(entry.getKey().equals("expDate")){
               expDate = entry.getValue();
            }                                       
        }
      }
      Token token = new Token(tokenID, userID, expDate);
      return token;
   }
   
   /**
    * gets the current time in the following format
    * "yyyy-MM-dd HH:mm:ss"
    * 
    * @return String strDate: current Date
    */
   public String getCurrentTimeStamp() {
       SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
       // Date now = new Date();
       Calendar now = Calendar.getInstance();
       String strDate = sdfDate.format(now.getTime());
       return strDate;
   }
   
   /**
    * gets the current date and adding 5 seconds
    * @param int seconds: number of seconds to add to the current time
    * @return String strDate: the new date = currentTime + 5seconds
    */
   public String getCurrentTimeStampAddSeconds(int seconds) {
       SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
       // Date now = new Date();
       Calendar now = Calendar.getInstance();
       now.add(Calendar.SECOND, seconds);
       String strDate = sdfDate.format(now.getTime());
       return strDate;
   }
   
   /**
    * gets the current hour
    * @return long currHour: current hour
    */
   public long getCurrentTimeStampInHours(){
      String currTime = getCurrentTimeStamp();
      SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date currDate = null;
      try {
         currDate = sdfDate.parse(currTime);
      } catch (ParseException e) {
         e.printStackTrace();
      }
      
      long currHour = currDate.getHours();
      //System.out.println("getCurrentTimeStampInHours: " +currHour);
      return currHour;
   }
   
   /**
    * gets the difference in time in Seconds between the current time 
    * and the passed in time [in this case: expiration Date]
    * 
    * @param String targetDate: expDate [passed in from Token class]
    * @return long diffSeconds: difference in time in seconds
    */
   public long getTimeDiff(String targetDate){
      SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      
      Date newTargetDate = null;
      Date currentDate = null;
      
      try {
         newTargetDate = sdfDate.parse(targetDate); // parse targetDate
         currentDate = sdfDate.parse(getCurrentTimeStamp()); // parse currentDate
      } catch (ParseException e) {
           e.printStackTrace();
      }
      
      long diff = currentDate.getTime() - newTargetDate.getTime();
      long diffSeconds = diff / 1000 % 60;
      
      //System.out.println("Time in seconds: " + diffSeconds + " seconds.");
      return diffSeconds;
   }
   
   public void logInformation(String message, Exception ex){
      try {
         LogManager lm = LogManager.getLogManager();
         Logger logger;
         FileHandler fh = new FileHandler("log_test.txt");
   
         logger = Logger.getLogger("LoggingExample1");
   
         lm.addLogger(logger);
         logger.setLevel(Level.INFO);
         fh.setFormatter(new XMLFormatter());
   
         logger.addHandler(fh);
         // root logger defaults to SimpleFormatter. We don't want messages
         // logged twice.
         //logger.setUseParentHandlers(false);
         logger.log(Level.INFO, ex.toString());
         fh.close();
       } catch (Exception e) {
         System.out.println("Exception thrown: " + e);
         e.printStackTrace();
       }
   }
   
}