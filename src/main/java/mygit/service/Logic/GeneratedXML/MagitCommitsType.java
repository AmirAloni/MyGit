
package mygit.service.Logic.GeneratedXML;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MagitCommitsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MagitCommitsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MagitSingleCommit" type="{}MagitSingleCommitType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MagitCommitsType", propOrder = {
    "magitSingleCommit"
})
public class MagitCommitsType {

    @XmlElement(name = "MagitSingleCommit")
    protected List<MagitSingleCommitType> magitSingleCommit;

    /**
     * Gets the value of the magitSingleCommit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the magitSingleCommit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMagitSingleCommit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MagitSingleCommitType }
     * 
     * 
     */
    public List<MagitSingleCommitType> getMagitSingleCommit() {
        if (magitSingleCommit == null) {
            magitSingleCommit = new ArrayList<MagitSingleCommitType>();
        }
        return this.magitSingleCommit;
    }

}
