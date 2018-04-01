/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISCO
 */
@Entity
@Table(name = "ART_COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtCompra.findAll", query = "SELECT a FROM ArtCompra a"),
    @NamedQuery(name = "ArtCompra.findByArtCId", query = "SELECT a FROM ArtCompra a WHERE a.artCId = :artCId"),
    @NamedQuery(name = "ArtCompra.findByCompraId", query = "SELECT a FROM ArtCompra a WHERE a.compraId = :compraId"),
    @NamedQuery(name = "ArtCompra.findByArtId", query = "SELECT a FROM ArtCompra a WHERE a.artId = :artId"),
    @NamedQuery(name = "ArtCompra.findByCantidad", query = "SELECT a FROM ArtCompra a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "ArtCompra.findByPrecio", query = "SELECT a FROM ArtCompra a WHERE a.precio = :precio")})
public class ArtCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ART_C_ID")
    private Integer artCId;
    @Column(name = "COMPRA_ID")
    private Integer compraId;
    @Column(name = "ART_ID")
    private Integer artId;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;

    public ArtCompra() {
    }

    public ArtCompra(Integer artCId) {
        this.artCId = artCId;
    }

    public Integer getArtCId() {
        return artCId;
    }

    public void setArtCId(Integer artCId) {
        this.artCId = artCId;
    }

    public Integer getCompraId() {
        return compraId;
    }

    public void setCompraId(Integer compraId) {
        this.compraId = compraId;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artCId != null ? artCId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtCompra)) {
            return false;
        }
        ArtCompra other = (ArtCompra) object;
        if ((this.artCId == null && other.artCId != null) || (this.artCId != null && !this.artCId.equals(other.artCId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ArtCompra[ artCId=" + artCId + " ]";
    }
    
}
