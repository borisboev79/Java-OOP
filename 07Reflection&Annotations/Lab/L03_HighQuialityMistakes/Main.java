package OOP.ReflectionAndAnnotations_Lab.L03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.TreeSet;

import static OOP.ReflectionAndAnnotations_Lab.L03_HighQualityMistakes.ReflectionUtils.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {

        Class reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        Field[] declaredFields = reflection.getDeclaredFields();

        TreeSet<Field> fields = collectByName(Arrays.stream(declaredFields));

        filterMembers(fields.stream(), f -> !Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println(f.getName() + " must be private!"));

        TreeSet<Method> getters = collectByName(filterMembersByName(methods, "get"));


        filterMembers(getters.stream(), g -> !Modifier.isPublic(g.getModifiers()))
                .forEach(g -> System.out.println(g.getName() + " have to be public!"));


        TreeSet<Method> setters = collectByName(filterMembersByName(methods, "set"));

        filterMembers(setters.stream(), s -> !Modifier.isPrivate(s.getModifiers()))
                .forEach(s -> System.out.println(s.getName() + " have to be private!"));


    }


}
