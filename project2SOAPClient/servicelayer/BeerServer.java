
package servicelayer;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BeerServer", targetNamespace = "http://servicelayer/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BeerServer {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMethods", targetNamespace = "http://servicelayer/", className = "servicelayer.GetMethods")
    @ResponseWrapper(localName = "getMethodsResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetMethodsResponse")
    @Action(input = "http://servicelayer/BeerServer/getMethodsRequest", output = "http://servicelayer/BeerServer/getMethodsResponse")
    public List<Object> getMethods();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "addUser", targetNamespace = "http://servicelayer/", className = "servicelayer.AddUser")
    @ResponseWrapper(localName = "addUserResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.AddUserResponse")
    @Action(input = "http://servicelayer/BeerServer/addUserRequest", output = "http://servicelayer/BeerServer/addUserResponse")
    public boolean addUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        String arg3);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCheapest", targetNamespace = "http://servicelayer/", className = "servicelayer.GetCheapest")
    @ResponseWrapper(localName = "getCheapestResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetCheapestResponse")
    @Action(input = "http://servicelayer/BeerServer/getCheapestRequest", output = "http://servicelayer/BeerServer/getCheapestResponse")
    public String getCheapest(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCostliest", targetNamespace = "http://servicelayer/", className = "servicelayer.GetCostliest")
    @ResponseWrapper(localName = "getCostliestResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetCostliestResponse")
    @Action(input = "http://servicelayer/BeerServer/getCostliestRequest", output = "http://servicelayer/BeerServer/getCostliestResponse")
    public String getCostliest(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "setPrice", targetNamespace = "http://servicelayer/", className = "servicelayer.SetPrice")
    @ResponseWrapper(localName = "setPriceResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.SetPriceResponse")
    @Action(input = "http://servicelayer/BeerServer/setPriceRequest", output = "http://servicelayer/BeerServer/setPriceResponse")
    public boolean setPrice(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Double arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.Object>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBeers", targetNamespace = "http://servicelayer/", className = "servicelayer.GetBeers")
    @ResponseWrapper(localName = "getBeersResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetBeersResponse")
    @Action(input = "http://servicelayer/BeerServer/getBeersRequest", output = "http://servicelayer/BeerServer/getBeersResponse")
    public List<Object> getBeers(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPrice", targetNamespace = "http://servicelayer/", className = "servicelayer.GetPrice")
    @ResponseWrapper(localName = "getPriceResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetPriceResponse")
    @Action(input = "http://servicelayer/BeerServer/getPriceRequest", output = "http://servicelayer/BeerServer/getPriceResponse")
    public double getPrice(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "validateUser", targetNamespace = "http://servicelayer/", className = "servicelayer.ValidateUser")
    @ResponseWrapper(localName = "validateUserResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.ValidateUserResponse")
    @Action(input = "http://servicelayer/BeerServer/validateUserRequest", output = "http://servicelayer/BeerServer/validateUserResponse")
    public boolean validateUser(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getToken", targetNamespace = "http://servicelayer/", className = "servicelayer.GetToken")
    @ResponseWrapper(localName = "getTokenResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetTokenResponse")
    @Action(input = "http://servicelayer/BeerServer/getTokenRequest", output = "http://servicelayer/BeerServer/getTokenResponse")
    public String getToken(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUserAccessLevel", targetNamespace = "http://servicelayer/", className = "servicelayer.GetUserAccessLevel")
    @ResponseWrapper(localName = "getUserAccessLevelResponse", targetNamespace = "http://servicelayer/", className = "servicelayer.GetUserAccessLevelResponse")
    @Action(input = "http://servicelayer/BeerServer/getUserAccessLevelRequest", output = "http://servicelayer/BeerServer/getUserAccessLevelResponse")
    public String getUserAccessLevel(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
