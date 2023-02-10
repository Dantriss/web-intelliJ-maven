package com.blog.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_idx;

    @Column(length = 100,nullable = false)
    private String title;

    @Lob
    private String content; //섬머노트 라이브러리 <html>태그가 섞여서 디자인됨

    @ColumnDefault("0")
    private int count;

    @ManyToOne //Mnay = board, one+ user
    @JoinColumn(name = "user_idx")
    private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 없다.

    @CreationTimestamp
    private Timestamp createDate;

}
