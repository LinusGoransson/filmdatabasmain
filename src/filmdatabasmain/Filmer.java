/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmdatabasmain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author linusgoransson
 */
@Entity
@Table(name = "filmer", catalog = "filmdatabas", schema = "")
@NamedQueries({
    @NamedQuery(name = "Filmer.findAll", query = "SELECT f FROM Filmer f"),
    @NamedQuery(name = "Filmer.findByTitel", query = "SELECT f FROM Filmer f WHERE f.titel = :titel"),
    @NamedQuery(name = "Filmer.findByRegiss\u00f6r", query = "SELECT f FROM Filmer f WHERE f.regiss\u00f6r = :regiss\u00f6r"),
    @NamedQuery(name = "Filmer.findByIMDb", query = "SELECT f FROM Filmer f WHERE f.iMDb = :iMDb"),
    @NamedQuery(name = "Filmer.findBy\u00c5r", query = "SELECT f FROM Filmer f WHERE f.\u00e5r = :\u00e5r"),
    @NamedQuery(name = "Filmer.findById", query = "SELECT f FROM Filmer f WHERE f.id = :id")})
public class Filmer implements Serializable {
    //Generaread class som skapades då jag connectade min databas med jtable 
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "titel")
    private String titel;
    @Basic(optional = false)
    @Column(name = "regiss\u00f6r")
    private String regissör;
    @Basic(optional = false)
    @Column(name = "IMDb")
    private String iMDb;
    @Basic(optional = false)
    @Column(name = "\u00e5r")
    private String år;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Filmer() {
    }

    public Filmer(Integer id) {
        this.id = id;
    }

    public Filmer(Integer id, String titel, String regissör, String iMDb, String år) {
        this.id = id;
        this.titel = titel;
        this.regissör = regissör;
        this.iMDb = iMDb;
        this.år = år;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        String oldTitel = this.titel;
        this.titel = titel;
        changeSupport.firePropertyChange("titel", oldTitel, titel);
    }

    public String getRegissör() {
        return regissör;
    }

    public void setRegissör(String regissör) {
        String oldRegissör = this.regissör;
        this.regissör = regissör;
        changeSupport.firePropertyChange("regiss\u00f6r", oldRegissör, regissör);
    }

    public String getIMDb() {
        return iMDb;
    }

    public void setIMDb(String iMDb) {
        String oldIMDb = this.iMDb;
        this.iMDb = iMDb;
        changeSupport.firePropertyChange("IMDb", oldIMDb, iMDb);
    }

    public String getÅr() {
        return år;
    }

    public void setÅr(String år) {
        String oldÅr = this.år;
        this.år = år;
        changeSupport.firePropertyChange("\u00e5r", oldÅr, år);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmer)) {
            return false;
        }
        Filmer other = (Filmer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "filmdatabasmain.Filmer[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
