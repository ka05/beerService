package servicelayer;
import java.util.*;
import javax.jws.*;
import datalayer.*;
import businesslayer.*;

/**
 * class BeerService:
 *
 * The main SOAP interface to handle service method calls
 */
@WebService( serviceName="BeerService" )
public class BeerServer{
   
   /**
    * gets a token from BeerBusinessLayer
    * @param String username: username
    * @param String password: users password
    *
    * @return String token: token used to access all functions on server except getMethods()
    */
    @WebMethod
   public String getToken(String username, String password){
      return (new BeerBusinessLayer()).getNewToken(username, password);
   }
   
   @WebMethod
   public boolean validateUser(String username, String password){
      return (new BeerBusinessLayer()).validateUser(username, password); 
   }
   
   @WebMethod
   public String getUserAccessLevel(String token){
      return (new BeerBusinessLayer()).getUserAccessLevel(token);
   }
      
   @WebMethod
   public boolean addUser(String token, String username, String age, String password){
      return (new BeerBusinessLayer()).addUser(token, username, age, password);
   }
   
   /**
    * grabs all of the methods existing on the server
    * @return: Vector methodName: servers method names
    * 
    * Note: dont need token access
    */
    @WebMethod
   public Vector getMethods(){
      Vector methodNames = new Vector();
      
      methodNames.add("public String getToken(String username,String Password)");
      methodNames.add("public Vector getMethods()");
      methodNames.add("public Double getPrice(String beer,String token)");
      methodNames.add("public Boolean setPrice(String beer, Double price, string token)");
      methodNames.add("public Vector getBeers(String token)");
      methodNames.add("public String getCheapest(String token)");
      methodNames.add("public String getCostliest(String token)");
      
      return methodNames;
   }
   
   /**
    * grabs the price of a given beer
    * @param String beer: beername
    * @param String token: token 
    * @return double price: price of selected beer
    */
    @WebMethod
   public double getPrice(String beer, String token){
      return (new BeerBusinessLayer()).getPrice(beer, token);
   }
   
   /**
    * sets the price of a given beer
    * @param String beer: beername
    * @param Double price: newPrice
    * @param String token: token
    * @return boolean success: if the price was updated or not
    */
    @WebMethod
   public boolean setPrice(String beer, Double price, String token){
      // return true if successfully changed in DB
      // false if failed
      return (new BeerBusinessLayer()).setPrice(beer, price, token);
   }
   
   /**
    * grabs all existing beers in database
    * @param String token: token
    * @return Vector beerList: list of all beers
    */
    @WebMethod
   public Vector getBeers(String token){
      return (new BeerBusinessLayer()).getBeers(token);
   }
   
   /**
    * gets the cheapest Beer
    * @param String token: token
    * @return String beer: name of cheapest beer
    */
    @WebMethod
   public String getCheapest(String token){
      return (new BeerBusinessLayer()).getCheapest(token);
   }
   
   /**
    * gets the costliest beer
    * @param String token: token
    * @return String beer: name of costliest beer
    */
    @WebMethod
   public String getCostliest(String token){
      return (new BeerBusinessLayer()).getCostliest(token);
   }
   
}