import java.util.ArrayList;

class Lab1Coder {
    private ArrayList<String> languages;
    private String name;
    int experience;

    Lab1Coder(String n, int exp) {
        this.languages = new ArrayList<>();
        this.name = n;
        this.experience = exp;
    }

    Lab1Coder(String n) {
        this.name = n;
        this.experience = 0;
        this.languages = new ArrayList<>();
    }

    Lab1Coder() {
        this.languages = new ArrayList<>();
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setExperience(int exp) {
        this.experience = exp;
    }

    int getExperinece() {
        return experience;
    }

    void setLanguages(String... lang) {
        for (String i : lang) {
            this.languages.add(i);
        }
    }
    
    ArrayList<String> getLanguages() {
        return this.languages;
    }

    ArrayList<String> findCommonLanguages(Lab1Coder other) {
        ArrayList<String> common = new ArrayList<>();
        
        for (String a : this.languages) {
            for (String b : other.getLanguages()) {
                if (a.equals(b)) {
                    common.add(a);
                }
            }
        }

        if (common.isEmpty()) common.add("none");
        return common;
    }

    public String toString() {
        String msg = String.format("%s(%d) knows", name, experience);

        for (String lang : languages) {
            msg += " " + lang;
        }

        return msg;
    }
}