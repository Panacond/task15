# Discount owners

The purpose of this exercise is to train you to work with the Java 8 streams API.  
The estimated workload is *35 min*.

### Description

Please, proceed to `Task` class and implement its method

`public static List<DiscountOwner> f(List<Supplier> supplierList, List<SupplierDiscount> supplierDiscountList)`

Method must return a list of `DiscountOwner` objects by the following rules:
* each `DiscountOwner` object contains an information about a store and a customer who has the maximum discount in it;
* if there are several customers with the maximum discount, take the data of the customer with the minimum *id*;
* the list must be sorted in ascending order by store names.

Parameters:
* `supplierList` is a list of `Supplier` objects;
* `supplierDiscountList` is a list of `SupplierDiscount` objects.

> Also, it is necessary to implement `Task.main` method to demonstrate all the functionality.

Proceed to `Supplier` class and implement its content, it contains the following fields:
* `<customer_id>`, `<year_of_birth>`, `<street_of_residence>`.

Proceed to `SupplierDiscount` class and implement its content, it contains the following fields:
* `<customer_id>`, `<store_name>`, `<discount_percentage>`.

Proceed to `DiscountOwner` class and implement its content, it contains the following fields:
* `<store_name>`, `<supplier>`.

> Follow Java naming convention when you name fields.

### Details

* Function to implement must contain just only one return statement.
* Use one or more  Java 8 stream pipelines to create return value.

### Example

Input:

```
supplierList = [
Supplier(1, 1993, "Sumskaya")
Supplier(2, 1994, "Pushkinskaya")
Supplier(3, 1995, "Beketova")
Supplier(4, 1996, "Amosova")
Supplier(5, 1996, "Amosova")
]
supplierDiscountList = [
SupplierDiscount(1, 9, "Posad") 
SupplierDiscount(2, 9, "Posad") 
SupplierDiscount(3, 10, "Colins") 
SupplierDiscount(4, 10, "Colins") 
SupplierDiscount(5, 10, "Denim") 
]
```

Output:
```
[
("Colins", new Supplier(3, 1995, "Beketova"))
("Denim", new Supplier(5, 1996, "Amosova"))
("Posad", new Supplier(1, 1993, "Sumskaya")) 
]
```
