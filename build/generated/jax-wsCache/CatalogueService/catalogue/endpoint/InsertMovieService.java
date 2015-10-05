
package catalogue.endpoint;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for insertMovieService complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="insertMovieService">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="movie" type="{http://endpoint.catalogue/}movieItem" minOccurs="0"/>
 *         &lt;element name="genreIdx" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="directorIdx" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertMovieService", propOrder = {
    "movie",
    "genreIdx",
    "directorIdx"
})
public class InsertMovieService {

    protected MovieItem movie;
    @XmlElement(type = Integer.class)
    protected List<Integer> genreIdx;
    @XmlElement(type = Integer.class)
    protected List<Integer> directorIdx;

    /**
     * Gets the value of the movie property.
     * 
     * @return
     *     possible object is
     *     {@link MovieItem }
     *     
     */
    public MovieItem getMovie() {
        return movie;
    }

    /**
     * Sets the value of the movie property.
     * 
     * @param value
     *     allowed object is
     *     {@link MovieItem }
     *     
     */
    public void setMovie(MovieItem value) {
        this.movie = value;
    }

    /**
     * Gets the value of the genreIdx property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genreIdx property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenreIdx().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getGenreIdx() {
        if (genreIdx == null) {
            genreIdx = new ArrayList<Integer>();
        }
        return this.genreIdx;
    }

    /**
     * Gets the value of the directorIdx property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the directorIdx property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDirectorIdx().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getDirectorIdx() {
        if (directorIdx == null) {
            directorIdx = new ArrayList<Integer>();
        }
        return this.directorIdx;
    }

}
