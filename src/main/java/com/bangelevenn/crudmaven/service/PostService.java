package com.bangelevenn.crudmaven.service;

import com.bangelevenn.crudmaven.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface PostService {
    List<Post> findAllByDateDesc();

    List<Post> findPostsByTitleContaining(String title);

    Post findByIdPost(Long id);

    Post save(Post post);

    void delete(long id);
}
