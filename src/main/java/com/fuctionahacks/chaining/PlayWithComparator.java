package com.fuctionahacks.chaining;

import java.util.function.Function;

import com.fuctionahacks.chaining.model.Person;
import com.fuctionahacks.chaining.util.Comparator;

public class PlayWithComparator {


    public static void main(String[] args) {


        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 72);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 40);
        Person jamesSr = new Person("James", 78);

        Function<Person, String> getName = Person::getName;
        Function<Person, Integer> getAge = Person::getAge;

        Comparator<Person> comparatorPerson = (p1, p2) -> getName.apply(p1).compareTo(getName.apply(p2));
        Comparator<Person> comparatorPersonCompose = Comparator.comparing(getName);
        Comparator<Person> comparatorPersonReversed = comparatorPersonCompose.reversed();
        Comparator<Person> comparatorAge = Comparator.comparing(getAge);
        Comparator<Person> ageAndNameComparator = comparatorPersonCompose.thenComparing(comparatorAge);

        System.out.println("Age Mary > John " + (comparatorAge.compare(mary, john) > 0));
        System.out.println("Age John >  Mary " + (comparatorAge.compare(john, mary) > 0));
        System.out.println("Mary > John " + (comparatorPersonCompose.compare(mary, john) > 0));
        System.out.println("John > James " + (comparatorPerson.compare(john, james) > 0));
        System.out.println("Linda > John " + (comparatorPerson.compare(linda, john) > 0));

        System.out.println("Reverse Mary > John " + (comparatorPersonReversed.compare(mary, john) > 0));
        System.out.println("Reverse John > James " + (comparatorPersonReversed.compare(john, james) > 0));
        System.out.println("Name and Age James Sr > James " + (ageAndNameComparator.compare(linda, john) > 0));
    }
}
