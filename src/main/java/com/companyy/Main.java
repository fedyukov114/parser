package com.companyy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        //variables for commission
        double totalCommissionResultRUB = 0;
        double totalCommissionResultUSD = 0;
        List<Double> totalCommissionRUB = new ArrayList();
        List<Double> totalCommissionUSD = new ArrayList();

        //variables for payment
        double totalPaymentResultUSD = 0;
        double totalPaymentResultRUB = 0;
        List<Double> totalPaymentUSD = new ArrayList();
        List<Double> totalPaymentRUB = new ArrayList();

        ObjectMapper mapper = new ObjectMapper();
        List<JsonObj> jsonObj = mapper
                .readValue(new File("operations.json"), new TypeReference<List<JsonObj>>() {});

        //если commision = null, то вернется FALSE.
        jsonObj.stream().filter(jsonObj1 -> Objects.nonNull(jsonObj1.getCommission()))
                .filter(jsonObj1 ->  jsonObj1.getStatus().equals("Done")
                        && jsonObj1.getCommission().getCurrency().equals("RUB"))
                .forEach(jsonObj1 -> totalCommissionRUB.add(jsonObj1.getCommission().getValue()));


        for (int i = 0; i < totalCommissionRUB.size(); i++){
            totalCommissionResultRUB = totalCommissionResultRUB + totalCommissionRUB.get(i);
        }

        jsonObj.stream().filter(jsonObj1 -> Objects.nonNull(jsonObj1.getCommission()))
                .filter(jsonObj1 ->  jsonObj1.getStatus().equals("Done")
                        && jsonObj1.getCommission().getCurrency().equals("USD"))
                .forEach(jsonObj1 -> totalCommissionUSD.add(jsonObj1.getCommission().getValue()));

        for (int i = 0; i < totalCommissionUSD.size(); i++){
            totalCommissionResultUSD = totalCommissionResultUSD + totalCommissionUSD.get(i);
        }

        jsonObj.stream().filter(jsonObj1 -> jsonObj1.getStatus().equals("Done")
                && jsonObj1.getCurrency().equals("USD"))
                .forEach(jsonObj1 -> totalPaymentUSD.add(jsonObj1.getPayment()));
        for (int i = 0; i < totalPaymentUSD.size(); i++){
            totalPaymentResultUSD = totalPaymentResultUSD + totalPaymentUSD.get(i);
        }

        jsonObj.stream().filter(jsonObj1 -> (jsonObj1.getStatus().equals("Done")
                && jsonObj1.getCurrency().equals("RUB")))
                .forEach(jsonObj1 -> totalPaymentRUB.add(jsonObj1.getPayment()));
        for (int i = 0; i < totalPaymentRUB.size(); i++){
            totalPaymentResultRUB = totalPaymentResultRUB + totalPaymentRUB.get(i);
        }

        //In order to correctly count "payment". Coz the commission is counted in both "payment" and "commission"
        totalPaymentResultUSD = totalPaymentResultUSD - totalCommissionResultUSD;
        totalPaymentResultRUB = totalPaymentResultRUB - totalCommissionResultRUB;

        System.out.println("Our total payment in USD: " + totalPaymentResultUSD + "\n"
                + "Our total payment in RUB: " + totalPaymentResultRUB
                + "\nOur total commission in USD: " + totalCommissionResultUSD + "\n"
                + "Our  total commission in RUB: " + totalCommissionResultRUB);
    }
}
