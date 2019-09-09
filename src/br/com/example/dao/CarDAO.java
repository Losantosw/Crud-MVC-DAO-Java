package br.com.example.dao;

import java.util.List;

import br.com.example.model.Car;

public interface CarDAO {
	
	 public void save(Car car);
	    
	 public void edit(Car car);
	    
	 public void delete(int id);

	 public List<Car> getCars();
}
