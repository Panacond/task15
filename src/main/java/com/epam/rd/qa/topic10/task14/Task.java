package com.epam.rd.qa.topic10.task14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task {

    public static List<DiscountOwner> f(List<Supplier> supplierList, List<SupplierDiscount> supplierDiscountList) {
        return supplierDiscountList.stream()
        .map(a -> {
          for(SupplierDiscount i: supplierDiscountList) {
            if (a.getStoreName().equals(i.getStoreName())) {
              if (a.getDiscountPercentage() < i.getDiscountPercentage()) {
                a.setDiscountPercentage(i.getDiscountPercentage());
              }
              if (a.getCustomerID() > i.getCustomerID()) {
                a.setCustomerID(i.getCustomerID());
              }
            }
          }
          return a;
        })
        .distinct()
        .map(a -> {
          for (Supplier i : supplierList){
            if (i.getCustomerID().equals(a.getCustomerID())){
              return new DiscountOwner(a.getStoreName(), new Supplier(a.getCustomerID(), i.getYearOfBirth(), i.getStreetOfResidence()));
            }
          }
          return null;
        })
        .filter(a -> a!= null)
        .sorted((o1, o2) ->
            o1.getStoreName().compareTo(o2.getStoreName()))
        .collect(Collectors.toList());
  }

}

    public static void main(String[] args) {
        List<Supplier> supplierList = Arrays.asList(
                new Supplier(1, 1993, "Sumskaya"),
                new Supplier(2, 1994, "Pushkinskaya"),
                new Supplier(3, 1995, "Beketova"),
                new Supplier(4, 1996, "Amosova"),
                new Supplier(5, 1996, "Amosova")
        );
        List<SupplierDiscount> supplierDiscountList = Arrays.asList(
                new SupplierDiscount(1, 9, "Posad"),
                new SupplierDiscount(2, 9, "Posad"),
                new SupplierDiscount(11, 10, "Colins"),
                new SupplierDiscount(3, 10, "Colins"),
                new SupplierDiscount(4, 9, "Colins"),
                new SupplierDiscount(5, 10, "Denim")
        );
        // stream discountList
        // Optional: filter by existing suppliers
        // collect by max discount and min ID
        // map into DiscountOwner
        // sort by asc storeName
        // as list

        List<DiscountOwner> expected = Arrays.asList(
                new DiscountOwner("Colins", new Supplier(3, 1995, "Beketova")),
                new DiscountOwner("Denim", new Supplier(5, 1996, "Amosova")),
                new DiscountOwner("Posad", new Supplier(1, 1993, "Sumskaya"))
        );

        List<DiscountOwner> result = f(supplierList, supplierDiscountList);
        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(expected.get(i).equals(result.get(i)) + " ");
        }
    }

}
