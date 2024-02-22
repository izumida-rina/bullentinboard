// package com.bulletinboard.Service;

// import java.util.Date;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.validation.BindingResult;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.ModelAndView;

// import com.bulletinboard.entity.Bulletinboard;
// import com.bulletinboard.entity.Division;
// import com.bulletinboard.repository.BulletinboardRepository;
// import com.bulletinboard.repository.DivisionRepository;

// @Service
// public class CrudService {
//     @Autowired
//     BulletinboardRepository b_repos;

//     @Autowired
//     DivisionRepository d_repos;

//     /* 更新処理 */
//     @PostMapping("/create")
//     @Transactional(readOnly = false)
//     public ModelAndView save(@ModelAttribute("formModel") @Validated Bulletinboard bulletinboard,
//             BindingResult result) {
//         System.out.println("formModel: " + bulletinboard);

//         // エラーチェック
//         if (result.hasErrors()) {
//             ModelAndView mav = new ModelAndView();
//             mav.setViewName("new");
//             List<Division> list = d_repos.findAll();
//             mav.addObject("lists", list);
//             return mav;
//         }

//         bulletinboard.setCreateDate(new Date());
//         b_repos.saveAndFlush(bulletinboard);
//         return new ModelAndView("redirect:/list");
//     }

//     /* 削除処理 */
//     @PostMapping("/delete")
//     @Transactional(readOnly = false)
//     public ModelAndView delete(@RequestParam int id) {
//         b_repos.deleteById(id);
//         return new ModelAndView("redirect:/list");
//     }

// }
