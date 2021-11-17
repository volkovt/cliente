package com.volkovt.Cliente.dto;

import java.io.Serializable;
import java.time.Instant;

import com.volkovt.Cliente.entity.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private Double income;
	private Instant birthDate;
	private Integer children;
	
	public ClienteDTO() {
	}
	
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.name = cliente.getName();
		this.cpf = cliente.getCpf();
		this.income = cliente.getIncome();
		this.birthDate = cliente.getBirthDate();
		this.children = cliente.getChildren();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
