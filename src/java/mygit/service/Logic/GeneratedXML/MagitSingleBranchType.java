
package mygit.service.Logic.GeneratedXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MagitSingleBranchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MagitSingleBranchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="master"/>
 *               &lt;enumeration value="repo1\master"/>
 *               &lt;enumeration value="test"/>
 *               &lt;enumeration value="repo1\test"/>
 *               &lt;enumeration value="feature1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="pointed-commit" type="{}pointed-commitType"/>
 *         &lt;element name="tracking-after" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="repo1\master"/>
 *               &lt;enumeration value="repo1\test"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="tracking" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="is-remote" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MagitSingleBranchType", propOrder = {
    "name",
    "pointedCommit",
    "trackingAfter"
})
public class MagitSingleBranchType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "pointed-commit", required = true)
    protected Logic.GeneratedXML.PointedCommitType pointedCommit;
    @XmlElement(name = "tracking-after")
    protected String trackingAfter;
    @XmlAttribute(name = "tracking")
    protected String tracking;
    @XmlAttribute(name = "is-remote")
    protected String isRemote;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the pointedCommit property.
     * 
     * @return
     *     possible object is
     *     {@link PointedCommitType }
     *     
     */
    public Logic.GeneratedXML.PointedCommitType getPointedCommit() {
        return pointedCommit;
    }

    /**
     * Sets the value of the pointedCommit property.
     * 
     * @param value
     *     allowed object is
     *     {@link PointedCommitType }
     *     
     */
    public void setPointedCommit(Logic.GeneratedXML.PointedCommitType value) {
        this.pointedCommit = value;
    }

    /**
     * Gets the value of the trackingAfter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackingAfter() {
        return trackingAfter;
    }

    /**
     * Sets the value of the trackingAfter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackingAfter(String value) {
        this.trackingAfter = value;
    }

    /**
     * Gets the value of the tracking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTracking() {
        return tracking;
    }

    /**
     * Sets the value of the tracking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTracking(String value) {
        this.tracking = value;
    }

    /**
     * Gets the value of the isRemote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRemote() {
        return isRemote;
    }

    /**
     * Sets the value of the isRemote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRemote(String value) {
        this.isRemote = value;
    }

}
