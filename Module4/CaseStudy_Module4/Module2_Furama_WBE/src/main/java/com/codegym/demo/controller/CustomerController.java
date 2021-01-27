package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.repository.CustomerTypeRepository;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping({"","/customer"})
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping({"","/list"})
    public ModelAndView customerList(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("/customer/list", "customerList", customerService.findCustomer(pageable));
    }

    @GetMapping({"/create"})
//    Hien thi ra
    public ModelAndView customerCreate(){
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
//    Xu ly
    public String cusCreate(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("messageCreate", "create success~");
            return "redirect:/list";
        }
    }
}
