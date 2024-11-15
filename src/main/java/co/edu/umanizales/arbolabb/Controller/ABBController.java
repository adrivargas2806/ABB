package co.edu.umanizales.arbolabb.Controller;

import co.edu.umanizales.arbolabb.model.Person;
import co.edu.umanizales.arbolabb.service.ABBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import co.edu.umanizales.arbolabb.model.Node;

@RestController
@RequestMapping("/abb")
public class ABBController {
    @Autowired
    private ABBService abbService;

    @GetMapping
    public Node abb(){
        return abbService.showPerson();
    }

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person){
        abbService.getAbb().add(person);
        return "OK";
    }
    @GetMapping("/valexi")
    public String val(@RequestBody Person person){
        return abbService.getAbb().valExi(person);
    }
    @GetMapping("/count")
    public int count(){
        return abbService.getAbb().count();
    }
    @GetMapping("/prune")
    public String prune(){
        abbService.getAbb().prune();
        return "Se podo";
    }

    @GetMapping("/height")
    public int calculateHeight(){
        return abbService.getAbb().calculateHeight();
    }

}
