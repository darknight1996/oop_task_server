package com.example.springboot.toy;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type1")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Ball.class, name = "ball"),
        @JsonSubTypes.Type(value = Car.class, name = "car"),
        @JsonSubTypes.Type(value = Cubes.class, name = "cubes"),
        @JsonSubTypes.Type(value = Doll.class, name = "doll")
})
public abstract class AbstractToy implements Serializable {

    private final int id;

    private final ToySize toySize;

    private final int cost;

    public AbstractToy(int id, ToySize toySize, int cost) {
        this.id = id;
        this.toySize = toySize;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public ToySize getToySize() {
        return toySize;
    }

    public int getCost() {
        return cost;
    }

    public String getType() {
        return this.getClass().getName().split("\\.")[1];
    }

    @Override
    public String toString() {
        return "Toy type: " + this.getType()
                + "\nToy cost: " + this.getCost()
                + "\nToy size: " + this.getToySize() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractToy that = (AbstractToy) o;
        return cost == that.cost && toySize == that.toySize;
    }

}
