package com.picolite.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.picolite.models.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name="comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="content")
    private String content;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="article_id", nullable = false)
    private Article article;

}
