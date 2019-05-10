package com.algorithm.playground.leetcode.problems.lc900.lc955

import com.algorithm.playground.leetcode.problems.lc900.lc955.DeleteColumnsToMakeSortedII.Solution as S
import spock.lang.Specification
import spock.lang.Unroll

class DeleteColumnsToMakeSortedIISpec extends Specification {

	@Unroll
	def "minDeletionSize"() {

		expect:

			new S().minDeletionSize(A as String[]) == out

		where:

			A                                                                                                                                                                                                                                                                                                                                                                                                                                    || out
			["ca", "bb", "ac"]                                                                                                                                                                                                                                                                                                                                                                                                                   || 1
			["xc", "yb", "za"]                                                                                                                                                                                                                                                                                                                                                                                                                   || 0
			["zyx", "wvu", "tsr"]                                                                                                                                                                                                                                                                                                                                                                                                                || 3
			["bbjwefkpb", "axmksfchw"]                                                                                                                                                                                                                                                                                                                                                                                                           || 1
			["ffusbkyqlb", "ercqbqkrhb", "tjghblnrtn", "soflcftrsy", "afexdrmbxo", "zvotdsjiyg", "tosldognaf", "vgrugbnqre", "ohpchuqazm", "lsgjitblxb", "oemujbxnxm", "nywzjglrug", "ermokiwkdi", "cnzykvhyci", "fdsblgitww", "esofnnmnhs", "lawlnyuwwx", "gijnnhtydz", "lqfkqmlcnn", "mchvrcovml", "slatswujew", "krebwrebsj", "kapfwsvmvv", "tzuawyxsqu", "aiuqwtuzdw", "ynkrxfehjc", "nkuuyqsire", "fktpymcvmr", "xxkfygbzzv", "oiaxzreocg"] || 6
			["xga", "xfb", "yfa"]                                                                                                                                                                                                                                                                                                                                                                                                                || 1

	}

}
