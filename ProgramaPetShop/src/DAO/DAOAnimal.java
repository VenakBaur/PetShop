package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import programapetshop.ClasseAnimal;
import programapetshop.ConnectionFactory;

public class DAOAnimal {

    public void cadastrarAnimal(ClasseAnimal animal) {

        String sql = "INSERT INTO animal(nome, especie, raca, idade, historicoMedico, tutor) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = ConnectionFactory.getConnection().prepareStatement(sql);
            ps.setString(1, animal.getNome());
            ps.setString(2, animal.getEspecie());
            ps.setString(3, animal.getRaca());
            ps.setLong(4, animal.getIdade());
            ps.setString(5, animal.getHistoricoMedico());
            ps.setString(6, animal.getTutor());

            ps.execute();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
