package com.cydeo.pizzacloud.model;

import com.cydeo.pizzacloud.enums.Cheese;
import com.cydeo.pizzacloud.enums.Sauce;
import com.cydeo.pizzacloud.enums.Topping;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pizza {

    private UUID id;
    private List<Cheese> cheeseList;
    private List<Sauce> sauceList;
    private List<Topping> toppingList;

}
