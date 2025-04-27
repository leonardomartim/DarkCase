package ui;

import model.Case;
import model.Suspect;
import model.Evidence;
import service.InvestigationService;
import utils.ReportGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InvestigationService service = new InvestigationService();
        Scanner sc = new Scanner(System.in);
        Case currentCase = null;

        System.out.println("Bem-vindo ao Sistema de Investigações - Dark Case");

        int option;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Criar novo caso");
            System.out.println("2 - Adicionar suspeito");
            System.out.println("3 - Adicionar pista");
            System.out.println("4 - Analisar suspeitos");
            System.out.println("5 - Gerar relatório");
            System.out.println("6 - Fechar caso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine(); // consumir newline

            switch (option) {
                case 1:
                    System.out.print("Nome do caso: ");
                    String name = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Local: ");
                    String loc = sc.nextLine();
                    System.out.print("Data (YYYY-MM-DD): ");
                    String date = sc.nextLine();

                    currentCase = new Case(name, desc, loc, date, true);
                    service.addCase(currentCase);
                    System.out.println("Caso criado com sucesso!");
                    break;

                case 2:
                    if (currentCase == null) {
                        System.out.println("Crie um caso primeiro (opção 1).");
                        break;
                    }
                    System.out.print("Nome do suspeito: ");
                    String sName = sc.nextLine();
                    System.out.print("Tem álibi? (true/false): ");
                    boolean hasAlibi = sc.nextBoolean();
                    System.out.print("Visto perto do crime? (true/false): ");
                    boolean seenNear = sc.nextBoolean();
                    System.out.print("Tem motivo? (true/false): ");
                    boolean motive = sc.nextBoolean();
                    sc.nextLine(); // consumir newline

                    Suspect suspect = new Suspect(sName, hasAlibi, seenNear, motive, new ArrayList<>());
                    service.addSuspect(suspect);
                    System.out.println("Suspeito adicionado!");
                    break;

                case 3:
                    if (currentCase == null) {
                        System.out.println("Crie um caso primeiro (opção 1).");
                        break;
                    }
                    System.out.print("Descrição da pista: ");
                    String eDesc = sc.nextLine();
                    System.out.print("Tipo da pista: ");
                    String eType = sc.nextLine();

                    Evidence ev = new Evidence(eDesc, eType);
                    service.addEvidence(ev);
                    System.out.println("Pista adicionada!");
                    break;

                case 4:
                    if (currentCase == null) {
                        System.out.println("Crie um caso primeiro (opção 1).");
                        break;
                    }
                    String analysis = service.analyzeSuspects(currentCase);
                    System.out.println("\n" + analysis);
                    break;

                case 5:
                    if (currentCase == null) {
                        System.out.println("Crie um caso primeiro (opção 1).");
                        break;
                    }
                    String report = service.analyzeSuspects(currentCase);
                    ReportGenerator.generateFullCaseReport(currentCase, report);
                    break;

                case 6:
                    if (currentCase != null && currentCase.isOpen()) {
                        service.closeCase(currentCase);
                    } else {
                        System.out.println("Nenhum caso aberto para fechar.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (option != 0);

        sc.close();
    }
}