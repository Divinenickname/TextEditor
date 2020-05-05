package main.java;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private ArrayList<Integer> indexes;
    private String text;
    private String textToSearch;
    private int curIndex;

    public SearchEngine(String text, String textToSearch) {
        indexes = new ArrayList<>();
        this.textToSearch = textToSearch;
        this.text = text;
        curIndex = 0;
        findAllIndexes();
    }

    private void findAllIndexes(){
        int last = text.lastIndexOf(textToSearch);
        int index = 0;

        while (last!= -1 && index <= last){
            int currentIndex = text.indexOf(textToSearch, index);
            indexes.add(currentIndex);
            index = currentIndex + textToSearch.length();
        }
    }

    public int nextIndex(){
        if(indexes.size() != 0){
            if(curIndex < indexes.size()-1){
                curIndex++;
            }

            return indexes.get(curIndex);
        }
        else {
            return -1;
        }

    }

    public int prevIndex(){
        if(indexes.size() != 0){
            if(curIndex > 0){
                curIndex--;
            }

            return indexes.get(curIndex);
        }
        else {
            return -1;
        }
    }

    public int getTextLength(){
        return textToSearch.length();
    }

    public List<Integer> getIndexes(){
        return indexes;
    }

}
