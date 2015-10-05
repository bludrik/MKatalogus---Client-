
package catalogue.endpoint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertDirectorService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertDirectorService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="director" type="{http://endpoint.catalogue/}directorItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertDirectorService", propOrder = {
    "director"
})
public class InsertDirectorService {

    protected DirectorItem director;

    /**
     * Gets the value of the director property.
     * 
     * @return
     *     possible object is
     *     {@link DirectorItem }
     *     
     */
    public DirectorItem getDirector() {
        return director;
    }

    /**
     * Sets the value of the director property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectorItem }
     *     
     */
    public void setDirector(DirectorItem value) {
        this.director = value;
    }

}
