package hu.uni.eszterhazy;

import hu.uni.eszterhazy.warehouse.demos.*;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Demo> demoList = new ArrayList<>();
        demoList.add(new OrderDemo());
        demoList.add(new SupplyDemo());
        demoList.add(new InventoryManagementDemo());
        demoList.add(new FactoryDemo());

        for (Demo demo : demoList) {
            demo.demo();
        }
    }
}
