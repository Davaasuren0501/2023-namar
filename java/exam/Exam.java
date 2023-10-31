package mid_term_exam;

import java.io.*;
import java.util.*;
class Candidate implements  Serializable {
    private String surname;
    private String gender;
    private int age;
    private int workExperience;
    private int interviewScore;
    public String getSurname() {
        return surname;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
    public int getWorkExperience() {
        return workExperience;
    }
    public int getInterviewGrade() {
        return interviewScore;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public void setInterviewGrade(int interviewGrade) {
        this.interviewScore = interviewGrade;
    }

    public Candidate(String surname, String gender, int age, int workExperience, int interviewGrade) {
        this.surname = surname;
        this.gender = gender;
        this.age = age;
        if(workExperience > 5 || workExperience<0) this.workExperience = 1;
        else this.workExperience = workExperience;
        if(interviewGrade > 5 || interviewGrade < 0) this.interviewScore = 1;
        else this.interviewScore = interviewGrade;
    }
    @Override
    public String toString() {
        return  surname + ", "   + workExperience + ", " + interviewScore;
    }
}

class CandidateComparator implements Comparator<Candidate>{
    @Override
    public int compare(Candidate o1, Candidate o2) {
        if(o1.getWorkExperience() == o2.getWorkExperience()){
            return Integer.compare(o2.getInterviewGrade(), o1.getInterviewGrade());
        }
        return Integer.compare(o2.getWorkExperience(), o1.getWorkExperience());
    }
}

public class Exam {

    private static void zahiral(PriorityQueue<Candidate> list){
        System.out.println("zahiral boloh bolomjtoi hunii medeelel:" );
        System.out.println(list.peek());
    }
    private static PriorityQueue<Candidate> readCandidatesFromBinFile(String filename) {
        List<Candidate> candidates1 = new ArrayList<Candidate>();
        PriorityQueue<Candidate> candidates = new PriorityQueue<Candidate>(15,new CandidateComparator());
        try (ObjectInputStream oistream = new ObjectInputStream(new FileInputStream(filename))) {
            candidates1 = (List<Candidate>) oistream.readObject();
            for(Candidate elem : candidates1){
                candidates.add(elem);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return candidates;
    }
    private static void writeCandidatesToBinFile(String filename) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("bat", "Male", 30, 4, 4));
        candidates.add(new Candidate("bold", "Female", 35, 3, 5));
        candidates.add(new Candidate("saraa", "Male", 28, 2, 2));
        candidates.add(new Candidate("erdene", "Male", 30, 3, 4));
        candidates.add(new Candidate("hangai", "Female", 35, 1, 1));
        candidates.add(new Candidate("tuul", "Male", 28, 4, 3));
        candidates.add(new Candidate("jargal", "Male", 30, 2, 4));
        candidates.add(new Candidate("temuulen", "Female", 35, 4, 5));
        candidates.add(new Candidate("ganaa", "Male", 28, 5, 3));
        candidates.add(new Candidate("telmen", "Male", 30, 1, 2));
        candidates.add(new Candidate("sarnai", "Female", 35, 5, 5));
        candidates.add(new Candidate("moogii", "Male", 28, 2, 3));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(candidates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        writeCandidatesToBinFile("src/mid_term_exam/candidates.bin");
        PriorityQueue<Candidate> candidates = readCandidatesFromBinFile("src/mid_term_exam/candidates.bin");
        zahiral(candidates);
    }

}