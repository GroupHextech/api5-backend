package api5.cloudKitchen.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;ploadController {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("csvFile") MultipartFile file) {
        // Processar o arquivo CSV aqui e salvar os dados no banco de dados
        // Lembre-se de lidar com exceções e validações adequadas

        return ResponseEntity.ok("Arquivo CSV foi carregado e processado com sucesso.");
    }
}
    
}
