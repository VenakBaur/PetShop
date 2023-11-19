package DAO;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import programapetshop.ClasseCliente;
import programapetshop.ConnectionFactory;


public class DAOCliente {
    
    public void cadastrarCliente(ClasseCliente cliente) {
        
        String sql = "INSERT INTO cliente (nomeCliente, CPF, enderecoCliente, telefoneCliente) VALUES (?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = ConnectionFactory.getConnection().prepareStatement(sql);
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getCPF());
            ps.setString(3, cliente.getEnderecoCliente());
            ps.setLong(4, cliente.getTelefoneCliente());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
