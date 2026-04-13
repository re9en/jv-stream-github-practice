package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35) return false;

        if (!candidate.isAllowedToVote()) return false;

        if (!"Ukrainian".equals(candidate.getNationality())) return false;

        String[] years = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(years[0]);
        int lastYear = Integer.parseInt(years[1]);

        return (lastYear - firstYear) >= 10;
    }
}
