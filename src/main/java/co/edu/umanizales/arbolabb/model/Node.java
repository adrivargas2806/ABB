package co.edu.umanizales.arbolabb.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Node {
   private Person data;
    private Node left;
    private Node right;
    private int size;
    private int height;


    public boolean isLeaf() {
        if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPerson(){
        return getLeft() != null || getRight() != null;

    }
    public int count() {

        return 1 + (this.getLeft() != null ? this.getLeft().count() : 0) +
                (this.getRight() != null ? this.getRight().count() : 0);

    }

    public Node(Person data) {
        this.data = data;
        this.size = 1;
    }

    public void add(Person person){
        if(person.getId() < this.getData().getId()){
            if(this.getLeft() == null){
                setLeft(new Node(person));
            }
        }
        else{
            if(this.getRight() == null){
                setRight(new Node(person));
            } else{
                getRight().add(person);
            }
        }
        size++;
    }
    public String validateIdExist(Person person) {
        if (person.getId() == this.data.getId()) {
            return "El id ya existe";
        }
        if (person.getId() < this.data.getId() && this.left != null) {
            return this.left.validateIdExist(person);
        }

        if (person.getId() > this.data.getId() && this.right != null) {
            return this.right.validateIdExist(person);
        }
        return "Se agregó el id";
    }

    public void prune(){
        if(getLeft()!= null && getLeft().hasPerson()){
            getLeft().prune();
        }
        else{
            setLeft(null);
        }
        if(getRight() != null && getRight().hasPerson()){
            getRight().prune();
        }
        else {
            setRight(null);

        }
        size = count();
    }

    public int getHeight() {
        if (isLeaf()) {
            return 1;
        } else {
            int altizq = 1, altder = 1;
            if (this.left != null) {
                altizq = left.getHeight();
            }
            if (this.right != null) {
                altder = right.getHeight();
            }
            return altizq > altder ? altizq+1 : altder+1;
        }
    }

}

