package com.pawan.blog.Services.Impl;

import com.pawan.blog.Services.TagService;
import com.pawan.blog.domain.entities.Tag;
import com.pawan.blog.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final TagRepository tagRepository;

    @Override
    public List<Tag> getTags(){
        return tagRepository.findAllWithPostCount();
    }
}
