
package net.taxcloud;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.taxcloud package. 
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

    private final static QName _AuthorizedRsp_QNAME = new QName("http://taxcloud.net", "AuthorizedRsp");
    private final static QName _GetTICsRsp_QNAME = new QName("http://taxcloud.net", "GetTICsRsp");
    private final static QName _GetTICGroupsRsp_QNAME = new QName("http://taxcloud.net", "GetTICGroupsRsp");
    private final static QName _VerifiedAddress_QNAME = new QName("http://taxcloud.net", "VerifiedAddress");
    private final static QName _GetCertificatesRsp_QNAME = new QName("http://taxcloud.net", "GetCertificatesRsp");
    private final static QName _DeleteCertificateRsp_QNAME = new QName("http://taxcloud.net", "DeleteCertificateRsp");
    private final static QName _CapturedRsp_QNAME = new QName("http://taxcloud.net", "CapturedRsp");
    private final static QName _PingRsp_QNAME = new QName("http://taxcloud.net", "PingRsp");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.taxcloud
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Transaction }
     * 
     */
    public Transaction createTransaction() {
        return new Transaction();
    }

    /**
     * Create an instance of {@link AddExemptCertificate }
     * 
     */
    public AddExemptCertificate createAddExemptCertificate() {
        return new AddExemptCertificate();
    }

    /**
     * Create an instance of {@link AddTransactionsRsp }
     * 
     */
    public AddTransactionsRsp createAddTransactionsRsp() {
        return new AddTransactionsRsp();
    }

    /**
     * Create an instance of {@link ArrayOfTransaction }
     * 
     */
    public ArrayOfTransaction createArrayOfTransaction() {
        return new ArrayOfTransaction();
    }

    /**
     * Create an instance of {@link ArrayOfTICGroup }
     * 
     */
    public ArrayOfTICGroup createArrayOfTICGroup() {
        return new ArrayOfTICGroup();
    }

    /**
     * Create an instance of {@link ArrayOfTransactionCartItem }
     * 
     */
    public ArrayOfTransactionCartItem createArrayOfTransactionCartItem() {
        return new ArrayOfTransactionCartItem();
    }

    /**
     * Create an instance of {@link ExemptState }
     * 
     */
    public ExemptState createExemptState() {
        return new ExemptState();
    }

    /**
     * Create an instance of {@link DeleteExemptCertificateResponse }
     * 
     */
    public DeleteExemptCertificateResponse createDeleteExemptCertificateResponse() {
        return new DeleteExemptCertificateResponse();
    }

    /**
     * Create an instance of {@link GetTICGroupsRsp }
     * 
     */
    public GetTICGroupsRsp createGetTICGroupsRsp() {
        return new GetTICGroupsRsp();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link AuthorizedRsp }
     * 
     */
    public AuthorizedRsp createAuthorizedRsp() {
        return new AuthorizedRsp();
    }

    /**
     * Create an instance of {@link LookupRsp }
     * 
     */
    public LookupRsp createLookupRsp() {
        return new LookupRsp();
    }

    /**
     * Create an instance of {@link Lookup }
     * 
     */
    public Lookup createLookup() {
        return new Lookup();
    }

    /**
     * Create an instance of {@link VerifyAddressResponse }
     * 
     */
    public VerifyAddressResponse createVerifyAddressResponse() {
        return new VerifyAddressResponse();
    }

    /**
     * Create an instance of {@link ReturnedRsp }
     * 
     */
    public ReturnedRsp createReturnedRsp() {
        return new ReturnedRsp();
    }

    /**
     * Create an instance of {@link AddTransactionsResponse }
     * 
     */
    public AddTransactionsResponse createAddTransactionsResponse() {
        return new AddTransactionsResponse();
    }

    /**
     * Create an instance of {@link GetTICGroupsResponse }
     * 
     */
    public GetTICGroupsResponse createGetTICGroupsResponse() {
        return new GetTICGroupsResponse();
    }

    /**
     * Create an instance of {@link Returned }
     * 
     */
    public Returned createReturned() {
        return new Returned();
    }

    /**
     * Create an instance of {@link GetExemptCertificates }
     * 
     */
    public GetExemptCertificates createGetExemptCertificates() {
        return new GetExemptCertificates();
    }

    /**
     * Create an instance of {@link PingRsp }
     * 
     */
    public PingRsp createPingRsp() {
        return new PingRsp();
    }

    /**
     * Create an instance of {@link ResponseMessage }
     * 
     */
    public ResponseMessage createResponseMessage() {
        return new ResponseMessage();
    }

    /**
     * Create an instance of {@link LookupForDate }
     * 
     */
    public LookupForDate createLookupForDate() {
        return new LookupForDate();
    }

    /**
     * Create an instance of {@link TaxID }
     * 
     */
    public TaxID createTaxID() {
        return new TaxID();
    }

    /**
     * Create an instance of {@link AuthorizedWithCapture }
     * 
     */
    public AuthorizedWithCapture createAuthorizedWithCapture() {
        return new AuthorizedWithCapture();
    }

    /**
     * Create an instance of {@link ArrayOfCartItem }
     * 
     */
    public ArrayOfCartItem createArrayOfCartItem() {
        return new ArrayOfCartItem();
    }

    /**
     * Create an instance of {@link CapturedRsp }
     * 
     */
    public CapturedRsp createCapturedRsp() {
        return new CapturedRsp();
    }

    /**
     * Create an instance of {@link Captured }
     * 
     */
    public Captured createCaptured() {
        return new Captured();
    }

    /**
     * Create an instance of {@link ArrayOfTIC }
     * 
     */
    public ArrayOfTIC createArrayOfTIC() {
        return new ArrayOfTIC();
    }

    /**
     * Create an instance of {@link Ping }
     * 
     */
    public Ping createPing() {
        return new Ping();
    }

    /**
     * Create an instance of {@link GetTICsByGroup }
     * 
     */
    public GetTICsByGroup createGetTICsByGroup() {
        return new GetTICsByGroup();
    }

    /**
     * Create an instance of {@link DeleteExemptCertificate }
     * 
     */
    public DeleteExemptCertificate createDeleteExemptCertificate() {
        return new DeleteExemptCertificate();
    }

    /**
     * Create an instance of {@link PingResponse }
     * 
     */
    public PingResponse createPingResponse() {
        return new PingResponse();
    }

    /**
     * Create an instance of {@link TransactionCartItem }
     * 
     */
    public TransactionCartItem createTransactionCartItem() {
        return new TransactionCartItem();
    }

    /**
     * Create an instance of {@link ArrayOfResponseMessage }
     * 
     */
    public ArrayOfResponseMessage createArrayOfResponseMessage() {
        return new ArrayOfResponseMessage();
    }

    /**
     * Create an instance of {@link DeleteCertificateRsp }
     * 
     */
    public DeleteCertificateRsp createDeleteCertificateRsp() {
        return new DeleteCertificateRsp();
    }

    /**
     * Create an instance of {@link GetCertificatesRsp }
     * 
     */
    public GetCertificatesRsp createGetCertificatesRsp() {
        return new GetCertificatesRsp();
    }

    /**
     * Create an instance of {@link LookupResponse }
     * 
     */
    public LookupResponse createLookupResponse() {
        return new LookupResponse();
    }

    /**
     * Create an instance of {@link ResponseBase }
     * 
     */
    public ResponseBase createResponseBase() {
        return new ResponseBase();
    }

    /**
     * Create an instance of {@link ExemptionCertificate }
     * 
     */
    public ExemptionCertificate createExemptionCertificate() {
        return new ExemptionCertificate();
    }

    /**
     * Create an instance of {@link AddCertificateRsp }
     * 
     */
    public AddCertificateRsp createAddCertificateRsp() {
        return new AddCertificateRsp();
    }

    /**
     * Create an instance of {@link ArrayOfExemptState }
     * 
     */
    public ArrayOfExemptState createArrayOfExemptState() {
        return new ArrayOfExemptState();
    }

    /**
     * Create an instance of {@link ArrayOfCartItemResponse }
     * 
     */
    public ArrayOfCartItemResponse createArrayOfCartItemResponse() {
        return new ArrayOfCartItemResponse();
    }

    /**
     * Create an instance of {@link ExemptionCertificateDetail }
     * 
     */
    public ExemptionCertificateDetail createExemptionCertificateDetail() {
        return new ExemptionCertificateDetail();
    }

    /**
     * Create an instance of {@link ReturnedResponse }
     * 
     */
    public ReturnedResponse createReturnedResponse() {
        return new ReturnedResponse();
    }

    /**
     * Create an instance of {@link GetTICs }
     * 
     */
    public GetTICs createGetTICs() {
        return new GetTICs();
    }

    /**
     * Create an instance of {@link GetTICsResponse }
     * 
     */
    public GetTICsResponse createGetTICsResponse() {
        return new GetTICsResponse();
    }

    /**
     * Create an instance of {@link GetTICsRsp }
     * 
     */
    public GetTICsRsp createGetTICsRsp() {
        return new GetTICsRsp();
    }

    /**
     * Create an instance of {@link TIC }
     * 
     */
    public TIC createTIC() {
        return new TIC();
    }

    /**
     * Create an instance of {@link CartItemResponse }
     * 
     */
    public CartItemResponse createCartItemResponse() {
        return new CartItemResponse();
    }

    /**
     * Create an instance of {@link AuthorizedWithCaptureResponse }
     * 
     */
    public AuthorizedWithCaptureResponse createAuthorizedWithCaptureResponse() {
        return new AuthorizedWithCaptureResponse();
    }

    /**
     * Create an instance of {@link AddExemptCertificateResponse }
     * 
     */
    public AddExemptCertificateResponse createAddExemptCertificateResponse() {
        return new AddExemptCertificateResponse();
    }

    /**
     * Create an instance of {@link AuthorizedResponse }
     * 
     */
    public AuthorizedResponse createAuthorizedResponse() {
        return new AuthorizedResponse();
    }

    /**
     * Create an instance of {@link LookupForDateResponse }
     * 
     */
    public LookupForDateResponse createLookupForDateResponse() {
        return new LookupForDateResponse();
    }

    /**
     * Create an instance of {@link VerifiedAddress }
     * 
     */
    public VerifiedAddress createVerifiedAddress() {
        return new VerifiedAddress();
    }

    /**
     * Create an instance of {@link VerifyAddress }
     * 
     */
    public VerifyAddress createVerifyAddress() {
        return new VerifyAddress();
    }

    /**
     * Create an instance of {@link GetTICGroups }
     * 
     */
    public GetTICGroups createGetTICGroups() {
        return new GetTICGroups();
    }

    /**
     * Create an instance of {@link Authorized }
     * 
     */
    public Authorized createAuthorized() {
        return new Authorized();
    }

    /**
     * Create an instance of {@link TICGroup }
     * 
     */
    public TICGroup createTICGroup() {
        return new TICGroup();
    }

    /**
     * Create an instance of {@link GetTICsByGroupResponse }
     * 
     */
    public GetTICsByGroupResponse createGetTICsByGroupResponse() {
        return new GetTICsByGroupResponse();
    }

    /**
     * Create an instance of {@link GetExemptCertificatesResponse }
     * 
     */
    public GetExemptCertificatesResponse createGetExemptCertificatesResponse() {
        return new GetExemptCertificatesResponse();
    }

    /**
     * Create an instance of {@link CapturedResponse }
     * 
     */
    public CapturedResponse createCapturedResponse() {
        return new CapturedResponse();
    }

    /**
     * Create an instance of {@link ArrayOfExemptionCertificate }
     * 
     */
    public ArrayOfExemptionCertificate createArrayOfExemptionCertificate() {
        return new ArrayOfExemptionCertificate();
    }

    /**
     * Create an instance of {@link AddTransactions }
     * 
     */
    public AddTransactions createAddTransactions() {
        return new AddTransactions();
    }

    /**
     * Create an instance of {@link CartItem }
     * 
     */
    public CartItem createCartItem() {
        return new CartItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthorizedRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "AuthorizedRsp")
    public JAXBElement<AuthorizedRsp> createAuthorizedRsp(AuthorizedRsp value) {
        return new JAXBElement<AuthorizedRsp>(_AuthorizedRsp_QNAME, AuthorizedRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTICsRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "GetTICsRsp")
    public JAXBElement<GetTICsRsp> createGetTICsRsp(GetTICsRsp value) {
        return new JAXBElement<GetTICsRsp>(_GetTICsRsp_QNAME, GetTICsRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTICGroupsRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "GetTICGroupsRsp")
    public JAXBElement<GetTICGroupsRsp> createGetTICGroupsRsp(GetTICGroupsRsp value) {
        return new JAXBElement<GetTICGroupsRsp>(_GetTICGroupsRsp_QNAME, GetTICGroupsRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifiedAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "VerifiedAddress")
    public JAXBElement<VerifiedAddress> createVerifiedAddress(VerifiedAddress value) {
        return new JAXBElement<VerifiedAddress>(_VerifiedAddress_QNAME, VerifiedAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCertificatesRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "GetCertificatesRsp")
    public JAXBElement<GetCertificatesRsp> createGetCertificatesRsp(GetCertificatesRsp value) {
        return new JAXBElement<GetCertificatesRsp>(_GetCertificatesRsp_QNAME, GetCertificatesRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteCertificateRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "DeleteCertificateRsp")
    public JAXBElement<DeleteCertificateRsp> createDeleteCertificateRsp(DeleteCertificateRsp value) {
        return new JAXBElement<DeleteCertificateRsp>(_DeleteCertificateRsp_QNAME, DeleteCertificateRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CapturedRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "CapturedRsp")
    public JAXBElement<CapturedRsp> createCapturedRsp(CapturedRsp value) {
        return new JAXBElement<CapturedRsp>(_CapturedRsp_QNAME, CapturedRsp.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PingRsp }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://taxcloud.net", name = "PingRsp")
    public JAXBElement<PingRsp> createPingRsp(PingRsp value) {
        return new JAXBElement<PingRsp>(_PingRsp_QNAME, PingRsp.class, null, value);
    }

}
