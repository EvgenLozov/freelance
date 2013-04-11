package quest_55243;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 25.03.13
 * Time: 15:53
 * To change this template use File | Settings | File Templates.
 */
public class Graduate extends Student {
    private String majorProfessor;
    private Boolean thesisOption;

    public Graduate(){}

    public Graduate(String firstName,String lastName,String uid, StudentType studentType,
                    ClassStanding studentClassStanding, String majorProfessor, boolean thesisOption){
        super(firstName,lastName,uid,studentType,studentClassStanding);
        this.majorProfessor = majorProfessor;
        this.thesisOption = thesisOption;
    }

    public String getMajorProfessor() {
        return majorProfessor;
    }

    public void setMajorProfessor(String majorProfessor) {
        this.majorProfessor = majorProfessor;
    }

    public Boolean isThesisOption() {
        return thesisOption;
    }

    public void setThesisOption(boolean thesisOption) {
        this.thesisOption = thesisOption;
    }

    @Override
    public String toString() {
        String thesis;
        if (isThesisOption())
            thesis = "The student will write a thesis.";
        else
            thesis = "The student not will write a thesis.";
        return super.toString()+"The student's major professor is "+ getMajorProfessor()+". "+ thesis;
    }
}
