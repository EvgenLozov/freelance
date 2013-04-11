package quest_55243;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 25.03.13
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */
public class UnderGraduate extends Student {
    private Major major;
    private Double overallGPA;
    private Double majorGPA;

    public UnderGraduate() {}

    public UnderGraduate(String firstName,String lastName,String uid, StudentType studentType,
                         ClassStanding studentClassStanding, Major studentMajor, double overallGPA, double majorGPA){
        super(firstName,lastName,uid,studentType,studentClassStanding);
        this.major = studentMajor;
        this.overallGPA = overallGPA;
        this.majorGPA = majorGPA;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Double getOverallGPA() {
        return overallGPA;
    }

    public void setOverallGPA(double overallGPA) {
        this.overallGPA = overallGPA;
    }

    public Double getMajorGPA() {
        return majorGPA;
    }

    public void setMajorGPA(double majorGPA) {
        this.majorGPA = majorGPA;
    }

    @Override
    public String toString() {
        return super.toString()+"The student's \n" +
                "major is "+getMajor()+" has an overall GPA of "+getOverallGPA()+" and a major GPA of "+getMajorGPA();
    }
}
