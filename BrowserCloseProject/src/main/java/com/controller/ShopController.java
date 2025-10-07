package com.controller;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemMaster;
import com.repository.ItemRepo;

@Controller
@RequestMapping("/form1")
public class ShopController {
	@Autowired
	 ItemRepo itemrepo;
	
    @GetMapping("/shop1")
    public ModelAndView showShopPage1(HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<ItemMaster>items = itemrepo.findByShopno(1);
        	mandv.addObject("items", items);
            mandv.setViewName("shop1");
        }
        return mandv;
    }
    @PostMapping("/shop1")
    public ModelAndView processShop1(@RequestParam MultiValueMap<String, String> allParams,HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<ItemMaster>items = itemrepo.findByShopno(2);
        	mandv.addObject("items", items);
            mandv.setViewName("shop2");
            
            List<ItemMaster> accumulatedItems = (List<ItemMaster>) session.getAttribute("selectedItems");
            if (accumulatedItems == null) {
                accumulatedItems = new ArrayList<>();
            }
            List<String> currentItemDescs = allParams.get("selectedItems");
            if (currentItemDescs != null) {
                for (String desc : currentItemDescs) {
                    ItemMaster item = itemrepo.findByItemdesc(desc);
                    if (item != null) {
                        accumulatedItems.add(item);
                    }
                }
            }
            
            session.setAttribute("selectedItems", accumulatedItems);
        }
        return mandv;
    }
    @GetMapping("/shop2")
    public ModelAndView showShopPage2(HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
        	List<ItemMaster>items = itemrepo.findByShopno(2);
        	mandv.addObject("items", items);
            mandv.setViewName("shop2");
        }
        return mandv;
    }
    @PostMapping("/shop2")
    public ModelAndView processShop2(@RequestParam MultiValueMap<String, String> allParams,HttpSession session) {
        ModelAndView mandv = new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
            mandv.setViewName("checkout");
            List<ItemMaster> accumulatedItems = (List<ItemMaster>) session.getAttribute("selectedItems");
            if (accumulatedItems == null) {
                accumulatedItems = new ArrayList<>();
            }
            List<String> currentItemDescs = allParams.get("selectedItems");
            if (currentItemDescs != null) {
                for (String desc : currentItemDescs) {
                    ItemMaster item = itemrepo.findByItemdesc(desc);
                    if (item != null) {
                        accumulatedItems.add(item);
                    }
                }
            }
            session.setAttribute("selectedItems", accumulatedItems);
        }
        return mandv;
    }
    
    @GetMapping("/checkout")
    public ModelAndView showCheckoutPage(HttpSession session) {
        ModelAndView mandv= new ModelAndView();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            mandv.setViewName("redirect:/form1/login");
        } else {
            List<ItemMaster> selectedItems = (List<ItemMaster>) session.getAttribute("selectedItems");
            double total = 0;
            if (selectedItems != null) {
                for (ItemMaster item : selectedItems) {
                    total += item.getItemprice();
                }
            }
            mandv.addObject("selectedItems", selectedItems);
            mandv.addObject("totalPrice", total);
            mandv.setViewName("checkout");
        }
        return mandv;
    }

   
}
