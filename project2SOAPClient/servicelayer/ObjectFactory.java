
package servicelayer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servicelayer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddUser_QNAME = new QName("http://servicelayer/", "addUser");
    private final static QName _GetPriceResponse_QNAME = new QName("http://servicelayer/", "getPriceResponse");
    private final static QName _GetCheapestResponse_QNAME = new QName("http://servicelayer/", "getCheapestResponse");
    private final static QName _SetPriceResponse_QNAME = new QName("http://servicelayer/", "setPriceResponse");
    private final static QName _GetCostliestResponse_QNAME = new QName("http://servicelayer/", "getCostliestResponse");
    private final static QName _SetPrice_QNAME = new QName("http://servicelayer/", "setPrice");
    private final static QName _GetCostliest_QNAME = new QName("http://servicelayer/", "getCostliest");
    private final static QName _GetPrice_QNAME = new QName("http://servicelayer/", "getPrice");
    private final static QName _ValidateUserResponse_QNAME = new QName("http://servicelayer/", "validateUserResponse");
    private final static QName _GetTokenResponse_QNAME = new QName("http://servicelayer/", "getTokenResponse");
    private final static QName _GetCheapest_QNAME = new QName("http://servicelayer/", "getCheapest");
    private final static QName _GetUserAccessLevelResponse_QNAME = new QName("http://servicelayer/", "getUserAccessLevelResponse");
    private final static QName _GetToken_QNAME = new QName("http://servicelayer/", "getToken");
    private final static QName _GetBeersResponse_QNAME = new QName("http://servicelayer/", "getBeersResponse");
    private final static QName _ValidateUser_QNAME = new QName("http://servicelayer/", "validateUser");
    private final static QName _AddUserResponse_QNAME = new QName("http://servicelayer/", "addUserResponse");
    private final static QName _GetMethodsResponse_QNAME = new QName("http://servicelayer/", "getMethodsResponse");
    private final static QName _GetMethods_QNAME = new QName("http://servicelayer/", "getMethods");
    private final static QName _GetBeers_QNAME = new QName("http://servicelayer/", "getBeers");
    private final static QName _GetUserAccessLevel_QNAME = new QName("http://servicelayer/", "getUserAccessLevel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servicelayer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCheapestResponse }
     * 
     */
    public GetCheapestResponse createGetCheapestResponse() {
        return new GetCheapestResponse();
    }

    /**
     * Create an instance of {@link SetPriceResponse }
     * 
     */
    public SetPriceResponse createSetPriceResponse() {
        return new SetPriceResponse();
    }

    /**
     * Create an instance of {@link GetCostliestResponse }
     * 
     */
    public GetCostliestResponse createGetCostliestResponse() {
        return new GetCostliestResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link GetPriceResponse }
     * 
     */
    public GetPriceResponse createGetPriceResponse() {
        return new GetPriceResponse();
    }

    /**
     * Create an instance of {@link ValidateUserResponse }
     * 
     */
    public ValidateUserResponse createValidateUserResponse() {
        return new ValidateUserResponse();
    }

    /**
     * Create an instance of {@link GetTokenResponse }
     * 
     */
    public GetTokenResponse createGetTokenResponse() {
        return new GetTokenResponse();
    }

    /**
     * Create an instance of {@link SetPrice }
     * 
     */
    public SetPrice createSetPrice() {
        return new SetPrice();
    }

    /**
     * Create an instance of {@link GetCostliest }
     * 
     */
    public GetCostliest createGetCostliest() {
        return new GetCostliest();
    }

    /**
     * Create an instance of {@link GetPrice }
     * 
     */
    public GetPrice createGetPrice() {
        return new GetPrice();
    }

    /**
     * Create an instance of {@link GetBeersResponse }
     * 
     */
    public GetBeersResponse createGetBeersResponse() {
        return new GetBeersResponse();
    }

    /**
     * Create an instance of {@link ValidateUser }
     * 
     */
    public ValidateUser createValidateUser() {
        return new ValidateUser();
    }

    /**
     * Create an instance of {@link GetCheapest }
     * 
     */
    public GetCheapest createGetCheapest() {
        return new GetCheapest();
    }

    /**
     * Create an instance of {@link GetUserAccessLevelResponse }
     * 
     */
    public GetUserAccessLevelResponse createGetUserAccessLevelResponse() {
        return new GetUserAccessLevelResponse();
    }

    /**
     * Create an instance of {@link GetToken }
     * 
     */
    public GetToken createGetToken() {
        return new GetToken();
    }

    /**
     * Create an instance of {@link GetUserAccessLevel }
     * 
     */
    public GetUserAccessLevel createGetUserAccessLevel() {
        return new GetUserAccessLevel();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link GetMethodsResponse }
     * 
     */
    public GetMethodsResponse createGetMethodsResponse() {
        return new GetMethodsResponse();
    }

    /**
     * Create an instance of {@link GetMethods }
     * 
     */
    public GetMethods createGetMethods() {
        return new GetMethods();
    }

    /**
     * Create an instance of {@link GetBeers }
     * 
     */
    public GetBeers createGetBeers() {
        return new GetBeers();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getPriceResponse")
    public JAXBElement<GetPriceResponse> createGetPriceResponse(GetPriceResponse value) {
        return new JAXBElement<GetPriceResponse>(_GetPriceResponse_QNAME, GetPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCheapestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getCheapestResponse")
    public JAXBElement<GetCheapestResponse> createGetCheapestResponse(GetCheapestResponse value) {
        return new JAXBElement<GetCheapestResponse>(_GetCheapestResponse_QNAME, GetCheapestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPriceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "setPriceResponse")
    public JAXBElement<SetPriceResponse> createSetPriceResponse(SetPriceResponse value) {
        return new JAXBElement<SetPriceResponse>(_SetPriceResponse_QNAME, SetPriceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCostliestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getCostliestResponse")
    public JAXBElement<GetCostliestResponse> createGetCostliestResponse(GetCostliestResponse value) {
        return new JAXBElement<GetCostliestResponse>(_GetCostliestResponse_QNAME, GetCostliestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "setPrice")
    public JAXBElement<SetPrice> createSetPrice(SetPrice value) {
        return new JAXBElement<SetPrice>(_SetPrice_QNAME, SetPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCostliest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getCostliest")
    public JAXBElement<GetCostliest> createGetCostliest(GetCostliest value) {
        return new JAXBElement<GetCostliest>(_GetCostliest_QNAME, GetCostliest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPrice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getPrice")
    public JAXBElement<GetPrice> createGetPrice(GetPrice value) {
        return new JAXBElement<GetPrice>(_GetPrice_QNAME, GetPrice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "validateUserResponse")
    public JAXBElement<ValidateUserResponse> createValidateUserResponse(ValidateUserResponse value) {
        return new JAXBElement<ValidateUserResponse>(_ValidateUserResponse_QNAME, ValidateUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTokenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getTokenResponse")
    public JAXBElement<GetTokenResponse> createGetTokenResponse(GetTokenResponse value) {
        return new JAXBElement<GetTokenResponse>(_GetTokenResponse_QNAME, GetTokenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCheapest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getCheapest")
    public JAXBElement<GetCheapest> createGetCheapest(GetCheapest value) {
        return new JAXBElement<GetCheapest>(_GetCheapest_QNAME, GetCheapest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserAccessLevelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getUserAccessLevelResponse")
    public JAXBElement<GetUserAccessLevelResponse> createGetUserAccessLevelResponse(GetUserAccessLevelResponse value) {
        return new JAXBElement<GetUserAccessLevelResponse>(_GetUserAccessLevelResponse_QNAME, GetUserAccessLevelResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetToken }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getToken")
    public JAXBElement<GetToken> createGetToken(GetToken value) {
        return new JAXBElement<GetToken>(_GetToken_QNAME, GetToken.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBeersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getBeersResponse")
    public JAXBElement<GetBeersResponse> createGetBeersResponse(GetBeersResponse value) {
        return new JAXBElement<GetBeersResponse>(_GetBeersResponse_QNAME, GetBeersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidateUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "validateUser")
    public JAXBElement<ValidateUser> createValidateUser(ValidateUser value) {
        return new JAXBElement<ValidateUser>(_ValidateUser_QNAME, ValidateUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMethodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getMethodsResponse")
    public JAXBElement<GetMethodsResponse> createGetMethodsResponse(GetMethodsResponse value) {
        return new JAXBElement<GetMethodsResponse>(_GetMethodsResponse_QNAME, GetMethodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMethods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getMethods")
    public JAXBElement<GetMethods> createGetMethods(GetMethods value) {
        return new JAXBElement<GetMethods>(_GetMethods_QNAME, GetMethods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBeers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getBeers")
    public JAXBElement<GetBeers> createGetBeers(GetBeers value) {
        return new JAXBElement<GetBeers>(_GetBeers_QNAME, GetBeers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserAccessLevel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicelayer/", name = "getUserAccessLevel")
    public JAXBElement<GetUserAccessLevel> createGetUserAccessLevel(GetUserAccessLevel value) {
        return new JAXBElement<GetUserAccessLevel>(_GetUserAccessLevel_QNAME, GetUserAccessLevel.class, null, value);
    }

}
