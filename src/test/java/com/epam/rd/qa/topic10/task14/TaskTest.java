package com.epam.rd.qa.topic10.task14;

import java.util.*;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import spoon.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.visitor.filter.TypeFilter;

/**
 * @author D. Kolesnikov
 */
public class TaskTest {

	@ParameterizedTest
	@CsvFileSource(resources = "data.csv", delimiter = ';')
	void test(String supplierLine, String supplierDiscountLine, String expectedLine) {

		List<Supplier> supplierList = Arrays.stream(supplierLine.split("\\s+"))
			.map(String::trim)
			.map(s -> s.split("~"))
			.map(br -> new Supplier(
					Integer.parseInt(br[0]),
					Integer.parseInt(br[1]),
					br[2]))
			.collect(Collectors.toList());

		List<SupplierDiscount> supplierDiscountList = 
				Arrays.stream(supplierDiscountLine.split("\\s+"))
			.map(String::trim)
			.map(s -> s.split("~"))
			.map(br -> new SupplierDiscount(
					Integer.parseInt(br[0]),
					Integer.parseInt(br[1]),
					br[2]))
			.collect(Collectors.toList());

		List<DiscountOwner> expected = Arrays.stream(expectedLine.split("\\s+"))
				.map(String::trim)
				.map(s -> s.split(":"))
				.map(br -> new DiscountOwner(br[0], createSupplier(br[1])))
				.collect(Collectors.toList());

		List<DiscountOwner> actual = Task.f(supplierList, supplierDiscountList);

		for (int j = 0; j < expected.size(); j++) {
			Assertions.assertThat(actual.get(j))
				.usingRecursiveComparison()
				.isEqualTo(expected.get(j));
		}
		
	}
		
	private static Supplier createSupplier(String supplierLine) {
		String[] ar = supplierLine.split("~");
		return new Supplier(Integer.parseInt(ar[0]),
				Integer.parseInt(ar[1]), ar[2]);
	}
		
	@Test
	void testMain() {
		Task.main(null);
	}

	@Test
	void testCompliance() {
		String packagePath = Task.class.getPackage()
			.getName()
			.replace('.', '/');
		String taskFile = "src/main/java/" + packagePath + "/Task.java";

		SpoonAPI spoon = new Launcher();
		spoon.addInputResource(taskFile);
		spoon.buildModel();

		List<CtMethod<?>> methods = spoon.getModel()
			.getElements(new TypeFilter<>(CtMethod.class));
		Assert.assertEquals("There are must be only two methods: 'main' and 'f'", 2, methods.size());

		methods.stream()
			.filter(m -> m.getSimpleName()
				.equals("f"))
			.findAny()
			.ifPresentOrElse(m -> Assert.assertEquals("Method 'f' must contain only one (return) statement", 1,
					m.getBody()
						.getStatements()
						.size()),
					() -> Assert.fail("There is must be method with name 'f'"));
	}

}
