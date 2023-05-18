package com.geekster.WeeklyTest_Instagram.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentBody;

    @ManyToOne
    @JoinColumn(nullable = false,name = "jk_post_id")
    private Post post;
}
