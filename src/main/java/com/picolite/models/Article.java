package com.picolite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="article")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="content")
    private String content;

    @Column(name="game_url")
    private String game_url;

    @OneToMany(mappedBy="article", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Comment> comments;

}
