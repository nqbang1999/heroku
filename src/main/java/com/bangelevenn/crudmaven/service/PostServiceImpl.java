package com.bangelevenn.crudmaven.service;


import com.bangelevenn.crudmaven.model.Post;
import com.bangelevenn.crudmaven.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;


    @Override
    public List<Post> findAllByDateDesc() {
        return postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Post> findPostsByTitleContaining(String title) {
        return postRepository.findPostsByTitleContaining(title);
    }

    @Override
    public Post findByIdPost(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }

}
