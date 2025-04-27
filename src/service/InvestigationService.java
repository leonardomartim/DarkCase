package service;

import model.Case;
import model.Evidence;
import model.Suspect;

import java.util.List;
import java.util.ArrayList;

public class InvestigationService {
    private List<Case> cases;
    private List<Suspect> suspects;
    private List<Evidence> evidenceList;

    public InvestigationService() {
        this.cases = new ArrayList<>();
        this.suspects = new ArrayList<>();
        this.evidenceList = new ArrayList<>();
    }

    // Método para adicionar um novo caso
    public void addCase(Case investigationCase) {
        cases.add(investigationCase);
    }

    // Método para adicionar um novo suspeito
    public void addSuspect(Suspect suspect) {
        suspects.add(suspect);
    }

    // Método para adicionar uma nova pista
    public void addEvidence(Evidence evidence) {
        evidenceList.add(evidence);
    }

    // Análise de suspeitos com base em pistas e álibis
    public String analyzeSuspects(Case investigationCase) {
        // Lógica simples de análise baseada em pistas
        StringBuilder analysisReport = new StringBuilder("Analysis Report for Case: " + investigationCase.getCaseName() + "\n");

        for (Suspect suspect : suspects) {
            analysisReport.append("Suspect: " + suspect.getName() + "\n");

            // Verifica se o suspeito tem álibi
            if (suspect.hasAlibi()) {
                analysisReport.append("Has an alibi. Suspect unlikely.\n");
            } else {
                analysisReport.append("No alibi. Further investigation needed.\n");
            }

            // Adiciona evidências associadas ao suspeito
            for (Evidence evidence : evidenceList) {
                analysisReport.append("Linked Evidence: " + evidence.getDescription() + "\n");
            }
        }

        return analysisReport.toString();
    }

    // Método para fechar um caso
    public void closeCase(Case investigationCase) {
        investigationCase.setOpen(false);
        System.out.println("Case " + investigationCase.getCaseName() + " is now closed.");
    }
}
