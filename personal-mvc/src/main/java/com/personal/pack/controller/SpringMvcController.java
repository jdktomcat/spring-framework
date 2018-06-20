package com.personal.pack.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类描述：SpringMVC测试控制器
 *
 * @author 汤旗
 * @date 2018-06-20
 */
@RequestMapping("/mvc")
public class SpringMvcController {

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    @ResponseBody
    public String test(@RequestParam(value = "id", required = false) Integer id) {
        return "mvctest";
    }

    @RequestMapping(value = "/view", method = {RequestMethod.GET})
    public ModelAndView view(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView view = new ModelAndView();
        view.setViewName("mvc");
        return view;
    }
}
