package api5.cloudKitchen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api5.cloudKitchen.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/media")
    public Double obterMediaDesempenhoRestaurante() {
        return feedbackService.obterMediaDesempenhoRestaurante();
    }

    @GetMapping("/quantidade-notas")
    public List<Object[]> obterQuantidadeNotasRestaurante() {
        return feedbackService.obterQuantidadeNotasRestaurante();
    }

}
