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
@Table(name = "ART_VENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtVenta.findAll", query = "SELECT a FROM ArtVenta a"),
    @NamedQuery(name = "ArtVenta.findByArtVId", query = "SELECT a FROM ArtVenta a WHERE a.artVId = :artVId"),
    @NamedQuery(name = "ArtVenta.findByVentaId", query = "SELECT a FROM ArtVenta a WHERE a.ventaId = :ventaId"),
    @NamedQuery(name = "ArtVenta.findByArtId", query = "SELECT a FROM ArtVenta a WHERE a.artId = :artId"),
    @NamedQuery(name = "ArtVenta.findByCantidad", query = "SELECT a FROM ArtVenta a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "ArtVenta.findByPrecio", query = "SELECT a FROM ArtVenta a WHERE a.precio = :precio")})
public class ArtVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ART_V_ID")
    private Integer artVId;
    @Column(name = "VENTA_ID")
    private Integer ventaId;
    @Column(name = "ART_ID")
    private Integer artId;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;

    public ArtVenta() {
    }

    public ArtVenta(Integer artVId) {
        this.artVId = artVId;
    }

    public Integer getArtVId() {
        return artVId;
    }

    public void setArtVId(Integer artVId) {
        this.artVId = artVId;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
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
        hash += (artVId != null ? artVId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtVenta)) {
            return false;
        }
        ArtVenta other = (ArtVenta) object;
        if ((this.artVId == null && other.artVId != null) || (this.artVId != null && !this.artVId.equals(other.artVId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ArtVenta[ artVId=" + artVId + " ]";
    }
    
}
