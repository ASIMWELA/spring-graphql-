package com.graphql.tuts;

public class PetAbA extends PetAb implements Pet{
    @Override
    public void makeSound() {
        System.out.println("meow");
    }
}
