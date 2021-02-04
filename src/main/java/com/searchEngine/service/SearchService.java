package com.searchEngine.service;

import com.searchEngine.entity.SearchItem;
import com.searchEngine.repository.SearchItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchService {

    @Autowired
    SearchItemRepository searchItemRepository;

    public List<SearchItem> findSuggestionByKeyword(String keyword, int pageNo, int pageSize) {
        //default dropdown menu item length is 10
        Page page = searchItemRepository.findByTitleStartsWithIgnoreCase(keyword, PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, "title")));
        return page.getContent();
    }

    public Page<SearchItem> findResultByKeyword(String keyword, int pageNo, int pageSize) {
        return searchItemRepository.findByTitleContainsIgnoreCaseOrTagsContainsIgnoreCaseOrTextContainsIgnoreCase(keyword, keyword, keyword, PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.ASC, "title")));
    }
}
