package com.codegym.demo.controller;

import com.codegym.demo.model.Customer;
import com.codegym.demo.service.CustomerService;
import com.codegym.demo.service.CustomerTypeService;
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
@RequestMapping({"","/customer"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping({"", "/list"})
    public ModelAndView customerList(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("/customer/list", "customerList", customerService.findCustomer(pageable));
    }

    @GetMapping({"/create"})
//    Hien thi ra
    public ModelAndView customerCreate() {
        ModelAndView modelAndView = new ModelAndView("/customer/create");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
//    Xu ly
    public String cusCreate(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        } else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("messageCreate", "create success~");
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView customerEdit(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        modelAndView.addObject("customer", customerService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String customerDelete(@PathVariable String id) {
        customerService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(Pageable pageable, Model model, @RequestParam("search") String searchName) {
        Page<Customer> customerList = customerService.findAllByCustomer_nameContaining(pageable, searchName);
        model.addAttribute("customerList", customerList);
        return "/customer/search";
    }

    @GetMapping("/home")
        public String showHome(){
        return "back_group";
        }
}
