package com.coldgeon.coldgeon1st.service;

import com.coldgeon.coldgeon1st.domain.Article;
import com.coldgeon.coldgeon1st.dto.AddArticleRequest;
import com.coldgeon.coldgeon1st.dto.UpdateArticleRequest;
import com.coldgeon.coldgeon1st.repository.BlogRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가하는 메서드
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // findAll 이용해서 제엔부 가져올 것.
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    //findbyid로 id에 해당하는 값만 찾기
    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    // delete는 간단하쥬
    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
        article.update(request.getTitle(), request.getContent());

        return article;

    }

}
