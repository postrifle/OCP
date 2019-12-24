package OCP8.misc.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsBoundsExample {

    List<?> listOne = new ArrayList<Dog>();
    List<? extends Animal> listTwo = new ArrayList<Dog>();
    List<? super Cat> listThree = new ArrayList<Tiger>();

    Dog dog = new Dog();
    Cat cat = new Cat();
    Cat cat_1 = new Kitten();
    Kitten kitten = new Kitten();
    Tiger tiger = new Tiger();
    Cat cat_2 = (Cat) new Tiger();

    public void populateList() {
/* Unbounded generics immutable
        listOne.add(dog);  DOES NOT COMPILE  */
/* upper-Unbounded generics immutable
        listTwo.add(dog); DOESNT COMPILE*/

        listThree.add(cat);
        listThree.add(cat_1);
        listThree.add(kitten);
//        listThree.add(tiger);  DOESNT COMPILE
        listThree.add(cat_2);
    }

}
