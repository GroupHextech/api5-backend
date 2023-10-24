package api5.cloudKitchen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void executarTrigger() {
        // Execute a trigger do Oracle
        jdbcTemplate.execute("BEGIN EXECUTE t_comparar_estoque; END;");
    }

}
