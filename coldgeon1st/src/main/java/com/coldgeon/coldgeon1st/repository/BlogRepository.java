package com.coldgeon.coldgeon1st.repository;

import com.coldgeon.coldgeon1st.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
