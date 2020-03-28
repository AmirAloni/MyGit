
package mygit.service.Logic.GeneratedXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MagitSingleFolderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MagitSingleFolderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="last-updater">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Moyshe Ufnik"/>
 *               &lt;enumeration value="Arik and Bentz"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="last-update-date">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="09.06.2019-20:15:11:232"/>
 *               &lt;enumeration value="09.06.2019-20:25:10:111"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="items" type="{}itemsType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="is-root" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MagitSingleFolderType", propOrder = {
    "lastUpdater",
    "lastUpdateDate",
    "name",
    "items"
})
public class MagitSingleFolderType {

    @XmlElement(name = "last-updater", required = true)
    protected String lastUpdater;
    @XmlElement(name = "last-update-date", required = true)
    protected String lastUpdateDate;
    protected String name;
    @XmlElement(required = true)
    protected ItemsType items;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "is-root")
    protected String isRoot;

    /**
     * Gets the value of the lastUpdater property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdater() {
        return lastUpdater;
    }

    /**
     * Sets the value of the lastUpdater property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdater(String value) {
        this.lastUpdater = value;
    }

    /**
     * Gets the value of the lastUpdateDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Sets the value of the lastUpdateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdateDate(String value) {
        this.lastUpdateDate = value;
    }

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
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link ItemsType }
     *     
     */
    public ItemsType getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemsType }
     *     
     */
    public void setItems(ItemsType value) {
        this.items = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the isRoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsRoot() {
        return isRoot;
    }

    /**
     * Sets the value of the isRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsRoot(String value) {
        this.isRoot = value;
    }

}
