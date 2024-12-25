package me.coding.leetcode.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution23 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> dns = new HashMap<>();
        int size = cpdomains.length;
        for (int i = 0; i < size; i++) {
            String[] splits = cpdomains[i].split(" ");
            int count = Integer.parseInt(splits[0]);
            String domain = splits[1];
            do {
                dns.put(domain, (dns.get(domain) != null ? dns.get(domain) : 0) + count);
                domain = domain.substring(domain.indexOf('.')+1);
            } while (domain.contains("."));
            dns.put(domain, (dns.get(domain) != null ? dns.get(domain) : 0) + count);
        }
        List<String> cpResult = new ArrayList<>();
        for (String dom : dns.keySet()) {
            cpResult.add(dns.get(dom) + " " + dom);
        }
        return cpResult;
    }
}
