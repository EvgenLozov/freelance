package quest_55243;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 25.03.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    //fields which describe a Student
    private String firstName;
    private String lastName;
    private String uid;
    private StudentType studentType;
    private ClassStanding studentClassStanding;

    //constructors
    /**
     * The no arguement constructor
     * PreConditon: A Student Object is to be created
     * PostCondition: A Student Object is instanciated with default values
     */
    public Student() {
        setFirstName("first name not initialized");
        setLastName("last name not initialized");
        setUid("uid not initialized");
        setStudentType(StudentType.UNDECLARED);
        setClassStanding(ClassStanding.UNKNOWN);

    }//end of default constructor

    /**
     * A complete constructor that builds an objects with the supplied
     parameters
     * PreCondition: A Student Object is to be created with the given field
     values
     * PostConditon: A Student Object is instanciated with supplied field
     values
     *
     * @param firstName A student's first name
     * @param lastName A student's last name
     * @param uid A student' uid number
     * @param studentType A student's characterization:
    UNDERGRADUATE,GRADUATE, or
     * UNDECLARED
     * @param studentClassStanding A student's standing: FRESHMAN, SOPHOMORE,
     * JUNIOR, SENIOR, UNKNOWN,MASTERS_STUDIES,or PHD_STUDIES
     */
    public Student(String firstName, String lastName,
                   String uid, StudentType studentType,
                   ClassStanding studentClassStanding) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uid = uid;
        this.studentType = studentType;
        this.studentClassStanding = studentClassStanding;
    }//end of full constructor

    //getters and setters
    /**
     * The setFirstName method sets the firstName field
     * PreCondition: The firstName field is to be reset
     * PostConditon: The firstName field is set to parameter firstName
     *
     * @param firstName Used to replace the value stored in field firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//end of setFirstName method

    /**
     * The getFirstName method returns the contents of the firstName field
     * PreCondition: The firstName field has a valid non null entry
     * PostCondition: The contents of the firstName field have been returned
     *
     * @return The contents of the firstName field
     */
    public String getFirstName() {
        return firstName;
    }//end of getFirstName method

    /**
     * The setlastName method sets the lastName field
     * PreCondition: The lastName field is to be reset
     * PostConditon: The lastName field is set to parameter lastName
     *
     * @param lastName Used to replace the value stored in field firstName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//end of setLastName method

    /**
     * The getLastName method returns the contents of the lastName field
     * PreCondition: The lastName field has a valid non null entry
     * PostCondition: The contents of the lastName field have been returned
     *
     * @return The contents of the lastName field
     */
    public String getLastName() {
        return lastName;
    }//end of getLastName method

    /**
     * The setUid method sets the uid field to the value of parameter uid
     * PreCondition: The uid field is to be reset
     * PostConditon: The uid field is set to parameter uid
     *
     * @param uid Used to replace the value stored in uid firstName
     */
    public void setUid(String uid) {
        this.uid = uid;
    }//end of setUid method

    /**
     * The getUid method returns the contents of the uid field
     * PreCondition: The uid field has a valid non null entry
     * PostCondition: The contents of the uid
     * field have been returned
     *
     * @return The contents of the uid field
     */
    public String getUid() {
        return uid;
    }//end of getUid method

    /**
     * The setStudentType method sets the studentType field to the value of
     * parameter studentType
     * PreCondition: The studentType field is to be reset
     * PostConditon: The studentType field is set to parameter studentType
     *
     * @param studentType Used to replace the value stored in studentType
     */
    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }//end of setStudentType method

    /**
     * The getStudentType method returns the contents of the studentType field
     * PreCondition: The studentType field has a valid entry
     * PostCondition: The contents of the studentType field have been returned
     *
     * @return The contents of the studentType field
     */
    public StudentType getStudentType() {
        return studentType;
    }//end of getStudentType method

    /**
     * The setClassStanding method sets the classStanding field to the value
     of
     * parameter classStanding
     * PreCondition: The classStanding field is to be reset
     * PostConditon: The classStanding field is set to parameter
     * classStanding
     *
     * @param classStanding Used to replace the value stored in classStanding
     */
    public void setClassStanding(ClassStanding classStanding) {
        this.studentClassStanding = classStanding;
    }//end setClassStanding method

    /**
     * The getClassStanding method returns the contents of the
     * studentClassStanding field
     * PreCondition: The studentClassStanding field has a valid entry
     * PostCondition: The contents of studentClassStanding field
     * have been returned
     *
     * @return The contents of the studentClassStanding field
     */
    public ClassStanding getClassStanding() {
        return studentClassStanding;
    }//end getClassStanding method

    /**
     * The toString method describes a Student object in terms of its fields
     * PreCondition: A Student object has been created and its fields
     populated
     * PostCondition: The Student object has been described
     *
     * @return The description of the Student Object
     */
    public String toString() {
        return "\nStudent " + getFirstName() + " " + getLastName() +
                " whose UID is "
                + getUid() + " is a\n" + getStudentType() + " student doing "
                + getClassStanding() + " work. ";
    }//end of toString method
}//end of class Student

