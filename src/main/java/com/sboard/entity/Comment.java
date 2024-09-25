package com.sboard.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;

    private int parent;
    private String content;
    //private String writer;
    private String regip;

    @CreationTimestamp
    private LocalDateTime rdate;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User user;

    public String getRdate() {
        if (rdate != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return rdate.format(formatter);
        }
        return null;
    }
}