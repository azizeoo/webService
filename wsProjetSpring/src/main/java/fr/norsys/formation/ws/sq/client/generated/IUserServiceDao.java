
package fr.norsys.formation.ws.sq.client.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "IUserServiceDao", targetNamespace = "http://wsInterface.dao.ws.formation.norsys.fr/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IUserServiceDao {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String sayHello(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns fr.norsys.formation.ws.sq.client.generated.UserArray
     */
    @WebMethod
    @WebResult(partName = "return")
    public UserArray getUsersByName(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0);

}
