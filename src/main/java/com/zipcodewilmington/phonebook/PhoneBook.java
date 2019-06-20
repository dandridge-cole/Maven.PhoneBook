package com.zipcodewilmington.phonebook;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook{//<T extends Map<String,List<String>>>{
    Map<String,List<String>> pb;

    public PhoneBook(Map<String,List<String>> map) {
        this.pb = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<String,List<String>>());
    }

    public void add(String name, String phoneNumber) {
        List<String> list = new ArrayList<String>(1);
        list.add(phoneNumber);
        this.pb.put(name, list);
    }

    public void addAll(String name, String... phoneNumbers) {
        this.pb.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        this.pb.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.pb.containsKey(findPBEntry(name)); // needs to work for both name and numbers
    }

    public List<String> lookup(String name) {
        return this.pb.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        return findPBEntry(phoneNumber);
    }

    public List<String> getAllContactNames() {
      //  List<String> al = new ArrayList(this.pb.keySet());
      //  Collections.sort(al);
     //   Collections.reverse(al);
        return new ArrayList(this.pb.keySet());
    }

    public Map<String, List<String>> getMap() {
        return this.pb;
    }

    public String findPBEntry(String str){
        for(Map.Entry<String,List<String>> entry:pb.entrySet()){
            for(String pn:entry.getValue()){
                if(str.equals(pn))return entry.getKey();
            }
        }
        return str; // search thru phone numbers and return string name, or return strwww.
    }
}
