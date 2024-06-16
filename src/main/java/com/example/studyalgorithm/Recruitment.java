package com.example.studyalgorithm;
import java.util.*;
import java.util.stream.Collectors;

public class Recruitment {

    public static String[] solution(String[] companies, String[] applicants) {
        // 기업 정보 매핑
        Map<Character, Company> companyMap = new HashMap<>();
        for (String comp : companies) {
            String[] parts = comp.split(" ");
            char companyName = parts[0].charAt(0);
            String preferences = parts[1];
            int capacity = Integer.parseInt(parts[2]);
            companyMap.put(companyName, new Company(companyName, preferences, capacity));
        }

        // 지원자 정보 매핑
        Map<Character, Applicant> applicantMap = new HashMap<>();
        for (String appl : applicants) {
            String[] parts = appl.split(" ");
            char applicantName = parts[0].charAt(0);
            String preferences = parts[1];
            int maxApplications = Integer.parseInt(parts[2]);
            applicantMap.put(applicantName, new Applicant(applicantName, preferences, maxApplications));
        }

        // 지원자가 지원을 시도할 기업 리스트를 관리
        List<Applicant> activeApplicants = new ArrayList<>(applicantMap.values());

        while (!activeApplicants.isEmpty()) {
            Map<Character, List<Character>> applications = new HashMap<>();

            // 각 지원자가 가장 선호하는 기업에 지원
            List<Applicant> nextRound = new ArrayList<>();
            for (Applicant applicant : activeApplicants) {
                if (applicant.hasMorePreferences()) {
                    char targetCompany = applicant.getNextPreference();
                    applications.computeIfAbsent(targetCompany, k -> new ArrayList<>()).add(applicant.name);
                }
            }

            // 각 기업이 지원자를 잠정적으로 선택
            for (Map.Entry<Character, List<Character>> entry : applications.entrySet()) {
                Company company = companyMap.get(entry.getKey());
                List<Character> rejected = company.reviewApplications(entry.getValue());
                for (char rej : rejected) {
                    Applicant rejApplicant = applicantMap.get(rej);
                    if (rejApplicant.advancePreference()) {
                        nextRound.add(rejApplicant);
                    }
                }
            }

            activeApplicants = nextRound;
        }

        // 결과 생성
        String[] result = companyMap.values().stream()
                .map(Company::getResult)
                .sorted()
                .toArray(String[]::new);

        return result;
    }

    static class Company {
        char name;
        String preferences;
        int capacity;
        List<Character> selected = new ArrayList<>();

        Company(char name, String preferences, int capacity) {
            this.name = name;
            this.preferences = preferences;
            this.capacity = capacity;
        }

        List<Character> reviewApplications(List<Character> applicants) {
            applicants.sort(Comparator.comparingInt(a -> preferences.indexOf(a)));
            List<Character> rejected = new ArrayList<>();
            int i = 0;
            for (char applicant : applicants) {
                if (i < capacity && !selected.contains(applicant)) {
                    selected.add(applicant);
                    i++;
                } else {
                    rejected.add(applicant);
                }
            }
            return rejected;
        }

        String getResult() {
            Collections.sort(selected);
            return name + "_" + selected.stream().map(String::valueOf).collect(Collectors.joining());
        }
    }

    static class Applicant {
        char name;
        String preferences;
        int maxApplications;
        int currentPreferenceIndex = 0;

        Applicant(char name, String preferences, int maxApplications) {
            this.name = name;
            this.preferences = preferences;
            this.maxApplications = maxApplications;
        }

        boolean hasMorePreferences() {
            return currentPreferenceIndex < maxApplications && currentPreferenceIndex < preferences.length();
        }

        char getNextPreference() {
            return preferences.charAt(currentPreferenceIndex++);
        }

        boolean advancePreference() {
            return hasMorePreferences();
        }
    }


    public static void main(String[] args) {
        String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
        System.out.println(solution(companies, applicants));
    }

}
