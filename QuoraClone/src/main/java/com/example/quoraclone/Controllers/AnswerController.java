package com.example.quoraclone.Controllers;

import com.example.quoraclone.dtos.AnswerDto;
import com.example.quoraclone.models.Answer;
import com.example.quoraclone.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }


    @GetMapping("/question/{questionid}")
    public List<Answer> getAnswersByQuestionId(@PathVariable Long questionid, @RequestParam int page, @RequestParam int pageSize) {
       return answerService.getAnswersByQuestionId(questionid, page, pageSize);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable Long id) {
        Answer answer = answerService.getAnswerById(id);
        if(answer != null){
            return new ResponseEntity<>(answer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @PostMapping
    public Answer createAnswer(@RequestBody AnswerDto answer) {
        return answerService.createAnswer(answer);
   }

   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
        return new ResponseEntity<>(HttpStatus.OK);
   }



}
