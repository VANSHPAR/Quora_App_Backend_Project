package com.example.quoraclone.Controllers;

import com.example.quoraclone.models.Answer;
import com.example.quoraclone.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;




    @GetMapping("/question/{questionid}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long id, @RequestParam int page, @RequestParam int pageSize) {
       return answerService.getAnswersByQuestionId(id, page, pageSize);
    }





}
