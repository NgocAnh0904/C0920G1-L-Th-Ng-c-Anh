package com.codegym.demo.controller;

import com.codegym.demo.model.Question;
import com.codegym.demo.service.QuestionService;
import com.codegym.demo.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping({"","/question"})
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuestionTypeService questionTypeService;

    @GetMapping({ "/list"})
    public ModelAndView questionList(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("/question/list", "questionList", questionService.findCustomer(pageable));
    }

    @GetMapping({"/create"})
    public ModelAndView questionCreate() {
        ModelAndView modelAndView = new ModelAndView("/question/create");
        modelAndView.addObject("questionTypes", questionTypeService.findAll());
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @PostMapping("/create")
    public String QusCreate(@Valid @ModelAttribute Question question, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println('á');
            model.addAttribute("questionTypes", questionTypeService.findAll());
            return "question/create";
        } else {
            questionService.save(question);
            redirectAttributes.addFlashAttribute("messageCreate", "create success~");
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView QusEdit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/question/edit");
        modelAndView.addObject("questionTypes", questionTypeService.findAll());
        modelAndView.addObject("question", questionService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String QusDelete(@PathVariable String id) {
        questionService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(Pageable pageable, Model model, @RequestParam("search") String searchName) {
        Page<Question> questionList = questionService.findAllByQuestion_nameContaining(pageable, searchName);
        model.addAttribute("questionList", questionList);
        return "/question/search";
    }

    @GetMapping("/home")
    public String showHome(){
        return "back_group";
    }
}
