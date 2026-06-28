package com.pawan.blog.Mapper;

import com.pawan.blog.domain.CreatePostRequest;
import com.pawan.blog.domain.UpdatePostRequest;
import com.pawan.blog.domain.dtos.CreatePostRequestDto;
import com.pawan.blog.domain.dtos.PostDto;
import com.pawan.blog.domain.dtos.UpdatePostRequestDto;
import com.pawan.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto dto);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "tagIds", target = "tagIds")
    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}