package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DvdController {

    // 둘다 MVC 일 때
    @GetMapping("/dvds")
    public String dvdListPage(Model model) {

        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();
        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();

        model.addAttribute(dvd); // 객체
        model.addAttribute("names", List.of("김영희", "김익명", "김일희")); // 리스트
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3)); // 리스트
        model.addAttribute("title", "테스트 제목"); // 리터럴

        return "views/dvd_list"; // return에 views 파일경로를 사용함
    }

//    @GetMapping("/dvds")
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("views/dvd_list"); // ModelAndView를 이용해 setViewName 객체안에 views 파일경로를 사용함
//        return mav;
//
//    }

    @ResponseBody // 데이터 응답이 됨
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    // JSON으로 변환 시켜 응답함
    @ResponseBody // 안 붙이면 return 데이터 값을 불러오기 때문
    @GetMapping("/dvd")
    public Object getDvd() {
        Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작사").publisher("테스트 발행사").build();
        Dvd dvd2 = Dvd.builder().title("테스트2").producer("테스트 제작사2").publisher("테스트 발행사2").build();
        Dvd dvd3 = Dvd.builder().title("테스트3").producer("테스트 제작사3").publisher("테스트 발행사3").build();
        return List.of(dvd, dvd2, dvd3);
    }
}