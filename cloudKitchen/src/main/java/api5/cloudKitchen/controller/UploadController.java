package api5.cloudKitchen.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import api5.cloudKitchen.entity.EstoqueEntity;
import api5.cloudKitchen.entity.FornecedorEntity;
import api5.cloudKitchen.entity.InsumoEntity;
import api5.cloudKitchen.repository.CategoriaRepository;
import api5.cloudKitchen.repository.ConfeccaoRepository;
import api5.cloudKitchen.repository.EstoqueRepository;
import api5.cloudKitchen.repository.FornecedorRepository;
import api5.cloudKitchen.repository.FuncionarioRepository;
import api5.cloudKitchen.repository.InsumoRepository;
import api5.cloudKitchen.repository.ItemPedidoRepository;
import api5.cloudKitchen.repository.PedidoRepository;
import api5.cloudKitchen.repository.PratoRepository;
import api5.cloudKitchen.repository.ReservaRepository;
import api5.cloudKitchen.repository.StatusRepository;
import api5.cloudKitchen.repository.UnidadeRepository;

@CrossOrigin
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ConfeccaoRepository confeccaoRepository;

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PratoRepository pratoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;


    @PostMapping("/csv")
    public ResponseEntity<String> uploadCSV(@RequestParam("csvFile") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Selecione um arquivo CSV para fazer upload.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Ler o arquivo CSV
            InputStreamReader reader = new InputStreamReader(file.getInputStream());
            CSVReader csvReader = new CSVReader(reader);
            List<String[]> csvData = csvReader.readAll();

            // Processar os dados e inserir no banco de dados
            for (String[] row : csvData) {
                // Converte os dados do CSV para suas entidades
                InsumoEntity insumo = new InsumoEntity();
                insumo.setInsId(Long.parseLong(row[0]));
                insumo.setInsQtdEntrada(Float.parseFloat(row[1]));
                insumo.setInsValidade(Date.valueOf(row[2]));
                insumo.setInsDataHoraCompra(LocalDateTime.parse(row[3]));
                insumo.setInsValorCompra(Float.parseFloat(row[4]));
                insumo.setForId(FornecedorEntity.parse(row[5]));
                insumo.setEstId(EstoqueEntity.parse(row[6]));

                // Salva a entidade no banco de dados
                insumoRepository.save(insumo);
            }

            return new ResponseEntity<>("Upload e processamento de arquivo CSV bem-sucedidos.", HttpStatus.OK);
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ocorreu um erro durante o processamento do arquivo CSV.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
