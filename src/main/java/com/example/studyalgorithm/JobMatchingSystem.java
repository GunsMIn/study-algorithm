package com.example.studyalgorithm;
import java.util.*;
import java.util.stream.Collectors;
public class JobMatchingSystem {

    static class Company {
        String name;
        int capacity;
        List<String> preferences;

        Company(String name, String prefString, int capacity) {
            this.name = name;
            this.capacity = capacity;
            this.preferences = Arrays.asList(prefString.split(""));
        }
    }

    static class Applicant {
        String name;
        List<String> preferences;
        int maxApplications;

        Applicant(String name, String prefString, int maxApplications) {
            this.name = name;
            this.preferences = Arrays.asList(prefString.split(""));
            this.maxApplications = maxApplications;
        }
    }

    public static String[] solution(String[] companiesInfo, String[] applicantsInfo) {
        Map<String, Company> companies = new HashMap<>();
        Map<String, Applicant> applicants = new HashMap<>();
        Map<String, List<String>> applications = new HashMap<>();

        // Parse companies
        for (String info : companiesInfo) {
            String[] parts = info.split(" ");
            companies.put(parts[0], new Company(parts[0], parts[1], Integer.parseInt(parts[2])));
        }

        // Parse applicants
        for (String info : applicantsInfo) {
            String[] parts = info.split(" ");
            applicants.put(parts[0], new Applicant(parts[0], parts[1], Integer.parseInt(parts[2])));
        }

        boolean updated;
        do {
            updated = false;
            applications.clear();
            // Applicants apply
            for (Applicant applicant : applicants.values()) {
                if (applicant.maxApplications > 0) {
                    String preferredCompany = applicant.preferences.get(0);
                    applications.computeIfAbsent(preferredCompany, k -> new ArrayList<>()).add(applicant.name);
                    applicant.maxApplications--;
                }
            }

            // Companies review applications
            for (Map.Entry<String, List<String>> entry : applications.entrySet()) {
                Company company = companies.get(entry.getKey());
                List<String> sortedApplicants = entry.getValue().stream()
                        .sorted(Comparator.comparingInt(a -> company.preferences.indexOf(a)))
                        .collect(Collectors.toList());
                int acceptCount = Math.min(company.capacity, sortedApplicants.size());
                company.capacity -= acceptCount;

                for (int i = acceptCount; i < sortedApplicants.size(); i++) {
                    String rejectedApplicant = sortedApplicants.get(i);
                    Applicant applicant = applicants.get(rejectedApplicant);
                    applicant.preferences.remove(entry.getKey());
                    if (applicant.preferences.size() > 0) {
                        updated = true;
                    }
                }
            }
        } while (updated);

        // Generate result
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Company> entry : companies.entrySet()) {
            String result = entry.getKey() + "_" + String.join("", applications.getOrDefault(entry.getKey(), new ArrayList<>()));
            results.add(result);
        }
        Collections.sort(results);
        return results.toArray(new String[0]);
    }



    public static void main(String[] args) {
        String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[] applicants = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
        System.out.println(Arrays.toString(solution(companies, applicants)));
    }
}
