
package mygit.service.Logic.GeneratedXML;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MagitBranchesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MagitBranchesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="head" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MagitSingleBranch" type="{}MagitSingleBranchType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MagitBranchesType", propOrder = {
    "head",
    "magitSingleBranch"
})
public class MagitBranchesType {

    @XmlElement(required = true)
    protected String head;
    @XmlElement(name = "MagitSingleBranch")
    protected List<MagitSingleBranchType> magitSingleBranch;

    /**
     * Gets the value of the head property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHead() {
        return head;
    }

    /**
     * Sets the value of the head property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHead(String value) {
        this.head = value;
    }

    /**
     * Gets the value of the magitSingleBranch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the magitSingleBranch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMagitSingleBranch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MagitSingleBranchType }
     * 
     * 
     */
    public List<MagitSingleBranchType> getMagitSingleBranch() {
        if (magitSingleBranch == null) {
            magitSingleBranch = new ArrayList<MagitSingleBranchType>();
        }
        return this.magitSingleBranch;
    }

}
