
package mygit.service.Logic.GeneratedXML;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the GeneratedXML package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MagitRepository_QNAME = new QName("", "MagitRepository");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: GeneratedXML
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MagitRepositoryType }
     * 
     */
    public MagitRepositoryType createMagitRepositoryType() {
        return new MagitRepositoryType();
    }

    /**
     * Create an instance of {@link MagitSingleBranchType }
     * 
     */
    public MagitSingleBranchType createMagitSingleBranchType() {
        return new MagitSingleBranchType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link MagitBlobsType }
     * 
     */
    public MagitBlobsType createMagitBlobsType() {
        return new MagitBlobsType();
    }

    /**
     * Create an instance of {@link MagitBranchesType }
     * 
     */
    public MagitBranchesType createMagitBranchesType() {
        return new MagitBranchesType();
    }

    /**
     * Create an instance of {@link PrecedingCommitsType }
     * 
     */
    public PrecedingCommitsType createPrecedingCommitsType() {
        return new PrecedingCommitsType();
    }

    /**
     * Create an instance of {@link MagitFoldersType }
     * 
     */
    public MagitFoldersType createMagitFoldersType() {
        return new MagitFoldersType();
    }

    /**
     * Create an instance of {@link PrecedingCommitType }
     * 
     */
    public Logic.GeneratedXML.PrecedingCommitType createPrecedingCommitType() {
        return new Logic.GeneratedXML.PrecedingCommitType();
    }

    /**
     * Create an instance of {@link MagitSingleFolderType }
     * 
     */
    public MagitSingleFolderType createMagitSingleFolderType() {
        return new MagitSingleFolderType();
    }

    /**
     * Create an instance of {@link MagitRemoteReferenceType }
     * 
     */
    public MagitRemoteReferenceType createMagitRemoteReferenceType() {
        return new MagitRemoteReferenceType();
    }

    /**
     * Create an instance of {@link RootFolderType }
     * 
     */
    public Logic.GeneratedXML.RootFolderType createRootFolderType() {
        return new Logic.GeneratedXML.RootFolderType();
    }

    /**
     * Create an instance of {@link MagitBlobType }
     * 
     */
    public MagitBlobType createMagitBlobType() {
        return new MagitBlobType();
    }

    /**
     * Create an instance of {@link ItemsType }
     * 
     */
    public ItemsType createItemsType() {
        return new ItemsType();
    }

    /**
     * Create an instance of {@link MagitCommitsType }
     * 
     */
    public MagitCommitsType createMagitCommitsType() {
        return new MagitCommitsType();
    }

    /**
     * Create an instance of {@link MagitSingleCommitType }
     * 
     */
    public MagitSingleCommitType createMagitSingleCommitType() {
        return new MagitSingleCommitType();
    }

    /**
     * Create an instance of {@link PointedCommitType }
     * 
     */
    public Logic.GeneratedXML.PointedCommitType createPointedCommitType() {
        return new Logic.GeneratedXML.PointedCommitType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MagitRepositoryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "MagitRepository")
    public JAXBElement<MagitRepositoryType> createMagitRepository(MagitRepositoryType value) {
        return new JAXBElement<MagitRepositoryType>(_MagitRepository_QNAME, MagitRepositoryType.class, null, value);
    }

}
