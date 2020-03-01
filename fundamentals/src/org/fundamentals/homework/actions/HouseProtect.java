package org.fundamentals.homework.actions;

public interface HouseProtect extends Action{
    @Override
    default String action(){
        return "protecting house";
    }
}
