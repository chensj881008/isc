
/*
 * 
 */

package com.winning.isc.ws.client;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class was generated by Apache CXF 2.2.3
 * Thu Aug 16 19:54:14 CST 2018
 * Generated source version: 2.2.3
 * 
 */


@WebServiceClient(name = "LBEBusinessWebService",
                  wsdlLocation = "http://203.110.176.178:9089/service/LBEBusiness?wsdl",
                  targetNamespace = "http://ws.livebos.apex.com/") 
public class LBEBusinessWebService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://ws.livebos.apex.com/", "LBEBusinessWebService");
    public final static QName LBEBusinessServiceImplPort = new QName("http://ws.livebos.apex.com/", "LBEBusinessServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://203.110.176.178:9089/service/LBEBusiness?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://203.110.176.178:9089/service/LBEBusiness?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public LBEBusinessWebService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public LBEBusinessWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LBEBusinessWebService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns LBEBusinessService
     */
    @WebEndpoint(name = "LBEBusinessServiceImplPort")
    public LBEBusinessService getLBEBusinessServiceImplPort() {
        return super.getPort(LBEBusinessServiceImplPort, LBEBusinessService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LBEBusinessService
     */
    @WebEndpoint(name = "LBEBusinessServiceImplPort")
    public LBEBusinessService getLBEBusinessServiceImplPort(WebServiceFeature... features) {
        return super.getPort(LBEBusinessServiceImplPort, LBEBusinessService.class, features);
    }

}
