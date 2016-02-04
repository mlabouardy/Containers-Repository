package com.labouardy.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labouardy.entity.Container;
import com.labouardy.repository.ContainerRepository;

@Service
@Transactional
public class InitService {

	@Autowired
	private ContainerRepository repository;
	
	@PostConstruct
	public void init(){
		Container c=new Container();
		c.setName("Apache");
		c.setDescription("Server web");
		c.setPort(80);
		repository.save(c);
	}
}
