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


public class FuncionarioDAO {
    public ArrayList<FuncionarioDTO> listarFuncionarios(){
        
        ArrayList<FuncionarioDTO> funcionarios = new ArrayList<>();
        
        String sql = "Select * From funcionario";
                
        Connection conn = new ConexaoDAO().conectaBD();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rset = ps.executeQuery();
            
            while (rset.next()){
                FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
                
                funcionarioDTO.setId(rset.getInt(1));
                funcionarioDTO.setNome(rset.getString(2));
                funcionarioDTO.setCargo(rset.getString(3));
                funcionarioDTO.setUsuario(rset.getString(4));
                funcionarioDTO.setSenha(rset.getString(5));
                
                funcionarios.add(funcionarioDTO);
            }
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null,"FucionarioDAO: " +e);
        }
        return funcionarios;
    }
    
    public void cadastrarFuncionario(FuncionarioDTO funcionarioDTO){
        String sql = "INSERT INTO funcionario (nome, cargo, usuario, senha) VALUES (?, ?, ?, ?);";
        
        Connection conn = new ConexaoDAO(). conectaBD();
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, funcionarioDTO.getNome());
            ps.setString(2, funcionarioDTO.getCargo());
            ps.setString(3, funcionarioDTO.getUsuario());
            ps.setString(4, funcionarioDTO.getSenha());
       
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO cadastrarFuncionario: " +e);
        }
    }
    

    
}
