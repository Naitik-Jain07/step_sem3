public class AccessChecker{
    static String classifyAccess(String fieldModifier, String accessorContext){
        if (fieldModifier.equals("private")){
            if (accessorContext.equals("SAME_CLASS")){
                return "ALLOWED";
            }else{
                return "NOT ALLOWED";
            }
            
        }
        else if (fieldModifier.equals("default")){
            if (accessorContext.equals("SAME_CLASS")|| accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }else{
                return "NOT ALLOWED";
            }
            
        }
        else if (fieldModifier.equals("protected")){
            if (accessorContext.equals("SAME_CLASS")|| accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }else{
                return "NOT ALLOWED";
            }
            
        }
        else if (fieldModifier.equals("public")){
                return "ALLOWED";            
        }
        return "DENIED";  
    }
    static String summarizeByModifier(String[][] attempts){
        String[] modifiers = {"private","public","protected","default"};
        int [] allowed = new int[4];
        int [] denied = new int[4];

        for (int i =0 ; i< attempts.length ; i++){
            String modifier = attempts[i][0];
            String context = attempts[i][1];
            String result = classifyAccess(modifier , context);

            int index = -1; //we need to find position
            //-1 means we didnt find it yet
            //not 0 coz 0 is gonna be a actual index . check loop

            for(int j = 0;j<modifiers.length;j++){
                if(modifiers[j].equals(modifier)){
                    index = j;
                    break;
                }
            }
            if (result.equals("ALLOWED")){
                allowed[index]++;

            }else {
                denied[index]++;
            }

        }
        String answer =""; //to store final formatted summary
        for (int i = 0; i < modifiers.length; i++) {
            // Add | between different modifiers for neatness
            if (i > 0) {
                answer = answer + " \n ";
            }
            // Add the modifier and its allowed/denied counts.
            answer = answer + modifiers[i]
                    + ": " + allowed[i]
                    + " allowed / "
                    + denied[i]
                    + " denied";
        }
        return answer;
    }        


    public static void main(String[] args) {
        System.out.println(
            classifyAccess("private", "SAME_CLASS")
        );
        System.out.println(
            classifyAccess("protected", "DIFFERENT_PACKAGE")
        );
        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(attempts)
        );
    }
}
