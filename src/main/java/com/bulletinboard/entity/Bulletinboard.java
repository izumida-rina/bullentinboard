package com.bulletinboard.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "bulletinboard")
public class Bulletinboard {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private Date createDate;

    @Column(nullable = false)
    @NotEmpty(message = "タイトルを入力してください")
    @Size(max = 100, message = "タイトルは100文字以下で入力してください")
    private String title;

    @Column(nullable = false)
    @NotEmpty(message = "内容を入力してください")
    private String contents;

    @Column(nullable = false)
    @NotEmpty(message = "ユーザー名を入力してください")
    private String createUser;

    @Column(nullable = false)
    @NotNull(message = "部署を選択してください")
    private int division;
}
