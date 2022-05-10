package service;

import csv.OpenCSVReader;
import csv.OpenCSVWriter;
import model.ReportEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class ReportGenerator {

    public static ItemService itemService;
    public static ReportEntityService reportEntityService;

    public static void generateReport(String path) {

        itemService = new ItemService(OpenCSVReader.readFile(path));
        itemService.runBalance();
        System.out.println("Supply: " + itemService.getSumOfSupply());
        System.out.println("Buy: " + itemService.getSumOfBuy());
        System.out.println("Result: " + itemService.getResult());
    }

    public static void saveToCsvFile() {
        OpenCSVWriter.saveFile(CustomerService.chooseOutputPath(), itemService);
    }

    public static void saveToDatabase() {
        reportEntityService = new ReportEntityService(itemService);
        reportEntityService.runServiceOfEntity();
        ReportEntity reportEntity = reportEntityService.getReportEntity();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(reportEntity);
        session.getTransaction().commit();
        session.close();
    }

}
