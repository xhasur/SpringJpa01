/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "regions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regions.findAll", query = "SELECT r FROM Regions r"),
    @NamedQuery(name = "Regions.findByRegionId", query = "SELECT r FROM Regions r WHERE r.regionId = :regionId"),
    @NamedQuery(name = "Regions.findByRegionName", query = "SELECT r FROM Regions r WHERE r.regionName = :regionName")})
public class Regions implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "region_id")
    private BigDecimal regionId;
    @Column(name = "region_name")
    private String regionName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
    private Collection<Countries> countriesCollection;

    public Regions() {
    }

    public Regions(BigDecimal regionId) {
        this.regionId = regionId;
    }

    public BigDecimal getRegionId() {
        return regionId;
    }

    public void setRegionId(BigDecimal regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @XmlTransient
    public Collection<Countries> getCountriesCollection() {
        return countriesCollection;
    }

    public void setCountriesCollection(Collection<Countries> countriesCollection) {
        this.countriesCollection = countriesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionId != null ? regionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regions)) {
            return false;
        }
        Regions other = (Regions) object;
        if ((this.regionId == null && other.regionId != null) || (this.regionId != null && !this.regionId.equals(other.regionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.entidades.Regions[ regionId=" + regionId + " ]";
    }
    
}
