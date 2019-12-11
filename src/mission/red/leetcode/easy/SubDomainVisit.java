package mission.red.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/subdomain-visit-coun
 */
public class SubDomainVisit {

    public static void main(String[] args) {
        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        System.out.println(new SubDomainVisit().subdomainVisits(input));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> domainCount = new HashMap<>();

        Arrays.stream(cpdomains).forEach(input -> {
            String[] x = input.split(" ");
            String[] domains = x[1].split("\\.");
            int count = Integer.parseInt(x[0]);

            String domainBuiilder = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                if(domainBuiilder.isEmpty()){
                    domainBuiilder = domainBuiilder.concat(domains[i]);
                } else{
                    domainBuiilder = domains[i] + "." + domainBuiilder;
                }
                if (!domainCount.containsKey(domainBuiilder)) {
                    domainCount.put(domainBuiilder, 0);
                }
                domainCount.put(domainBuiilder, domainCount.get(domainBuiilder) + count);
            }
        });

        for(Map.Entry<String, Integer> entry: domainCount.entrySet()){
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
