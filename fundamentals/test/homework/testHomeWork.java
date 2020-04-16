package homework;

import org.fundamentals.homework.animals.Cat;
import org.fundamentals.homework.animals.Dog;
import org.fundamentals.homework.animals.Hedgehog;
import org.fundamentals.homework.animals.Unknown;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class testHomeWork {
    static Cat cat;
    static Dog dog;
    static Hedgehog hedgehog;
    static Unknown unknown;

    @BeforeAll
    static void init() {
        cat = new Cat();
        dog = new Dog();
        hedgehog = new Hedgehog();
        unknown = new Unknown();
    }

    @Test
    public void hedgehogClass() {
        Assertions.assertEquals(Hedgehog.class, hedgehog.getClass());
    }

    @Test
    public void hedgehogName() {
        Assertions.assertEquals("Hedgehog", hedgehog.getAnimalName());
    }

    @Test
    public void hedgehogVoice() {
        Assertions.assertEquals("frr", hedgehog.animalVoice());
    }

    @Test
    public void hedgehogAction() {
        Assertions.assertEquals("catching mice", hedgehog.animalAction());
    }

    @Test
    public void unknownClass() {
        Assertions.assertEquals(Unknown.class, unknown.getClass());
    }

    @Test
    public void unknownName() {
        Assertions.assertEquals("Unknown animal", unknown.getAnimalName());
    }

    @Test
    public void unknownVoice() {
        Assertions.assertEquals("arrrrrr", unknown.animalVoice());
    }

    @Test
    public void unknownAction() {
        Assertions.assertEquals("tigdin-tigdin", unknown.animalAction());
    }

    @Test
    public void dogClass() {
        Assertions.assertEquals(Dog.class, dog.getClass());
    }

    @Test
    public void dogName() {
        Assertions.assertEquals("Dog", dog.getAnimalName());
    }

    @Test
    public void dogVoice() {
        Assertions.assertEquals("woof", dog.animalVoice());
    }

    @Test
    public void dogAction() {
        Assertions.assertEquals("protecting house", dog.animalAction());
    }

    @Test
    public void catClass() {
        Assertions.assertEquals(Cat.class, cat.getClass());
    }

    @Test
    public void catName() {
        Assertions.assertEquals("Cat", cat.getAnimalName());
    }

    @Test
    public void catVoice() {
        Assertions.assertEquals("meow", cat.animalVoice());
    }

    @Test
    public void catAction() {
        Assertions.assertEquals("catching mice", cat.animalAction());
    }
}
