package javapro.dz19;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

// Анотації для означення інструкцій тестування
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {
    int priority() default 5;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeSuite {
    int priority() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterSuite {
    int priority() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeEach {
    int priority() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BeforeAll {
    int priority() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AfterAll {
    int priority() default 0;
}

// Клас-тест для прикладу
class ExampleTest {
    @BeforeSuite(priority = 1)
    public static void beforeSuite() {
        System.out.println("BeforeSuite method");
    }

    @AfterSuite(priority = 1)
    public static void afterSuite() {
        System.out.println("AfterSuite method");
    }

    @BeforeEach(priority = 3)
    public void beforeEach() {
        System.out.println("BeforeEach method");
    }

    @BeforeAll(priority = 2)
    public static void beforeAll() {
        System.out.println("BeforeAll method");
    }

    @AfterAll(priority = 2)
    public static void afterAll() {
        System.out.println("AfterAll method");
    }

    @Test(priority = 5)
    public void test1() {
        System.out.println("Test 1");
    }

    @Test(priority = 7)
    public void test2() {
        System.out.println("Test 2");
    }

    @Test(priority = 4)
    public void test3() {
        System.out.println("Test 3");
    }
}

// Клас TestRunner для виконання методів-тестів
public class TestRunner {
    public static void start(Class<?> testClass) throws Exception {
        Method[] methods = testClass.getDeclaredMethods();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        Method[] beforeEachMethods = new Method[methods.length];
        Method[] beforeAllMethods = new Method[methods.length];
        Method[] afterAllMethods = new Method[methods.length];
        Method[] testMethods = new Method[methods.length];

        // Розподілити методи за анотаціями
        int beforeEachIndex = 0;
        int beforeAllIndex = 0;
        int afterAllIndex = 0;
        int testIndex = 0;
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeSuiteMethod != null) {
                    throw new Exception("BeforeSuite and AfterSuite should be present in a single instance");
                }
                beforeSuiteMethod = method;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (afterSuiteMethod != null) {
                    throw new Exception("BeforeSuite and AfterSuite should be present in a single instance");
                }
                afterSuiteMethod = method;
            } else if (method.isAnnotationPresent(BeforeEach.class)) {
                beforeEachMethods[beforeEachIndex++] = method;
            } else if (method.isAnnotationPresent(BeforeAll.class)) {
                beforeAllMethods[beforeAllIndex++] = method;
            } else if (method.isAnnotationPresent(AfterAll.class)) {
                afterAllMethods[afterAllIndex++] = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                testMethods[testIndex++] = method;
            }
        }

        // Сортування методів за пріоритетами
        Arrays.sort(testMethods, 0, testIndex, Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));
        Arrays.sort(beforeEachMethods, 0, beforeEachIndex, Comparator.comparingInt(m -> m.getAnnotation(BeforeEach.class).priority()));
        Arrays.sort(beforeAllMethods, 0, beforeAllIndex, Comparator.comparingInt(m -> m.getAnnotation(BeforeAll.class).priority()));
        Arrays.sort(afterAllMethods, 0, afterAllIndex, Comparator.comparingInt(m -> m.getAnnotation(AfterAll.class).priority()));

        // Виконання методів в потрібному порядку
        if (beforeSuiteMethod != null) {
            beforeSuiteMethod.invoke(null);
        }

        for (int i = 0; i < beforeAllIndex; i++) {
            beforeAllMethods[i].invoke(null);
        }

        for (int i = 0; i < testIndex; i++) {
            for (int j = 0; j < beforeEachIndex; j++) {
                beforeEachMethods[j].invoke(testClass.newInstance());
            }
            testMethods[i].invoke(testClass.newInstance());
        }

        for (int i = 0; i < afterAllIndex; i++) {
            afterAllMethods[i].invoke(null);
        }

        if (afterSuiteMethod != null) {
            afterSuiteMethod.invoke(null);
        }
    }

    public static void main(String[] args) throws Exception {
        start(ExampleTest.class);
    }
}

