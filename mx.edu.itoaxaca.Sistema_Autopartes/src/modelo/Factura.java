/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ISCO
 */
@Entity
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByFacId", query = "SELECT f FROM Factura f WHERE f.facId = :facId")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total")
    , @NamedQuery(name = "Factura.findByCNombre", query = "SELECT f FROM Factura f WHERE f.cNombre = :cNombre")
    , @NamedQuery(name = "Factura.findByFPago", query = "SELECT f FROM Factura f WHERE f.fPago = :fPago")
    , @NamedQuery(name = "Factura.findByVendedor", query = "SELECT f FROM Factura f WHERE f.vendedor = :vendedor")
    , @NamedQuery(name = "Factura.findByCApellidos", query = "SELECT f FROM Factura f WHERE f.cApellidos = :cApellidos")
    , @NamedQuery(name = "Factura.findByCRfc", query = "SELECT f FROM Factura f WHERE f.cRfc = :cRfc")
    , @NamedQuery(name = "Factura.findByCDireccion", query = "SELECT f FROM Factura f WHERE f.cDireccion = :cDireccion")
    , @NamedQuery(name = "Factura.findByCTelefono", query = "SELECT f FROM Factura f WHERE f.cTelefono = :cTelefono")
    , @NamedQuery(name = "Factura.findByVentaId", query = "SELECT f FROM Factura f WHERE f.ventaId = :ventaId")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FAC_ID")
    private Integer facId;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private Double total;
    @Column(name = "C_NOMBRE")
    private String cNombre;
    @Column(name = "F_PAGO")
    private String fPago;
    @Column(name = "VENDEDOR")
    private Integer vendedor;
    @Column(name = "C_APELLIDOS")
    private String cApellidos;
    @Column(name = "C_RFC")
    private String cRfc;
    @Column(name = "C_DIRECCION")
    private String cDireccion;
    @Column(name = "C_TELEFONO")
    private String cTelefono;
    @Column(name = "VENTA_ID")
    private Integer ventaId;

    public Factura() {
    }

    public Factura(Integer facId) {
        this.facId = facId;
    }

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCNombre() {
        return cNombre;
    }

    public void setCNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getFPago() {
        return fPago;
    }

    public void setFPago(String fPago) {
        this.fPago = fPago;
    }

    public Integer getVendedor() {
        return vendedor;
    }

    public void setVendedor(Integer vendedor) {
        this.vendedor = vendedor;
    }

    public String getCApellidos() {
        return cApellidos;
    }

    public void setCApellidos(String cApellidos) {
        this.cApellidos = cApellidos;
    }

    public String getCRfc() {
        return cRfc;
    }

    public void setCRfc(String cRfc) {
        this.cRfc = cRfc;
    }

    public String getCDireccion() {
        return cDireccion;
    }

    public void setCDireccion(String cDireccion) {
        this.cDireccion = cDireccion;
    }

    public String getCTelefono() {
        return cTelefono;
    }

    public void setCTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ facId=" + facId + " ]";
    }
    
}
