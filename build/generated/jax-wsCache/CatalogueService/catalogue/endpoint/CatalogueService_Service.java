
package catalogue.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CatalogueService", targetNamespace = "http://endpoint.catalogue/", wsdlLocation = "http://Balazs-PC:8080/MovieCatalogue/CatalogueService?wsdl")
public class CatalogueService_Service
    extends Service
{

    private final static URL CATALOGUESERVICE_WSDL_LOCATION;
    private final static WebServiceException CATALOGUESERVICE_EXCEPTION;
    private final static QName CATALOGUESERVICE_QNAME = new QName("http://endpoint.catalogue/", "CatalogueService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://Balazs-PC:8080/MovieCatalogue/CatalogueService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CATALOGUESERVICE_WSDL_LOCATION = url;
        CATALOGUESERVICE_EXCEPTION = e;
    }

    public CatalogueService_Service() {
        super(__getWsdlLocation(), CATALOGUESERVICE_QNAME);
    }

    public CatalogueService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), CATALOGUESERVICE_QNAME, features);
    }

    public CatalogueService_Service(URL wsdlLocation) {
        super(wsdlLocation, CATALOGUESERVICE_QNAME);
    }

    public CatalogueService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CATALOGUESERVICE_QNAME, features);
    }

    public CatalogueService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CatalogueService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CatalogueService
     */
    @WebEndpoint(name = "CatalogueServicePort")
    public CatalogueService getCatalogueServicePort() {
        return super.getPort(new QName("http://endpoint.catalogue/", "CatalogueServicePort"), CatalogueService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CatalogueService
     */
    @WebEndpoint(name = "CatalogueServicePort")
    public CatalogueService getCatalogueServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://endpoint.catalogue/", "CatalogueServicePort"), CatalogueService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CATALOGUESERVICE_EXCEPTION!= null) {
            throw CATALOGUESERVICE_EXCEPTION;
        }
        return CATALOGUESERVICE_WSDL_LOCATION;
    }

}
