public class Bachelor extends Student {
    private String graduateTheme;


    public Bachelor(int idNumber, String name, int cardNumber, int studyYear, EducationType educationType,
                    University university, Faculty faculty, String graduateTheme) throws StudentException {
        super(idNumber, name, cardNumber, studyYear, educationType, university, faculty);
        this.graduateTheme = graduateTheme;
    }

    public String getGraduateTheme() {
        return graduateTheme;
    }

    public void setGraduateTheme(String graduateTheme) {
        this.graduateTheme = graduateTheme;
    }
}
