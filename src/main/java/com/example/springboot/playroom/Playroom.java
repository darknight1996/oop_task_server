package com.example.springboot.playroom;

import com.example.springboot.child.Child;
import com.example.springboot.exception.NotEnoughAgeException;
import com.example.springboot.exception.NotEnoughMoneyException;
import com.example.springboot.toy.AbstractToy;

import java.io.Serializable;
import java.util.List;

public class Playroom implements Serializable {

    private final String name;

    private final int minAge;

    private List<AbstractToy> toys;

    private Child child;

    public Playroom(String name, int minAge, List<AbstractToy> toys) {
        this.name = name;
        this.minAge = minAge;
        this.toys = toys;
    }

    private int getAvgToysPrice() {
        return toys.stream().mapToInt(AbstractToy::getCost).sum() / toys.size();
    }

    private boolean isEnoughMoney(int money) {
        return (money >= getAvgToysPrice());
    }

    private boolean isValidAge(int age) {
        return (age >= minAge);
    }


    public String getName() {
        return name;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) throws Exception {

        String SUCCESS = "You have successfully entered the room";

        if (!isEnoughMoney(child.getMoney())) {
            throw new NotEnoughMoneyException();
        }

        if (!isValidAge(child.getAge())) {
            throw new NotEnoughAgeException();
        }

        System.out.println(SUCCESS);
        this.child = child;
    }

    public List<AbstractToy> getToys() {
        return toys;
    }

    public void setToys(List<AbstractToy> toys) {
        this.toys = toys;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("playroom.Playroom: ").append(name).append("\n");
        stringBuffer.append("Min age: ").append(minAge).append("\n");
        stringBuffer.append("Avg toys price: ").append(getAvgToysPrice()).append("\n");
        stringBuffer.append("Toys: ").append("\n");
        toys.forEach(toy -> {
            stringBuffer.append("----------").append("\n");
            stringBuffer.append(toy);
        });
        return stringBuffer.toString();

    }

    public String treeContent() {
        String stringBuffer = name +
                ", min age: " + minAge +
                ", avg toys price: " + getAvgToysPrice();
        return stringBuffer;
    }
}
