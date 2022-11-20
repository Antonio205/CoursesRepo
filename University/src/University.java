import java.util.ArrayList;

public class University {
    private String title;
    private int educationCost;
    private String rectorName;
    private ArrayList<Faculty> faculties;

    public University(String title, int educationCost, String rectorName, ArrayList<Faculty> faculties) {
        this.title = title;
        this.educationCost = educationCost;
        this.rectorName = rectorName;
        this.faculties = faculties;
    }

    public boolean containFaculty(Faculty faculty){
        for(var i : faculties){
            if (faculty.equals(i)) {
                return true;
            }
        }

        return false;
    }

    public int getAverage() throws StudentException{
        int sum = 0;
        int t = 0;
        for (var i : faculties){
            if (i.isSmbPassExam()) {
                ++t;
                sum += i.getAverage();
            }
        }

        return sum / t;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEducationCost() {
        return educationCost;
    }

    public void setEducationCost(int educationCost) {
        this.educationCost = educationCost;
    }

    public String getRectorName() {
        return rectorName;
    }

    public void setRectorName(String rectorName) {
        this.rectorName = rectorName;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }


}
