package com.pawan.blog.Controllers;

import com.pawan.blog.Mapper.PostMapper;
import com.pawan.blog.Services.PostService;
import com.pawan.blog.Services.UserService;
import com.pawan.blog.domain.CreatePostRequest;
import com.pawan.blog.domain.UpdatePostRequest;
import com.pawan.blog.domain.dtos.CreatePostRequestDto;
import com.pawan.blog.domain.dtos.PostDto;
import com.pawan.blog.domain.dtos.UpdatePostRequestDto;
import com.pawan.blog.domain.entities.Post;
import com.pawan.blog.domain.entities.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @Valid @RequestBody CreatePostRequestDto createPostRequestDto,
            @RequestAttribute UUID userId){
        User loggedInUser = userService.getUserById(userId);
        CreatePostRequest createPostRequest = postMapper.toCreatePostRequest(createPostRequestDto);
        Post createdPost = postService.createPost(loggedInUser, createPostRequest);
        PostDto createdPostDto = postMapper.toDto(createdPost);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDto> updatePost(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePostRequestDto updatePostRequestDto){
        UpdatePostRequest updatePostRequest = postMapper.toUpdatePostRequest(updatePostRequestDto);

        Post updatePost = postService.updatePost(id, updatePostRequest);
        PostDto updatedPostDto = postMapper.toDto(updatePost);
        return ResponseEntity.ok(updatedPostDto);
    }
}
