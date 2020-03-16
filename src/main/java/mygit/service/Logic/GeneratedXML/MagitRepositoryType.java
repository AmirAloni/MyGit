
package mygit.service.Logic.GeneratedXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MagitRepositoryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MagitRepositoryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MagitBlobs" type="{}MagitBlobsType"/>
 *         &lt;element name="MagitFolders" type="{}MagitFoldersType"/>
 *         &lt;element name="MagitCommits" type="{}MagitCommitsType"/>
 *         &lt;element name="MagitBranches" type="{}MagitBranchesType"/>
 *         &lt;element name="MagitRemoteReference" type="{}MagitRemoteReferenceType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MagitRepositoryType", propOrder = {
    "location",
    "magitBlobs",
    "magitFolders",
    "magitCommits",
    "magitBranches",
    "magitRemoteReference"
})
public class MagitRepositoryType {

    @XmlElement(required = true)
    protected String location;
    @XmlElement(name = "MagitBlobs", required = true)
    protected MagitBlobsType magitBlobs;
    @XmlElement(name = "MagitFolders", required = true)
    protected MagitFoldersType magitFolders;
    @XmlElement(name = "MagitCommits", required = true)
    protected MagitCommitsType magitCommits;
    @XmlElement(name = "MagitBranches", required = true)
    protected MagitBranchesType magitBranches;
    @XmlElement(name = "MagitRemoteReference", required = true)
    protected MagitRemoteReferenceType magitRemoteReference;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the magitBlobs property.
     * 
     * @return
     *     possible object is
     *     {@link MagitBlobsType }
     *     
     */
    public MagitBlobsType getMagitBlobs() {
        return magitBlobs;
    }

    /**
     * Sets the value of the magitBlobs property.
     * 
     * @param value
     *     allowed object is
     *     {@link MagitBlobsType }
     *     
     */
    public void setMagitBlobs(MagitBlobsType value) {
        this.magitBlobs = value;
    }

    /**
     * Gets the value of the magitFolders property.
     * 
     * @return
     *     possible object is
     *     {@link MagitFoldersType }
     *     
     */
    public MagitFoldersType getMagitFolders() {
        return magitFolders;
    }

    /**
     * Sets the value of the magitFolders property.
     * 
     * @param value
     *     allowed object is
     *     {@link MagitFoldersType }
     *     
     */
    public void setMagitFolders(MagitFoldersType value) {
        this.magitFolders = value;
    }

    /**
     * Gets the value of the magitCommits property.
     * 
     * @return
     *     possible object is
     *     {@link MagitCommitsType }
     *     
     */
    public MagitCommitsType getMagitCommits() {
        return magitCommits;
    }

    /**
     * Sets the value of the magitCommits property.
     * 
     * @param value
     *     allowed object is
     *     {@link MagitCommitsType }
     *     
     */
    public void setMagitCommits(MagitCommitsType value) {
        this.magitCommits = value;
    }

    /**
     * Gets the value of the magitBranches property.
     * 
     * @return
     *     possible object is
     *     {@link MagitBranchesType }
     *     
     */
    public MagitBranchesType getMagitBranches() {
        return magitBranches;
    }

    /**
     * Sets the value of the magitBranches property.
     * 
     * @param value
     *     allowed object is
     *     {@link MagitBranchesType }
     *     
     */
    public void setMagitBranches(MagitBranchesType value) {
        this.magitBranches = value;
    }

    /**
     * Gets the value of the magitRemoteReference property.
     * 
     * @return
     *     possible object is
     *     {@link MagitRemoteReferenceType }
     *     
     */
    public MagitRemoteReferenceType getMagitRemoteReference() {
        return magitRemoteReference;
    }

    /**
     * Sets the value of the magitRemoteReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link MagitRemoteReferenceType }
     *     
     */
    public void setMagitRemoteReference(MagitRemoteReferenceType value) {
        this.magitRemoteReference = value;
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

}
