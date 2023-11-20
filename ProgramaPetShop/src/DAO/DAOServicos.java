package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import programapetshop.ClasseServicos;
import programapetshop.ConnectionFactory;
import java.sql.Timestamp;

public class DAOServicos {
    
    public void registrarServico(ClasseServicos servico) {
        
        String sql = "INSERT INTO servicos (nomeServico, precoServico, dataServico) VALUES (?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try {
            ps = ConnectionFactory.getConnection().prepareStatement(sql);
            ps.setString(1, servico.getNomeServico());
            ps.setFloat(2, servico.getPrecoServico());
            ps.setString(3, servico.getDataServico());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
