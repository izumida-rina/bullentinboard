package com.bulletinboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.bulletinboard.Service.CrudService;
import com.bulletinboard.entity.Bulletinboard;
import com.bulletinboard.entity.Division;
import com.bulletinboard.repository.BulletinboardRepository;
import com.bulletinboard.repository.DivisionRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class demoController {
    @Autowired
    BulletinboardRepository b_repos;

    @Autowired
    DivisionRepository d_repos;

    @Autowired
    CrudService crudService;

    /* 一覧画面への遷移 */
    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<Bulletinboard> list = b_repos.findAll();
        //System.out.println(list);
        mav.setViewName("list");
        mav.addObject("data", list);
        return mav;
    }

    /* タイトルあいまい検索 */
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String keyword) {
        System.out.println(keyword);
        ModelAndView mav = new ModelAndView();
        // タイトルあいまい検索を実行し、結果を取得する
        List<Bulletinboard> searchResults = b_repos.findByTitleContaining(keyword);
        System.out.println(searchResults);
        mav.addObject("data", searchResults);
        mav.setViewName("list");
        return mav;
    }

    /* 新規画面への遷移 */
    @GetMapping("/add")
    ModelAndView add() {
        ModelAndView mav = new ModelAndView();
        Bulletinboard data = new Bulletinboard();
        mav.addObject("formModel", data);
        mav.setViewName("new");
        List<Division> list = d_repos.findAll();
        mav.addObject("lists", list);
        return mav;
    }

    /* 編集画面への遷移 */
    @GetMapping("/edit")
    ModelAndView edit(@RequestParam int id) {
        ModelAndView mav = new ModelAndView();
        Bulletinboard data = b_repos.findById(id);
        mav.addObject("formModel", data);
        mav.setViewName("new");
        List<Division> list = d_repos.findAll();
        mav.addObject("lists", list);
        return mav;
    }

    /* 詳細画面への遷移 */
    @GetMapping("/detail")
    ModelAndView detail(@RequestParam int id) {
        System.out.println(id);
        ModelAndView mav = new ModelAndView();
        Bulletinboard data = b_repos.findById(id);
        System.out.println(data);
        mav.addObject("formModel", data);
        Division div = d_repos.findById(data.getDivision());
        mav.addObject("div", div);
        mav.setViewName("show");
        return mav;
    }

}
