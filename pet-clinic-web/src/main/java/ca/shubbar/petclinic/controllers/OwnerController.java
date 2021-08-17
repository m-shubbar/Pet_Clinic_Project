package ca.shubbar.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mustafa <codingbox@outlook.com>
 * Created at 2021-08-16
 */

// defining the root word
@RequestMapping("/owners")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(){
        return "owners/index";
    }
}
