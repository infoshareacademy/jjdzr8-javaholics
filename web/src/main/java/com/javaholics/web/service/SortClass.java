package com.javaholics.web.service;

public class SortClass {
    private int[] tab;

    public SortClass(int[] tab){
        this.tab=tab;
    }

    public void setTab(int[] tab) {
        this.tab = tab;
    }

    public int[] getTab() {
        return tab;
    }
    public void sortArrayDetails(){

        int temp;
        for (int j = 0; j < tab.length ; j++) {

        for (int i = 0; i < tab.length-1 ; i++) {
            if (tab[i]>tab[i+1]) {
                temp=tab[i+1];
                tab[i+1]=tab[i];
                tab[i]=temp;
            }
        }
        }

    }
}
