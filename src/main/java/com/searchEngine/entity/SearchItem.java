package com.searchEngine.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "search_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data

public class SearchItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "tags")
    private String tags;

    @Column(name = "submission_date")
    private Date submissionDate;

    @Column(name = "text")
    private String text;

    @Column(name = "url")
    private String url;

}
