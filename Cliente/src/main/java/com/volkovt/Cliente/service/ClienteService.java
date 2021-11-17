package com.volkovt.Cliente.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.volkovt.Cliente.dto.ClienteDTO;
import com.volkovt.Cliente.entity.Cliente;
import com.volkovt.Cliente.repository.ClienteRepository;
import com.volkovt.Cliente.service.exceptions.ResourceNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAll(PageRequest pageRequest) {
		return repository.findAll(pageRequest).map(x -> new ClienteDTO(x));
	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(Long id) {
		return repository.findById(id).map(x -> new ClienteDTO(x))
				.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
	}

	@Transactional
	public ClienteDTO save(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setName(dto.getName());
		cliente.setBirthDate(dto.getBirthDate());
		cliente.setCpf(dto.getCpf());
		cliente.setIncome(dto.getIncome());
		cliente.setChildren(dto.getChildren());
		return new ClienteDTO(repository.save(cliente));
	}

	public ClienteDTO update(Long id, ClienteDTO dto) {
		try {
			Cliente cliente = repository.getOne(id);
			cliente.setName(dto.getName());
			cliente.setBirthDate(dto.getBirthDate());
			cliente.setCpf(dto.getCpf());
			cliente.setIncome(dto.getIncome());
			cliente.setChildren(dto.getChildren());
			return new ClienteDTO(repository.save(cliente));
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}
}
