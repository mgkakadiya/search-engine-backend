package com.searchEngine.repository;

import com.searchEngine.entity.SearchItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchItemRepository extends JpaRepository<SearchItem, Long> {

    Page<SearchItem> findByTitleStartsWithIgnoreCase(@Param("title") String title, Pageable pageable);

    Page<SearchItem> findByTitleContainsIgnoreCaseOrTagsContainsIgnoreCaseOrTextContainsIgnoreCase(@Param("title") String title, @Param("tags") String tags, @Param("text") String text, Pageable pageable);

}
