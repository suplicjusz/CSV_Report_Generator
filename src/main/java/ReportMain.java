
import service.CustomerService;
import service.ReportGenerator;

import static service.CustomerService.tryAgain;

public class ReportMain {
    public static void main(String[] args) {
        do {
            ReportGenerator.generateReport(CustomerService.chooseInputPath());
            ReportGenerator.saveToCsvFile();
            CustomerService.setTryAgain();
        } while (tryAgain);
    }
}
