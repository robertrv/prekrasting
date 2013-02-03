package org.home.kata;

public class MasterMindExecutor {

    private String solution;

    public MasterMindExecutor(String solution) {
        this.solution = solution;
    }

    public String checkCode(String currentTry) {

        String result = "";
        String tryRemaining = "";
        String solutionRemaining = "";



        if ( currentTry.equals(solution)){
            result = "XXXX";
        }else {
           for (int i=0 ; i < currentTry.length(); i++){
               if(solution.charAt(i) == currentTry.charAt(i)){
                   result = result + "X";
               } else {
                   tryRemaining += currentTry.charAt(i);
                   solutionRemaining += solution.charAt(i);
               }
           }

            int index;
            for (int i=0 ; i < tryRemaining.length(); i++){
                if (solutionRemaining.contains(String.valueOf(tryRemaining.charAt(i)))) {
                    result += "*";
                    index = solutionRemaining.indexOf(tryRemaining.charAt(i));
                    solutionRemaining = solutionRemaining.substring(0, index) + solutionRemaining.substring(index+1);
                }
            }

        }


        return result;
    }
}
