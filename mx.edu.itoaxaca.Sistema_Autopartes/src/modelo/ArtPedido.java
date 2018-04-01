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
@Table(name = "ART_PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtPedido.findAll", query = "SELECT a FROM ArtPedido a"),
    @NamedQuery(name = "ArtPedido.findByArtPId", query = "SELECT a FROM ArtPedido a WHERE a.artPId = :artPId"),
    @NamedQuery(name = "ArtPedido.findByPedId", query = "SELECT a FROM ArtPedido a WHERE a.pedId = :pedId"),
    @NamedQuery(name = "ArtPedido.findByArtId", query = "SELECT a FROM ArtPedido a WHERE a.artId = :artId"),
    @NamedQuery(name = "ArtPedido.findByCantidad", query = "SELECT a FROM ArtPedido a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "ArtPedido.findByPrecio", query = "SELECT a FROM ArtPedido a WHERE a.precio = :precio")})
public class ArtPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ART_P_ID")
    private Integer artPId;
    @Column(name = "PED_ID")
    private Integer pedId;
    @Column(name = "ART_ID")
    private Integer artId;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Double precio;

    public ArtPedido() {
    }

    public ArtPedido(Integer artPId) {
        this.artPId = artPId;
    }

    public Integer getArtPId() {
        return artPId;
    }

    public void setArtPId(Integer artPId) {
        this.artPId = artPId;
    }

    public Integer getPedId() {
        return pedId;
    }

    public void setPedId(Integer pedId) {
        this.pedId = pedId;
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
        hash += (artPId != null ? artPId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtPedido)) {
            return false;
        }
        ArtPedido other = (ArtPedido) object;
        if ((this.artPId == null && other.artPId != null) || (this.artPId != null && !this.artPId.equals(other.artPId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ArtPedido[ artPId=" + artPId + " ]";
    }
    
}
