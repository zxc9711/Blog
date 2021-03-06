package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论类
 * @Author: antigenMHC
 * @Date: 2020/2/21 0:19
 * @Version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String headPicture;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creatTime;

    @ManyToOne
    private Blog blog;
    /**
     * 标记是否是管理员
     * */
    private boolean master;

    /**
     * 评论自关联的关系
     * 作为父类对象可以有一对多的关系
     * 因此父类对象是关系被维护方
     **/
    @OneToMany(mappedBy = "parentComment", fetch=FetchType.EAGER)
    private List<Comment> replayComments = new ArrayList<>();

    /**作
     * 为子类对象只能有一个父类，但子类可以是多个，
     * */
    @ManyToOne
    private Comment parentComment;

}
