package com.twu.biblioteca;

import java.util.List;

public class SelectChioceProcessor implements SelectChioce {
    private List<SelectChioce> selectChioceList;
    public SelectChioceProcessor(List<SelectChioce> selectChioceList){
        this.selectChioceList = selectChioceList;
    }
    @Override
    public void selectOneChoice(String choose) {
       for(SelectChioce selectChioce:selectChioceList){
           selectChioce.selectOneChoice(choose);
       }
    }
}
