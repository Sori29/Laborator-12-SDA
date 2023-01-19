package com.example.laborator12;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class ListaMosului {
        private Map<String, List<Student>> mapNume = new TreeMap<>();
        private Map<Double, List<Student>> mapMedie = new TreeMap<>();
        private Map<String, List<Student>> mapLocalitate = new TreeMap<>();
        public ListaMosului ( File f ) {
            // DE COMPLETAT
        }
        public ListaMosului() {
            for (Student s : exempluDeTest()) {
                inscrieInListaMosului(s);
            }
        }
        public void inscrieInListaMosului(Student s) {
            adaugaInMap(mapNume, s.getNume(), s);
            adaugaInMap(mapMedie, s.getMedie(), s);
            adaugaInMap(mapLocalitate, s.getLocalitate(), s);
        }
        public <K,E> void adaugaInMap(Map<K, List<E>> map, K cheie, E element) {
            List<E> lst = map.get(cheie);
            if (lst == null) {
                lst = new ArrayList<>();
                map.put(cheie, lst);
            }
            lst.add(element);
        }
        private List<Student> exempluDeTest() {
            Student[] lstStud = new Student[]{new Student("Ionel", 6.55, "Suceava"),
                    new Student("Viorel", 7.45, "Suceava"),
                    new Student("Violeta", 6.55, "Radauti"),
                    new Student("Elena", 8.25, "Cajvana"),
                    new Student("Mariana", 9.75, "Suceava"),
                    new Student("Costel", 6.55, "Radauti"),
                    new Student("Ionel", 8.25, "Cajvana"),
                    new Student("Violeta", 8.55, "Campulung Moldovenesc"),
                    new Student("Ioana", 8.35, "Vatra-Dornei")};
            return Arrays.asList(lstStud);
        }
        public Map<String, List<Student>> getMapNume() {
            return mapNume;
        }
        public Map<Double, List<Student>> getMapMedie() {
            return mapMedie;
        }
        public Map<String, List<Student>> getMapLocalitate() {
            return mapLocalitate;
        }
}
