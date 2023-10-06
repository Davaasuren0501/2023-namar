public class HighYearTest {
    public HighYearTest(){
        try {
            int yearStart = 1900;
            int yearEnd = 2023;
            CatchHighYear( yearStart,yearEnd );
        } catch (HighYearException e) {
            System.out.println(e.getError());
        }
    }

    void CatchHighYear ( int yearStart, int yearEnd ) throws HighYearException {
        for( int i=yearStart; i <= yearEnd; i+=4) {
            throw new HighYearException("Undur Jil " + (i+4));
        }
    }

    public static void main(String[] args) {
        new HighYearTest();
    }
}
