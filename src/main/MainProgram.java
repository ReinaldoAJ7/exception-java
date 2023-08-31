package main;
/**
 * Fazer um programa para ler os dados de uma conta bancária e depois realizar um
 * saque nesta conta bancária, mostrando o novo saldo. Um saque não pode ocorrer
 * ou se não houver saldo na conta, ou se o valor do saque for superior ao limite de
 * saque da conta. Implemente a conta bancária conforme projeto abaixo:
 */
/**
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 500.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 100.00
 * New balance: 400.00
 * ------------------------------------------------------------
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 500.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 400.00
 * Withdraw error: The amount exceeds withdraw limit
 */
/**
 * Enter account data
 * Number: 8021
 * Holder: Bob Brown
 * Initial balance: 200.00
 * Withdraw limit: 300.00
 * Enter amount for withdraw: 250.00
 * Withdraw error: Not enough balance
 */

import entities.Account;
import exceptions.DomainException;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data:");
        System.out.print("Number: ");
        int number = (Integer)sc.nextInt();
        System.out.print("Holder: ");;
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double iniBalnace = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withDrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, iniBalnace, withDrawLimit);
        System.out.print("Enter amount for withdraw: ");
        double withDraw = sc.nextDouble();

        try{
            account.withDraw(withDraw);
            System.out.printf("New balance: R$%.2f",account.getBalance());
        }
        catch (DomainException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpeted error.\n");
        }


    }
}
