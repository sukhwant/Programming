
public interface DatabaseAccess {

    public void saveToDB(Animal animal);

    public Animal readFromDB(String animalID);

}
