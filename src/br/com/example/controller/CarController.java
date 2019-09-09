package br.com.example.controller;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.example.dao.CarDAO;
import br.com.example.dao.CarDAOImpl;
import br.com.example.model.Car;

public class CarController {
    CarDAO dao = new CarDAOImpl();
    List<Car> cars;

    public CarController() {
        this.dao = new CarDAOImpl();
    }
    
    public void insert(Car car){
        if(!(car == null 
        	|| car.getName().trim().isEmpty()
            || car.getModel().trim().isEmpty()
            || car.getPlate().trim().isEmpty()	
       	)){
            dao.save(car);
            JOptionPane.showMessageDialog(null, "Carro Inserido Com Sucesso");
        }else
            JOptionPane.showMessageDialog(null, "Todos os campos são necessários !!!");
    }
    
    public void edit(Car car){
    	if(!(car == null 
           	|| car.getName().trim().isEmpty()
            || car.getModel().trim().isEmpty()
            || car.getPlate().trim().isEmpty()	
        )){
            dao.edit(car);
            JOptionPane.showMessageDialog(null, "Carro Alterado Com Sucesso");
        }else
            JOptionPane.showMessageDialog(null, "Todos os campos são necessários !!!");
    }
    
    public void delete(int id, String car){
        if(JOptionPane.showConfirmDialog(null,"Tem certeza que deseja excluir o " 
            +  car,"Excluir",JOptionPane.YES_NO_OPTION) == 0){
            dao.delete(id);
            JOptionPane.showMessageDialog(null, "Carro Deletado Com Sucesso");
           
        }else
            JOptionPane.showMessageDialog(null, "Cancelado");
    }
    
    public List<Car> getCars(){
        this.cars = dao.getCars(); 
        return this.cars;
    }
    
}