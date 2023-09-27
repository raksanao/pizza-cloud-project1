package com.cydeo.pizzacloud.controller;

import com.cydeo.pizzacloud.bootstrap.DataGenerator;
import com.cydeo.pizzacloud.model.Pizza;
import com.cydeo.pizzacloud.repository.PizzaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;


@Controller
public class DesignPizzaController {

    private PizzaRepository pizzaRepository;

    public DesignPizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @PostMapping("/design")//i added designer
    public String showDesignForm(Model model) {

        model.addAttribute("cheeses", DataGenerator.cheeseTypeList);
        model.addAttribute("sauces", DataGenerator.sauceTypeList);
        model.addAttribute("toppings", DataGenerator.toppingTypeList);
        model.addAttribute("cheeseList", DataGenerator.cheeseTypeList);

        model.addAttribute("sauceList",DataGenerator.sauceTypeList);
        model.addAttribute("toppingList",DataGenerator.toppingTypeList);

        return "/design";

    }

    @PostMapping("/createPizza")
    public String processPizza(Pizza pizza) {

        pizza.setId(UUID.randomUUID());
        pizzaRepository.createPizza(pizza);

        return "redirect:/orders/current?pizzaId=" + pizza.getId();

    }

}
