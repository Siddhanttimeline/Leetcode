class Solution {
    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();
        
        for(String str : emails){

            String[] parts = str.split("@");
            String localName = parts[0];
            String domainName = parts[1];

            int i=0;
            StringBuilder cleanedFirst = new StringBuilder(); 
            while(i<localName.length()){
                if(localName.charAt(i) == '.'){
                    i++;
                    continue;
                }else if(localName.charAt(i) == '+'){
                    break;
                }
                cleanedFirst.append(localName.charAt(i));
                i++;
            }

            String combined = cleanedFirst.toString() +"@"+ domainName;
            set.add(combined);

        }

        return set.size();


    }
}