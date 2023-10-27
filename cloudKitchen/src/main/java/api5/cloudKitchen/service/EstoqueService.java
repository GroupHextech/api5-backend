package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void avisoNivelBaixo() {
        // Execute a trigger do Oracle
        jdbcTemplate.execute("SELECT * FROM est_estoque WHERE est_qtd_estoque <= est_nivel_minimo");
    }

}
