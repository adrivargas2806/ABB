package co.edu.umanizales.arbolabb.model;

import lombok.Data;


@Data
public class ABB {
    public Node root;

    public int count(){
        return root == null ? 0 : root.count();
    }
    public int calculateHeight(){
        return root == null ? 0 : root.getHeight();
    }

    public void add(Person person) {
        if (root == null) {
            root = new Node(person);
        }
        else {
            root.add(person);
        }
    }
    public String valExi(Person person) {
        return root.validateIdExist(person);

    }
    public void prune(){
        if(root !=null){
            root.prune();
        }
    }


}


