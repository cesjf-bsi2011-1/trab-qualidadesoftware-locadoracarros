/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.auadottonizaidem.locadoraveicolos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author auadtassio
 */
@Entity
@Table(name = "locacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
    @NamedQuery(name = "Locacao.findById", query = "SELECT l FROM Locacao l WHERE l.id = :id"),
    @NamedQuery(name = "Locacao.findByDataLocacao", query = "SELECT l FROM Locacao l WHERE l.dataLocacao = :dataLocacao"),
    @NamedQuery(name = "Locacao.findByConcluida", query = "SELECT l FROM Locacao l WHERE l.concluida = :concluida")})
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "data_locacao")
    private long dataLocacao;
    @Column(name = "concluida")
    private Boolean concluida;
    @JoinColumn(name = "cliente_locador", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente clienteLocador;
    @JoinColumn(name = "veiculo_locado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Veiculo veiculoLocado;
    @JoinColumn(name = "funcionario_responsavel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario funcionarioResponsavel;

    public Locacao() {
    }

    public Locacao(Integer id) {
        this.id = id;
    }

    public Locacao(Integer id, long dataLocacao) {
        this.id = id;
        this.dataLocacao = dataLocacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(long dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    public Cliente getClienteLocador() {
        return clienteLocador;
    }

    public void setClienteLocador(Cliente clienteLocador) {
        this.clienteLocador = clienteLocador;
    }

    public Veiculo getVeiculoLocado() {
        return veiculoLocado;
    }

    public void setVeiculoLocado(Veiculo veiculoLocado) {
        this.veiculoLocado = veiculoLocado;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
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
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.auadottonizaidem.locadoraveicolos.model.Locacao[ id=" + id + " ]";
    }
    
}
