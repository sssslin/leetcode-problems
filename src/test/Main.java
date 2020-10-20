package test;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        runSolution("addTwoNumbers");
    }

    private static void runSolution(String solutionName) {
        System.out.println("running " + solutionName);
        String className = "com.tags.list" + "." + solutionName + ".Solution";
        try {
            Class<?> clazz = Class.forName(className);
            BaseSolution solution = (BaseSolution) clazz.newInstance();
            Method isFuncTest = clazz.getMethod("isFunctionalTestCase");
            if ((boolean) isFuncTest.invoke(solution)) {
                solution.runFuncTestCases();
            } else {
                solution.runTestCases();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
