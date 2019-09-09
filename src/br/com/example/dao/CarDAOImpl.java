package br.com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.example.model.Car;
import br.com.example.utils.ConnectionFactory;

public class CarDAOImpl implements CarDAO{
    Connection conn = null;
    PreparedStatement pstm = null;
    String qry = null;
    ResultSet rs;
    
    @Override
    public void save(Car car) {
        qry = "INSERT INTO cars (name, model, plate) VALUES (?,?,?)";
        
        try {  
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);

            this.pstm.setString(1, car.getName());
            this.pstm.setString(2, car.getModel());
            this.pstm.setString(3, car.getPlate());

            this.pstm.execute();
            this.pstm.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Carro Inserido Com Sucesso");
            
        }catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer connsulta" + Erro + "SQL" + qry);
        }
    }

    @Override
    public void edit(Car car) {
        qry = "UPDATE cars SET name=?, model=?, plate=? WHERE id=?";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);
            
            this.pstm.setString(1, car.getName());
            this.pstm.setString(2, car.getModel());
            this.pstm.setString(3, car.getPlate());
            this.pstm.setInt(5, car.getId());

            this.pstm.execute();
            this.pstm.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Carro Alterado Com Sucesso");
        }catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer connsulta" + Erro + "SQL" + qry);
        }
    }

    @Override
    public void delete(int id) {
        qry = "DELETE FROM cars WHERE id = ?";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);

            this.pstm.setInt(1, id);

            this.pstm.execute();
            this.pstm.close();
            conn.close();
            JOptionPane.showMessageDialog(null, "Carro Deletado Com Sucesso");
        }catch (SQLException Erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer consulta" + Erro + "SQL" + qry);
        }
    }

    @Override
    public List<Car> getCars() {
        List<Car> list = new ArrayList<>();   
        qry = "SELECT * FROM cars";
        
        try {
            conn = new ConnectionFactory().getConnection();
            pstm = conn.prepareStatement(qry);
            
            rs = pstm.executeQuery();
            while(rs.next()){
                list.add(
                    new Car(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("model"),
                        rs.getString("plate")
                    )
                );
            }
            this.pstm.close();
            conn.close();
        }catch(SQLException Erro){
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista" + Erro + "SQL" + qry);
        }

        return list;
    }
    
}