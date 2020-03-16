
package mygit.service.Logic.GeneratedXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MagitSingleCommitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MagitSingleCommitType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="root-folder" type="{}root-folderType"/>
 *         &lt;element name="message">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Initial commit performed on this repository"/>
 *               &lt;enumeration value="changed Foo PSVM to say hello to tao tao"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="author">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Moyshe Ufnik"/>
 *               &lt;enumeration value="Arik and Bentz"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="date-of-creation">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="09.06.2019-20:15:11:232"/>
 *               &lt;enumeration value="09.06.2019-20:25:10:111"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="preceding-commits" type="{}preceding-commitsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MagitSingleCommitType", propOrder = {
    "rootFolder",
    "message",
    "author",
    "dateOfCreation",
    "precedingCommits"
})
public class MagitSingleCommitType {

    @XmlElement(name = "root-folder", required = true)
    protected Logic.GeneratedXML.RootFolderType rootFolder;
    @XmlElement(required = true)
    protected String message;
    @XmlElement(required = true)
    protected String author;
    @XmlElement(name = "date-of-creation", required = true)
    protected String dateOfCreation;
    @XmlElement(name = "preceding-commits")
    protected PrecedingCommitsType precedingCommits;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the rootFolder property.
     * 
     * @return
     *     possible object is
     *     {@link RootFolderType }
     *     
     */
    public Logic.GeneratedXML.RootFolderType getRootFolder() {
        return rootFolder;
    }

    /**
     * Sets the value of the rootFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link RootFolderType }
     *     
     */
    public void setRootFolder(Logic.GeneratedXML.RootFolderType value) {
        this.rootFolder = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the dateOfCreation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfCreation() {
        return dateOfCreation;
    }

    /**
     * Sets the value of the dateOfCreation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfCreation(String value) {
        this.dateOfCreation = value;
    }

    /**
     * Gets the value of the precedingCommits property.
     * 
     * @return
     *     possible object is
     *     {@link PrecedingCommitsType }
     *     
     */
    public PrecedingCommitsType getPrecedingCommits() {
        return precedingCommits;
    }

    /**
     * Sets the value of the precedingCommits property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrecedingCommitsType }
     *     
     */
    public void setPrecedingCommits(PrecedingCommitsType value) {
        this.precedingCommits = value;
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

}
