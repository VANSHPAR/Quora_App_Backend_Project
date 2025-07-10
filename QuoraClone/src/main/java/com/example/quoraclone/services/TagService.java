package com.example.quoraclone.services;

import com.example.quoraclone.Repositories.TagRepository;
import com.example.quoraclone.dtos.TagDto;
import com.example.quoraclone.models.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TagService {

    private final TagRepository tagRepository;


    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Tag createTag(TagDto tagDto){
        Tag tag=new Tag();
        tag.setName(tagDto.getName());
        return tagRepository.save(tag);

    }

    public void deleteTagById(Long id){
        tagRepository.deleteById(id);
    }

    public Optional<Tag> getTagById(Long id){
        return tagRepository.findById(id);
    }
}
