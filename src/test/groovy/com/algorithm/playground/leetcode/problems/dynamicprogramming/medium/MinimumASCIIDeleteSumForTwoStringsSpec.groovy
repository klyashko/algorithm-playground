package com.algorithm.playground.leetcode.problems.dynamicprogramming.medium


import spock.lang.Specification
import spock.lang.Unroll

class MinimumASCIIDeleteSumForTwoStringsSpec extends Specification {

    @Unroll
    def "minimumDeleteSum"() {

        expect:

			new MinimumASCIIDeleteSumForTwoStrings.Solution().minimumDeleteSum(s1, s2) == output

        where:

            s1                                                                                            || s2     || output
            "sea"                                                                                         || "eat"  || 231
            "delete"                                                                                      || "leet" || 403
            "igijekdtywibepwonjbwykkqmrgmtybwhwjiqudxmnniskqjfbkpcxukrablqmwjndlhblxflgehddrvwfacarwkcpmcfqnajqfxyqwiugz" +
                    "tocqzuikamtvmbjrypfqvzqiwooewpzcpwhdejmuahqtukistxgfafrymoaodtluaexucnndlnpeszdfsvfofdylcicrrevjgga" +
                    "srgdhwdgjwcchyanodmzmuqeupnpnsmdkcfszznklqjhjqaboikughrnxxggbfyjriuvdsusvmhiaszicfa" ||
                    "ikhuivqorirphlzqgcruwirpewbjgrjtugwpnkbrdfufjsmgzzjespzdcdjcoioaqybciofdzbdieegetnogoibbwfielwungeh" +
                    "etanktjqjrddkrnsxvdmehaeyrpzxrxkhlepdgpwhgpnaatkzbxbnopecfkxoekcdntjyrmmvppcxcgquhomcsltiqzqzmkloom" +
                    "vfayxhawlyqxnsbyskjtzxiyrsaobbnjpgzmetpqvscyycutdkpjpzfokvi"                                   || 41731
    }

}
