package com.searchEngine;

import com.searchEngine.entity.SearchItem;
import com.searchEngine.repository.SearchItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class SearchEngineApplicationTests {

    @MockBean
    private SearchItemRepository searchItemRepository;

    @Test
    void contextLoads() {
        assert (searchItemRepository != null);

    }

    @Test
    void testSearchItemRepositoryMethodFindSearchSuggestion() throws Exception {

        SearchItem searchItem = new SearchItem(1, "keyword", "keyword", new Date(), "keyword", "keyword");
        List<SearchItem> searchItemsList = new ArrayList<>();
        searchItemsList.add(searchItem);
        Page<SearchItem> searchItemsPage = new PageImpl<>(searchItemsList);

        when(searchItemRepository.findByTitleStartsWithIgnoreCase(org.mockito.Matchers.isA(String.class),
                org.mockito.Matchers.isA(Pageable.class))).thenReturn(searchItemsPage);

        assert (searchItemRepository.findByTitleStartsWithIgnoreCase("zaphod", PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "title"))).getContent().size() == 1);
    }

    @Test
    void testSearchItemRepositoryMethodFindBySearchResult() throws Exception {

        SearchItem searchItem = new SearchItem(1, "zaphod", null, null, null, null);
        List<SearchItem> searchItemsList = new ArrayList<>();
        searchItemsList.add(searchItem);
        searchItemsList.add(searchItem);
        searchItemsList.add(searchItem);
        searchItemsList.add(searchItem);
        searchItemsList.add(searchItem);
        Page<SearchItem> searchItemsPage = new PageImpl<>(searchItemsList);

        when(searchItemRepository.findByTitleContainsIgnoreCaseOrTagsContainsIgnoreCaseOrTextContainsIgnoreCase(
                org.mockito.Matchers.isA(String.class),
                org.mockito.Matchers.isA(String.class),
                org.mockito.Matchers.isA(String.class),
                org.mockito.Matchers.isA(Pageable.class))).thenReturn(searchItemsPage);

        assert (searchItemRepository.findByTitleContainsIgnoreCaseOrTagsContainsIgnoreCaseOrTextContainsIgnoreCase("keyword",
                "keyword",
                "keyword",
                PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "title"))).getContent().size() == 5);

    }

}
