package com.blog.table;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;


@Entity //Class User가 MySQL에 테이블이 생성됨
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@DynamicInsert insert시 null 인 필드를 제외시켜줌
public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라감
    private int user_idx; //Auto-increment

    @Column(nullable = false, length = 20) // not null
    private String user_id;

    @Column(nullable = false, length = 50) //not null (비밀번호 암호화)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

//    @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING) // db에는 EnumType이라는게 없기 때문에 해당 타입이 String 이라는 것을 지정해줘야함
    private RoleType role;

    @CreationTimestamp //시간이 자동 입력
    private Timestamp createDate;



}
