package com.pawan.blog.Controllers;

import com.pawan.blog.Mapper.PostMapper;
import com.pawan.blog.Services.PostService;
import com.pawan.blog.Services.UserService;
import com.pawan.blog.domain.dtos.PostDto;
import com.pawan.blog.domain.entities.Post;
import com.pawan.blog.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false)UUID categoryId,
            @RequestParam(required = false)UUID tagId){
        List<Post> posts = postService.getAllPosts(categoryId,tagId);
        List<PostDto> postDtos = posts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostDto>> getDrafts(@RequestAttribute UUID userId){
            User loggedInUser = userService.getUserById(userId);
            List<Post> draftPosts = postService.getDraftPosts(loggedInUser);
            List<PostDto> postDtos = draftPosts.stream().map(postMapper::toDto).toList();
            return ResponseEntity.ok(postDtos);
    }
}
