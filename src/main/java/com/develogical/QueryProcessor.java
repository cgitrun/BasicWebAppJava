package com.develogical;

public class QueryProcessor {
    public boolean isPrime(int n)
    {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n/2
        for (int i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;

        return true;
    }
    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.contains("your name")) {
            return "RobTest";
        }

        if (query.contains("prime")) {
            String[] splitString = query.split(":");
            String numFullString = splitString[1];
            String[] numsStringArr = numFullString.split(", ");

            String response = "";
            for (String num : numsStringArr) {
                String strippedNum = num.replaceAll("\\s+","");
                if (isPrime(Integer.parseInt(strippedNum))) {
                    response += num + " ";
                }
            }
            return response;
        }

        if (query.contains("minus")) {
            String[] splitString = query.split(" ");
            String firstNum = splitString[2];
            String secondNum = splitString[4];

            int result = Integer.parseInt(firstNum) - Integer.parseInt(secondNum);
            return Integer.toString(result);
        }

        if (query.contains("plus")) {
            query = query.replaceAll("What is ","");
            query = query.replaceAll("plus ","");
            String[] numsStringArr = query.split(" ");
            int sum = 0;
            for (String num : numsStringArr) {
                sum += Integer.parseInt(num);
            }
            return Integer.toString(sum);
        }

        return "";
    }

}