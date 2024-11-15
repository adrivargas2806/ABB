package co.edu.umanizales.arbolabb.service;

import co.edu.umanizales.arbolabb.model.ABB;
import co.edu.umanizales.arbolabb.model.Node;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ABBService {
    private ABB abb;
    private Node node;

    @PostConstruct
    public void init(){
        abb = new ABB();
    }
    public Node showPerson(){
            return abb.getRoot();
     }
}
