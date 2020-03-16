
package mygit.service.Logic.GeneratedXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for preceding-commitsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="preceding-commitsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="preceding-commit" type="{}preceding-commitType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "preceding-commitsType", propOrder = {
    "precedingCommit"
})
public class PrecedingCommitsType {

    @XmlElement(name = "preceding-commit", required = true)
    protected Logic.GeneratedXML.PrecedingCommitType precedingCommit;

    /**
     * Gets the value of the precedingCommit property.
     * 
     * @return
     *     possible object is
     *     {@link PrecedingCommitType }
     *     
     */
    public Logic.GeneratedXML.PrecedingCommitType getPrecedingCommit() {
        return precedingCommit;
    }

    /**
     * Sets the value of the precedingCommit property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrecedingCommitType }
     *     
     */
    public void setPrecedingCommit(Logic.GeneratedXML.PrecedingCommitType value) {
        this.precedingCommit = value;
    }

}
