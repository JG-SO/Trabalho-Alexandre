/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.DAO;

import java.util.ArrayList;
import project.DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import project.DTO.InventarioDTO;

/**
 *
 * @author Nomewixuo
 */
public class InventarioDAO {
    public ArrayList<InventarioDTO> listarInventario(){
        
        ArrayList<InventarioDTO> inventario = new ArrayList<>();
        
        String sql = "Select * From inventario";
                
        Connection conn = new ConexaoDAO().conectaBD();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rset = ps.executeQuery();
            
            while (rset.next()){
                InventarioDTO inventarioDTO = new InventarioDTO();
                
                inventarioDTO.setId(rset.getInt(1));
                inventarioDTO.setNome(rset.getString(2));
                inventarioDTO.setData(rset.getString(3));
                inventarioDTO.setQuantidade(rset.getInt(4));
                inventarioDTO.setValor(rset.getString(5));
                
                inventario.add(inventarioDTO);
            }
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null,"InventarioDAO: " +e);
        }
        return inventario;
    }
    
    
}
