import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.PaypalService;

public class ProgramContract {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato:");
        System.out.print("Número: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate startDateContract = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Valor do contrato: ");
        double valor = sc.nextDouble();

        Contract contract = new Contract(number, startDateContract, valor);

        System.out.print("Entre com o número de parcelas: ");
        int parcelas = sc.nextInt();
        sc.nextLine();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, parcelas);

        System.out.println("PARCELAS: ");
        for (Installment installment : contract.getInstallment()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
