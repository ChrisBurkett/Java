
public class Dog extends RescueAnimal {

   
    private String breed;

   
    public Dog(String name, String breed, String gender, String age,
    String weight, String acquisitionDate, String acquisitionCountry,
	String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }

   
    public String getBreed() {
        return breed;
    }

   
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }

}
