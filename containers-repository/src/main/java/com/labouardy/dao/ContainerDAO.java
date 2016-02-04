package com.labouardy.dao;

import java.util.List;

import com.labouardy.entity.Container;

public interface ContainerDAO {
	List<Container> containers();
	void create(Container container);
	void delete(Long id);
	Container find(Long id);
}
