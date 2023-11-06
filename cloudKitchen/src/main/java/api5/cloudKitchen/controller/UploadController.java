package api5.cloudKitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import api5.cloudKitchen.service.InsumoService;
@CrossOrigin
@RestController
public class UploadController {

    private final InsumoService insumoService; 

    @Autowired
    public UploadController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @PostMapping("/upload")
    public String uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                insumoService.processarCSV(file.getInputStream());
                return "CSV carregado e processado com sucesso!";
            } catch (Exception e) {
                e.printStackTrace();
                return "Erro ao processar o CSV: " + e.getMessage();
            }
        } else {
            return "Arquivo CSV não fornecido ou vazio.";
        }
    }
}