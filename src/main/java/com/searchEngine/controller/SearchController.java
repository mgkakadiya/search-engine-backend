package com.searchEngine.controller;

import com.searchEngine.entity.SearchItem;
import com.searchEngine.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping(value = "/suggestion", produces = MediaType.APPLICATION_JSON)
    public List<SearchItem> findSuggestion(@RequestParam(value = "keyword", required = true) String keyword,
                                           @RequestParam(value = "page", required = true) int pageNo,
                                           @RequestParam(value = "pageSize", required = true) int pageSize) throws Exception {
        List<SearchItem> list = searchService.findSuggestionByKeyword(keyword, pageNo, pageSize);
        return list;
    }

    @GetMapping(value = "/result", produces = MediaType.APPLICATION_JSON)
    public Page<SearchItem> findResult(@RequestParam(value = "keyword", required = true) String keyword,
                                       @RequestParam(value = "page", required = true) int pageNo,
                                       @RequestParam(value = "pageSize", required = true) int pageSize) throws Exception {
        return searchService.findResultByKeyword(keyword, pageNo, pageSize);
    }
}
