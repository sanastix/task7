package com.company.task7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Duplicates {

    //3. Есть List объектов, у каждого из которых 2 поля: int и String.
    // Удалить те, у которых значения int повторяются (оставить по одному из дубликатов).

    public static void main(String[] args) {

        List<Animal> list = new ArrayList<>();

        Animal cat1 = new Animal(5, "Murzik");
        list.add(cat1);
        Animal cat2 = new Animal(3, "Begemot");
        list.add(cat2);
        Animal dog1 = new Animal(5, "Bartolomew");
        list.add(dog1);
        Animal cat3 = new Animal(6, "Matroskin");
        list.add(cat3);
        Animal cat4 = new Animal(6, "Garfild");
        list.add(cat4);
        Animal cat5 = new Animal(10, "Leopold");
        list.add(cat5);
        Animal cat6 = new Animal(6, "Cheshir");
        list.add(cat6);
        Animal cat7 = new Animal(7, "Puss-in-Boots");
        list.add(cat7);
        Animal dog2 = new Animal(4, "Muhtar");
        list.add(dog2);
        Animal dog3 = new Animal(3, "Hatiko");
        list.add(dog3);
        Animal dog4 = new Animal(8, "Bim");
        list.add(dog4);
        Animal dog5 = new Animal(7, "Rex");
        list.add(dog5);
        Animal dog6 = new Animal(4, "Baskervill");
        list.add(dog6);
        Animal dog7 = new Animal(9, "Beethoven");
        list.add(dog7);
        Animal dog8 = new Animal(12, "Milo");
        list.add(dog8);
        Animal dog9 = new Animal(15, "Marley");
        list.add(dog9);

        Set<Animal> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);

    }

}
