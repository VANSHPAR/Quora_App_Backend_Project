package com.example.quoraclone.Controllers;

import com.example.quoraclone.dtos.TagDto;
import com.example.quoraclone.models.Tag;
import com.example.quoraclone.services.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {
    private final TagService tagService;


    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<Tag> getAllTags() {
      return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Long id) {
        Optional<Tag> tag=tagService.getTagById(id);
        return new ResponseEntity<>(tag.get(), HttpStatus.OK);
    }

    @PostMapping
    public Tag createTag(@RequestBody TagDto tagDto) {
        return tagService.createTag(tagDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTagById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
