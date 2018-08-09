package com.leetcode.problems.array.hard

import com.leetcode.problems.array.hard.MedianOfTwoSortedArrays.Solution;
import spock.lang.Specification
import spock.lang.Unroll

class MedianOfTwoSortedArraysSpec extends Specification {

    @Unroll
    def "findMedianSortedArrays"() {

        expect:

             new Solution().findMedianSortedArrays(nums1 as int[], nums2 as int[]) == median

        where:

            nums1  || nums2  || median
            [1, 3] || [2]    || 2.0d
            [1, 2] || [3, 4] || 2.5

    }
}
