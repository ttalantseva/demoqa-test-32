package lesson07.utils;

public class TestData {

    public String firstName;
    public String lastName;
    public String userEmail;
    public String gender;
    public String userMobileNumber;
    public String dayOfBirth;
    public String monthOfBirth;
    public String yearOfBirth;
    public String subject1;
    public String subject2;
    public String hobbies;
    public String uploadImage = "капча.jpg";
    public String currentAddress;
    public String state;
    public String city;

    public TestData() {
        RandomUtils randomUtils = new RandomUtils();
        randomUtils.generateTestData(this);
    }
}
