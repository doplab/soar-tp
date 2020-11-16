package ch.unil.doplab.shoppingwebsite_v4.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Software Architectures | DOPLab | UniL
 *
 * @author Melike Geçer
 */
@Entity
@Table(name = "ITEMS")
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByItemId", query = "SELECT i FROM Items i WHERE i.itemId = :itemId"),
    @NamedQuery(name = "Items.findByItemClass", query = "SELECT i FROM Items i WHERE i.itemClass = :itemClass"),
    @NamedQuery(name = "Items.findByItemName", query = "SELECT i FROM Items i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "Items.findByItemPrice", query = "SELECT i FROM Items i WHERE i.itemPrice = :itemPrice"),
    @NamedQuery(name = "Items.findByHasMeatOrAlcohol", query = "SELECT i FROM Items i WHERE i.hasMeatOrAlcohol = :hasMeatOrAlcohol"),
    @NamedQuery(name = "Items.findByIngredients", query = "SELECT i FROM Items i WHERE i.ingredients = :ingredients")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Size(max = 1)
    @Column(name = "ITEM_CLASS")
    private String itemClass;
    @Size(max = 50)
    @Column(name = "ITEM_NAME")
    private String itemName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ITEM_PRICE")
    private Double itemPrice;
    @Size(max = 1)
    @Column(name = "HAS_MEAT_OR_ALCOHOL")
    private String hasMeatOrAlcohol;
    @Size(max = 255)
    @Column(name = "INGREDIENTS")
    private String ingredients;
    @ManyToMany(mappedBy = "itemsList")
    private List<Users> usersList;

    public Items() {
    }

    public Items(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getHasMeatOrAlcohol() {
        return hasMeatOrAlcohol;
    }

    public void setHasMeatOrAlcohol(String hasMeatOrAlcohol) {
        this.hasMeatOrAlcohol = hasMeatOrAlcohol;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ch.unil.doplab.shoppingwebsite_v4.models.Items[ itemId=" + itemId + " ]";
    }
    
}
