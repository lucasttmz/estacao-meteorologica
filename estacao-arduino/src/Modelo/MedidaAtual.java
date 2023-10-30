/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
 * @author Lucas
 */
@Entity
@Table(name = "medidasatuais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedidaAtual.findAll", query = "SELECT m FROM MedidaAtual m"),
    @NamedQuery(name = "MedidaAtual.findByIdMedidaAtual", query = "SELECT m FROM MedidaAtual m WHERE m.idMedidaAtual = :idMedidaAtual"),
    @NamedQuery(name = "MedidaAtual.findByTemperatura", query = "SELECT m FROM MedidaAtual m WHERE m.temperatura = :temperatura"),
    @NamedQuery(name = "MedidaAtual.findByUmidade", query = "SELECT m FROM MedidaAtual m WHERE m.umidade = :umidade"),
    @NamedQuery(name = "MedidaAtual.findByChuva", query = "SELECT m FROM MedidaAtual m WHERE m.chuva = :chuva"),
    @NamedQuery(name = "MedidaAtual.findByMomento", query = "SELECT m FROM MedidaAtual m WHERE m.momento = :momento")})
public class MedidaAtual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedidaAtual")
    private Integer idMedidaAtual;
    @Column(name = "temperatura")
    private Integer temperatura;
    @Column(name = "umidade")
    private Integer umidade;
    @Column(name = "chuva")
    private Integer chuva;
    @Column(name = "momento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date momento;

    public MedidaAtual() {
    }

    public MedidaAtual(Integer idMedidaAtual) {
        this.idMedidaAtual = idMedidaAtual;
    }

    public Integer getIdMedidaAtual() {
        return idMedidaAtual;
    }

    public void setIdMedidaAtual(Integer idMedidaAtual) {
        this.idMedidaAtual = idMedidaAtual;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }

    public Integer getUmidade() {
        return umidade;
    }

    public void setUmidade(Integer umidade) {
        this.umidade = umidade;
    }

    public Integer getChuva() {
        return chuva;
    }

    public void setChuva(Integer chuva) {
        this.chuva = chuva;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedidaAtual != null ? idMedidaAtual.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedidaAtual)) {
            return false;
        }
        MedidaAtual other = (MedidaAtual) object;
        if ((this.idMedidaAtual == null && other.idMedidaAtual != null) || (this.idMedidaAtual != null && !this.idMedidaAtual.equals(other.idMedidaAtual))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.MedidaAtual[ idMedidaAtual=" + idMedidaAtual + " ]";
    }
    
}
