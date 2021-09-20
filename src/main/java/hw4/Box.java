package hw4;

import hw4.fruit.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<Fruit> fruitArrayList = new ArrayList<>();

    public Float getWeight(){
        return fruitArrayList.size()*T.getWeight();
    }

    public boolean compare(Box<Fruit> anotherBox){
        return getWeight().equals(anotherBox.getWeight());
    }

    public void transfer(Box<T> anotherBox){
        anotherBox.fruitArrayList.addAll(fruitArrayList);
        fruitArrayList.clear();
    }

    public void addFruit(T fruit){
        fruitArrayList.add(fruit);
    }
}
