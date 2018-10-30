package com.dms.banco.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_UNI_MEDIDA")
public class Unidade {

	@Id
	@Column(name = "unidade")
	private String id;
	private String descricao;
	private BigDecimal conversor;
	private Character status;
	@Column(name = "unidade_ex")
	private String unidadeEx;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getConversor() {
		return conversor;
	}

	public void setConversor(BigDecimal conversor) {
		this.conversor = conversor;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public String getUnidadeEx() {
		return unidadeEx;
	}

	public void setUnidadeEx(String unidadeEx) {
		this.unidadeEx = unidadeEx;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unidade other = (Unidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
