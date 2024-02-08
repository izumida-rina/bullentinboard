package com.bulletinboard.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.bulletinboard.entity.Bulletinboard;
import com.bulletinboard.repository.BulletinboardRepository;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class demo {
    @Autowired
    BulletinboardRepository repos;
    
    /* 一覧画面への遷移 */
    @GetMapping
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<Bulletinboard> list= repos.findAll();
        System.out.println(list);
        mav.setViewName("list");
        mav.addObject("data", list);
        return mav;
    }

    /* 新規画面への遷移 */
    @GetMapping("/add")
    ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        Bulletinboard data = new Bulletinboard();
        mav.addObject("formModel", data);
        mav.setViewName("new");
        return mav;
    }

    /* 編集画面への遷移 */
    @GetMapping("/edit")
    ModelAndView edit(@RequestParam int id) {
        ModelAndView mav = new ModelAndView();
        Bulletinboard data = repos.findById(id);
        mav.addObject("formModel", data);
        mav.setViewName("new");
        return mav;
    }

    /* 詳細画面への遷移 */
    @GetMapping("/detail")
    ModelAndView detail(@RequestParam int id) {
        System.out.println(id);
        ModelAndView mav = new ModelAndView();
        Bulletinboard data = repos.findById(id);
        System.out.println(data);
        mav.addObject("formModel", data);
        mav.setViewName("show");
        return mav;
    }

    /* 更新処理 */
    @PostMapping("/create")
    @Transactional(readOnly = false)
    public ModelAndView save(@ModelAttribute("formModel") Bulletinboard bulletinboard){
        System.out.println("formModel: " + bulletinboard);
        bulletinboard.setCreateDate(new Date());
        repos.saveAndFlush(bulletinboard);
        return new ModelAndView("redirect:/");
    }

    /* 削除処理 */
    @PostMapping("/delete")
    @Transactional(readOnly = false)
    public ModelAndView delete(@RequestParam int id){
        repos.deleteById(id);
        return new ModelAndView("redirect:/");
    }

    /* 初期データ */
    @PostConstruct
    public void init() {
        Bulletinboard create1 = new Bulletinboard();
        create1.setCreateDate(new Date());
        create1.setTitle("初投稿");
        create1.setContents("はじめまして！");
        create1.setCreateUser("田中");
        repos.saveAndFlush(create1);

        create1 = new Bulletinboard();
        create1.setCreateDate(new Date());
        create1.setTitle("ブログ");
        create1.setContents("こんにちは");
        create1.setCreateUser("高橋");
        repos.saveAndFlush(create1);
    }
}
