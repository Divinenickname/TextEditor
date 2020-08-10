package main.java;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private String text;
    private String pattern;
    private String regex;
    private int currentIndex;
    private boolean useRegEx = false;
    private List<Integer> indexes;

    public SearchEngine(String text, String pattern) {
        this.pattern = pattern;
        this.text = text;
        currentIndex = 0;
    }

    public SearchEngine(){};

    public void find(){
        indexes = new ArrayList<>();
        var ind = 0;

        while ((ind = text.indexOf(pattern, ind)) != -1){
            indexes.add(ind);
            System.out.println(ind);
            ind++;
        }

        System.out.println(indexes.size());
    }

    public void setUseRegEx(boolean useRegEx) {
        this.useRegEx = useRegEx;
    }

    public int getCurrentIndex(){
        if(indexes == null || indexes.size()==0){
            return -1;
        }

        return indexes.get(currentIndex);
    }

    public String getPattern(){
        return pattern;
    }

    public int previousIndex(){
        if(indexes == null || indexes.size()==0){
            return -1;
        }

        if(currentIndex>0){
            currentIndex--;
        }

        return indexes.get(currentIndex);
    }

    public int nextIndex(){
        if(indexes == null || indexes.size()==0){
            return -1;
        }

        if(currentIndex<indexes.size()-1){
            currentIndex++;
        }


        return indexes.get(currentIndex);
    }
}
