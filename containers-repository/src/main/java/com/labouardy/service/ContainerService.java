package com.labouardy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labouardy.dao.ContainerDAO;
import com.labouardy.entity.Container;
import com.labouardy.repository.ContainerRepository;

@Service
public class ContainerService implements ContainerDAO{
	@Autowired
	private ContainerRepository repository;

	@Override
	public List<Container> containers() {
		return repository.findAll();
	}

	@Override
	public void create(Container container) {
		repository.save(container);
	}

	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	@Override
	public Container find(Long id) {
		return repository.findOne(id);
	}

	
	

}
