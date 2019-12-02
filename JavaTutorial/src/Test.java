
public class Test {

    public static void main(String[] args) {
        walk(new Fish());
        
        DatabaseAccess dbAccess = new NoSqlDatabase();
        dbAccess.saveToDB(new Fish());
        
        
    }

    public static void walk(Animal animal) {
        animal.walk();
    }


}
