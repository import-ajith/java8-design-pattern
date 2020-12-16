package com.design.comparator;

import com.design.chaining.function.Function;
import com.design.comparator.model.Person;
import com.design.comparator.util.Comparator;

/**
 * @author Ajithlal
 */
public class PlayWithComparator {
    public static void main(String[] args) {
        Person person1=new Person(21,"Ajith");
        Person person2=new Person(22,"Vinay");
        Person person3=new Person(23,"Prasobh");
        Person person4=new Person(24,"Ajith");

        Function<Person,String> getName=p -> p.getName();
        Function<Person,Integer> getAge=p -> p.getAge();

        /*Comparator<Person> comp=(p1,p2)->{
               *//* String name1=p1.getName();
                String name2=p2.getName();*//*
            String name1=extract.apply(p1);
            String name2=extract.apply(p2);
                return name1.compareTo(name2);
        };*/


        Comparator<Person> compName= Comparator.comparing(getName);
        Comparator<Person> compAge= Comparator.comparing(getAge);

        /*same name different age*/
       /* Comparator<Person> compNameAge= compName.thenComparing(compAge);*/

        /*compact code*/
        Comparator<Person> compNameAge= Comparator
                                            .comparing(Person :: getName)
                                            .thenComparing(Person :: getAge);




        Comparator<Person> compReverse=compName.reversed();

        System.out.println("Ajith > Vinay : "+(compName.compare(person1,person2)>0));
        System.out.println("Prasobh > Ajith : "+(compName.compare(person3,person1)>0));
        System.out.println("Vinay > Prasobh : "+(compName.compare(person2,person3)>0));


        System.out.println("Ajith > Ajith 24 : "+(compNameAge.compare(person1,person4)>0));

        System.out.println("Ajith > Vinay : Reverse "+(compAge.compare(person1,person2)>0));
        System.out.println("Prasobh > Ajith : Reverse "+(compAge.compare(person3,person1)>0));
        System.out.println("Vinay > Prasobh : Reverse "+(compAge.compare(person2,person3)>0));

    }
}
