package com.bulletinboard.Loader;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bulletinboard.entity.Bulletinboard;
import com.bulletinboard.entity.Division;
import com.bulletinboard.entity.Users;
import com.bulletinboard.repository.BulletinboardRepository;
import com.bulletinboard.repository.DivisionRepository;
import com.bulletinboard.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Component
public class initLoader {
    @Autowired
    private BulletinboardRepository bulletinboardRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        loadBulletinboardData();
        loadDivisionData();
        loadLoginUser();
    }

    /* listに表示させる初期データ */
    private void loadBulletinboardData() {
        Bulletinboard create1 = new Bulletinboard();
        create1.setCreateDate(new Date());
        create1.setTitle("初投稿");
        create1.setContents("はじめまして！");
        create1.setCreateUser("田中");
        create1.setDivision(1);
        bulletinboardRepository.saveAndFlush(create1);

        Bulletinboard create2 = new Bulletinboard();
        create2.setCreateDate(new Date());
        create2.setTitle("ブログ");
        create2.setContents("こんにちは");
        create2.setCreateUser("高橋");
        create2.setDivision(2);
        bulletinboardRepository.saveAndFlush(create2);
    }

    /* 分類データ */
    private void loadDivisionData() {
        Division div1 = new Division();
        div1.setId(0);
        div1.setName("通達/連絡");
        divisionRepository.saveAndFlush(div1);

        Division div2 = new Division();
        div2.setId(1);
        div2.setName("会議開催について");
        divisionRepository.saveAndFlush(div2);

        Division div3 = new Division();
        div3.setId(2);
        div3.setName("スケジュール");
        divisionRepository.saveAndFlush(div3);

        Division div4 = new Division();
        div4.setId(3);
        div4.setName("イベント");
        divisionRepository.saveAndFlush(div4);

        Division div5 = new Division();
        div5.setId(4);
        div5.setName("その他");
        divisionRepository.saveAndFlush(div5);
    }

    /* テストログインユーザー */
    public void loadLoginUser() {
        Users user1 = new Users();
        user1.setUsername("test");
        user1.setPassword(passwordEncoder.encode("test"));
        userRepository.saveAndFlush(user1);
    }

}
