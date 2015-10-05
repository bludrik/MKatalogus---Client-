
package catalogue.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateMovieService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateMovieService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="modifiedItem" type="{http://endpoint.catalogue/}movieItem" minOccurs="0"/>
 *         &lt;element name="modifiedGenreIdx" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="modifiedDirectorIdx" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateMovieService", propOrder = {
    "id",
    "modifiedItem",
    "modifiedGenreIdx",
    "modifiedDirectorIdx"
})
public class UpdateMovieService {

    protected int id;
    protected MovieItem modifiedItem;
    @XmlElement(type = Integer.class)
    protected List<Integer> modifiedGenreIdx;
    @XmlElement(type = Integer.class)
    protected List<Integer> modifiedDirectorIdx;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the modifiedItem property.
     * 
     * @return
     *     possible object is
     *     {@link MovieItem }
     *     
     */
    public MovieItem getModifiedItem() {
        return modifiedItem;
    }

    /**
     * Sets the value of the modifiedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovieItem }
     *     
     */
    public void setModifiedItem(MovieItem value) {
        this.modifiedItem = value;
    }

    /**
     * Gets the value of the modifiedGenreIdx property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiedGenreIdx property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiedGenreIdx().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getModifiedGenreIdx() {
        if (modifiedGenreIdx == null) {
            modifiedGenreIdx = new ArrayList<Integer>();
        }
        return this.modifiedGenreIdx;
    }

    /**
     * Gets the value of the modifiedDirectorIdx property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the modifiedDirectorIdx property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModifiedDirectorIdx().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getModifiedDirectorIdx() {
        if (modifiedDirectorIdx == null) {
            modifiedDirectorIdx = new ArrayList<Integer>();
        }
        return this.modifiedDirectorIdx;
    }

}
