package datalayer;

import java.sql.*;
import java.util.*;

import utils.*;

/**
 * class BeerDataLayer:
 *
 * data layer of BeerService,
 * handles database calls
 */

public class BeerDataLayer{

   String dbName = "beerprices";
   String user = "root";
   String pswd = "student";
   DatabaseAccess db;

   /**
    * grabs all beers from database
    * @return ArrayList<ArrayList<String>> res: response from db.getData() call to database
    */
   public ArrayList<ArrayList<String>> getBeers(){
      ArrayList<ArrayList<String>> res = null;
      try{
                     
         //create an object of the utility class that you will use to do your queries
         db = new DatabaseAccess(dbName,user,pswd);   
         
         String sql = "SELECT beername from beers";
         res = db.getData(sql);
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      }
      
      if(res == null){
         System.out.println("Couldnt get data!");
      }
      
      return res;
   }
   
   public boolean addUser(String username, String age, String password){
      boolean success = false;
      try{           
         
         String sql = "INSERT into users (username, age, password) VALUES ('" + username + "', '" + age + "', '" + (new Utils()).md5Me(password) + "')";
         success = (new DatabaseAccess(dbName,user,pswd)).setData(sql);
      }
      catch(SQLException e){
         e.printStackTrace();
         success = false;
      }
      catch(ClassNotFoundException e){
         e.printStackTrace();
         success = false;
      }   
      return success;
   }
   
   
   /**
    * inserts a token into the token table of the database
    * @param String tokenID: id of token
    * @param String userID: userId associated with token
    * @param String expDate: expiration date of token
    * @return boolean: whether or not the query executed properly
    */
   public boolean insertToken(String tokenID, String userID, String expDate){
      String sql = "INSERT INTO tokens (tokenId, userId, expDate) VALUES ( ?, ?, ?)";
      ArrayList<String> params = new ArrayList<String>(); //wipe out previous params
      params.add(tokenID);
      params.add(userID);
      params.add(expDate);
      
      return paramQuery(sql, params);   
   }
   
   /**
    * validates if the username and password entered are valid
    * @param String username: username from BusinessLayer -> ServiceLayer -> Client -> User
    * @param String password: password from BusinessLayer -> ServiceLayer -> Client -> User
    * @return boolean: username and password were valid
    */
   public boolean checkUserPassword(String username, String password){
      String sql = "SELECT count(*) from users WHERE username = ? AND password = ?"; 
      ArrayList<String> params = new ArrayList<String>();
      params.add(username);
      params.add((new Utils()).md5Me(password)); // add hashed password
      boolean valid = paramQueryReturnNumRows(sql, params);

      return valid;
   }
   
   /**
    * validates whether the user is 21 or older
    * @param String username: username from BusinessLayer -> ServiceLayer -> Client -> User
    * @return boolean: if user is 21 or older or not
    */
   public boolean checkUserAge(String username){
      String sql = "SELECT age from users WHERE username like ?";
      boolean above21 = false; 
      ArrayList<String> params = new ArrayList<String>();
      params.add(username);
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      
      for(ArrayList resList : res){
         for(Object val : resList){
            if(Integer.parseInt(val.toString()) >= 21){
               above21 = true;
            }else{
               above21 = false;
            }
         }
      }
      return above21;
   }
   
   /**
    * grabs the userID given the username
    * @param String username: username from BusinessLayer -> ServiceLayer -> Client -> User
    * @return String userID: id of user in table in DB
    */
   public String getUserID(String username){
      String userID = "";
      String sql = "SELECT userid from users WHERE username = ?"; 
      ArrayList<String> params = new ArrayList<String>(); 
      params.add(username);
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      
      for(ArrayList resList : res){
         for(Object val : resList){
            userID = val.toString();
         }
      }
      return userID;
   }
  
   
   /**
    * grabs 
    * @return
    */
   public String getExistingToken(){
      return "token";
   }
   
   /**
    * grabs the price of a given beer
    * @param String beer: name of beer to get price of
    * @return double price: price of beer
    */
   public double getPrice(String beer){
      double price = 0.0;
      String sql = "SELECT beerprice from beers WHERE beername = ?"; 
      ArrayList<String> params = new ArrayList<String>(); 
      params.add(beer);
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      
      for(ArrayList resList : res){
         for(Object val : resList){
            price = Double.parseDouble(val.toString());
         }
      }
      return price;   
   }
   

   /**
    * grabs the price of a given beer
    * @param String beer: name of beer to get price of
    * @param Double price: new price of beer
    * @return boolean: whether the query executed or not
    */
   public boolean setPrice(String beer, Double price){
      String sql = "UPDATE beers SET beerprice = ? where beername = ?";
      ArrayList<String> params = new ArrayList<String>(); //wipe out previous params
      params.add(price.toString());
      params.add(beer);
      return paramQueryUpdate(sql, params);
   }
   
   /**
    * gets the cheapest Beer from DB
    * @return String beer: name of cheapest beer
    */
   public String getCheapest(){
      String cheapestBeer = "";
      String sql = "SELECT beername from beers where beerprice = (SELECT max(beerprice) from beers)"; 
      ArrayList<String> params = new ArrayList<String>();
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      
      for(ArrayList resList : res){
         for(Object val : resList){
            cheapestBeer = val.toString();
         }
      }
      return cheapestBeer;  
   }
   
   /**
    * gets the costliest beer from DB
    * @return String beer: name of costliest beer
    */
   public String getCostliest(){
      String cheapestBeer = "";
      String sql = "SELECT beername from beers where beerprice = (SELECT min(beerprice) from beers)"; 
      ArrayList<String> params = new ArrayList<String>();
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      
      for(ArrayList resList : res){
         for(Object val : resList){
            cheapestBeer = val.toString();
         }
      }
      return cheapestBeer;  
   }
   
   /**
    * deletes a given token from the DB
    * @param String tokenId: id of token to delete
    */
   public void deleteToken(String tokenId){
      String sql = "DELETE FROM tokens where tokenId = ?"; 
      ArrayList<String> params = new ArrayList<String>();
      params.add(tokenId);
      boolean deleted = paramQueryUpdate(sql, params);
      //System.out.println("deleted" + deleted);
   }
   
   /**
    * grabs a token given its tokenId
    * @param String tokenId: id of token to get
    * @return Token token: the token returned from the DB
    */
   public Token getToken(String tokenId){
      String sql = "SELECT * FROM tokens where tokenId like '" + tokenId + "'"; 
      ArrayList<HashMap<String,String>> res = paramQueryWithColNames(sql);
      
      return (new Utils()).parseToken(res);
   }
   
   /**
    * determines if the current users accessLevel is admin
    * @param String userID: id of user
    * @return boolean: if user is admin
    */
   public boolean validateUserAccessLevel(String userID){
      boolean isAdmin = false;
      String sql = "SELECT accesslevel FROM users where userid = ?";
      ArrayList<String> params = new ArrayList<String>();
      params.add(userID);
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      for(ArrayList resList : res){
         for(Object val : resList){
            if(val.toString().equals("admin")){
               isAdmin = true;
            }
         }
      }
      return isAdmin;
   }
   
   /**
    * gets the current users accessLevel
    * @param String userID: id of user
    * @return String accessLevel: users accessLevel
    */
   public String getUserAccessLevel(String userID){
      String accessLevel = "";
      String sql = "SELECT accesslevel FROM users where userid = ?";
      ArrayList<String> params = new ArrayList<String>();
      params.add(userID);
      
      ArrayList<ArrayList<String>> res = paramQueryReturn(sql, params);
      for(ArrayList resList : res){
         for(Object val : resList){
            if(val.toString().equals("admin")){
               accessLevel = val.toString();
            }
         }
      }
      return accessLevel;
   }
   
   /**
    * [paramQueryWithColNames description]
    * @param
    * @return
    */
   public ArrayList<HashMap<String,String>> paramQueryWithColNames(String sql){
      ArrayList<HashMap<String,String>> res = null;
      try{
                     
         //create an object of the utility class that you will use to do your queries
         res = (new DatabaseAccess(dbName,user,pswd)).getDataWithColNames(sql);
         
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      } 
      return res;
   }

   
   public boolean paramQuery(String sql, ArrayList<String> params){
      boolean bool = false;
      
      try{
                     
         //create an object of the utility class that you will use to do your queries
         bool = (new DatabaseAccess(dbName,user,pswd)).nonSelectResults(sql,params);
         
      }
      catch(SQLException e)
      {
         bool = false;
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         bool = false;
         e.printStackTrace();
      } 
      return bool;
   }
   
   public boolean paramQueryUpdate(String sql, ArrayList<String> params){
      boolean bool = false;
      
      try{
                     
         //create an object of the utility class that you will use to do your queries
         int updated = (new DatabaseAccess(dbName,user,pswd)).nonSelect(sql,params);
         if (updated > 0) {
            bool = true;
         }else{
            bool = false;
         }
         
      }
      catch(SQLException e)
      {
         bool = false;
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         bool = false;
         e.printStackTrace();
      } 
      return bool;
   }
   
   
   
   public ArrayList<ArrayList<String>> paramQueryReturn(String sql, ArrayList<String> params){
      ArrayList<ArrayList<String>> res = null;
      try{               
         //create an object of the utility class that you will use to do your queries    
         res = (new DatabaseAccess(dbName,user,pswd)).getDataPS(sql,params);
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      } 
      
      if(res == null){
         System.out.println("Response is null!");
      }
      return res;
   }

   public boolean paramQueryReturnNumRows(String sql, ArrayList<String> params){
      boolean exists = false;
      try{               
         //create an object of the utility class that you will use to do your queries    
         int numRows = (new DatabaseAccess(dbName,user,pswd)).getDataPQNumRows(sql,params);
         if (numRows > 0) {
            exists = true;
         }else{
            exists = false;
         }
      }
      catch(SQLException e)
      {
         e.printStackTrace();
      }
      catch(ClassNotFoundException e)
      {
         e.printStackTrace();
      } 
      
      return exists;
   }

}