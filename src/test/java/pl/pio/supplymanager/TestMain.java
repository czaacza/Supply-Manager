package pl.pio.supplymanager;

public class TestMain {
    public static void main(String[] args) {
        AppDBTest appDBTest = new AppDBTest();
        appDBTest.readProductsFromFile_Test();
        appDBTest.readProductionsFromFile_Test();
        appDBTest.readCategoriesFromFile_Test();
        appDBTest.readDescriptionsFromFile_Test();
    }
}
