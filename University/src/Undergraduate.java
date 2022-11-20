import lombok.Getter;
import lombok.Setter;

public class Undergraduate extends Student{

    private String dissertationTheme;

    public Undergraduate (int idNumber, String name, int cardNumber, int studyYear,
                         EducationType educationType, University university, Faculty faculty, String dissertationTheme) throws StudentException {
        super(idNumber, name, cardNumber, studyYear, educationType, university, faculty);
        this.dissertationTheme = dissertationTheme;
    }


    public String getDissertationTheme() {
        return dissertationTheme;
    }

    public void setDissertationTheme(String dissertationTheme) {
        this.dissertationTheme = dissertationTheme;
    }
}
